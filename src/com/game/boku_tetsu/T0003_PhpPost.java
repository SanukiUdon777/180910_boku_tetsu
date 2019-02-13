package com.game.boku_tetsu;
/*
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

public class T0003_PhpPost extends AsyncTask<String, Integer, Integer>
{ 	
    @Override
    protected Integer doInBackground(String... contents)
    {
    	post();
		return 0;
    }
    
    public void post()
    {
    	 //

    	//http://jyarashi.php.xdomain.jp/GAME_DB/GameDB_Receive.php?game_tytle=TestGame&user_id=TestPlayer&message1=message1&message2=message2
    	//
    	
    	HttpClient httpclient = new DefaultHttpClient();
    	
    	//HttpClient httpclient = HttpClients.createDefault();
    	HttpPost httppost = new HttpPost("http://jyarashi.php.xdomain.jp/GAME_DB/test0001_XY_Pos/XYPos_Receive_Post.php");
     	//HttpPost httppost = new HttpPost("http://jyarashi.php.xdomain.jp/GAME_DB/GameDB_Receive.php?game_tytle=TestGame&user_id=TestPlayer&message1=message1&message2=message2");

    	// Request parameters and other properties.
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
    	params.add(new BasicNameValuePair("game_tytle", "TestGame3"));
    	params.add(new BasicNameValuePair("user_id", 	"TestPlayer3"));
    	params.add(new BasicNameValuePair("player_x_pos", String.valueOf(GRS0001_Player.sPlayerInf.rXpos)));
    	params.add(new BasicNameValuePair("player_y_pos", String.valueOf(GRS0001_Player.sPlayerInf.rYpos)));
    	
  	
    	try {
			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	//Execute and get the response.
    	HttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
		} catch (ClientProtocolException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	HttpEntity entity = response.getEntity();


    }
}
*/