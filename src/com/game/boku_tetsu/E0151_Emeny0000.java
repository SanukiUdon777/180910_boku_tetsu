package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Paint;

public class E0151_Emeny0000
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_esEnemy 	sEnemy		= new _esEnemy();
	public static  	int			rWaitCounter 	= _esEnemy.dChargeTime;
	
	public static  	float		rMovePos 	= 0.0f;
	
	public static  	int			rShotLR 		= 0;
	
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachInitialHander()
		{
			//初期化処理
			sEnemy = new _esEnemy();


		}
		
		//-----------------------------------------------------------------------//
		//終了時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachEndHander()
		{

		}
		
		//-----------------------------------------------------------------------//
		//パネルタッチ時に処理される
		//-----------------------------------------------------------------------//	
		public final static void fCall_EachTouchPanel( int lrNowTounchPanel )
		{		
			

			

		}
		
		//-----------------------------------------------------------------------//
		//定期的に処理される(データ処理)
		//-----------------------------------------------------------------------//	
		public final static void fCall_EachRoutineHander()
		{		
			 
			rMovePos++;
			float Radian = (float)(rMovePos * Math.PI / 180.0);
			sEnemy.rX_Pos = (float)(0.25f*Math.sin(Radian));
			 
			//戦場中央位置
			E0110_FiledControl.sBTField.rCenter_X += (float)(0.0025f*Math.cos(Radian));
			E0110_FiledControl.sBTField.rCenter_Y += (float)(0.0025f*Math.sin(Radian));				
			
			//戦場サイズ
			E0110_FiledControl.sBTField.rMax_X-= (float)(0.0025f*Math.sin(Radian));		 
			E0110_FiledControl.sBTField.rMin_X+= (float)(0.0025f*Math.sin(Radian));	
			E0110_FiledControl.sBTField.rMax_Y-= (float)(0.0025f*Math.sin(Radian));		 
			E0110_FiledControl.sBTField.rMin_Y+= (float)(0.0025f*Math.sin(Radian));	
			
			
					 rWaitCounter--;
					 
					 if(rWaitCounter<0)
					 {
						 rShotLR++;
						 rShotLR = rShotLR % 2;
						 if(rShotLR == 0)
						 {
							 //正解
							 E0130_BulletControl.fShotReqEnemyBullet(sEnemy.rX_Pos-_bmp.Player_RatioSize_XY,sEnemy.rY_Pos, _bmp.de0000, +10, 0.1f, -90.0f);
						 }
						 else
						 {
							 //不正解
							 E0130_BulletControl.fShotReqEnemyBullet(sEnemy.rX_Pos+_bmp.Player_RatioSize_XY,sEnemy.rY_Pos, _bmp.de0001, -10, 0.1f, -90.0f);		 
						 }
						 
						 
						 rWaitCounter=_esEnemy.dChargeTime;
					 }
				 
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{	
			
			
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, E0150_EnemyControl.sEnemy.rBMP, sEnemy.rX_Pos, sEnemy.rY_Pos,  0 );	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_c, sEnemy.rX_Pos-_bmp.Player_RatioSize_XY, sEnemy.rY_Pos,  -180.0f );	
			//_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_r, sEnemy.rX_Pos-_bmp.Player_RatioSize_XY, sEnemy.rY_Pos,  -180.0f );	
			//_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_l, sEnemy.rX_Pos+_bmp.Player_RatioSize_XY, sEnemy.rY_Pos,  -180.0f );	

			
			
			
			
			
		}


		
	}