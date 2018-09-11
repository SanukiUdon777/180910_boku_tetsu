package com.game.boku_tetsu;


import com.game.boku_tetsu.A0000_Act_InitializationProgram.HandleMessage;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.GestureDetector;
import android.view.Window;
import android.view.WindowManager;

public class __ExtendsActivity extends Activity
{
//===========================================================================//
//クラス全体で使用出来る変数定義
//===========================================================================//	
	//アクティビティ情報	
	private static String			NowActivty;
	
//---------------------------------------------------------------------------//
//
//---------------------------------------------------------------------------//	
public void SetNowActivty( String SetNowActivty )
{
	NowActivty = SetNowActivty;
		
}

public static Boolean CheckNowActivty( String CheckActivty )
{
	if( NowActivty == CheckActivty )
	{
		return true;
	}
	else
	{
		return false;
	}
}


//---------------------------------------------------------------------------//
//画面情報の入手
//---------------------------------------------------------------------------//	
	public void GetWindowBaseRatioSize()
	{
		//画面情報の読み込み 本体サイズを取得
		WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
		Display Disp = wm.getDefaultDisplay();
		
		Point DisplaySize = new Point(0, 0);
        Point RealSize = new Point(0, 0);
        
		Disp.getSize(DisplaySize);
	    Disp.getRealSize(RealSize);
	      
		Rect rect = new Rect();
		Window window = getWindow();
		window.getDecorView().getWindowVisibleDisplayFrame(rect);
		float rContentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
				
		float StatusBarSize_Y 		= rect.top;		
		float TitleBarSize_Y		= rContentViewTop - StatusBarSize_Y;
		float NavigationBarSize_X 	= RealSize.x-DisplaySize.x; // ナビゲーションバーが下に表示される場合
		float NavigationBarSize_Y 	= RealSize.y-DisplaySize.y; // ナビゲーションバーが下に表示される場合
		
		if( DisplaySize.y <= DisplaySize.x )
		{
			_g.Display.rBaseRatioSize = DisplaySize.y/2;
			
			//レート設定：Y軸を-1.0f～+1.0fと設定する）
			_g.Display.rMaxRatio_Y= +1.0f;	
			_g.Display.rMinRatio_Y = -_g.Display.rMaxRatio_Y;
		
			_g.Display.rMaxRatio_X= (DisplaySize.x/2)/_g.Display.rBaseRatioSize;	
			_g.Display.rMinRatio_X = -_g.Display.rMaxRatio_X;	
			
		}
		else
		{
			//画面比率（横幅の1/2サイズを1.0fと固定する）
			_g.Display.rBaseRatioSize = DisplaySize.x/2;
		
			//レート設定：x軸を-1.0f～+1.0fと設定する）
			_g.Display.rMaxRatio_X = +1.0f;	
			_g.Display.rMinRatio_X = -_g.Display.rMaxRatio_X;
		
			_g.Display.rMaxRatio_Y = (DisplaySize.y/2)/_g.Display.rBaseRatioSize;	
			_g.Display.rMinRatio_Y = -_g.Display.rMaxRatio_Y;		
		}
		
		if( _g.Display.rMaxRatio_X >= _g.Display.rMaxRatio_Y )
		{
			_g.Display.rMaxRatio_XY = _g.Display.rMaxRatio_X;
		}
		else
		{
			_g.Display.rMaxRatio_XY = _g.Display.rMaxRatio_Y;	
		}
		
		
		//バーのサイズレシオを基準値より計算する
		_g.Display.rStatusBarRatio_Y 		= StatusBarSize_Y / _g.Display.rBaseRatioSize;		
		_g.Display.rTitleBarRatio_Y 		= TitleBarSize_Y / _g.Display.rBaseRatioSize;		
		_g.Display.rNavigationBarRatio_X 	= NavigationBarSize_X / _g.Display.rBaseRatioSize;
		_g.Display.rNavigationBarRatio_Y 	= NavigationBarSize_Y / _g.Display.rBaseRatioSize;
				
	}//End_fSetWindowSize
}//End
