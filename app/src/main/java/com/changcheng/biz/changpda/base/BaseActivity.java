package com.changcheng.biz.changpda.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;


import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.utils.StatusBarUtil;
import com.changcheng.biz.changpda.view.CustomProgressDialog;

import java.util.ArrayList;
import java.util.List;

import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_SCODE;
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_EX_SCODE;

/**
 * Created by Li on 2017/10/18.
 */

public abstract class BaseActivity extends FragmentActivity {
	/** 是否沉浸状态栏 **/
	private boolean isSetStatusBar = true;
	/** 是否允许全屏 **/
	private boolean mAllowFullScreen = false  ;
	/** 是否禁止旋转屏幕 **/
	private boolean isAllowScreenRoate = true;
	/** 当前Activity渲染的视图View **/
	private View mContextView = null;
	/** 是否输出日志信息 **/
	private boolean isDebug;
	private String APP_NAME;
	/**当前打开Activity存储List*/
	private static List<Activity> activities = new ArrayList<>();
	/** 用于传递的上下文信息*/
	public Context context;
	public Activity activity;
	/** 加载提示框*/
	private CustomProgressDialog customProgressDialog;
	protected final String TAG = this.getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getApplicationContext();
		activity = this;
		ActivityStackManager.add(this);
		//activities.add(this);
		try {
			Bundle bundle = getIntent().getExtras();
			initBundle(bundle);
			mContextView = LayoutInflater.from(this)
					.inflate(getLayoutId(), null);
			if (mAllowFullScreen) {
				this.getWindow().setFlags(
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				requestWindowFeature(Window.FEATURE_NO_TITLE);
			}
			if (isSetStatusBar) {
				steepStatusBar();
			}
			setContentView(mContextView);
			if (!isAllowScreenRoate) {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			} else {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			}

			customProgressDialog = new CustomProgressDialog(activity, R.style.progress_dialog_loading, "玩命加载中...");
			findViews(mContextView);
			initData(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Register receiver
		IntentFilter intentFilter = new IntentFilter(SCN_CUST_ACTION_SCODE);
		registerReceiver(scanDataReceiver,intentFilter);
	}

	/**
	 * [沉浸状态栏]
	 */
	private void steepStatusBar() {

		/*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// 透明状态栏
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
			// 透明导航栏
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}*/
		StatusBarUtil.setTransparent(activity);
	}

	/**
	 * [初始化Bundle参数]
	 *
	 * @param bundle
	 */
	public abstract void initBundle(Bundle bundle);

	/**
	 * [绑定布局]
	 *
	 * @return
	 */
	public abstract int getLayoutId();


	/**
	 * [初始化控件]
	 *
	 * @param view
	 */
	public abstract void findViews(View view);

	/**
	 * [业务操作]
	 *
	 * @param mContext
	 */
	public abstract void initData(Context mContext);

	/**
	 * [页面跳转]
	 *
	 * @param clz
	 */
	public void startActivity(Class<?> clz) {
		startActivity(clz, null);
	}

	/**
	 * [携带数据的页面跳转]
	 *
	 * @param clz
	 * @param bundle
	 */
	public void startActivity(Class<?> clz, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, clz);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	/**
	 * @param resId View的ID
	 * @param <T> 将View转化为对应泛型，简化强转的步骤
	 * @return ID对应的View
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int resId) {
		return (T) super.findViewById(resId);
	}

	/**
	 * [含有Bundle通过Class打开编辑界面]
	 *
	 * @param cls
	 * @param bundle
	 * @param requestCode
	 */
	public void startActivityForResult(Class<?> cls, Bundle bundle,
									   int requestCode) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivityForResult(intent, requestCode);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityStackManager.remove(this);
		//activities.remove(this);
		unregisterReceiver(scanDataReceiver);
	}

	/**
	 * [是否允许全屏]
	 *
	 * @param allowFullScreen
	 */
	public void setAllowFullScreen(boolean allowFullScreen) {
		this.mAllowFullScreen = allowFullScreen;
	}

	/**
	 * [是否设置沉浸状态栏]
	 *
	 * @param
	 */
	public void setSteepStatusBar(boolean isSetStatusBar) {
		this.isSetStatusBar = isSetStatusBar;
		if (isSetStatusBar) {
			steepStatusBar();
		}
	}

	/**
	 * [是否允许屏幕旋转]
	 *
	 * @param isAllowScreenRoate
	 */
	public void setScreenRoate(boolean isAllowScreenRoate) {
		this.isAllowScreenRoate = isAllowScreenRoate;
	}


	/**
	 * [防止快速点击]
	 *
	 * @return
	 */
	private boolean fastClick() {
		long lastClick = 0;
		if (System.currentTimeMillis() - lastClick <= 1000) {
			return false;
		}
		lastClick = System.currentTimeMillis();
		return true;
	}

	/**
	 * 关闭所有Activity（除MainActivity以外）
	 */
	public void finishAllActivity() {
		ActivityStackManager.finish();
//		for (Activity activity : activities) {
//			activity.finish();
//		}
	}

	public void AppExit() {
		try {
			finishAllActivity();
			ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			activityManager.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {

		}
	}

	/**
	 * 隐藏键盘
	 */
	public void hideKeyBoard() {
		View view = activity.getWindow().peekDecorView();
		if (view != null) {
			InputMethodManager inputmanger = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

	/**
	 * 显示加载提示框
	 */
	public void showLoadDialog() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				customProgressDialog.show();
			}
		});
	}

	/**
	 * 隐藏加载提示框
	 */
	public void hideLoadDialog() {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (customProgressDialog != null && customProgressDialog.isShowing()) {
					customProgressDialog.dismiss();
				}
			}
		});
	}

	public abstract void initReceive(String msg);

	private BroadcastReceiver scanDataReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction().equals(SCN_CUST_ACTION_SCODE)){
				try {
					String message = "";
					message = intent.getStringExtra(SCN_CUST_EX_SCODE).toString();
					initReceive(message);
				}catch (Exception e){
					e.printStackTrace();
					Log.e("in",e.toString());
				}

			}
		}
	};

}
