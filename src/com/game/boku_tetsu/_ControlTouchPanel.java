package com.game.boku_tetsu;

public class _ControlTouchPanel
{
//===========================================================================//
//RAM定義
//===========================================================================//
	//----------------------------------------//
	//タッチ状態の保存
	//----------------------------------------//
	final static 	int dTouch_OFF 			= 0;
	final static 	int dTouch_Start  		= 1;
	final static 	int dTouch_First  		= 2;
	final static 	int dTouch_Continue  	= 3;
	final static 	int dTouch_Release		= 4;
	final static 	int dTouch_Inhibit  	= 5;
	private static 	int rNowTouch 			= dTouch_OFF;

	//----------------------------------------//
	//タッチ位置の保存
	//----------------------------------------//	
	private static float rRatio_TouchXpos;
	private static float rRatio_TouchYpos;	

	//----------------------------------------//
	//タッチパネルシフト処理
	//----------------------------------------//
	private static float 	rBefore_Ratio_TouchXpos;
	private static float 	rBefore_Ratio_TouchYpos;	
	private static float 	rNow_Ratio_TouchXpos;
	private static float 	rNow_Ratio_TouchYpos;	
		
	private static float 	rMoveShirtDistance_X;
	private static float 	rMoveShirtDistance_Y;	
		
	//----------------------------------------//
	//タッチパネルシフトの感度
	//----------------------------------------//
	final static 	float	 dMinTouch_Dist	= 0.1f;		 //タッチの最小値
	private static 	float 	 rToutchSensitivity = 25.0f; //タッチ感度調整（後で調整できるようにする）
			
//===========================================================================//
//インターフェイス関数
//===========================================================================//	
	public final static void fSetToutchInhibit()
	{		
		//選択可能状態
		rNowTouch = dTouch_Inhibit;
	}
	
	static float fCheckToutchX()
	{
		return rRatio_TouchXpos;
	}
	
	static float fCheckToutchY()
	{
		return rRatio_TouchYpos;
	}

	static int fCheckNowTouch()
	{
		return rNowTouch;
	}
	
	public final static float fCheckMoveShirtDistance_X()
	{	
		
		return rMoveShirtDistance_X;
	}
	
	public final static float fCheckMoveShirtDistance_Y()
	{	
		return rMoveShirtDistance_Y;
	}
		
	public static void fStart_TouchPanel(float ToutchX, float ToutchY )
	{
		if(rNowTouch == dTouch_Inhibit)
		{
			return;
		}
		
		//パネルサイズの読み込み
		float rBaseRatioSize 	= _g.Display.rBaseRatioSize; 	//A0000_MainProgam.fCheckBaseRatioSize();
		float rMaxRatio_X 		= _g.Display.rMaxRatio_X;		//A0000_MainProgam.fCheckMaxRatioX();
		float rMaxRatio_Y  		= _g.Display.rMaxRatio_Y;		//A0000_MainProgam.fCheckMaxRatioY();	

		//選択可能状態
		rNowTouch = dTouch_Start;
			
		//タッチ場所の保持
		float rTouchXpos = ToutchX;
		float rTouchYpos = ToutchY;
			
		//タッチ場所のレート計算
		rRatio_TouchXpos = +(rTouchXpos-(rBaseRatioSize*rMaxRatio_X))/(rBaseRatioSize);
		rRatio_TouchYpos = -(rTouchYpos-(rBaseRatioSize*rMaxRatio_Y))/(rBaseRatioSize); 	
		
		//前回のタッチ場所との差分を計算
		fToutchShiftDistance();
		
	}
	
	public static void fContinue_TouchPanel(float ToutchX, float ToutchY )
	{
		if(rNowTouch == dTouch_Inhibit)
		{
			return;
		}
		
		//パネルサイズの読み込み
		float rBaseRatioSize 	= _g.Display.rBaseRatioSize; 	//A0000_MainProgam.fCheckBaseRatioSize();
		float rMaxRatio_X 		= _g.Display.rMaxRatio_X;		//A0000_MainProgam.fCheckMaxRatioX();
		float rMaxRatio_Y  		= _g.Display.rMaxRatio_Y;		//A0000_MainProgam.fCheckMaxRatioY();	
		
		//タッチ場所の保持
		float rTouchXpos = ToutchX;
		float rTouchYpos = ToutchY;	 
	
		//タッチ場所のレート計算
		rRatio_TouchXpos = +(rTouchXpos-(rBaseRatioSize*rMaxRatio_X)) / (rBaseRatioSize);
		rRatio_TouchYpos = -(rTouchYpos-(rBaseRatioSize*rMaxRatio_Y)) / (rBaseRatioSize); 	
		
		//前回のタッチ場所との差分を計算
		fToutchShiftDistance();
		
	}
	
	public static void fRelease_TouchPanel(float ToutchX, float ToutchY )
	{
		//パネルサイズの読み込み
		float rBaseRatioSize 	= _g.Display.rBaseRatioSize; 	//A0000_MainProgam.fCheckBaseRatioSize();
		float rMaxRatio_X 		= _g.Display.rMaxRatio_X;		//A0000_MainProgam.fCheckMaxRatioX();
		float rMaxRatio_Y  		= _g.Display.rMaxRatio_Y;		//A0000_MainProgam.fCheckMaxRatioY();	

		//選択可能状態
		rNowTouch = dTouch_Release;
			
		//タッチ場所の保持
		float rTouchXpos = ToutchX;
		float rTouchYpos = ToutchY;
			
		//タッチ場所のレート計算
		rRatio_TouchXpos = +(rTouchXpos-(rBaseRatioSize*rMaxRatio_X))/(rBaseRatioSize);
		rRatio_TouchYpos = -(rTouchYpos-(rBaseRatioSize*rMaxRatio_Y))/(rBaseRatioSize); 	
		
		//前回のタッチ場所との差分を計算
		fToutchShiftDistance();
		
	}
	
	public static void fStop_TouchPanel(float ToutchX, float ToutchY )
	{
		//選択可能状態
		rNowTouch = dTouch_OFF;
		
		//前回のタッチ場所との差分を計算
		fToutchShiftDistance();
	}
	
//===========================================================================//
//内部処理関数
//===========================================================================//		
	public final static void fToutchShiftDistance()
	{						
		//タッチパネル処理
		if( rNowTouch == dTouch_OFF )
		{
			//初期化
			rBefore_Ratio_TouchXpos = rNow_Ratio_TouchXpos = 0;
			rBefore_Ratio_TouchYpos = rNow_Ratio_TouchYpos = 0;
			
			rMoveShirtDistance_X = 0;
			rMoveShirtDistance_Y = 0;
			
		}
		else if( rNowTouch == dTouch_Start )
		{
			//初回位置の取得
			rBefore_Ratio_TouchXpos = 0;
			rBefore_Ratio_TouchYpos = 0;	
			rNow_Ratio_TouchXpos = fCheckToutchX();
			rNow_Ratio_TouchYpos = fCheckToutchY();
			
			//タッチ距離の産出へ移行する
			rNowTouch = dTouch_First;
			
		}
		else if( rNowTouch == dTouch_First || rNowTouch == dTouch_Continue )
		{
			//距離の測定
			rBefore_Ratio_TouchXpos = rNow_Ratio_TouchXpos;
			rBefore_Ratio_TouchYpos = rNow_Ratio_TouchYpos;
		
			rNow_Ratio_TouchXpos = fCheckToutchX();
			rNow_Ratio_TouchYpos = fCheckToutchY();
			rMoveShirtDistance_X = (rNow_Ratio_TouchXpos - rBefore_Ratio_TouchXpos);
			rMoveShirtDistance_Y = (rNow_Ratio_TouchYpos - rBefore_Ratio_TouchYpos);

			//処理を継続する
			rNowTouch = dTouch_Continue;
			
		}
	}
	
}//class
