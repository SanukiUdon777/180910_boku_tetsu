package com.game.boku_tetsu;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class A0001_Act_MainMenu extends __ExtendsActivity
{
	//===========================================================================//
	//RAM定義
	//===========================================================================//		
	private static HandleMessage 	lrRoutineHandler;						//定期処理ハンドラ
	private static String 			lrNowClassName;	  
	private static GestureDetector 	lrGestureDetector;
	
	//---------------------------------------------------------------------------//
	//初期化用アクティビティーを実行(プログラム開始時の初期化処理)
	//---------------------------------------------------------------------------//
	@Override
	protected void onCreate(Bundle savedInstanceState)     
	{
		//------------------------------------------------------------// 
		//画面を表示する
		//------------------------------------------------------------//
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);	//画面:XML呼び出し
	    
		//クラスネームの取得
		lrNowClassName = new Object(){}.getClass().getEnclosingClass().getName();
		SetNowActivty(lrNowClassName);
	    
		//バージョン表示
		TextView TextView_Version = (TextView) findViewById(R.id.TextView_Version);
		TextView_Version.setText(_AplInf.dVersion);     	
		
		//BGM設定
		_func.BGM.OnCreateRequestBGM(_bgm.PlayStage);  
		
	    //定期処理のタイマーの初回実行
		lrRoutineHandler = new HandleMessage();
		lrRoutineHandler.fSleep(_g.MainHandler.dMainRoutine);			
     
	    
	}//protected void onCreate(Bundle savedInstanceState) 

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
	  				
	  		}
	  				
	  		//使用済みメッセージの削除	
	  		public void fSleep(long delayMills) 
	  		{	
	  			removeMessages(0);
	  			sendMessageDelayed(obtainMessage(0),delayMills);
	  		}
	  			
	  	}//End_HandleMessage

		//===========================================================================//
		//スタートボタン横のアニメーション
		//===========================================================================//	
		void StartGameAnime(int ID_Image, int ID_Anime)
		{
			View SelectView = (View) findViewById(ID_Image);
			SelectView.setBackgroundResource( ID_Anime );
			AnimationDrawable FraAnim = (AnimationDrawable)SelectView.getBackground();
			FraAnim.start();
		}
		
		//===========================================================================//
		// Startボタン操作(レイアウト XML操作)
		//===========================================================================//	
	    public void SwitchActivity_Story(View v)
	    {
	    	//アクテビティー切り替え
	    	Intent varIntent = new Intent(this, A0002_Act_SelectStage.class);
	        startActivity(varIntent);
	        
	    	//このアクティビティーの終了させ、次のアクティビティへ移動
	        this.finish(); 
	        
	    }

		//===========================================================================//
		// Exitボタン操作(レイアウト XML操作)
		//===========================================================================//	
	    public void SwitchActivity_GameEND(View v)
	    {        
	        //このアクティビティーの終了させ、終了する
	        this.finish(); 
	        
	        // プログラム終了（成功して終了）
	        System.exit(0);
	    }   
	    
		//===========================================================================//
		//ボタン押したとき
		//===========================================================================//
		 @Override 
		 public boolean onKeyDown(int keyCode, KeyEvent event)
		 {
			//各キー処理
			 if( keyCode != KeyEvent.KEYCODE_BACK )
			 { 
				 return false;
			 }
			 
			//BGM再生停止
			// _API_Music.Play_BGM( SelectBGM.NoSound );
			 
			//各キー処理
			this.finish(); 
			// プログラム終了（成功して終了）
			System.exit(0);
			
			return true;
			
		 }//public boolean onKeyDown(int keyCode, KeyEvent event)    	    
	   	
}
