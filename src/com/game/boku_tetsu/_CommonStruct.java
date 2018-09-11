package com.game.boku_tetsu;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

class StrButtonInf
{	
	Button ButtonData;
	RelativeLayout.LayoutParams RelativeLayoutParams;
	
}

class StrImageButtonInf
{	
	ImageButton ButtonData;
	RelativeLayout.LayoutParams RelativeLayoutParams;
	
}

class Str_SetDB_CharBMP
{	
	//BMP初期化用のDB作成
	int   rR_BitMap;
	float rXSizeRatio;
	float rYSizeRatio;
	int   rXCharChip;
	int   rYCharChip;

	
	Str_SetDB_CharBMP(int Bitmap, float X_Sixe, float Y_Size, int X_CharChip, int Y_CharChip )
	{
		rR_BitMap = Bitmap;
		rXSizeRatio = X_Sixe;
		rYSizeRatio = Y_Size;
		rXCharChip = X_CharChip;
		rYCharChip = Y_CharChip;
	}
}




