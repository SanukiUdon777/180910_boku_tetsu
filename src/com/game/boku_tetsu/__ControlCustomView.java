package com.game.boku_tetsu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class __ControlCustomView extends View
{
//===========================================================================//
//クラス全体で使用出来る変数定義
//===========================================================================//	
	//アクティビティ情報
	public static __ControlCustomView 	Name;	
	public static String				UsedClassName;	
	public static LinearLayout 			UsedLayoutName;		
	public static RelativeLayout 		UsedLayoutName2;		
	public static String				CalledFunctionName;	

	public __ControlCustomView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO 自動生成されたコンストラクター・スタブ
		
	}
		
		
	public static void UseCustomViewSetting(String SetClassName, LinearLayout SetLayoutName )
	{		
		//カスタムビューの設定
		UsedLayoutName 	= SetLayoutName;
		Name 	= (__ControlCustomView) UsedLayoutName.findViewById(R.id.GamePlayView);
		
		//関数ジャンプ用のクラス名を設定(CustomView制御用にテーブルJMPを行う)
		UsedClassName 	= SetClassName;	
		CalledFunctionName = "DrawCanvas";
		

		
	}//UseCustomViewSetting

	public static void UseCustomViewSetting2(String SetClassName, RelativeLayout SetLayoutName )
	{
		//カスタムビューの設定
		UsedLayoutName2 	= SetLayoutName;
		Name 	= (__ControlCustomView) UsedLayoutName2.findViewById(R.id.GamePlayView2);
		
		//関数ジャンプ用のクラス名を設定(CustomView制御用にテーブルJMPを行う)
		UsedClassName 	= SetClassName;	
		CalledFunctionName = "DrawCanvas";
		
		//SetLayoutName.setLayoutParams(null);
		//RelativeLayout.LayoutParams.
		
		/*
		 *   
		 *   
		 *   
		 *   / マージンを指定（左、上、右、下）
8
param.setMargins(5, 5, 15, 0);
9
// 垂直位置を真ん中に
10
param.addRule(RelativeLayout.CENTER_VERTICAL, 1);
11
// 水平位置を右に
12
param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 2);
13
 
14
relativeLayout.addView(imgview, param);

		 *   Button button1 = new Button(this);
        button1.setId(1);
        button1.setText("Yahoo Japan");
        relativeLayout.addView(button1, createParam(140, 80));
		 * 
		 LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.WRAP_CONTENT,
	                LinearLayout.LayoutParams.WRAP_CONTENT);
	 
	        button.setLayoutParams(buttonLayoutParams);
	        layout.addView(button);
		*/
		
		
	}//UseCustomViewSetting
	
	
	
	@Override
	protected void onDraw(Canvas DrawCanvas)
	{
		super.onDraw(DrawCanvas);

		//ジャンプ先関数を指定する
		String ClassName	= UsedClassName;
		String MethodName	= CalledFunctionName;
		
		//クラス情報を獲得
		Class<?> clazz = null;
		try 
		{
			clazz = Class.forName(ClassName);
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//メソッドに引き渡すクラスの順番を定義	
		Class<?> para[] = new Class[] { Canvas.class };
		
		//引数無しの メソッドを取得する
		Method method = null;
		
		try 
		{
			method = clazz.getMethod(MethodName,para);
		} 
		catch (NoSuchMethodException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//実行
		try 
		{
			method.invoke(clazz.newInstance(),DrawCanvas);
		} 
		catch (IllegalAccessException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} 
		catch (IllegalArgumentException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} 
		catch (InstantiationException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	
		
	}//End_onDraw
}
