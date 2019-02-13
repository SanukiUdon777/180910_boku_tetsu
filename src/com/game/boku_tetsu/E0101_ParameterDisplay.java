package com.game.boku_tetsu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;
import android.widget.TextView;



public class E0101_ParameterDisplay
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//	

	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//	
		public final static void fDrawStage(Canvas DrawCanvas, Paint DrawPaint)
		{		
			//縦軸表示は割合補正を検討する
			//_g.Display.rMaxRatio_XY
			//
			//プレイヤHP
			_func.DrawLine.Bar_FixDiaplay(DrawCanvas, DrawPaint, -0.5f, -1.1f, +1.0f, +0.05f, (float)E0120_PlayerControl.sPlayer.rHP);
			
			//敵HP
			_func.DrawLine.Bar_FixDiaplay(DrawCanvas, DrawPaint, -0.5f, _g.Display.rMaxRatio_XY-0.1f, +1.0f, +0.05f, (float)E0150_EnemyControl.sEnemy.rHP);
			
			//_func.DrawLine.Bar_FixDiaplay(DrawCanvas, DrawPaint, -0.5f, +1.2f, +1.0f, +0.1f,50.0f);
			//_func.DrawLine.Bar_FixDiaplay(DrawCanvas, DrawPaint, -0.5f, +1.4f, +1.0f, +0.1f,100.0f);
			
	
	
		}

	}