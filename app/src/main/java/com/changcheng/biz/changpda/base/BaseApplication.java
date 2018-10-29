package com.changcheng.biz.changpda.base;

import android.app.Application;


/**
 * Created
 */

public class BaseApplication extends Application{
	public static boolean isDebug = true ;
	public static String APP_NAME  ;

	private static BaseApplication instance;
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static BaseApplication getIntance() {

		return instance;

	}
}


