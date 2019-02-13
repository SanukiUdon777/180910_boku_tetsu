package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Paint;

public class B0501_Emeny0001
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_dsEnemy 	sEnemy		= new _dsEnemy();
	
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
	

		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{	

			
			
			//test
			//_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_pikopiko000, -(+AttackX), sPlayerInf.rYpos+AttackY, +(AttackDegree -90));	
			//_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.Player003, -sPlayerInf.rXpos, sPlayerInf.rYpos,  0 );			
			
			
			
		}


		
	}