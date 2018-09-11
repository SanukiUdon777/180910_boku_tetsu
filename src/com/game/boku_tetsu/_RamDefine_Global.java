package com.game.boku_tetsu;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

class _g	//GLOBAL RAM宣言
{
//===========================================================================//
//パッケージ名
//===========================================================================//	
	public static String			rPackageName;


//===========================================================================//
//全体定義
//===========================================================================//		
		final 	static int 				dOFF 	= 0; 
		final 	static int 				dON 	= 1;
		
		
//===========================================================================//
//DEBUG用RAM
//===========================================================================//	
	static class Debug
	{
		//デバック用
		final 	static int 			rSW = _g.dOFF;

		//デバック用数値表示
		public static String rMessage001 = "NoMassege";
		public static String rMessage002 = "NoMassege";
		public static String rMessage003 = "NoMassege";
		public static String rMessage004 = "NoMassege";
		public static String rMessage005 = "NoMassege";
	}
	
//===========================================================================//
//メインハンドラ関数
//===========================================================================//
	static class MainHandler
	{
		final 	static int 				dMainRoutine = 33; 	//33ms毎の周期処理(30FPF)	

	}

//===========================================================================//
//画面情報
//===========================================================================//	
	static class Display
	{
		//画面ベースサイズ(DOT)		
		public static float			rBaseRatioSize;		//BaseRatioSize = Raito(1.0f)

		//全体画面サイズ(RATIO)	
		public static float			rMinRatio_X;
		public static float			rMaxRatio_X;
		public static float			rMinRatio_Y;	
		public static float			rMaxRatio_Y;
		public static float			rMaxRatio_XY;
		
		
		//バー画面サイズ(RATIO)	
		public static  float 		rStatusBarRatio_Y;		
		public static  float 		rTitleBarRatio_Y;		
		public static  float 		rNavigationBarRatio_X;
		public static  float 		rNavigationBarRatio_Y;		
	}
	
	
	
	
	
	
	
	
	
}
