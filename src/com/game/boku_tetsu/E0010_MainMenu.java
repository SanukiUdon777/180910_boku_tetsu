package com.game.boku_tetsu;

import java.io.IOException;
import java.math.BigDecimal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class E0010_MainMenu extends Activity
{

		//===========================================================================//
		//クラス全体で使用出来る変数定義
		//===========================================================================//	
		//カスタムビュー作成
		
		//===================================================//
		//初期化用アクティビティーを実行(プログラム開始時の初期化処理)
		//===================================================//
	    @Override
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	    	//------------------------------------------------------------//
	    	//画面を表示する
	    	//------------------------------------------------------------//
	        super.onCreate(savedInstanceState);
	        //Activety.NowMode = SelectActivity.MainMenu;   
	        setContentView(R.layout.main_menu);	//画面:XML呼び出し
	        
	        //バージョン表示
		    TextView TextView_Version = (TextView) findViewById(R.id.TextView_Version);
		    //TextView_Version.setText(GameInf.VersionName);
	             		    
	    }//protected void onCreate(Bundle savedInstanceState) 
	    
		//===========================================================================//
		 //アクティビティーが非表示になるときの処理
		//===========================================================================//
		 @Override
		 protected void onResume()
		 {
			 super.onResume();
		    //------------------------------------------------------------//
		    //BGMの再生
		    //------------------------------------------------------------//
			// _API_Music.Play_BGM( SelectBGM.Opening );	 
			 
		 }
		 
		//===========================================================================//
		 //アクティビティーが非表示になるときの処理
		//===========================================================================//
		 @Override
		 protected void onPause()
		 {
			 super.onPause();
			 //------------------------------------------------------------//
			 //BGMの停止
			 //------------------------------------------------------------//
			 //if(Activety.NowMode == SelectActivity.MainMenu )
			 //{
			//	 _API_Music.Play_BGM( SelectBGM.NoSound );
			 //}
		 }
	    
		//===========================================================================//
		 //アクティビティーが非表示になるときの処理
		//===========================================================================//
		 @Override
		 protected void onStop()
		 {
			 super.onStop();
			 
		 }//protected void onStop()
		 
	    public class GameMenuView extends View
		{
	    	//===========================================================================//	
	    	//描画エリア作成
	    	//===========================================================================//	
	    	public GameMenuView(Context context)
	    	{
				super(context);
				// TODO 自動生成されたコンストラクター・スタブ
			}

	    	//===========================================================================//	
	    	//描画実施
	    	//===========================================================================//	
	    	@Override
	    	protected void onDraw(Canvas canvas)
	    	{
	    		super.onDraw(canvas);
	    			
	    	}
		}
	    	    
		//===========================================================================//
		//フォーカスが変わった時に呼ばれるクラス
		//===========================================================================//	
		@Override
		public void onWindowFocusChanged(boolean hasFocus)
		{
			super.onWindowFocusChanged(hasFocus);
			//------------------------------------------------------------//
			//レイアウトのサイズを取得(ゲーム画面)
			//------------------------------------------------------------//
			//ScrollView Tbl_GameMenu = (ScrollView)findViewById(R.id.Scroll_GameMenu);
			
			//------------------------------------------------------------//
	    	//アニメーション作成
	    	//------------------------------------------------------------// 
			/*
			StartGameAnime(R.id.Image_Char_TL_L,R.drawable.main_menu_anim);
			StartGameAnime(R.id.Image_Char_TL_R,R.drawable.main_menu_anim);
			StartGameAnime(R.id.Image_Char_SG_L,R.drawable.main_menu_anim);
			StartGameAnime(R.id.Image_Char_SG_R,R.drawable.main_menu_anim);
			StartGameAnime(R.id.Image_Char_EG_L,R.drawable.main_menu_anim);
			StartGameAnime(R.id.Image_Char_EG_R,R.drawable.main_menu_anim);
			*/
			
		}//public void onWindowFocusChanged(boolean hasFocus)

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
		// Storyボタン操作(レイアウト XML操作)
		//===========================================================================//	
	    public void SwitchActivity_Story(View v)
	    {
	    	//アクテビティー切り替え
	    	Intent varIntent = new Intent(this, E0050_StageSelect.class);
	        startActivity(varIntent);
	        
	    	//このアクティビティーの終了させ、次のアクティビティへ移動
	        this.finish(); 
	        
	    }
	    
	
		//===========================================================================//
		// Exitボタン操作(レイアウト XML操作)
		//===========================================================================//	
	    public void SwitchActivity_GameEND(View v)
	    {        
	    	//BGM再生停止
	    	//_API_Music.Play_BGM( SelectBGM.NoSound );
	    	
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
			 //_API_Music.Play_BGM( SelectBGM.NoSound );
			 
			//各キー処理
			this.finish(); 
			// プログラム終了（成功して終了）
			System.exit(0);
			
			return true;
		 }//public boolean onKeyDown(int keyCode, KeyEvent event)    	    
	   	
}
