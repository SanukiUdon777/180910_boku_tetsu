package com.game.boku_tetsu;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;
import android.widget.TextView;

public class C0101_PlayerControl
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
			Initial_DispPos();

		
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
		public final static void fCall_EachTouchPanel()
		{		
			TouchCalc_DispPos();
			
		}
		
		//-----------------------------------------------------------------------//
		//定期的に処理される(データ処理)
		//-----------------------------------------------------------------------//	
		public final static void fCall_EachRoutineHander()
		{			
			//データ処理
			DispAngle_ToBoss();
			Calc_Hitback();		

		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas canvas, Paint DrawPaint)
		{	
			_func.DrawBmpCC.FixDiaplay(canvas, DrawPaint, 2, 0, 0, sPlayerInf.rCharXpos, sPlayerInf.rCharYpos );	
			_func.DrawBmp.FixDiaplay(canvas, DrawPaint, sPlayerInf.rBMP, sPlayerInf.rXpos, sPlayerInf.rYpos, sPlayerInf.rDisplayAngle );
	
		}

	//===========================================================================//
	//内部処理関数
	//===========================================================================//	
		//-----------------------------------------------------------------------//
		//プレイヤの画像表示角度
		//-----------------------------------------------------------------------//
		public static final void DispAngle_ToBoss()
		{	
			
			sPlayerInf.rDisplayAngle = (float)Math.toDegrees(Math.atan2((double)( +sPlayerInf.rYpos - 0.0f ), (double)(-sPlayerInf.rXpos + 0.0f )));
			sPlayerInf.rDisplayAngle += 90.0f;
		}
		
		//-----------------------------------------------------------------------//
		//プレイヤの表示位置
		//-----------------------------------------------------------------------//
		//初期化処理
		public static final void Initial_DispPos()
		{	
			//BMPの設定
			sPlayerInf.rBMP = _bmp.Player000;
			
			//初期位置の設定
			CheckMax_MoveArea();	
			Calc_DispPosOffset();			
		}
		
		//タッチパネル押下時の処理
		public static final void TouchCalc_DispPos()
		{	
			if( sPlayerInf.rHitBack_Count > 0 )
			{
				//ヒットバック中は移動禁止
				return;
			}
			
			sPlayerInf.rXpos += _ControlTouchPanel.fCheckMoveShirtDistance_X();
			sPlayerInf.rYpos += _ControlTouchPanel.fCheckMoveShirtDistance_Y();
			
			CheckMax_MoveArea();
			Calc_DispPosOffset();	
		}

		public static final void Calc_DispPosOffset()
		{	
				
			sPlayerInf.rCharXpos =  sPlayerInf.rXpos - (float) (0.25f * _bmp.Base_RatioSize * Math.cos(Math.toRadians((double)sPlayerInf.rDisplayAngle-90.0f)));
			sPlayerInf.rCharYpos =  sPlayerInf.rYpos + (float) (0.25f * _bmp.Base_RatioSize * Math.sin(Math.toRadians((double)sPlayerInf.rDisplayAngle-90.0f)));
			
		}
		
		
		//移動範囲の制限処理
		public static final void CheckMax_MoveArea()
		{	
				
			if( sPlayerInf.rXpos >= dMaxMove_X )
			{
				sPlayerInf.rXpos = dMaxMove_X;
			}
	
			if( sPlayerInf.rXpos <= -dMaxMove_X )
			{
				sPlayerInf.rXpos = -dMaxMove_X;
			}
			
			if( sPlayerInf.rYpos >= dMaxMove_Y_UP )
			{
				sPlayerInf.rYpos = dMaxMove_Y_UP;
			}
			
			if( sPlayerInf.rYpos <= dMaxMove_Y_DOWN )
			{
				sPlayerInf.rYpos = dMaxMove_Y_DOWN;
			}		
		}	
		
		//ヒットバック処理
		public static final void Calc_Hitback()
		{	
			if( sPlayerInf.rHitBack_Count > 0 )
			{
				sPlayerInf.rXpos += (float)( sPlayerInf.rHitBack_Distance * Math.cos(Math.toRadians((double)sPlayerInf.rHitBack_Angle)));
				sPlayerInf.rYpos += (float)( sPlayerInf.rHitBack_Distance * Math.sin(Math.toRadians((double)sPlayerInf.rHitBack_Angle)));
				sPlayerInf.rHitBack_Count--;
				
				CheckMax_MoveArea();
				Calc_DispPosOffset();	
				
			}	
		}			
		
	}