package com.game.boku_tetsu;

import android.graphics.Bitmap;


//===========================================================================//
//BMP登録リスト
//===========================================================================//
class _bmpcc
{
//---------------------------------------------------------------------------//
//BMPサイズ
//---------------------------------------------------------------------------//	
	final static float 	Base_RatioSize 		= 0.25f;							//画像サイズ基準値
	final static float 	Player_XY_Size 		= (Base_RatioSize);
	
//---------------------------------------------------------------------------//
//BMP登録番号(呼び出し番号)
//---------------------------------------------------------------------------//
	final static int Player000			= 0000;
	final static int Player001			= 0001;
	final static int Player002			= 0002;
	final static int BMP_END			= ( Player002 + 1 );				//登録番号の終端番号
	
//---------------------------------------------------------------------------//
//BMP初期化データ値(画像データ設定値)
//---------------------------------------------------------------------------//	
	public static 	BmpCCDataList[] BmpDataList = 
	{
		//Char Chipのため、縦横に複数の表示データある。保存時はBMPを拡大しておく
		new BmpCCDataList(R.drawable.bmpcc_actor10,		Player_XY_Size,	Player_XY_Size, 3 ,4 ),	//0
		new BmpCCDataList(R.drawable.bmpcc_actor10, 	Player_XY_Size,	Player_XY_Size, 3 ,4 ),	//1
		new BmpCCDataList(R.drawable.bmpcc_actor10, 	Player_XY_Size,	Player_XY_Size, 3 ,4 )	//2
	};
	
}//End

//===========================================================================//
//BMP保存用の構造体
//===========================================================================//
class BmpCCData
{	
//---------------------------------------------------------------------------//
//BMPの記録
//---------------------------------------------------------------------------//
	Bitmap 	BMP_CC;	

}//End

//===========================================================================//
//BMP初期設定用の構造体
//===========================================================================//
class BmpCCDataList
{	
	//BMP初期化用のDB作成
	int   BMP_CC_Number;
	float RatioSize_X;
	float RatioSize_Y;
	int   CharChip_X;
	int   CharChip_Y;

	
	BmpCCDataList(int Bitmap, float X_Sixe, float Y_Size, int X_CharChip, int Y_CharChip )
	{
		BMP_CC_Number 	= Bitmap;
		RatioSize_X = X_Sixe;
		RatioSize_Y = Y_Size;
		CharChip_X 	= X_CharChip;
		CharChip_Y 	= Y_CharChip;
	}
	
}//End
