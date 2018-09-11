package com.game.boku_tetsu;

class _bgm
{	
//---------------------------------------------------------------------------//
//BMP登録番号(呼び出し番号)
//---------------------------------------------------------------------------//	
	final static int Stop		 	= 0;
	final static int ReStart		= 1;
	final static int Tytle 			= 2;
	final static int SelectStage 	= 3;
	final static int PlayStage 		= 4;
	final static int BGM_END		= ( PlayStage + 1 );				//登録番号の終端番号	

	
//---------------------------------------------------------------------------//
//BGM初期化データ値(音楽データ設定値)
//---------------------------------------------------------------------------//	
	public static BgmDataList[] BgmDataList = 
		{
			new BgmDataList( R.raw.bgm_no_sound 						),	//0000
			new BgmDataList( R.raw.bgm_no_sound 						),	//0001
			new BgmDataList( R.raw.bgm_maoudamashii_acoustic09 			),	//0002		
			new BgmDataList( R.raw.bgm_game_maoudamashii_5_casino04 	),	//0003		
			new BgmDataList( R.raw.bgm_dvorak_symphony_no9_4th_2013 	)	//0004		
	
		};	
}//End

//===========================================================================//
//BGM初期設定用の構造体
//===========================================================================//
class BgmDataList
{	
	//BMP初期化用のDB作成
	int  BGM_Number;
		
	BgmDataList( int BGM_Num )
	{
		BGM_Number 		= BGM_Num;
	}
		
}//End
	
	
	
		




