package com.game.boku_tetsu;

/////////////////////////////////////////////////////////////	
//Define宣言
class _d	//GLOBAL Define宣言
{

	//
	final 	static float 				dBaseTextSize 			= 0.10f;
	final 	static float 				dBaseLineSize 			= 0.01f;

	final 	static float 				dMaxBattleFiled_XSize 	= 0.95f;
	final 	static float 				dMaxBattleFiled_YSize 	= 0.95f;


}


/////////////////////////////////////////////////////////////	
//構造体宣言
class _dsPlayer
{	
	//設定値
	final 	static int 		dInital_HP 		= +100;
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= -1.0f;
	final 	static float 	dSize 			= +0.1f;
	final	static	int		dMaxRepeat		= 1;
	final	static	int		dChargeTime		= (int)(0.1*_g.MainHandler.dMainRoutine);
	
	//RAM定義
	public 	int 		rHP;
	public 	float 		rX_Pos;
	public 	float 		rY_Pos;	
	public 	float 		rX_Size;
	public 	float 		rY_Size;
	public 	int			rShortInhibit;
	public 	int			rRepeatCounter;
	
	//初期化処理
	_dsPlayer()
	{
		rHP				= dInital_HP;
		rX_Pos 			= dInital_X_Pos;
		rY_Pos 			= dInital_Y_Pos;
		rX_Size 		= dSize;
		rY_Size 		= dSize;
		rShortInhibit 	= _g.dOFF;
		rRepeatCounter 	= dMaxRepeat;
	}
}

class _dsEnemy
{	
	//設定値
	final 	static int 		dInital_HP 		= +100;
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= +1.0f;
	final 	static float 	dSize 			= +0.1f;
	final	static	int		dMaxRepeat		= 1;
	final	static	int		dChargeTime		= (int)(0.25*_g.MainHandler.dMainRoutine);
	
	//RAM定義
	public 	int 		rHP;
	public 	float 		rX_Pos;
	public 	float 		rY_Pos;	
	public 	float 		rX_Size;
	public 	float 		rY_Size;
	public 	int			rShortInhibit;
	public 	int			rRepeatCounter;
	
	//初期化処理
	_dsEnemy()
	{
		rHP				= dInital_HP;	
		rX_Pos 			= dInital_X_Pos;
		rY_Pos 			= dInital_Y_Pos;
		rX_Size 		= dSize;
		rY_Size 		= dSize;
		rShortInhibit 	= _g.dOFF;
		rRepeatCounter 	= dMaxRepeat;
	}
}

class _dsBullet
{	
	//設定値
	final 	static int 		dMax 			= +500;
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= -0.0f;
	final 	static float 	dSize 			= +0.1f;
	
	//RAM定義
	public 	int 		rDisplay;
	
	public 	float 		rX_Pos;
	public 	float 		rY_Pos;	
	public 	float 		rX_Size;
	public 	float 		rY_Size;

	public 	float 		rSpeed;
	public 	float 		rAngle;
	
	//初期化処理
	_dsBullet()
	{
		rDisplay 	= _g.dOFF;		
		rX_Pos 		= dInital_X_Pos;
		rY_Pos 		= dInital_Y_Pos;
		rX_Size 	= dSize;
		rY_Size 	= dSize;
		rSpeed		= 0.0f;
		rAngle		= 0.0f;
	}
}

class _dsWall	
{	
	//設定値
	final 	static int 		dMax 			= +500;
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= -0.0f;
	final 	static float 	dSize 			= +0.1f;
	
	//RAM定義
	public 	float 		rX_Pos;
	public 	float 		rY_Pos;	
	public 	float 		rX_Size;
	public 	float 		rY_Size;
		
	//初期化処理
	_dsWall()
	{
		rX_Pos = dInital_X_Pos;
		rY_Pos = dInital_Y_Pos;
		rX_Size = dSize;
		rY_Size = dSize;
	}
}










