package com.game.boku_tetsu;
/*
import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class T0002_JsonGet extends AsyncTask<String, Integer, Integer>
{ 	
	static String data1;
	static String data2;
	static String data3;
	static String data4;
	
	static float get_x, get_y;
	
    @Override
    protected Integer doInBackground(String... contents)
    {
    	String url = "http://jyarashi.php.xdomain.jp/GAME_DB/test0001_XY_Pos/XYPos_Send_JSON.php";
		OpenHttpGETConnection(url);
		return 0;

    }
    
    public static void OpenHttpGETConnection(String url)
    {

    	HttpClient client = new DefaultHttpClient();
    	String responseData = new String("");
 
    	//JSONデータを取得
    	try
    	{
    		HttpGet get = new HttpGet(url);
    				 
    		// リクエスト送信
    	    HttpResponse response = client.execute(get);
    	    
    	    // 取得
    	    HttpEntity entity = response.getEntity();
    	    responseData = EntityUtils.toString(entity, "UTF-8");
            
    	}
    	catch(IOException e)
    	{
    	    e.printStackTrace();
    	}

    	//JSONな文字列をオブジェクトに変換
    	try
    	{
             // JSONな文字列をオブジェクトに変換
             JSONObject json = new JSONObject(responseData);
             
             // "rows"の項目を取得し、ループ             
             JSONArray rows = json.getJSONArray("data");
             for (int i = 0; i < rows.length(); i++)
             {
                 JSONObject row = rows.getJSONObject(i);
                 data1 = row.getString("id");
                 data2 = row.getString("date");
                 data3 = row.getString("player_x_pos");
                 data4 = row.getString("player_y_pos");
                 
                 GRS0100_EnemyControl.sEnemyInf.rXpos = get_x = -Float.parseFloat(data3);
                 GRS0100_EnemyControl.sEnemyInf.rYpos = get_y = -Float.parseFloat(data4);              
                 
             }
             
         } 
    	catch (JSONException e)
         {
             e.printStackTrace();
         } 
    }
}
*/