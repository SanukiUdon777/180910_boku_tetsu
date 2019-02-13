package com.game.boku_tetsu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class E0100_Act_PlayGame extends __ExtendsActivity implements OnGestureListener, OnDoubleTapListener  
{
//===========================================================================//
//RAM定義
//===========================================================================//		
	private static HandleMessage 	lrRoutineHandler;						//定期処理ハンドラ
	private static String 			lrNowClassName;	  
	private static GestureDetector 	lrGestureDetector;
	
	private static int lrNowTounchPanel = _g.dOFF;
	
	private static 	StrImageButtonInf sImgBtn1 = new StrImageButtonInf();
	
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
		
		//画面:XML呼び出し
		//setContentView(R.layout.custom_view);	//画面:XML呼び出し
		setContentView(R.layout.custom_view_game_play_e);	//画面:XML呼び出し	
		
		//画面サイズの獲得(初回時)
		GetWindowBaseRatioSize();
						
		//アクティビティー情報をセット
		lrNowClassName = new Object(){}.getClass().getEnclosingClass().getName();
		//LinearLayout 	LayoutName = (LinearLayout)(findViewById(R.id.main_LinearLayout));
		RelativeLayout	LayoutName = (RelativeLayout)(findViewById(R.id.main_RelativeLayout));	
		
		SetNowActivty(lrNowClassName);
		//__ControlCustomView.UseCustomViewSetting(lrNowClassName, LayoutName);	//	
		__ControlCustomView.UseCustomViewSetting2(lrNowClassName, LayoutName);	//	
		
		 
		//GestureDetectorインスタンス作成(タッチパネル処理)
	    lrGestureDetector = new GestureDetector(this, this);

	    //初期化処理（全体）
	    //InitialValueSet();
	    
	    //ボタン設定（位置/画像）
		sImgBtn1.ButtonData = (ImageButton) findViewById(R.id.Attack001);
		_func.ImageButton.InitialImageButton( sImgBtn1, _bmp.bmp_taihou001, 0.1f, 0.1f, ScaleType.FIT_XY );
		_func.ImageButton.SetImageButtonPos(sImgBtn1, 0.0f, -1.2f);

		//初期化処理（各処理）
		E0110_FiledControl.fCall_EachInitialHander();
		E0120_PlayerControl.fCall_EachInitialHander();
		E0130_BulletControl.fCall_EachInitialHander();
		E0140_HitJudge.fCall_EachInitialHander();
		try {
			E0150_EnemyControl.fCall_EachInitialHander();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
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
		
		//各処理
		E0110_FiledControl.fCall_EachEndHander();
		E0120_PlayerControl.fCall_EachEndHander();
		E0130_BulletControl.fCall_EachEndHander();
		E0140_HitJudge.fCall_EachEndHander();
		try {
			E0150_EnemyControl.fCall_EachEndHander();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
			
			//各処理
			E0110_FiledControl.fCall_EachRoutineHander();
			E0120_PlayerControl.fCall_EachRoutineHander();
			E0130_BulletControl.fCall_EachRoutineHander();
			E0140_HitJudge.fCall_EachRoutineHander();
			try {
				E0150_EnemyControl.fCall_EachRoutineHander();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
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
	public void DrawCanvas(Canvas DrawCanvas) throws Exception
	{
		//背景色
		DrawCanvas.drawColor( Color.BLACK );	
		//DrawCanvas.drawColor( Color.WHITE );
		Paint DrawPaint = new Paint();
		
		//各処理
		E0101_ParameterDisplay.fDrawStage(DrawCanvas, DrawPaint);
		E0110_FiledControl.fDrawStage(DrawCanvas, DrawPaint);
		E0120_PlayerControl.fDrawStage(DrawCanvas, DrawPaint);
		E0130_BulletControl.fDrawStage(DrawCanvas, DrawPaint);
		E0140_HitJudge.fDrawStage(DrawCanvas, DrawPaint);
		E0150_EnemyControl.fDrawStage(DrawCanvas, DrawPaint);
	  }

//---------------------------------------------------------------------------//
// ボタン操作(レイアウト XML操作)
//---------------------------------------------------------------------------//		
	public void Click_Attack001(View v)	 
	{   
		//弾発射時のSE
		//_func.SoundEffect.PlaySE(_se.SE009);
		//	D0100b_Func.fSetPlayerBullet(_d.dPSB_X1pos, _d.dP_Ypos, _bmp.Char000, 0.0f, +0.1f, 0.0f, 0.0f);
		
		/*
		new AlertDialog.Builder(this)
	    .setTitle("TEST")
	    .setMessage("Hello, Dialog!")
	    .setPositiveButton("OK", null)
	    .show();
	    */

		// インスタンス作成
		AlertDialog.Builder adb = new AlertDialog.Builder(this);

		// タイトル設定
		adb.setTitle("タイトル");

		// メッセージ設定
		adb.setMessage("メッセージ");

		// OKボタン設定

		// OKボタン設定
		adb.setPositiveButton("OK", 
		new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// OKボタン押下時の処理
		}
		});
		
		adb.setNeutralButton("OK2", 
		new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// OKボタン押下時の処理
		}
		});
	
		// キャンセルボタン設定
		adb.setNegativeButton("キャンセル", 
		new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
		// キャンセルボタン押下時の処理
		}
		});

		// 表示
		adb.show();
		
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
 			lrNowTounchPanel = _g.dON;
 			break;
        
 		case MotionEvent.ACTION_MOVE://指を持ち上げずにスライドさせた場合
 			_ControlTouchPanel.fContinue_TouchPanel(event.getX(),event.getY());
 			lrNowTounchPanel = _g.dON;
 			break;
        
 		case MotionEvent.ACTION_UP://指を持ち上げた場合    
 			_ControlTouchPanel.fRelease_TouchPanel(event.getX(),event.getY());
 			lrNowTounchPanel = _g.dOFF;
 			break;
 			
 		case MotionEvent.ACTION_CANCEL://UP+DOWNの同時発生(＝キャンセル)の場合				    	
 		case MotionEvent.ACTION_OUTSIDE:	    	
 			break;
 			
 		default:   
 			_ControlTouchPanel.fStop_TouchPanel(event.getX(),event.getY());
 			break;    
		}
		
		//タッチパネル処理
		E0110_FiledControl.fCall_EachTouchPanel(lrNowTounchPanel);
		E0120_PlayerControl.fCall_EachTouchPanel(lrNowTounchPanel);
		E0130_BulletControl.fCall_EachTouchPanel(lrNowTounchPanel);
		E0140_HitJudge.fCall_EachTouchPanel(lrNowTounchPanel);
		try {
			E0150_EnemyControl.fCall_EachTouchPanel(lrNowTounchPanel);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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

}//End
