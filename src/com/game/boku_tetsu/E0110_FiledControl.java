package com.game.boku_tetsu;

import com.game.boku_tetsu._func.DrawLine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;
import android.widget.TextView;



public class E0110_FiledControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_esBattleField sBTField 	= new _esBattleField();

	
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

				
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			
			//外枠
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, sBTField.rMin_X+sBTField.rCenter_X, sBTField.rMax_Y+sBTField.rCenter_Y, sBTField.rMax_X+sBTField.rCenter_X, sBTField.rMax_Y+sBTField.rCenter_Y, 0.01f, Color.WHITE, Paint.Style.STROKE);
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, sBTField.rMin_X+sBTField.rCenter_X, sBTField.rMin_Y+sBTField.rCenter_Y, sBTField.rMax_X+sBTField.rCenter_X, sBTField.rMin_Y+sBTField.rCenter_Y, 0.01f, Color.WHITE, Paint.Style.STROKE);
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, sBTField.rMin_X+sBTField.rCenter_X, sBTField.rMax_Y+sBTField.rCenter_Y, sBTField.rMin_X+sBTField.rCenter_X, sBTField.rMin_Y+sBTField.rCenter_Y, 0.01f, Color.WHITE, Paint.Style.STROKE);
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, sBTField.rMax_X+sBTField.rCenter_X, sBTField.rMax_Y+sBTField.rCenter_Y, sBTField.rMax_X+sBTField.rCenter_X, sBTField.rMin_Y+sBTField.rCenter_Y, 0.01f, Color.WHITE, Paint.Style.STROKE);

		}

	}