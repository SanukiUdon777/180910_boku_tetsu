package com.game.boku_tetsu;

import com.game.boku_tetsu._func.DrawLine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;
import android.widget.TextView;



public class D0110_FiledControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_dsWall[] sWall 	= new _dsWall[_dsWall.dMax];

	
	
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachInitialHander()
		{
			 //構造体の実体化/初期化
			 for(int i = 0; i < _dsWall.dMax; i++)
			 {
				 sWall[i] = new _dsWall();
				 sWall[i].rX_Pos = -1.0f + ((2.0f/_dsWall.dMax) * i);
				 

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

				
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			//壁
			 for(int i = 0; i < _dsWall.dMax - 1; i++)
			 {
				 DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, sWall[i].rX_Pos, sWall[i].rY_Pos, sWall[i+1].rX_Pos, sWall[i+1].rY_Pos, 0.01f, Color.WHITE, Paint.Style.STROKE);
				 
			 }
			
			//外枠
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, +(_d.dMaxBattleFiled_XSize), +(_d.dMaxBattleFiled_YSize), -(_d.dMaxBattleFiled_XSize), +(_d.dMaxBattleFiled_YSize), 0.01f, Color.WHITE, Paint.Style.STROKE);
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, +(_d.dMaxBattleFiled_XSize), -(_d.dMaxBattleFiled_YSize), -(_d.dMaxBattleFiled_XSize), -(_d.dMaxBattleFiled_YSize), 0.01f, Color.WHITE, Paint.Style.STROKE);
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, +(_d.dMaxBattleFiled_XSize), +(_d.dMaxBattleFiled_YSize), +(_d.dMaxBattleFiled_XSize), -(_d.dMaxBattleFiled_YSize), 0.01f, Color.WHITE, Paint.Style.STROKE);
			DrawLine.Line_FixDiaplay(DrawCanvas, DrawPaint, -(_d.dMaxBattleFiled_XSize), +(_d.dMaxBattleFiled_YSize), -(_d.dMaxBattleFiled_XSize), -(_d.dMaxBattleFiled_YSize), 0.01f, Color.WHITE, Paint.Style.STROKE);
			
			


		}

	}