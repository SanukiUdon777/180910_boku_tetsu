package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Paint;



public class D0120_PlayerControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_dsPlayer 	sPlayer 		= new _dsPlayer();
	public static  	int			rWaitCounter 	= _dsPlayer.dChargeTime;
	
	public static  	int			rShotLR 		= 0;
	
	
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachInitialHander()
		{
			sPlayer = new _dsPlayer();
			 
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
			sPlayer.rX_Pos = _ControlTouchPanel.fCheckToutchX();
			sPlayer.rShortInhibit = lrNowTounchPanel;
			
			 if(sPlayer.rRepeatCounter > 0 && sPlayer.rShortInhibit == _g.dOFF)
			 {
				 
				 rShotLR++;
				 rShotLR = rShotLR % 2;
				 if(rShotLR == 0)
				 {
					 D0130_BulletControl.fShotReqPlayerBullet(sPlayer.rX_Pos+_bmp.Player_RatioSize_XY, sPlayer.rY_Pos, 0.1f, 90.0f);
				 }
				 else
				 {
					 D0130_BulletControl.fShotReqPlayerBullet(sPlayer.rX_Pos-_bmp.Player_RatioSize_XY, sPlayer.rY_Pos, 0.1f, 90.0f);
				 }
				 sPlayer.rRepeatCounter--;
				 
				 if(sPlayer.rRepeatCounter<0)
				 {
					 sPlayer.rRepeatCounter=0;
				 }
			 }
			 
		}
		
		//-----------------------------------------------------------------------//
		//定期的に処理される(データ処理)
		//-----------------------------------------------------------------------//	
		public final static void fCall_EachRoutineHander()
		{		
			if(sPlayer.rRepeatCounter<_dsPlayer.dChargeTime)
			{
				if(rWaitCounter>0)
				{
					rWaitCounter--;
				}
				else
				{
					rWaitCounter = _dsPlayer.dChargeTime;
					sPlayer.rRepeatCounter++;
					
				}
	
			}
			
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_c, sPlayer.rX_Pos, sPlayer.rY_Pos,  0 );	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_l, sPlayer.rX_Pos-_bmp.Player_RatioSize_XY, sPlayer.rY_Pos,  0 );	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_r, sPlayer.rX_Pos+_bmp.Player_RatioSize_XY, sPlayer.rY_Pos,  0 );	

		}

	}