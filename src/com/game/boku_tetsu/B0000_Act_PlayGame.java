package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class B0000_Act_PlayGame extends __ExtendsActivity implements OnGestureListener, OnDoubleTapListener  
{
//===========================================================================//
//RAM定義
//===========================================================================//		
	private static HandleMessage 	lrRoutineHandler;						//定期処理ハンドラ
	private static String 			lrNowClassName;	  
	private static GestureDetector 	lrGestureDetector;
	
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
		
		//------------------------------------------------------------// 
		//画面を表示する
		//------------------------------------------------------------//
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_view);	//画面:XML呼び出し
	    
		//クラスネームの取得
		lrNowClassName = new Object(){}.getClass().getEnclosingClass().getName();
		SetNowActivty(lrNowClassName);
	     	
		//アクティビティー情報をセット
		lrNowClassName = new Object(){}.getClass().getEnclosingClass().getName();
		LinearLayout 	LayoutName = (LinearLayout)(findViewById(R.id.main_LinearLayout));
		SetNowActivty(lrNowClassName);
		__ControlCustomView.UseCustomViewSetting(lrNowClassName, LayoutName);		
		
		
		//BGM設定
		_func.BGM.OnCreateRequestBGM(_bgm.PlayStage);  
		
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
		if( CheckNowActivty(lrNowClassName))
		{
			_func.BGM.RequestBGM(_bgm.Stop);
		}
		
	}//End_onStop

//---------------------------------------------------------------------------//
//アクティビティーが再表示になるときの処理
//---------------------------------------------------------------------------//
	@Override
	protected void onResume()
	{
		super.onResume();
		if( CheckNowActivty(lrNowClassName))
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
		if( CheckNowActivty(lrNowClassName))
		{
			_func.BGM.RequestBGM(_bgm.Stop);
		}
		
	}//End_onDestroy

//===========================================================================//	
//定期処理ハンドラ
//===========================================================================//	
	protected static class HandleMessage extends Handler
	{	
		@Override
		public void handleMessage(Message msg) 
		{	
			if(!CheckNowActivty(lrNowClassName))
			{
				return;
			}
			
			//次回の呼び出し時間セット
			lrRoutineHandler.fSleep( _g.MainHandler.dMainRoutine );	

			//BGM
			_func.BGM.ControlBGM();
			
			//CANVAS再表示命令
			__ControlCustomView.Name.invalidate();
				
		}
				
		//使用済みメッセージの削除	
		public void fSleep(long delayMills) 
		{	
			removeMessages(0);
			sendMessageDelayed(obtainMessage(0),delayMills);
		}
			
	}//End_HandleMessage

//===========================================================================//	
//画面表示
//===========================================================================//	
	public void DrawCanvas(Canvas DrawCanvas)
	{
		//背景色
		DrawCanvas.drawColor( Color.BLACK );
		
		//表示内容を更新する			
		//_func.DrawText.FixDiaplay_Center( DrawCanvas, DrawPaint, dDisplay_StartDisplay[DispNum], DrawXPosRatio, DrawYPosRatio, DrawSizeRatio, Color.WHITE );	
				
	}	
		
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
		//タッチ時の共通処理
	    //gestureDetector#onTouchEvent//メソッドでタッチイベントの判別・振り分けを行う
	    lrGestureDetector.onTouchEvent(event);
	    
		//タッチパネルによる時期の移動
		switch (event.getAction())
		{
	 		case MotionEvent.ACTION_DOWN:// タッチ押下	    	 		    
	 		case MotionEvent.ACTION_MOVE://指を持ち上げずにスライドさせた場合
	 		case MotionEvent.ACTION_UP://指を持ち上げた場合     			
	 		case MotionEvent.ACTION_CANCEL://UP+DOWNの同時発生(＝キャンセル)の場合				    	
	 		case MotionEvent.ACTION_OUTSIDE:	    				
	 		default:   
	 			break;
		}



		return false;	
	}

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

//===========================================================================//
//内部処理関数
//===========================================================================//		
//---------------------------------------------------------------------------//
//初期化処理
//---------------------------------------------------------------------------//		
	protected void InitialValueSet()
	{	

	}//InitialValueSet

}//End
