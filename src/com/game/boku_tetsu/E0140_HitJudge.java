package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class E0140_HitJudge
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	

	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//		
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachInitialHander()
		{

			 
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
			double BulletRange = 0;
			 //ヒット判定
			 for(int i = 0; i < _esBullet.dMax; i++)
			 {
				//全壁
				if(E0130_BulletControl.sEnemyBullet[i].rDisplay == _g.dON)
				{
					double x1 = E0120_PlayerControl.sPlayer.rX_Pos;
					double y1 = E0120_PlayerControl.sPlayer.rY_Pos;
					double x2 = E0130_BulletControl.sEnemyBullet[i].rX_Pos;
					double y2 = E0130_BulletControl.sEnemyBullet[i].rY_Pos;
					 
					BulletRange = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
						 
					//範囲確認
					if(BulletRange<=(float)_bmp.Player_RatioSize_XY/2)
					{					
						E0130_BulletControl.sEnemyBullet[i].rDisplay = _g.dOFF;
						
						if(E0130_BulletControl.sEnemyBullet[i].rDamege>0)
						{
							E0150_EnemyControl.sEnemy.rHP -= E0130_BulletControl.sEnemyBullet[i].rDamege;
						}
						else
						{
							E0120_PlayerControl.sPlayer.rHP += E0130_BulletControl.sEnemyBullet[i].rDamege;
						}
							
						
					}				  
				 }
			 }
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			//float AllPoint = _esWall.dMax
			/*
			float disp=0;
			 for(int i2 = 0; i2 < _esWall.dMax; i2++)
			 {
				 disp += E0110_FiledControl.sWall[i2].rY_Pos;
			 }

			_func.DrawText.FixDiaplay_Center(DrawCanvas, DrawPaint, String.format("%.2f", disp)+"%", 0.0f, 1.2f, 0.1f, Color.WHITE);
			*/
			//disp
			//_func.DrawText.FixDiaplay_Center(DrawCanvas, DrawPaint, String.format("%.2f%", disp), 0.0f, 1.2f, 0.1f, Color.WHITE);
			
		}

	}