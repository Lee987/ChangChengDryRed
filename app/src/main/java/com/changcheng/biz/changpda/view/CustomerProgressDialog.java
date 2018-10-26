package com.changcheng.biz.changpda.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.changcheng.biz.changpda.R;


/**
 * 版    权 ：博智信息
 * 项目名称 : heroicalliance
 * 包    名 : com.biz.view
 * 作    者 : FLY
 * 创建时间 : 2018/3/6
 * <p>
 * 描述:
 */

public class CustomerProgressDialog extends Dialog implements View.OnClickListener{
    public TextView tvTitle;
    public HorizontalProgressBarWithNumber mProgressBar;
    private Button butCancel, butYes;
    private int progress;
    private OnClickListener listener;
   // private CloseSystemDialogsReceiver mCloseSystemDialogsReceiver;

    public CustomerProgressDialog(Context context, OnClickListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_progress);
        this.listener = listener;
        initViews();
       /* IntentFilter filter = new IntentFilter(
                Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        mCloseSystemDialogsReceiver = new CloseSystemDialogsReceiver();
        getWindow().getContext().registerReceiver(mCloseSystemDialogsReceiver,
                filter);*/
    }

    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        mProgressBar = (HorizontalProgressBarWithNumber) findViewById(R.id.progress);
        butYes = (Button) findViewById(R.id.butYes);
        butCancel = (Button) findViewById(R.id.butCancel);
        butYes.setEnabled(false);
        butYes.setOnClickListener(this);
        butCancel.setOnClickListener(this);
        mProgressBar.setMax(100);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        mProgressBar.setProgress(progress);
    }

    public int getProgress() {
        return mProgressBar.getProgress();
    }

    @Override
    public void setTitle(CharSequence title) {
        tvTitle.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        tvTitle.setText(titleId);
    }

    /**
     * 设置标题栏字体颜色。
     *
     * @param color 颜色的ARGB值.
     */
    public void setTitleTextColor(int color) {
        tvTitle.setTextColor(color);
    }

    public static CustomerProgressDialog getDefault(Context context,
                                                    OnClickListener listener) {
        CustomerProgressDialog dialog = new CustomerProgressDialog(context, listener);
        dialog.setTitle(context.getResources().getString(R.string.dialog_download));
        //dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.setTitleTextColor(context.getResources().getColor(
                R.color.color_262626));
        return dialog;
    }

    @Override
    public void onClick(View v) {
        if (v == butYes) {
            if (listener != null) {
                listener.onYesClick(v);
            }
            dismiss();
        } else if (v == butCancel) {
            if (listener != null) {
                listener.onNoClick(v);
            }
            dismiss();
        }
    }

    public void setConfirmBtnEnable(boolean b) {
        butYes.setEnabled(b);
    }

    /*private class CloseSystemDialogsReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(intent.getAction())) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)) {
                    getWindow().getContext().unregisterReceiver(mCloseSystemDialogsReceiver);
                }
            }

        }
    }*/

    public interface OnClickListener {
        /**
         * 当点击“yes”按钮时回调。
         *
         * @param v
         */
        public void onYesClick(View v);

        /**
         * 当点击“no”按钮时回调。
         *
         * @param v
         */
        public void onNoClick(View v);
    }

}
