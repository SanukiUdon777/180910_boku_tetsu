package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Paint;

public class D0151_Emeny0001
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_dsEnemy 	sEnemy		= new _dsEnemy();
	public static  	int			rWaitCounter 	= _dsEnemy.dChargeTime;
	
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
			sEnemy = new _dsEnemy();


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
			sEnemy.rX_Pos = (float)(0.85f*Math.sin(Radian));
			 
			
				
				 
					 
					 rWaitCounter--;
					 
					 if(rWaitCounter<0)
					 {
						 rShotLR++;
						 rShotLR = rShotLR % 2;
						 if(rShotLR == 0)
						 {
							 D0130_BulletControl.fShotReqEnemyBullet(sEnemy.rX_Pos-_bmp.Player_RatioSize_XY, sEnemy.rY_Pos, 0.1f, -90.0f);
						 }
						 else
						 {
							 D0130_BulletControl.fShotReqEnemyBullet(sEnemy.rX_Pos+_bmp.Player_RatioSize_XY, sEnemy.rY_Pos, 0.1f, -90.0f);		 
						 }
						 
						 
						 rWaitCounter=_dsEnemy.dChargeTime;
					 }
				 
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.Char000, sEnemy.rX_Pos, sEnemy.rY_Pos,  0 );	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_r, sEnemy.rX_Pos-_bmp.Player_RatioSize_XY, sEnemy.rY_Pos,  -180.0f );	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_l, sEnemy.rX_Pos+_bmp.Player_RatioSize_XY, sEnemy.rY_Pos,  -180.0f );	

			
			
			
			
			
		}


		
	}