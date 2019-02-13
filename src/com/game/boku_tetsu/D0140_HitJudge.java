package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class D0140_HitJudge
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
			 
			 //ヒット判定
			 double BulletRange = 0;
			 int 	HitJudge = _g.dOFF;
			 for(int i = 0; i < _dsBullet.dMax; i++)
			 {
				 //全弾丸
				 HitJudge = _g.dOFF;
				 
				 for(int i2 = 0; i2 < _dsWall.dMax; i2++)
				 {
					 //全壁
					 if(D0130_BulletControl.sPlayerBullet[i].rDisplay == _g.dON)
					 {
						 double x1 = D0110_FiledControl.sWall[i2].rX_Pos;
						 double y1 = D0110_FiledControl.sWall[i2].rY_Pos;
						 double x2 = D0130_BulletControl.sPlayerBullet[i].rX_Pos;
						 double y2 = D0130_BulletControl.sPlayerBullet[i].rY_Pos;
					 
						 BulletRange = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
						 
						 	//範囲確認
							if(BulletRange<=0.2d)
							{
								
								D0110_FiledControl.sWall[i2].rY_Pos += (0.2d-BulletRange)*0.5f;
								
								//弾丸の削除判定
								if(BulletRange<=0.15d)
								{
									HitJudge = _g.dON;
								}
							
							}				 
						 
						 
					 }
					 
				 }
				  
				//弾丸の削除
				 if(HitJudge == _g.dON)
				 {
					 D0130_BulletControl.sPlayerBullet[i].rDisplay = _g.dOFF;
					 
				 }		 
			 }
			 
	
			 
			 
			 for(int i = 0; i < _dsBullet.dMax; i++)
			 {
				 //全弾丸
				 HitJudge = _g.dOFF;
				 
				 for(int i2 = 0; i2 < _dsWall.dMax; i2++)
				 {
					 //全壁
					 if(D0130_BulletControl.sEnemyBullet[i].rDisplay == _g.dON)
					 {
						 double x1 = D0110_FiledControl.sWall[i2].rX_Pos;
						 double y1 = D0110_FiledControl.sWall[i2].rY_Pos;
						 double x2 = D0130_BulletControl.sEnemyBullet[i].rX_Pos;
						 double y2 = D0130_BulletControl.sEnemyBullet[i].rY_Pos;
					 
						 BulletRange = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
						 
						 	//範囲確認
							if(BulletRange<=0.2d)
							{
								
								D0110_FiledControl.sWall[i2].rY_Pos -= (0.2d-BulletRange)*0.5f;
								
								//弾丸の削除判定
								if(BulletRange<=0.15d)
								{
									HitJudge = _g.dON;
								}
							
							}				 
						 
						 
					 }
					 
				 }
				  
				//弾丸の削除
				 if(HitJudge == _g.dON)
				 {
					 D0130_BulletControl.sEnemyBullet[i].rDisplay = _g.dOFF;
					 
				 }		 
			 }
			 			 
			 
			 
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			//float AllPoint = _dsWall.dMax
			
			float disp=0;
			 for(int i2 = 0; i2 < _dsWall.dMax; i2++)
			 {
				 disp += D0110_FiledControl.sWall[i2].rY_Pos;
			 }

			_func.DrawText.FixDiaplay_Center(DrawCanvas, DrawPaint, String.format("%.2f", disp)+"%", 0.0f, 1.2f, 0.1f, Color.WHITE);
			
			//disp
			//_func.DrawText.FixDiaplay_Center(DrawCanvas, DrawPaint, String.format("%.2f%", disp), 0.0f, 1.2f, 0.1f, Color.WHITE);
			
		}

	}