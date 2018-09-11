package com.game.boku_tetsu;

class _se
{	
//---------------------------------------------------------------------------//
//BMP登録番号(呼び出し番号)
//---------------------------------------------------------------------------//	
	final static int SE001		 	= 1;
	final static int SE002			= 2;
	final static int SE003 			= 3;
	final static int SE004 			= 4;
	final static int SE005 			= 5;
	final static int SE006 			= 6;
	final static int SE007 			= 7;
	final static int SE008 			= 8;
	final static int SE009 			= 9;
	final static int SE010 			= 10;
	final static int SE011 			= 11;
	final static int SE012 			= 12;
	final static int SE013 			= 13;	
	final static int SE_END			= ( SE013 );						//登録番号の終端番号	

	
//---------------------------------------------------------------------------//
//BGM初期化データ値(音楽データ設定値)
//---------------------------------------------------------------------------//	
	public static SetDataList[] SeDataList = 
		{
			new SetDataList( R.raw.se_boss_damage 						),	//0001
			new SetDataList( R.raw.se_boss_dead							),	//0002
			new SetDataList( R.raw.se_game_clear 						),	//0003		
			new SetDataList( R.raw.se_game_over 						),	//0004		
			new SetDataList( R.raw.se_player_damege 					),	//0005		
			new SetDataList( R.raw.se_ok 								),	//0006		
			new SetDataList( R.raw.se_ng 								),	//0007		
			new SetDataList( R.raw.se_reflect_ball 						),	//0008		
			new SetDataList( R.raw.se_himei01 							),	//0009		
			new SetDataList( R.raw.se_himei02 							),	//0010		
			new SetDataList( R.raw.se_himei03 							),	//0011		
			new SetDataList( R.raw.se_himei04 							),	//0012		
			new SetDataList( R.raw.se_himei05 							)	//0013	
		};	
}//End

//===========================================================================//
//BGM初期設定用の構造体
//===========================================================================//
class SetDataList
{	
	//BMP初期化用のDB作成
	int  SE_Number;
		
	SetDataList( int BGM_Num )
	{
		SE_Number 		= BGM_Num;
	}
		
}//End
	
	
	
		




