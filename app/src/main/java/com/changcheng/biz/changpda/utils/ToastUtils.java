package com.changcheng.biz.changpda.utils;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Li on 2017/10/18.
 */

public class ToastUtils {
	private static Toast mToast;
	private static Handler mHandler = new Handler();
	private static Runnable r = new Runnable() {
		public void run() {
			mToast.cancel();
		}
	};

	public static void showToast(Context mContext, String text, int duration) {

		mHandler.removeCallbacks(r);
		if (mToast != null)
			mToast.setText(text);
		else
			mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
		mHandler.postDelayed(r, duration);

		mToast.show();
	}

	public static void showToast(Context mContext, int resId, int duration) {

		//	mToast.setGravity(Gravity.CENTER | Gravity.BOTTOM,0,0);
		showToast(mContext, mContext.getResources().getString(resId), duration);
	}

	public static void showToastPosition(Context mContext, int resId, int duration) {
		mToast.setGravity(Gravity.CENTER,0,150);
		showToast(mContext, mContext.getResources().getString(resId), duration);
	}

	public static void  CancelToast(){

		mToast.cancel();

	}

}
