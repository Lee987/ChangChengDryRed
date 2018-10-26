package com.changcheng.biz.changpda.base;

/**
 * Created by Li on 2017/10/18.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.view.CustomProgressDialog;


public abstract class BaseFragment extends Fragment implements View.OnClickListener {
	protected final String TAG = this.getClass().getSimpleName();
	private View mContextView = null;
	/**
	 * 用于传递的上下文信息
	 */
	public Context context;
	public Activity activity;
	/** 加载提示框*/
	private CustomProgressDialog customProgressDialog;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		this.context = context.getApplicationContext();
		activity = (Activity) context;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		mContextView = inflater.inflate(getLayoutId(), container, false);
		customProgressDialog = new CustomProgressDialog(context, R.style.progress_dialog_loading, "玩命加载中。。。");
		findViews(mContextView);
		formatData(getActivity());
		return mContextView;
	}

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
	public abstract void findViews(final View view);

	/**
	 * [业务操作]
	 *
	 * @param mContext
	 */
	public abstract void formatData(Context mContext);

	/** View点击 **/
	public abstract void widgetClick(View v);

	@Override
	public void onClick(View v) {
		if (fastClick())
			widgetClick(v);
	}

	@SuppressWarnings("unchecked")
	public <T extends View> T getView(View view, int resId) {
		return (T) view.findViewById(resId);
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
}
