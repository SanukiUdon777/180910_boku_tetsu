package com.game.boku_tetsu;



import java.io.IOException;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Button;

class _func
{
//============================================================================================//
		public static class DrawText	//テキスト表示
		{
			public static void FixDiaplay_Left(Canvas DrawCanvas, Paint DrawPaint, String DrawString, float DrawXPosRatio, float DrawYPosRatio, float DrawSizeRatio, int DrawColor)
			{
				float BaseRatioSize 	= _g.Display.rBaseRatioSize;
				float TextSize 			= BaseRatioSize * DrawSizeRatio;
			
				DrawPaint.setColor( DrawColor );
				DrawPaint.setStyle( Style.FILL );		
				DrawPaint.setTextSize( TextSize );
			
				float Offset_X = 0;
				float Offset_Y = ( BaseRatioSize * DrawSizeRatio )/2;
				
				float DispXpos = (+DrawXPosRatio*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize - Offset_X;
				float DispYpos = (-DrawYPosRatio*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize + Offset_Y;
				
				
				DrawCanvas.drawText( DrawString, DispXpos, DispYpos, DrawPaint );

			}//End_fDrawText_FixDiaplay_Left
		
			public static void FixDiaplay_Center(Canvas DrawCanvas, Paint DrawPaint, String DrawString, float DrawXPosRatio, float DrawYPosRatio, float DrawSizeRatio, int DrawColor)
			{
				float BaseRatioSize 	= _g.Display.rBaseRatioSize;
				float TextSize 			= BaseRatioSize * DrawSizeRatio;

				DrawPaint.setColor(DrawColor);
				DrawPaint.setStyle(Style.FILL);
				DrawPaint.setTextSize(TextSize);
						
				float Offset_X = DrawPaint.measureText(DrawString)/2;
				float Offset_Y = ( BaseRatioSize * DrawSizeRatio )/2;
				
				float DispXpos = (+DrawXPosRatio*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize - Offset_X;
				float DispYpos = (-DrawYPosRatio*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize + Offset_Y;
				
				
				DrawCanvas.drawText(DrawString, DispXpos, DispYpos, DrawPaint);
			
			}//End_FixDiaplay_Center
			
		}//End
		

//============================================================================================//	
		public static class DrawBmp
		{		
			//BMPの保存データ配列を作成
			public static BmpData[] BmpData			= new BmpData[_bmp.BMP_END];
			
			//画像準備
			public static void InitalBMP( Resources Res )
			{
				//BMPの設定
				for( int i = 0; i < _bmp.BMP_END; i++ )
				{		
					BmpData[i] 		= new BmpData(); 
					BmpData[i].BMP 	= BMP_SetData( Res, _bmp.BmpDataList[i].BMP_Number, _bmp.BmpDataList[i].RatioSize_X, _bmp.BmpDataList[i].RatioSize_Y );
				}
				
			}//End_BMP_MemoryData

			public static Bitmap BMP_SetData(Resources Res, int BitMap, float XSizeRatioSize, float YSizeRatioSize)
			{
				return Bitmap.createScaledBitmap( BitmapFactory.decodeResource(Res, BitMap), 
						(int)(XSizeRatioSize*_g.Display.rBaseRatioSize), (int)(YSizeRatioSize*_g.Display.rBaseRatioSize), false);
			}//End_BMP_SetData
			
			//通常表示
			public static void FixDiaplay(Canvas Canvas, Paint DrawPaint, int BitmapNum, float XPos, float YPos, float Rotate)
			{
				float DispXpos = (+XPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize - BmpData[BitmapNum].BMP.getWidth()/2;
				float DispYpos = (-YPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize - BmpData[BitmapNum].BMP.getHeight()/2;
			
				//BMP描画
				Canvas.save(android.graphics.Canvas.MATRIX_SAVE_FLAG);//キャンバス全体を保存
				Canvas.rotate(Rotate, DispXpos+BmpData[BitmapNum].BMP.getWidth()/2, DispYpos+BmpData[BitmapNum].BMP.getHeight()/2);	
				Canvas.drawBitmap(BmpData[BitmapNum].BMP, DispXpos, DispYpos, DrawPaint);
				Canvas.restore();
				
			}//End_FixDiaplay
			
			public static void FixDiaplay_Magnification(Canvas Canvas, Paint DrawPaint, int BitmapNum, float XPos, float YPos, float Rotate, float Magnification )
			{			
				//BMP拡大
				Matrix Edit_Matrix;  
				Bitmap Edit_Bitmap;  
				Edit_Matrix = new Matrix();
				Edit_Matrix.setScale(Magnification, Magnification);
				Edit_Bitmap = Bitmap.createBitmap(BmpData[BitmapNum].BMP, 0, 0, BmpData[BitmapNum].BMP.getWidth(), BmpData[BitmapNum].BMP.getHeight(), Edit_Matrix, true);
			
				
				//BMP描画		
				float DispXpos = (+XPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize - Edit_Bitmap.getWidth()/2;
				float DispYpos = (-YPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize - Edit_Bitmap.getHeight()/2;
				
				Canvas.save(android.graphics.Canvas.MATRIX_SAVE_FLAG);//キャンバス全体を保存
				Canvas.rotate(Rotate, DispXpos+Edit_Bitmap.getWidth()/2, DispYpos+Edit_Bitmap.getHeight()/2);	
				Canvas.drawBitmap(Edit_Bitmap, DispXpos, DispYpos, DrawPaint);
				Canvas.restore();
				
			}//End_FixDiaplay
			
			public static void FixDiaplay_MagnificationXY(Canvas Canvas, Paint DrawPaint, int BitmapNum, float XPos, float YPos, float Rotate, float MagnificationX, float MagnificationY)
			{			
				//BMP拡大
				Matrix Edit_Matrix;  
				Bitmap Edit_Bitmap;  
				Edit_Matrix = new Matrix();
				Edit_Matrix.setScale(MagnificationX, MagnificationY);
				Edit_Bitmap = Bitmap.createBitmap(BmpData[BitmapNum].BMP, 0, 0, BmpData[BitmapNum].BMP.getWidth(), BmpData[BitmapNum].BMP.getHeight(), Edit_Matrix, true);
			
				
				//BMP描画		
				float DispXpos = (+XPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize - Edit_Bitmap.getWidth()/2;
				float DispYpos = (-YPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize - Edit_Bitmap.getHeight()/2;
				
				Canvas.save(android.graphics.Canvas.MATRIX_SAVE_FLAG);//キャンバス全体を保存
				Canvas.rotate(Rotate, DispXpos+Edit_Bitmap.getWidth()/2, Edit_Bitmap.getHeight()/2);	
				Canvas.drawBitmap(Edit_Bitmap, DispXpos, DispYpos, DrawPaint);
				Canvas.restore();
				
			}//End_FixDiaplay
			
			/*
			public static void MeshDiaplay(Canvas Canvas, Paint DrawPaint, int BitmapNum, float XPos, float YPos, float Rotate)
			{
				float DispXpos = (+XPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize - BmpData[BitmapNum].BMP.getWidth()/2;
				float DispYpos = (-YPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize - BmpData[BitmapNum].BMP.getHeight()/2;
			
				//BMP描画
				Canvas.save(android.graphics.Canvas.MATRIX_SAVE_FLAG);//キャンバス全体を保存
				Canvas.rotate(Rotate, DispXpos+BmpData[BitmapNum].BMP.getWidth()/2, DispYpos+BmpData[BitmapNum].BMP.getHeight()/2);	
				//Canvas.drawBitmap(BmpData[BitmapNum].BMP, DispXpos, DispYpos, DrawPaint);
				
				float[] verts = {DispXpos, DispYpos, DispXpos+100, DispYpos+100}; 	//X座標とY座標をサイズ分														//よってメッシュ配列のサイズ
				int MESH_WIDTH = 1;
				int MESH_HEIGHT = 1;
				//int MESH_SIZE = (MESH_WIDTH+1)*(MESH_HEIGHT+1)*2;
				Canvas.drawBitmapMesh(BmpData[BitmapNum].BMP, MESH_WIDTH, MESH_HEIGHT, verts, 0, null, 0, null);
				
				Canvas.restore();
				
			}//End_FixDiaplay
			*/
			
		}//End

//============================================================================================//	

	public static class DrawBmpCC
	{		
		//BMPの保存データ配列を作成
		public static BmpCCData[] BmpCCData		= new BmpCCData[_bmp.BMP_END];
		
		//画像準備
		public static void InitalBMP( Resources Res )
		{			
			//CharChip BMPの設定
			for( int i = 0; i < _bmpcc.BMP_END; i++)
			{		
				BmpCCData[i] 		= new BmpCCData();
				BmpCCData[i].BMP_CC 	= BMP_SetData( Res, _bmpcc.BmpDataList[i].BMP_CC_Number, _bmpcc.BmpDataList[i].RatioSize_X, _bmpcc.BmpDataList[i].RatioSize_Y );
			}		
		}//End_BMP_MemoryData

		
		public static Bitmap BMP_SetData(Resources Res, int BitMap, float XSizeRatioSize, float YSizeRatioSize)
		{
			return DrawBmp.BMP_SetData(Res, BitMap, XSizeRatioSize, YSizeRatioSize);
	
		}//End_BMP_SetData
		
		
		//通常表示(charChip)
		public static void FixDiaplay(Canvas Canvas, Paint DrawPaint, int BitmapNum, int SelX, int SelY, float XPos, float YPos)
		{
			int DispXpos = (int) (((+XPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize) - BmpCCData[BitmapNum].BMP_CC.getWidth() /2);
			int DispYpos = (int) (((-YPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize) - BmpCCData[BitmapNum].BMP_CC.getHeight()/2);			
			
			int width  = BmpCCData[BitmapNum].BMP_CC.getWidth();
			int height = BmpCCData[BitmapNum].BMP_CC.getHeight();
				
			Canvas.drawBitmap(
					BmpCCData[BitmapNum].BMP_CC, 
					new Rect(width/_bmpcc.BmpDataList[BitmapNum].CharChip_X*SelX, height/_bmpcc.BmpDataList[BitmapNum].CharChip_Y*SelY, width/_bmpcc.BmpDataList[BitmapNum].CharChip_X*(SelX+1), height/_bmpcc.BmpDataList[BitmapNum].CharChip_Y*(SelY+1)), 
					new Rect(DispXpos, DispYpos, DispXpos + width, DispYpos + height), 
					DrawPaint);
		
		}//End_FixDiaplay
	}//End

//============================================================================================//		
		public static class Button
		{
			public static void InitialButton(StrButtonInf DrawButton, String Text, float TextRatioSize )
			{			
				float TextSize = _g.Display.rBaseRatioSize * TextRatioSize;
				
				DrawButton.RelativeLayoutParams = new RelativeLayout.LayoutParams
						(
			        		RelativeLayout.LayoutParams.WRAP_CONTENT, 
			        		RelativeLayout.LayoutParams.WRAP_CONTENT
			
			        	);
				
				DrawButton.ButtonData.setTextSize(TextSize);
				DrawButton.ButtonData.setText(Text);

				
			}//End_InitialButton
			
			public static void SetButtonPos( StrButtonInf DrawButton, float DrawXPosRatio, float DrawYPosRatio )
			{
				float SetPosX = (_g.Display.rBaseRatioSize*_g.Display.rMaxRatio_X) +(DrawXPosRatio*_g.Display.rBaseRatioSize)- DrawButton.ButtonData.getWidth()/2;
				float SetPosY =	(_g.Display.rBaseRatioSize*_g.Display.rMaxRatio_Y) -(DrawYPosRatio*_g.Display.rBaseRatioSize)- DrawButton.ButtonData.getHeight()/2;
				
				DrawButton.RelativeLayoutParams.setMargins((int)(SetPosX), (int)(SetPosY),0, 0 );  
				DrawButton.ButtonData.setLayoutParams(DrawButton.RelativeLayoutParams);
				
			}//End_SetButtonPos
		
		}//End

//============================================================================================//			
		public static class ImageButton	
		{
			public static int ConvertBMP_ID( int DispBMP )
			{
				return _bmp.BmpDataList[DispBMP].BMP_Number;	
			}
			
			public static void InitialImageButton( StrImageButtonInf DrawButton, int DispBMP, float RatioSizeX, float RatioSizeY, ScaleType Scale)
			{
				float SetSizeX = (RatioSizeX*(_g.Display.rBaseRatioSize*2.0f));
				float SetSizeY = (RatioSizeY*(_g.Display.rBaseRatioSize*2.0f));	

				DrawButton.ButtonData.setImageResource(ConvertBMP_ID(DispBMP));

				DrawButton.RelativeLayoutParams = new RelativeLayout.LayoutParams((int)SetSizeX, (int)SetSizeY);
				DrawButton.ButtonData.setLayoutParams(DrawButton.RelativeLayoutParams);
				DrawButton.ButtonData.setScaleType(Scale);
					
			}//End_InitialImageButton
			
			public static void SetImageButtonPos( StrImageButtonInf DrawButton, float DrawXPosRatio, float DrawYPosRatio )
			{
				float SetPosX = (_g.Display.rBaseRatioSize*_g.Display.rMaxRatio_X) +(DrawXPosRatio*_g.Display.rBaseRatioSize) - DrawButton.ButtonData.getWidth()/2;
				float SetPosY =	(_g.Display.rBaseRatioSize*_g.Display.rMaxRatio_Y) -(DrawYPosRatio*_g.Display.rBaseRatioSize) - DrawButton.ButtonData.getHeight()/2;
				
				DrawButton.RelativeLayoutParams.setMargins((int)(SetPosX), (int)(SetPosY),0, 0 );  
				DrawButton.ButtonData.setLayoutParams(DrawButton.RelativeLayoutParams);
				
			}//End_SetImageButtonPos
			
			public static void SetImageButtonBmp( StrImageButtonInf DrawButton, int DispBMP )
			{
				DrawButton.ButtonData.setImageResource(ConvertBMP_ID(DispBMP));
				
			}//End_InitialImageButton
			
		}//End

//============================================================================================//	
		public static class DrawLine
		{		
			public static void Line_FixDiaplay(Canvas Canvas, Paint DrawPaint, float XStartPos, float YStartPos, float XStopPos, float YStopPos, float SizeRatio, int Color, Paint.Style style)
			{
				float rBaseRatioSize = _g.Display.rBaseRatioSize;	
				float rMaxRatio_X = _g.Display.rMaxRatio_X;	
				float rMaxRatio_Y = _g.Display.rMaxRatio_Y;	
				
				float DispStartXpos = (+XStartPos*rBaseRatioSize) 	+ rMaxRatio_X*rBaseRatioSize;
				float DispStartYpos = (-YStartPos*rBaseRatioSize) 	+ rMaxRatio_Y*rBaseRatioSize;
				float DispStopXpos 	= (+XStopPos*rBaseRatioSize) 	+ rMaxRatio_X*rBaseRatioSize;
				float DispStopYpos 	= (-YStopPos*rBaseRatioSize) 	+ rMaxRatio_Y*rBaseRatioSize;
				
				float DispSize		= (+SizeRatio*rBaseRatioSize);
					
				DrawPaint.setColor(Color);
				DrawPaint.setStyle(style);
				DrawPaint.setStrokeWidth(DispSize);
				Canvas.drawLine(DispStartXpos,DispStartYpos,DispStopXpos,DispStopYpos, DrawPaint);
			}

			public static void Circle_STROKE_FixDiaplay(Canvas Canvas, Paint DrawPaint, float XStartPos, float YStartPos, float Radius, float SizeRatio, int Color, Paint.Style style)
			{
				float rBaseRatioSize = _g.Display.rBaseRatioSize;	
				float rMaxRatio_X = _g.Display.rMaxRatio_X;	
				float rMaxRatio_Y = _g.Display.rMaxRatio_Y;	
				
				float DispStartXpos = (+XStartPos*rBaseRatioSize*rMaxRatio_X) 	+ rMaxRatio_X*rBaseRatioSize;
				float DispStartYpos = (-YStartPos*rBaseRatioSize*rMaxRatio_Y) 	+ rMaxRatio_Y*rBaseRatioSize;
				float DispRadius 	= (+Radius*rBaseRatioSize);
				float DispSize		= (+SizeRatio*rBaseRatioSize);
				
			
				
				DrawPaint.setColor(Color);
				DrawPaint.setStyle(style);
				DrawPaint.setStrokeWidth(DispSize);
				
				Canvas.drawCircle(DispStartXpos, DispStartYpos, DispRadius, DrawPaint);
			}	
			
			public static void Rect_STROKE_FixDiaplay(Canvas Canvas, Paint DrawPaint, float XStartPos, float YStartPos, float XRatioSize, float YRatioSize,float SizeRatio, int Color, Paint.Style style)
			{

				float rBaseRatioSize = _g.Display.rBaseRatioSize;	
				float rMaxRatio_X = _g.Display.rMaxRatio_X;	
				float rMaxRatio_Y = _g.Display.rMaxRatio_Y;	
				
				float DispStartXpos = (+XStartPos*rBaseRatioSize) 	+ rMaxRatio_X*rBaseRatioSize;
				float DispStartYpos = (-YStartPos*rBaseRatioSize) 	+ rMaxRatio_Y*rBaseRatioSize;	
				
				float DispStopXpos 	= (+XRatioSize*rBaseRatioSize) 	+ DispStartXpos;
				float DispStopYpos 	= (+YRatioSize*rBaseRatioSize) 	+ DispStartYpos;
				
				float DispSize		= (+SizeRatio*rBaseRatioSize);
				
				/*
				float rBaseRatioSize = _g.Display.rBaseRatioSize;	
				float DispSize		= (+SizeRatio*rBaseRatioSize);
				
				float DispStartXpos = (+XStartPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize;
				float DispStartYpos = (-YStartPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize;				
				float DispStopXpos	= (+XStopPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_X*_g.Display.rBaseRatioSize;
				float DispStopYpos 	= (-YStopPos*_g.Display.rBaseRatioSize) + _g.Display.rMaxRatio_Y*_g.Display.rBaseRatioSize;
				
				*/
				
				float Offset_X = 0;
				float Offset_Y = 0;//( DispStartYpos - DispStopYpos )/2;
	
				DispStartXpos 	+= Offset_X;
				DispStartYpos	+= Offset_Y;
				DispStopXpos	+= Offset_X;
				DispStopYpos	+= Offset_Y;
				
				DrawPaint.setColor(Color);
				DrawPaint.setStyle(style);
				DrawPaint.setStrokeWidth(DispSize);
				Canvas.drawRect(DispStartXpos,DispStartYpos,DispStopXpos,DispStopYpos, DrawPaint);
			}
			

			
			public static void Bar_FixDiaplay(Canvas Canvas, Paint DrawPaint, float XStartPos, float YStartPos, float XSize, float YSize, float Gauge)
			{
				Gauge = Gauge/100;

				float InLineX =  XSize/100;	
				float InLineY =  InLineX*2;

				
				Rect_STROKE_FixDiaplay(Canvas, DrawPaint, XStartPos, 				YStartPos, 			XStartPos+XSize, 			YStartPos-YSize, 			0.0001f, Color.WHITE, Style.FILL );
				Rect_STROKE_FixDiaplay(Canvas, DrawPaint, XStartPos+(XSize*Gauge), 	YStartPos, 			XStartPos+XSize-InLineX, 	YStartPos-YSize+InLineY, 	0.0001f, Color.BLACK, Style.FILL );
						
			}
			
		}
		
//============================================================================================//
		public static class BGM
		{
			private static MediaPlayer[] lrBGM = new MediaPlayer[_bgm.BGM_END];
			private static int 			lrBeforePlay 	= _bgm.Stop;
			private static int 			lrBeforeStop	= _bgm.Stop;
			private static int 			lrNowPlay 		= _bgm.Stop;
			private static int 			lrReqPlay 		= _bgm.Stop;

			private static int 			lrWaitCounter 	= 0;
			final 	static int 			ldWaitNextWait 	= 100/_g.MainHandler.dMainRoutine; 
			
			private static boolean 		lrOnCreateTiming = false;
			
			//初期化処理
			public static void InitalBGM(Context Cont)
			{			
				//CharChip BMPの設定
				for( int i = 0; i < _bgm.BGM_END; i++)
				{		
					lrBGM[i] 		= MediaPlayer.create(Cont, _bgm.BgmDataList[i].BGM_Number );//BGM
					
				}
			}//End_InitalBGM

			public static void OnCreateRequestBGM( int ReqMusic )
			{
				//音楽再生開始
				lrReqPlay = ReqMusic;
				lrOnCreateTiming = true;
				
			}//End_RequestBGM
			
			public static void RequestBGM( int ReqMusic )
			{
				//音楽再生開始
				if( lrOnCreateTiming == false)
				{
					lrReqPlay = ReqMusic;
				}
			}//End_RequestBGM
				
			public static Boolean CheckNowBGM()
			{
				if( lrNowPlay == lrReqPlay )
				{
					return true;
				}
				else
				{
					return false;
				}
			}//End_CheckNowBGM
			
			public static void ControlBGM()
			{		
				if(lrWaitCounter != 0)
				{
					lrWaitCounter--;
					return;
				}

		    	if(lrNowPlay != lrReqPlay )
		    	{	
		    		if(lrNowPlay != _bgm.Stop)
		    		{

		    		//音楽停止
		    		 lrBGM[lrNowPlay].stop();  
		    		 lrBeforeStop 	= lrNowPlay;
		      		 lrNowPlay 		= _bgm.Stop;
		    		 lrWaitCounter 	= ldWaitNextWait;
		    		 return;

		    		}
		    		
		    		 try
		    		 {
		    			 //再生停止後Waitを行ってから次回再生準備を行う	    			 
		    			 lrBGM[lrBeforeStop].prepare();
		    			
		    		 } 
		    		 catch (IllegalStateException e) 
		    		 {
		    				// TODO 自動生成された catch ブロック
		    				e.printStackTrace();
		    		} 
		    		 catch (IOException e) 
		    		 {
		    				// TODO 自動生成された catch ブロック
		    				e.printStackTrace();	
		    		 } 
		    			
		    		if(lrReqPlay == _bgm.ReStart)
		    		{
		        		//音楽再生
		    			lrReqPlay = lrBeforePlay;
		        		lrBGM[lrReqPlay].setLooping(true);
		        		lrBGM[lrReqPlay].start(); 	
		    			lrNowPlay 		= lrReqPlay;
		    		}
		    		else
		    		{    			
		        		//音楽再生
		        		lrBGM[lrReqPlay].setLooping(true);
		        		lrBGM[lrReqPlay].seekTo(0);
		        		lrBGM[lrReqPlay].start(); 	
		    			lrBeforePlay 	= lrReqPlay;
		    			lrNowPlay 		= lrReqPlay;
		    			lrOnCreateTiming = false;
		    		}

		    	}
		    }//End_ControlBGM
		}//End
		

//============================================================================================//			
		public static class SoundEffect
		{		
			static SoundPool lrSE;
			static AudioAttributes attr;
			
			//初期化処理
			public static void InitalSoundEffect(Context Cont)
			{			
				attr = new AudioAttributes.Builder()
				    .setUsage(AudioAttributes.USAGE_MEDIA)
				    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
				    .build();

				lrSE = new SoundPool.Builder()
				    .setAudioAttributes(attr)
				    .setMaxStreams(_se.SE_END)
				    .build();
				
				//CharChip BMPの設定
				for( int i = 0; i < _se.SE_END; i++)
				{		
					lrSE.load(Cont, _se.SeDataList[i].SE_Number , 0);
				}
					
			}//End_InitalSe		
			
			
			//効果音を開始する
		    static void PlaySE( int SelectBGM )
		    {	
			    lrSE.play(SelectBGM, 0.75F, 0.75F, 0, 0, 1.0F);

		    }
		}

//============================================================================================//	
}//End
