package com.game.boku_tetsu;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;
import android.widget.TextView;



public class B0200_PlayerControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
		//プレイヤ情報
		public static  _bsPlayerInf sPlayerInf = new _bsPlayerInf();
		
		//移動範囲
		final static float dMaxMove_X				= 0.9f;
		final static float dMaxMove_Y_UP			= +0.9f;		
		final static float dMaxMove_Y_DOWN			= -0.9f;
		

		
		static float AttackLength;
		static float AttackX, AttackY;
		static float AttackDegree;
		static float AttackSpeed;
		static float AttackStatus;
		
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachInitialHander()
		{
			//初期化処理
			sPlayerInf = new _bsPlayerInf();

			AttackSpeed = -5.0f;
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
			
			AttackStatus = lrNowTounchPanel;

					

			

		}
		
		//-----------------------------------------------------------------------//
		//定期的に処理される(データ処理)
		//-----------------------------------------------------------------------//	
		public final static void fCall_EachRoutineHander()
		{		
			if( AttackStatus == _g.dON )
			{
						AttackSpeed = -5.0f;
			}
			else
			{
						AttackSpeed = +5.0f;
			}

		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{	
			AttackDegree += AttackSpeed;
			
			if( AttackDegree < 25 )
			{
				AttackDegree = 25;
			}
			else 	if( AttackDegree > 90+25 )
			{
				AttackDegree = 90+25;
			}

			double radian =  AttackDegree * Math.PI / 180.0;
			AttackLength = 0.50f;
			
			AttackX = (float) (Math.cos(radian)*AttackLength + sPlayerInf.rXpos);
			AttackY = (float) (Math.sin(radian)*AttackLength + sPlayerInf.rYpos);
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_pikopiko000, AttackX, sPlayerInf.rYpos+AttackY, -(AttackDegree -90));	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.Player003, sPlayerInf.rXpos, sPlayerInf.rYpos,  0 );	
			
			
			
			
			
			
			
			//test
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_pikopiko000, -(+AttackX), sPlayerInf.rYpos+AttackY, +(AttackDegree -90));	
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.Player003, -sPlayerInf.rXpos, sPlayerInf.rYpos,  0 );			
			
			
			
		}


		
	}