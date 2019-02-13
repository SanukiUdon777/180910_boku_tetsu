package com.game.boku_tetsu;

/////////////////////////////////////////////////////////////	
//Define宣言
class _e	//GLOBAL Define宣言
{
	//
	final 	static float 				dBaseTextSize 			= 0.10f;
	final 	static float 				dBaseLineSize 			= 0.01f;

	final 	static float 				dMaxAllFiled_XSize 		= 2.0f;	
	final 	static float 				dMaxAllFiled_YSize 		= 2.0f;	
	
	final 	static float 				dMaxBattleFiled_XSize 	= 0.95f;
	final 	static float 				dMaxBattleFiled_YSize 	= 0.95f;

	final 	static int 					dMaxStage =5;
}


/////////////////////////////////////////////////////////////	
//構造体宣言
class _esStage
{	
	//RAM定義

	
	
}


class _esPlayer
{	
	//設定値
	final 	static int 		dInital_HP 		= +100;
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= -0.0f;
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
	_esPlayer()
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

class _esEnemy
{	
	//設定値
	final 	static int 		dInital_HP 		= +100;
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= +1.0f;
	final 	static float 	dSize 			= +0.3f;
	final	static	int		dMaxRepeat		= 1;
	final	static	int		dChargeTime		= (int)(0.25*_g.MainHandler.dMainRoutine);
	
	//RAM定義
	public 	int 		rSelectStage;
	public 	int 		rBMP;	
	public 	int 		rHP;
	public 	float 		rX_Pos;
	public 	float 		rY_Pos;	
	public 	float 		rX_Size;
	public 	float 		rY_Size;
	public 	int			rShortInhibit;
	public 	int			rRepeatCounter;
	
	//初期化処理
	_esEnemy()
	{
		rSelectStage	= 0;
		rBMP			= 0;
		rHP				= dInital_HP;	
		rX_Pos 			= dInital_X_Pos;
		rY_Pos 			= dInital_Y_Pos;
		rX_Size 		= dSize;
		rY_Size 		= dSize;
		rShortInhibit 	= _g.dOFF;
		rRepeatCounter 	= dMaxRepeat;
	}
}

class _esBullet
{	
	//設定値
	final 	static int 		dMax 			= +500;
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= -0.0f;
	final 	static float 	dSize 			= +0.1f;
	
	//RAM定義
	public 	int 		rDisplay;
	public 	int 		rBMP;
	public 	int 		rDamege;
	public 	float 		rX_Pos;
	public 	float 		rY_Pos;	
	public 	float 		rX_Size;
	public 	float 		rY_Size;

	public 	float 		rSpeed;
	public 	float 		rAngle;
	
	//初期化処理
	_esBullet()
	{
		rDisplay 	= _g.dOFF;
		rBMP		= 0;
		rDamege		= 0;
		rX_Pos 		= dInital_X_Pos;
		rY_Pos 		= dInital_Y_Pos;
		rX_Size 	= dSize;
		rY_Size 	= dSize;
		rSpeed		= 0.0f;
		rAngle		= 0.0f;
	}
}

class _esBattleField	
{	
	//設定値
	final 	static float 	dInital_X_Pos 	= +0.0f;
	final 	static float 	dInital_Y_Pos 	= -0.25f;

	
	final 	static float 	dInital_Size 	= +0.5f;


	
	//RAM定義
	public 	float 		rCenter_X;
	public 	float 		rCenter_Y;
	
	public 	float 		rMin_X;
	public 	float 		rMax_X;
	public 	float 		rMin_Y;
	public 	float 		rMax_Y;
		
	//初期化処理
	_esBattleField()
	{
		rCenter_X = dInital_X_Pos;
		rCenter_Y = dInital_Y_Pos;
		rMin_X = -dInital_Size;
		rMax_X = +dInital_Size;
		rMin_Y = -dInital_Size;
		rMax_Y = +dInital_Size;
	}
}










