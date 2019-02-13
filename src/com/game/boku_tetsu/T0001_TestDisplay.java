package com.game.boku_tetsu;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;


public class T0001_TestDisplay extends AsyncTask<String, Integer, Integer>
{
//===========================================================================//
//RAM定義
//===========================================================================//		
	private static A0100_MainView 	rView_GameView;			//Custom View画面
	private static LinearLayout 	rLayout_GameDisplay;	

	private static String 	rDisplayTextView = "TestDiaplay";
		
//===========================================================================//
//インターフェイス関数
//===========================================================================//
	public final void fCall_EachInitialHander()//レイアウト変更後に一度だけ処理される
	{	 
		//------------------------------//
		//ビューの登録
		//------------------------------//
		rLayout_GameDisplay = A0000_MainProgam.fCheckLayout();
		
		rView_GameView = (A0100_MainView) rLayout_GameDisplay.findViewById(R.id.GamePlayView);
		rView_GameView.setBackgroundColor(Color.BLACK);
		
		//------------------------------//
		//バック時の戻り先レイアウト指定
		//------------------------------//	
		A0200_ControlLayout.fSetBeforeLayout(A0200_ControlLayout.dLayout_GameLoading);
		
		//------------------------------//
		//初期化処理
		//------------------------------//	
		//音楽データ読み込み
		Z0200_Sound.fInitalMusic(A0000_MainProgam.fCheckContext());		
		
		

		T0003_PhpPost POSTPHP = new T0003_PhpPost();
		POSTPHP.execute();
		
		
	}
	
	public final void fCall_EachRoutineHander()//定期的に処理される
	{
		
		T0002_JsonGet Get_ReplayFile = new T0002_JsonGet();
		Get_ReplayFile.execute();
		
		//------------------------------------------------------------//
		//画面の再表示要求
		//------------------------------------------------------------//
		rView_GameView.invalidate();
	
	}
	
	public final void fCall_EachEndHander()//終了時に一度だけ処理される
	{
		//音楽再生停止
		Z0200_Sound.fRequestMusic(Z0200_Sound.dStop);
	}
	
	public final static void fCall_EachTouchPanel()//パネルタッチ時に処理される
	{		

	}
	
	public final static void fDrawStage(Canvas canvas)
	{	
		//表示領域と背景色の設定
		Paint DrawPaint = new Paint();
		canvas.drawColor(Color.BLACK); //背景色を設定

		//背景表示
		Z0100_Picture.fDrawText_FixField_Center(canvas, DrawPaint, rDisplayTextView, 0.0f, 0.0f-Z0100_Picture.dText_BaseSize*1.0f, 0, 0, 0, 1, Z0100_Picture.dText_BaseSize, Color.WHITE);

	}

	@Override
	protected Integer doInBackground(String... params) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
//===========================================================================//
//内部処理関数
//===========================================================================//	



}
*/
