package com.game.boku_tetsu;

import java.lang.reflect.Method;
import android.graphics.Canvas;
import android.graphics.Paint;

public class B0500_EnemyControl
{	
	//===========================================================================//
	//RAM定義
	//===========================================================================//			
	//敵情報
	public static  _bsEnemyInf sEnemyInf = new _bsEnemyInf();
		
	//===========================================================================//
	//インターフェイス関数
	//===========================================================================//
		//-----------------------------------------------------------------------//
		//初期化時に一度だけ処理される
		//-----------------------------------------------------------------------//
		public static void fCall_EachInitialHander() throws Exception
		{
			//各ステージ毎のインターフェイス関数を実行する
			_b.rSelectStage = 1;			
			String ClassName = _g.rPackageName+"."+"B0501_Emeny"+String.format("%1$04d",_b.rSelectStage);
			String MethodName = "fDrawStage";

			//クラス情報を獲得
			Class<?> clazz = Class.forName(ClassName);
			
			//メソッドに引き渡すクラスの順番を定義	
			Class<?> para[] = new Class[] {};

			//引数無しの メソッドを取得する
			Method method = clazz.getMethod(MethodName,para);
			
			//実行
			method.invoke(clazz.newInstance());	
		}
		
		//-----------------------------------------------------------------------//
		//定期的に処理される
		//-----------------------------------------------------------------------//
		public final static void fCall_EachRoutineHander() throws Exception
		{						
			//各ステージ毎のインターフェイス関数を実行する			
			String ClassName = _g.rPackageName+"."+"B0501_Emeny"+String.format("%1$04d",_b.rSelectStage);
			String MethodName = "fCall_EachRoutineHander";

			//クラス情報を獲得
			Class<?> clazz = Class.forName(ClassName);
			
			//メソッドに引き渡すクラスの順番を定義	
			Class<?> para[] = new Class[] {};

			//引数無しの メソッドを取得する
			Method method = clazz.getMethod(MethodName,para);
			
			//実行
			method.invoke(clazz.newInstance());	
			
		}
		
		//-----------------------------------------------------------------------//
		//invalidate命令(画面の再表示要求時)に処理される
		//-----------------------------------------------------------------------//
		public final static void fDrawStage(Canvas canvas, Paint DrawPaint) throws Exception
		{		
			//各ステージ毎のインターフェイス関数を実行する		
			String ClassName = _g.rPackageName+"."+"B0501_Emeny"+String.format("%1$04d",_b.rSelectStage);
			String MethodName = "fDrawStage";

			//クラス情報を獲得
			Class<?> clazz = Class.forName(ClassName);
			
			//メソッドに引き渡すクラスの順番を定義	
			//メソッドに引き渡すクラスの順番を定義
			Class<?> para[] = new Class[] { Canvas.class, Paint.class };
			Object[] ob = new Object[] { canvas, DrawPaint };

			//引数無しの メソッドを取得する
			Method method = clazz.getMethod(MethodName,para);
			
			//実行
			method.invoke(clazz.newInstance(),ob);	
			
		}
						
}
