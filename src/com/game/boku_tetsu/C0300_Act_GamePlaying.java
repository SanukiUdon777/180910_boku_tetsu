package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class C0300_Act_GamePlaying extends __ExtendsActivity implements OnGestureListener, OnDoubleTapListener  
{
//===========================================================================//
//RAM定義
//===========================================================================//		
//---------------------------------------------------------------------------//
//ハンドラ関数
//---------------------------------------------------------------------------//
	private static HandleMessage 	lrRoutineHandler;						//定期処理ハンドラ
			
//---------------------------------------------------------------------------//
//アクティビティー情報
//---------------------------------------------------------------------------//	
	static String					lrThisActivityName;
	RelativeLayout 					lrThisLayoutName;

//---------------------------------------------------------------------------//
//タッチパネル関数
//---------------------------------------------------------------------------//
	GestureDetector 				lrGestureDetector;
	
//---------------------------------------------------------------------------//
//テストRAM
//---------------------------------------------------------------------------//	
//	static String					Test001;
//	static String					Test002;
//	static String					Test003;
//	static String					Test004;
//	static String					Test005;
	
//===========================================================================//
//内部処理関数
//===========================================================================//		
//---------------------------------------------------------------------------//
//初期化処理
//---------------------------------------------------------------------------//			
	protected void InitialProcess(String PackegeName)
	{	
		//画面情報
		for(int i=0; i<_b.dMaxRow; i++ )
		{
			_b.sGameDispInf.rX_Pos[i] = (float)(_g.Display.rMinRatio_X + ((_g.Display.rMaxRatio_X*2)/(_b.dMaxRow+1))*(i));
			
		}
		
		for(int i=0; i<_b.dMaxCol; i++ )
		{
			_b.sGameDispInf.rY_Pos[i] = (float)(_g.Display.rMinRatio_Y + ((_g.Display.rMaxRatio_Y*2)/(_b.dMaxCol+1))*(_b.dMaxCol-i));		

		}
		
		_b.sGameDispInf.rX_Size = Math.abs(_b.sGameDispInf.rX_Pos[1] - _b.sGameDispInf.rX_Pos[0]);
		_b.sGameDispInf.rY_Size = Math.abs(_b.sGameDispInf.rY_Pos[1] - _b.sGameDispInf.rY_Pos[0]);
		
		//Player
		C0101_PlayerControl.fCall_EachInitialHander();
		
		//Enemy
		//B0500_EnemyControl.fCall_EachInitialHander();
		
		//BGM要求
		_func.BGM.OnCreateRequestBGM(_bgm.Stop);
		
	}//InitialProcess
	
//---------------------------------------------------------------------------//
//定期処理
//---------------------------------------------------------------------------//				
	protected static void PeriodicProcess()
	{
		//CANVAS再表示命令
		__ControlCustomView.Name.invalidate();
		
		//BGM
		_func.BGM.RequestBGM(_bgm.PlayStage);
		_func.BGM.ControlBGM();
		
		//Player
		C0101_PlayerControl.fCall_EachRoutineHander();	
			
		//Enemy	
		try 
		{
			B0500_EnemyControl.fCall_EachRoutineHander();
		} 
		catch (Exception e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
	}//PeriodicProcess

//---------------------------------------------------------------------------//	
//タッチパネル
//---------------------------------------------------------------------------//	
	public void TouchPanel()
	{
		//Player
		C0101_PlayerControl.fCall_EachTouchPanel();
		
	}
	
//---------------------------------------------------------------------------//	
//画面表示
//---------------------------------------------------------------------------//	
	public void DrawCanvas(Canvas DrawCanvas)
	{
		//背景色
		DrawCanvas.drawColor( Color.BLACK );	
		//DrawCanvas.drawColor( Color.WHITE );
		lrThisLayoutName.setBackgroundColor(Color.WHITE);
		Paint DrawPaint = new Paint();

		//TEST
		_func.DrawLine.Line_FixDiaplay( DrawCanvas, DrawPaint, 		 	_b.sGameDispInf.rX_Pos[0],  _b.sGameDispInf.rY_Pos[0],  _b.sGameDispInf.rX_Pos[_b.dMaxRow-1], _b.sGameDispInf.rY_Pos[_b.dMaxCol-1], _b.dBaseLineSize, Color.WHITE, Paint.Style.STROKE );	
		_func.DrawLine.Line_FixDiaplay( DrawCanvas, DrawPaint,		 	_b.sGameDispInf.rX_Pos[_b.dMaxRow-1],  _b.sGameDispInf.rY_Pos[0],  _b.sGameDispInf.rX_Pos[0], _b.sGameDispInf.rY_Pos[_b.dMaxCol-1], _b.dBaseLineSize, Color.WHITE, Paint.Style.STROKE );	
		_func.DrawLine.Rect_STROKE_FixDiaplay( DrawCanvas, DrawPaint, 	_b.sGameDispInf.rX_Pos[1], _b.sGameDispInf.rY_Pos[1], _b.sGameDispInf.rX_Size*(_b.dMaxRow-3)  , _b.sGameDispInf.rY_Size*(_b.dMaxRow-3),   _b.dBaseLineSize, Color.WHITE, Paint.Style.STROKE );
	
		//Player
		C0101_PlayerControl.fDrawStage(DrawCanvas, DrawPaint);
		
	}//DrawCanvas
		
//===========================================================================//
//アンドロイド制御関数
//===========================================================================//	
//---------------------------------------------------------------------------//
//アクティビティー起動時の処理
//---------------------------------------------------------------------------//
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		//画面:XML呼び出し
		//setContentView(R.layout.custom_view);	//画面:XML呼び出し
		setContentView(R.layout.custom_view_game_play_c);	//画面:XML呼び出し	
		
		//画面サイズの獲得(初回時)
		GetWindowBaseRatioSize();			
		
		//アクティビティー情報をセット
		lrThisActivityName = new Object(){}.getClass().getEnclosingClass().getName();	
		lrThisLayoutName = (RelativeLayout)(findViewById(R.id.main_RelativeLayout));		
		SetNowActivty(lrThisActivityName);
		__ControlCustomView.UseCustomViewSetting2(lrThisActivityName, lrThisLayoutName);	//カスタムViewの利用設定
				
		// GestureDetectorインスタンス作成(タッチパネル処理)
		lrGestureDetector = new GestureDetector(this, this);

		//初期化処理
		InitialProcess(getPackageName());
	
		//定期処理のタイマーの初回実行
		lrRoutineHandler = new HandleMessage();
		lrRoutineHandler.fSleep(_g.MainHandler.dMainRoutine);		

	}//End_onCreate

	
//---------------------------------------------------------------------------//
//フォーカスが変わった時の処理
//---------------------------------------------------------------------------//
	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
		super.onWindowFocusChanged(hasFocus);
		
		//画面サイズの獲得(更新時)
		GetWindowBaseRatioSize();

	}//End_onWindowFocusChanged

//---------------------------------------------------------------------------//
//アクティビティーが非表示になるときの処理
//---------------------------------------------------------------------------//
	@Override
	protected void onStop()
	{
		super.onStop();
		if( CheckNowActivty(lrThisActivityName))
		{
			 lrRoutineHandler = null;
			_func.BGM.RequestBGM(_bgm.Stop);	
			_func.BGM.ControlBGM();

		}
				
	}//End_onStop

//---------------------------------------------------------------------------//
//アクティビティーが再表示になるときの処理
//---------------------------------------------------------------------------//
	@Override
	protected void onResume()
	{
		super.onResume();
		if( CheckNowActivty(lrThisActivityName))
		{
			_func.BGM.RequestBGM(_bgm.ReStart);
			
		}
	}//End_onResume
					
//---------------------------------------------------------------------------//
//アクティビティーが終了になるときの処理
//---------------------------------------------------------------------------//
	protected void onDestroy()
	{
		super.onDestroy();
		
	}//End_onDestroy

//===========================================================================//	
//定期処理ハンドラ
//===========================================================================//	
	protected static class HandleMessage extends Handler
	{	
		@Override
		public void handleMessage(Message msg) 
		{	
			if(!CheckNowActivty(lrThisActivityName) || lrRoutineHandler == null )
			{
				return;
			}
		
			//次回の呼び出し時間セット
			lrRoutineHandler.fSleep( _g.MainHandler.dMainRoutine );	
			
			//定期処理
			PeriodicProcess();

		}
						
		//使用済みメッセージの削除	
		public void fSleep(long delayMills) 
		{	
			removeMessages(0);
			sendMessageDelayed(obtainMessage(0),delayMills);
		}
					
	}//End_HandleMessage


//===========================================================================//
// ボタン操作
//===========================================================================//			
//---------------------------------------------------------------------------//
//レイアウト XMLキー処理
//---------------------------------------------------------------------------//	
	
	
	

//---------------------------------------------------------------------------//
//キー処理
//---------------------------------------------------------------------------//	    
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
			case KeyEvent.KEYCODE_BACK:
				this.finish();  	//このアクティビティーの終了させる
				System.exit(0);		//プログラム終了
				break;
		 			
			default:   
				break;

		}
				
		//終了
		return false;
				
	}//End_onKeyDown

			
//---------------------------------------------------------------------------//
//タッチパネル処理
//---------------------------------------------------------------------------//
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		//定期処理のタイマーの初回実行
		if( lrRoutineHandler == null )
		{
			lrRoutineHandler = new HandleMessage();
			lrRoutineHandler.fSleep(_g.MainHandler.dMainRoutine);	
			return false;	
		}
		
		//タッチ時の共通処理
	    //gestureDetector#onTouchEvent//メソッドでタッチイベントの判別・振り分けを行う
	    lrGestureDetector.onTouchEvent(event);
			    
		//タッチパネルによる時期の移動
		switch (event.getAction())
		{	
		case MotionEvent.ACTION_DOWN:// タッチ押下
 			_ControlTouchPanel.fStart_TouchPanel(event.getX(),event.getY());	 			
 			break;
        
 		case MotionEvent.ACTION_MOVE://指を持ち上げずにスライドさせた場合
 			_ControlTouchPanel.fContinue_TouchPanel(event.getX(),event.getY());
 			break;
        
 		case MotionEvent.ACTION_UP://指を持ち上げた場合    
 			_ControlTouchPanel.fRelease_TouchPanel(event.getX(),event.getY());
 			break;
 			
 		case MotionEvent.ACTION_CANCEL://UP+DOWNの同時発生(＝キャンセル)の場合				    	
 		case MotionEvent.ACTION_OUTSIDE:	    	
 			break;
 			
 		default:   
 			_ControlTouchPanel.fStop_TouchPanel(event.getX(),event.getY());
 			break;    				

		}
		
		//タッチパネル処理
		TouchPanel();

		return false;	
		
	}//onTouchEvent
	
	@Override
	public boolean onDoubleTap(MotionEvent arg0)
	{
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent arg0) 
	{
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent arg0) 
	{
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean onDown(MotionEvent arg0) 
	{
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) 
	{
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) 
	{
		// TODO 自動生成されたメソッド・スタブ
				
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) 
	{
		// TODO 自動生成されたメソッド・スタブ
		return false;
	
	}

	@Override
	public void onShowPress(MotionEvent arg0) 
	{
		// TODO 自動生成されたメソッド・スタブ
				
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) 
	{
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
}//END