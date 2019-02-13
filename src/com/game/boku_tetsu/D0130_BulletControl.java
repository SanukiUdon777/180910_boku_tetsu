package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Paint;



public class D0130_BulletControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_dsBullet[] sPlayerBullet 	= new _dsBullet[_dsBullet.dMax];
	public static int PlayerShotBulletNumber	= 0;

	public static  	_dsBullet[] sEnemyBullet 	= new _dsBullet[_dsBullet.dMax];
	public static int EnemyShotBulletNumber	= 0;
	
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//弾丸の発射要求
		//-----------------------------------------------------------------------//
		public final static void fShotReqPlayerBullet(float X_Pos, float Y_Pos, float Speed, float Angle)
		{	
			//プレイヤ弾丸
			if(PlayerShotBulletNumber >= _dsBullet.dMax)
			{
				PlayerShotBulletNumber = 0;
			}

			sPlayerBullet[PlayerShotBulletNumber].rX_Pos = X_Pos;
			sPlayerBullet[PlayerShotBulletNumber].rY_Pos = Y_Pos;
			sPlayerBullet[PlayerShotBulletNumber].rSpeed = Speed;			
			sPlayerBullet[PlayerShotBulletNumber].rAngle = Angle;
			sPlayerBullet[PlayerShotBulletNumber].rDisplay = _g.dON;

			PlayerShotBulletNumber++;
			
		}
		
		//-----------------------------------------------------------------------//
		//弾丸の発射要求
		//-----------------------------------------------------------------------//
		public final static void fShotReqEnemyBullet(float X_Pos, float Y_Pos, float Speed, float Angle)
		{	
			//プレイヤ弾丸
			if(EnemyShotBulletNumber >= _dsBullet.dMax)
			{
				EnemyShotBulletNumber = 0;
			}

			sEnemyBullet[EnemyShotBulletNumber].rX_Pos = X_Pos;
			sEnemyBullet[EnemyShotBulletNumber].rY_Pos = Y_Pos;
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
			 for(int i = 0; i < _dsBullet.dMax; i++)
			 {
				 sPlayerBullet[i] = new _dsBullet();
				 sEnemyBullet[i] = new _dsBullet();
				
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
			 for(int i = 0; i < _dsBullet.dMax; i++)
			 {
				 //プレイヤ弾丸
				 if(sPlayerBullet[i].rDisplay == _g.dON)
				 {
					 float Radian = (float) (sPlayerBullet[i].rAngle * Math.PI / 180.0);
					 float Speed = sPlayerBullet[i].rSpeed;
					 sPlayerBullet[i].rX_Pos += (float) (Math.cos(Radian)*Speed);
					 sPlayerBullet[i].rY_Pos += (float) (Math.sin(Radian)*Speed);
				 }
				 
				 //敵弾丸
				 if(sEnemyBullet[i].rDisplay == _g.dON)
				 {
					 float Radian = (float) (sEnemyBullet[i].rAngle * Math.PI / 180.0);
					 float Speed = sEnemyBullet[i].rSpeed;
					 sEnemyBullet[i].rX_Pos += (float) (Math.cos(Radian)*Speed);
					 sEnemyBullet[i].rY_Pos += (float) (Math.sin(Radian)*Speed);
				 }				 
				  
			 } 
			 
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			//弾丸
			 for(int i = 0; i < _dsBullet.dMax - 1; i++)
			 {
				 if(sPlayerBullet[i].rDisplay == _g.dON)
				 {	
					 if(i%2==0)
					 {
						 _func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_l, sPlayerBullet[i].rX_Pos, sPlayerBullet[i].rY_Pos,  0 );	
					 }
					 else
					 {
						 _func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_r, sPlayerBullet[i].rX_Pos, sPlayerBullet[i].rY_Pos,  0 );	
					 }
				}
				 
				 if(sEnemyBullet[i].rDisplay == _g.dON)
				 {
					 if(i%2==0)
					 {
						 _func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_l, sEnemyBullet[i].rX_Pos, sEnemyBullet[i].rY_Pos,  180.0f );	
					 }
					 else
					 {
						 _func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_r, sEnemyBullet[i].rX_Pos, sEnemyBullet[i].rY_Pos,  180.0f );	
					 }	
				 }
				 
			 }
		
			
		}

	}