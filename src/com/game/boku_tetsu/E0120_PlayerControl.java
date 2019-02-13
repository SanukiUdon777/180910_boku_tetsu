package com.game.boku_tetsu;



import android.graphics.Canvas;
import android.graphics.Paint;



public class E0120_PlayerControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	
	public static  	_esPlayer 	sPlayer 		= new _esPlayer();
	
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachInitialHander()
		{
			sPlayer = new _esPlayer();
			sPlayer.rX_Pos += E0110_FiledControl.sBTField.rCenter_X;
			sPlayer.rY_Pos += E0110_FiledControl.sBTField.rCenter_Y;
		
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
			sPlayer.rX_Pos += _ControlTouchPanel.fCheckMoveShirtDistance_X();
			sPlayer.rY_Pos += _ControlTouchPanel.fCheckMoveShirtDistance_Y();
			
			if(sPlayer.rX_Pos < E0110_FiledControl.sBTField.rMin_X+ E0110_FiledControl.sBTField.rCenter_X+_bmp.Player_RatioSize_XY/2){sPlayer.rX_Pos = E0110_FiledControl.sBTField.rMin_X+ E0110_FiledControl.sBTField.rCenter_X+_bmp.Player_RatioSize_XY/2;}
			if(sPlayer.rX_Pos > E0110_FiledControl.sBTField.rMax_X+ E0110_FiledControl.sBTField.rCenter_X-_bmp.Player_RatioSize_XY/2){sPlayer.rX_Pos = E0110_FiledControl.sBTField.rMax_X+ E0110_FiledControl.sBTField.rCenter_X-_bmp.Player_RatioSize_XY/2;}
			if(sPlayer.rY_Pos < E0110_FiledControl.sBTField.rMin_Y+ E0110_FiledControl.sBTField.rCenter_Y+_bmp.Player_RatioSize_XY/2){sPlayer.rY_Pos = E0110_FiledControl.sBTField.rMin_Y+ E0110_FiledControl.sBTField.rCenter_Y+_bmp.Player_RatioSize_XY/2;}
			if(sPlayer.rY_Pos > E0110_FiledControl.sBTField.rMax_Y+ E0110_FiledControl.sBTField.rCenter_Y-_bmp.Player_RatioSize_XY/2){sPlayer.rY_Pos = E0110_FiledControl.sBTField.rMax_Y+ E0110_FiledControl.sBTField.rCenter_Y-_bmp.Player_RatioSize_XY/2;}		
			
			
			
			
			 
		}
		
		//-----------------------------------------------------------------------//
		//定期的に処理される(データ処理)
		//-----------------------------------------------------------------------//	
		public final static void fCall_EachRoutineHander()
		{		
			if(sPlayer.rX_Pos < E0110_FiledControl.sBTField.rMin_X+ E0110_FiledControl.sBTField.rCenter_X+_bmp.Player_RatioSize_XY/2){sPlayer.rX_Pos = E0110_FiledControl.sBTField.rMin_X+ E0110_FiledControl.sBTField.rCenter_X+_bmp.Player_RatioSize_XY/2;}
			if(sPlayer.rX_Pos > E0110_FiledControl.sBTField.rMax_X+ E0110_FiledControl.sBTField.rCenter_X-_bmp.Player_RatioSize_XY/2){sPlayer.rX_Pos = E0110_FiledControl.sBTField.rMax_X+ E0110_FiledControl.sBTField.rCenter_X-_bmp.Player_RatioSize_XY/2;}
			if(sPlayer.rY_Pos < E0110_FiledControl.sBTField.rMin_Y+ E0110_FiledControl.sBTField.rCenter_Y+_bmp.Player_RatioSize_XY/2){sPlayer.rY_Pos = E0110_FiledControl.sBTField.rMin_Y+ E0110_FiledControl.sBTField.rCenter_Y+_bmp.Player_RatioSize_XY/2;}
			if(sPlayer.rY_Pos > E0110_FiledControl.sBTField.rMax_Y+ E0110_FiledControl.sBTField.rCenter_Y-_bmp.Player_RatioSize_XY/2){sPlayer.rY_Pos = E0110_FiledControl.sBTField.rMax_Y+ E0110_FiledControl.sBTField.rCenter_Y-_bmp.Player_RatioSize_XY/2;}		
			
			
		}

		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{					
			_func.DrawBmp.FixDiaplay(DrawCanvas, DrawPaint, _bmp.bmp_char_c, sPlayer.rX_Pos, sPlayer.rY_Pos,  0 );	
	
			//_func.DrawBmpCC.FixDiaplay(DrawCanvas, DrawPaint, 2, 0, 0, sPlayer.rX_Pos, sPlayer.rY_Pos);
			//Z0100_Picture.fDrawCharChip_FixDiaplay(canvas, DrawPaint, 2, 0, 0, sPlayerInf.rCharXpos, sPlayerInf.rCharYpos );	
			
		}

	}