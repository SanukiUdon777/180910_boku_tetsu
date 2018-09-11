package com.game.boku_tetsu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.LinearLayout;

public class A0000_Act_InitializationProgram extends __ExtendsActivity implements OnGestureListener, OnDoubleTapListener  
{
//===========================================================================//
//RAM定義
//===========================================================================//		
	private static HandleMessage 	lrRoutineHandler;						//定期処理ハンドラ
	private static String 			lrNowClassName;	  
	private static GestureDetector 	lrGestureDetector;

//---------------------------------------------------------------------------//
//画面切り替え時間
//---------------------------------------------------------------------------//
	final static int 				dWaitMenudisplay = 500;					//Loading表示時間(ms)
	final static int				dCghangeActivity = 500;					//Activity切替え時間(ms)
	private static int 				lrTimerMenuDisplay = 0;					//時間カウンタ

//---------------------------------------------------------------------------//
//表示文字
//---------------------------------------------------------------------------//
	private static String[] 		dDisplay_StartDisplay = 
	{
		"              ",//1
		"N             ",//2
		" o            ",//3
		"  w           ",//4
		"              ",//5
		"    L         ",//6
		"     o        ",//7
		"      a       ",//8
		"       d      ",//9
		"        i     ",//10
		"         n    ",//11
		"          g   ",//12
		"           .  ",//13
		"            . ",//14
		"             .",//15
		"              ",//16
		"Now Loading...",//17
		"Now Loading...",//18
		"Now Loading...",//19
		"Now Loading..." //20
	 };
	
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
		setContentView(R.layout.custom_view);	//画面:XML呼び出し
		
		//画面サイズの獲得(初回時)
		GetWindowBaseRatioSize();

		//パッケージ名情報をセット		
		_g.rPackageName = getPackageName();
						
		//アクティビティー情報をセット
		lrNowClassName = new Object(){}.getClass().getEnclosingClass().getName();
		LinearLayout 	LayoutName = (LinearLayout)(findViewById(R.id.main_LinearLayout));
		SetNowActivty(lrNowClassName);
		__ControlCustomView.UseCustomViewSetting(lrNowClassName, LayoutName);		
		
		//GestureDetectorインスタンス作成(タッチパネル処理)
	    lrGestureDetector = new GestureDetector(this, this);

	    //初期化処理
	    InitialValueSet();
	    
	    //定期処理のタイマーの初回実行
		lrRoutineHandler = new HandleMessage();
		lrRoutineHandler.fSleep(_g.MainHandler.dMainRoutine);			
     
		//BMP/BMP_CC読み込み
		Context 				rContext_MainDisplay;
		Resources 				rResource_MainDisplay;
		rContext_MainDisplay 	= this;
		rResource_MainDisplay 	= rContext_MainDisplay.getResources();
		GetWindowBaseRatioSize();
		_func.DrawBmp.InitalBMP( rResource_MainDisplay );
		_func.DrawBmpCC.InitalBMP( rResource_MainDisplay );
		
		//BGM読み込み
		_func.BGM.InitalBGM(rContext_MainDisplay);
		_func.SoundEffect.InitalSoundEffect(rContext_MainDisplay);
		
		//BGM要求
		_func.BGM.OnCreateRequestBGM(_bgm.Stop);
		
		//第２引数で切り替わる秒数(ミリ秒)を指定(起動後にアクティビティーを変更する) 
		Handler hdl = new Handler();
		splashHandler spl = new splashHandler();
		hdl.postDelayed(spl, dWaitMenudisplay + dCghangeActivity );

	}//End_onCreate

    // splashHandlerクラス
    class splashHandler implements Runnable
    {
        public void run() 
        {
 		    Intent varIntent = new Intent(A0000_Act_InitializationProgram.this, A0001_Act_MainMenu.class);
 		    startActivity(varIntent);
 		    A0000_Act_InitializationProgram.this.finish();	
 
        }//End_run
    }//End_splashHandler
        
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
		Paint DrawPaint = new Paint();
		float DrawXPosRatio = 0.0f;
		float DrawYPosRatio = 0.0f;
		float DrawSizeRatio = 0.1f;
		
		//Loading表示時間を更新する
		int DispCharCounter = dWaitMenudisplay/_g.MainHandler.dMainRoutine;		
		if( lrTimerMenuDisplay < DispCharCounter )
		{
			//カウンタをデクリメント
			lrTimerMenuDisplay++;
		}

		int DispNum = ( dDisplay_StartDisplay.length - 1 ) * lrTimerMenuDisplay / DispCharCounter;
		_func.DrawText.FixDiaplay_Center( DrawCanvas, DrawPaint, dDisplay_StartDisplay[DispNum], DrawXPosRatio, DrawYPosRatio, DrawSizeRatio, Color.WHITE );	
				
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
		lrTimerMenuDisplay = 0;
	}//InitialValueSet

}//End
