package com.game.boku_tetsu;

import android.graphics.Bitmap;


//===========================================================================//
//BMP登録リスト
//===========================================================================//
class _bmp
{
//---------------------------------------------------------------------------//
//BMPサイズ
//---------------------------------------------------------------------------//	
	final static float Base_RatioSize 				= 0.1f;						//画像サイズ基準値
	final static float Player_RatioSize_XY 			= ( Base_RatioSize * 2.0f );	//Player画像サイズ
	
//---------------------------------------------------------------------------//
//BMP登録番号(呼び出し番号)
//---------------------------------------------------------------------------//
	final static int Player000			= 0;
	final static int Player001			= 1;
	final static int Player002			= 2;
	final static int Char000			= 3;
	final static int Char001			= 4;
	
	final static int bullet_w_g			= 5;
	final static int bullet_r_g			= 6;
	final static int bullet_b_g			= 7;
	final static int bullet_y_g			= 8;

	final static int bullet_w_t			= 9;
	final static int bullet_r_t			= 10;
	final static int bullet_b_t			= 11;
	final static int bullet_y_t			= 12;
	
	final static int bullet_w_p			= 13;
	final static int bullet_r_p			= 14;
	final static int bullet_b_p			= 15;
	final static int bullet_y_p			= 16;

	final static int atack_w			= 17;
	final static int atack_r			= 18;
	final static int atack_b			= 19;
	final static int atack_y			= 20;
	
	final static int bmp_field000		= 21;
	final static int bmp_field001		= 22;
	final static int bmp_field002		= 23;	
	final static int bmp_field003		= 24;
	
	final static int bmp_text_box000	= 25;
	final static int bmp_text_box001	= 26;
	final static int bmp_text_box002	= 27;	
	final static int bmp_text_box003	= 28;
	
	final static int bmp_taihou000		= 29;
	final static int bmp_taihou001		= 30;
	final static int bmp_field004		= 31;	
	final static int bmp_taihou003		= 32;

	final static int d_field000			= 33;
	final static int d_field001			= 34;
	final static int d_field002			= 35;	
	final static int d_field003			= 36;

	final static int bmp_taihou_f		= 37;
	final static int bmp_taihou_b		= 38;
	final static int bmp_taihou_l		= 39;	
	final static int bmp_taihou_r		= 40;
	
	final static int BMP_END			= ( bmp_taihou_r + 1 );				//登録番号の終端番号
	
//---------------------------------------------------------------------------//
//BMP初期化データ値(画像データ設定値)
//---------------------------------------------------------------------------//	
	public static BmpDataList[] BmpDataList = 
	{
		new BmpDataList( R.drawable.bmp_player0000,		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0000
		new BmpDataList( R.drawable.bmp_player0001, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0001
		new BmpDataList( R.drawable.bmp_player0002, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0002			
		new BmpDataList( R.drawable.bmp_char_0000, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0003		
		new BmpDataList( R.drawable.bmp_char_0001, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0004	
	
		new BmpDataList( R.drawable.bmp_bullet_w_g, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0005	
		new BmpDataList( R.drawable.bmp_bullet_r_g, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0006	
		new BmpDataList( R.drawable.bmp_bullet_b_g, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0007	
		new BmpDataList( R.drawable.bmp_bullet_y_g, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0008	
		
		new BmpDataList( R.drawable.bmp_bullet_w_t, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0009	
		new BmpDataList( R.drawable.bmp_bullet_r_t, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0010	
		new BmpDataList( R.drawable.bmp_bullet_b_t, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0011	
		new BmpDataList( R.drawable.bmp_bullet_y_t, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0012	
		
		new BmpDataList( R.drawable.bmp_bullet_w_p, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0013	
		new BmpDataList( R.drawable.bmp_bullet_r_p, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0014	
		new BmpDataList( R.drawable.bmp_bullet_b_p, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0015	
		new BmpDataList( R.drawable.bmp_bullet_y_p, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0016	
		
		new BmpDataList( R.drawable.bmp_img_button_w, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0017	
		new BmpDataList( R.drawable.bmp_img_button_r, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0018	
		new BmpDataList( R.drawable.bmp_img_button_b, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0019	
		new BmpDataList( R.drawable.bmp_img_button_y, 	Player_RatioSize_XY,	Player_RatioSize_XY ),	//0020	
		
		new BmpDataList( R.drawable.bmp_field000, 		1.920f,					1.080f 				),	//0021	
		new BmpDataList( R.drawable.bmp_field000, 		1.920f,					1.080f 				),	//0022	
		new BmpDataList( R.drawable.bmp_field000, 		1.920f,					1.080f 				),	//0023	
		new BmpDataList( R.drawable.bmp_field000, 		1.920f,					1.080f 				),	//0024	
		
		new BmpDataList( R.drawable.bmp_text_box000, 	1.800f,					0.250f 				),	//0025
		new BmpDataList( R.drawable.bmp_text_box000, 	1.920f,					1.080f 				),	//0026	
		new BmpDataList( R.drawable.bmp_text_box000, 	1.920f,					1.080f 				),	//0027	
		new BmpDataList( R.drawable.bmp_text_box000, 	1.920f,					1.080f 				),	//0028	
	
		new BmpDataList( R.drawable.bmp_taihou, 		Player_RatioSize_XY,	Player_RatioSize_XY	),	//0029
		new BmpDataList( R.drawable.bmp_pb01, 			Player_RatioSize_XY,	Player_RatioSize_XY ),	//0030	
		new BmpDataList( R.drawable.bmp_field001, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0031	
		new BmpDataList( R.drawable.bmp_taihou, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0032	
	
		new BmpDataList( R.drawable.bmp_d_fild000, 		2.0f,					4.0f				),	//0033
		new BmpDataList( R.drawable.bmp_d_fild000, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0034	
		new BmpDataList( R.drawable.bmp_d_fild000, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0035	
		new BmpDataList( R.drawable.bmp_d_fild000, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0036	
	
		new BmpDataList( R.drawable.bmp_taihou_f, 		Player_RatioSize_XY,	Player_RatioSize_XY	),	//0037
		new BmpDataList( R.drawable.bmp_taihou_b, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0038
		new BmpDataList( R.drawable.bmp_taihou_l, 		Player_RatioSize_XY,	Player_RatioSize_XY ),	//0039	
		new BmpDataList( R.drawable.bmp_taihou_r, 		Player_RatioSize_XY,	Player_RatioSize_XY )	//0040	
		
	};
}//End

//===========================================================================//
//BMP保存用の構造体
//===========================================================================//
class BmpData
{	
//---------------------------------------------------------------------------//
//BMPの記録
//---------------------------------------------------------------------------//
	Bitmap 	BMP;	

}//End

//===========================================================================//
//BMP初期設定用の構造体
//===========================================================================//
class BmpDataList
{	
	//BMP初期化用のDB作成
	int   BMP_Number;
	float RatioSize_X;
	float RatioSize_Y;
		
	BmpDataList( int BMP_Num, float RS_X, float RS_Y )
	{
		BMP_Number 		= BMP_Num;
		RatioSize_X 	= RS_X;
		RatioSize_Y 	= RS_Y;
	}
	
}//End
