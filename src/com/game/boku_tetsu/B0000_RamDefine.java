package com.game.boku_tetsu;


class _b	//GLOBAL Define宣言
{
	//表示位置
	final 	static int 					dMaxRow 		= 25;			//横-行
	final 	static int 					dMaxCol 		= 25;			//縦-列
	public 	static 	_bsGameDisplayInf	sGameDispInf	= new _bsGameDisplayInf();

	//
	final 	static float 				dBaseTextSize 	= 0.10f;		//横-行
	final 	static float 				dBaseLineSize 	= 0.01f;		//横-行

	//
	public static int 					rSelectStage	= 0;
}
	
	
/////////////////////////////////////////////////////////////	
//構造体宣言
class _bsGameDisplayInf	
{	
	public float[] 	rX_Pos = new float[_b.dMaxRow];
	public float[] 	rY_Pos = new float[_b.dMaxCol];	
	public float 	rX_Size;
	public float 	rY_Size;
					
}
	
class _bsPlayerInf
{
	//現在の表示位置
	float 	rXpos;
	float 	rYpos;	
	float	rDisplayAngle;

	float 	rCharXpos;
	float 	rCharYpos;	
	
	int		rBMP = 0;
	
	float	rHitBack_Count;		//通常移動無効時間
	float 	rHitBack_Angle;		//
	float 	rHitBack_Distance;	//
	
	_bsPlayerInf()
	{
		rXpos = -0.5f;
		rYpos = 0.0f;	
		rDisplayAngle = 0f;		
		
		rCharXpos = 0f;
		rCharYpos = 0f;
		
		rBMP = 0;	
		
		rHitBack_Count = 0f;
		rHitBack_Angle = 0f;
		rHitBack_Distance = 0f;
	}
}

class _bsEnemyInf
{		
	float 	rXpos;
	float 	rYpos;
	float 	rDisplayAngle;

	float 	rTargetXpos;
	float 	rTargetYpos;
	
	int		rHP;
	int		rMode;
	
	int 	rBMP;
	
	float	rHitBack_Count;		//通常移動無効時間
	float 	rHitBack_Angle;		//
	float 	rHitBack_Distance;	//
	
	
	_bsEnemyInf()
	{
		rXpos = rTargetXpos = 0f;
		rYpos = rTargetYpos = 1.0f;
		rDisplayAngle = 0;
		
		rHP = 0;
		rMode = 0;
		rBMP = 0;
		
		rHitBack_Count = 0f;
		rHitBack_Angle = 0f;
		rHitBack_Distance = 0f;
	}
}

class _bsBulletInf
{	
	//個別の設定値
	final int 	dDispOFF = 0;
	final int 	dDispON  = 1;
	int rDisplay;
	
	float rXpos;
	float rYpos;
	float rSize;
	
	float rMoveSpeed;
	float rMoveAngle;
	float rDisplayAngle;
	float rRotation;
	
	final static int 	dReflectOFF = 0;
	final static int 	dReflectON  = 1;
	int rPlayerReflect;

	final int 	dDamegeOFF = 0;
	final int 	dDamegeON  = 1;
	int rDamegeBullet;
	
	String	rBulletString;
	
	_bsBulletInf()
	{
		rDisplay 		= dDispOFF;
		
		rXpos 			= 0.0f;
		rYpos 			= 0.0f;
		rSize 			= 0.0f;
		
		rMoveSpeed 		= 0.0f;
		rMoveAngle		= 0.0f;
		rDisplayAngle 	= 0.0f;
		rRotation		= 0.0f;
		
		rPlayerReflect 		= dReflectOFF;
		rDamegeBullet		= dDamegeOFF;
		
		rBulletString = "";
	}
}








		




