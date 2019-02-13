package com.game.boku_tetsu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.boku_tetsu.E0100_Act_PlayGame.HandleMessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class E0050_StageSelect extends Activity
{
	//===========================================================================//
	//RAM定義
	//===========================================================================//		
		private 	int 		rStageNumber;
		
		//===========================================================================//
		//クラス全体で使用出来る変数定義
		//===========================================================================//	
		//カスタムビュー作成
		Context ThisContext;
  		
		static TextView Header;
		static TextView Footer;

		static int position;  
		static int y;
		 
		ListView lv;
		SimpleAdapter la;
		List<Map<String, Object>> list;
		
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
	        //Activety.NowMode = SelectActivity.SelectBatteleFiled;
	        setContentView(R.layout.stage_select);	//画面:XML呼び出し
	        
	        
	        TextView TextView_Tytle = (TextView) findViewById(R.id.StageSelectTytle);
		    String String_tytle  = "\n◆Select Episode(No.000-No."; 
		    	   String_tytle += String.format("%1$03d",_e.dMaxStage);
		    	   String_tytle += ")◆\n";
		    		
	
		     TextView_Tytle.setText(String_tytle);	
		     
	        
	       	//コンテキストの保存
	        ThisContext = this;
	        
	    	//List Viweの作成
			//ヘッダーの生成
	        Header = new TextView(this);
	        Footer = new TextView(this);
	        Header.setTextColor(Color.WHITE);
	        Footer.setTextColor(Color.WHITE);

	        // リストビューにデータ (アダプタ) を追加
	        lv = (ListView)findViewById(R.id.StageSelectList);
	    
	        //lv.addHeaderView(Header);
	        //lv.addFooterView(Footer);  	        
	        
			Header.setText("");
			Footer.setText("");
			
	        list = new ArrayList<Map<String, Object>>();
	        for (int i=0; i<=_e.dMaxStage; i++)
	        {
	            Map<String, Object> map = new HashMap<String, Object>();
	            map.put("main", "\nEpisode No." + String.format("%1$03d",i)+"\n");
	            
	    		String FileName = "char_boss_"+ String.format("%1$03d",i);
				int resid = this.getResources().getIdentifier(FileName,"drawable",this.getPackageName());
				E0150_EnemyControl.sEnemy.rBMP = resid;
				
	            map.put("sub", resid);
	            list.add(map);
	        }
	        
	        // ListView に設定するデータ (アダプタ) を生成する (テキスト 2 行表示リスト)
	        SimpleAdapter la = new SimpleAdapter(
	        		ThisContext,
	                list,
	                R.layout.list_view_world_replay,
	                new String[] {"main", "sub"},
	                new int[] {R.id.cell_text1, R.id.cell_image}
	                );
			
	        lv.setAdapter(la);

	        
			//androidの本体サイズを取得
			WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
			Display Disp = wm.getDefaultDisplay();
			Point DisplaySize = new Point();
			Disp.getSize(DisplaySize);

	        lv.getLayoutParams().height = (int)(0.7f*DisplaySize.y);
	        lv.requestLayout();
	        lv.setSelectionFromTop(position, y);
	        
	        //---------------------------------------------------------
	        // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
	        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() 
	        {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	            {	
	                ListView listView = (ListView) parent;
	                // クリックされたアイテムを取得します

	    	    	//ゲームステージを選択
	                E0150_EnemyControl.sEnemy.rSelectStage = position;
	    	    	switchActivity_Stage();
	
	            }
	        });
	        //-------------------------------------------------------------	        
		
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
			//if( CheckNowActivty(lrNowClassName))
			//{
				_func.BGM.RequestBGM(_bgm.ReStart);
			//}	 
			  
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
			//if( CheckNowActivty(lrNowClassName))
			//{
				_func.BGM.RequestBGM(_bgm.Stop);
			//}
			 
			 position = lv.getFirstVisiblePosition();  
			 y = lv.getChildAt(0).getTop();
			 
		 }
	    
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
			        
		}//public void onWindowFocusChanged(boolean hasFocus)

		//===========================================================================//
		// Startボタン操作(レイアウト XML操作)
		//===========================================================================//
	    public void switchActivity_Stage()
	    {
	        	    	
	    	//アクテビティー切り替え
	    	Intent varIntent = new Intent(this, E0100_Act_PlayGame.class);
	        startActivity(varIntent);
	        
	    	//このアクティビティーの終了させ、次のアクティビティへ移動
	        this.finish(); 
	        
	    }
	    
		//===========================================================================//
		// Returnボタン操作(レイアウト XML操作)
		//===========================================================================//	
	    public void switchActivity_Return(View v)
	    {   
	        //次のアクティビティへ移動
			Intent varIntent = new Intent(this, E0010_MainMenu.class);
			startActivity(varIntent);
			
	        //このアクティビティーの終了させ、次のアクティビティへ移動
	        this.finish(); 

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
			 
			//次のアクティビティへ移動
			Intent varIntent = new Intent(this, E0010_MainMenu.class);
			startActivity(varIntent);

			//このアクティビティーの終了させ、次のアクティビティへ移動
			this.finish(); 
			
			return true;

		 }//public boolean onKeyDown(int keyCode, KeyEvent event)    	    
	   	
}
