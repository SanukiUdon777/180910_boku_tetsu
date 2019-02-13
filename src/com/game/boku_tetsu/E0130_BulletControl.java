package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Paint;



public class E0130_BulletControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_esBullet[] sEnemyBullet 	= new _esBullet[_esBullet.dMax];
	public static int EnemyShotBulletNumber	= 0;
	
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//		
		//-----------------------------------------------------------------------//
		//弾丸の発射要求
		//-----------------------------------------------------------------------//
		public final static void fShotReqEnemyBullet(float X_Pos, float Y_Pos, int BMP ,int Damage ,float Speed, float Angle)
		{	
			//プレイヤ弾丸
			if(EnemyShotBulletNumber >= _esBullet.dMax)
			{
				EnemyShotBulletNumber = 0;
			}

			sEnemyBullet[EnemyShotBulletNumber].rX_Pos = X_Pos;
			sEnemyBullet[EnemyShotBulletNumber].rY_Pos = Y_Pos;
			sEnemyBullet[EnemyShotBulletNumber].rBMP = BMP;
			sEnemyBullet[EnemyShotBulletNumber].rDamege = Damage;
			sEnemyBullet[EnemyShotBulletNumber].rSpeed = Speed;			
			sEnemyBullet[EnemyShotBulletNumber].rAngle = Angle;
			sEnemyBullet[EnemyShotBulletNumber].rDisplay = _g.dON;

			EnemyShotBulletNumber++;
			
		}		
		
		
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachInitialHander()
		{
			 //構造体の実体化/初期化
			 for(int i = 0; i < _esBullet.dMax; i++)
			 {
				 sEnemyBullet[i] = new _esBullet();
				
			 }

			 
			 
			 
			 
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
			//移動
			 for(int i = 0; i < _esBullet.dMax; i++)
			 {
				 //敵弾丸
				 if(sEnemyBullet[i].rDisplay == _g.dON)
				 {
					 float Radian = (float) (sEnemyBullet[i].rAngle * Math.PI / 180.0);
					 float Speed = sEnemyBullet[i].rSpeed;
					 sEnemyBullet[i].rX_Pos += (float) (Math.cos(Radian)*Speed);
					 sEnemyBullet[i].rY_Pos += (float) (Math.sin(Radian)*Speed);
					  
					 if( Math.abs(sEnemyBullet[i].rX_Pos) >= _e.dMaxAllFiled_XSize | Math.abs(sEnemyBullet[i].rY_Pos) >= _e.dMaxAllFiled_YSize)
					 {
						 sEnemyBullet[i].rDisplay = _g.dOFF;
					 }
 
				 }				 			  
			 } 
			 
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			//弾丸
			 for(int i = 0; i < _esBullet.dMax - 1; i++)
			 {
				 if(sEnemyBullet[i].rDisplay == _g.dON)
				 {
					 _func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, sEnemyBullet[i].rBMP, sEnemyBullet[i].rX_Pos, sEnemyBullet[i].rY_Pos,  180.0f );	

				 }
			 }	
		}

	}