package com.changcheng.biz.changpda.utils;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;


import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.ActivityStackManager;
import com.changcheng.biz.changpda.base.BaseApplication;
import com.changcheng.biz.changpda.view.CustomerProgressDialog;

import java.io.File;

/**
 * 版    权 ：博智信息
 * 项目名称 : heroicalliance
 * 包    名 : com.biz.crm.changchengdryred.service
 * 作    者 : FLY
 * 创建时间 : 2018/3/6
 * <p>
 * 描述:
 */

public class DownLoadService extends Service {
    public static final String APK_PATH = "apk_path";
    private Context mContext;
    private File apkFile;
    private CustomerProgressDialog mProgressDialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (msg.arg1 >= 100) {
                    installApk(apkFile);
                    mProgressDialog.dismiss();
                    handler.removeMessages(1);
                }
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mContext = this;
        if (intent != null) {
            String apkPath = intent.getStringExtra(APK_PATH);
            if (apkPath != null) {
                loadFile(apkPath);
            } else {
                ToastUtils.showToast(this,getString(R.string.text_apk_path_isempty),2000);
            }
        } else {
            ToastUtils.showToast(this,getString(R.string.text_update_error),2000);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 下载文件
     */
    private void loadFile(String path) {
        initProgressDialog();
        DownloadUtil.get().download(path, "diageo", new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess(File file) {
                apkFile = file;
                DownloadUtil.get().setCancelDownload(false);
                mProgressDialog.setConfirmBtnEnable(true);
            }

            @Override
            public void onDownloading(long progress, long total) {
                Log.e("zs", progress + "----" + total);
                updateProgressBar(progress);
                Message message = new Message();
                message.what = 1;
                message.arg1 = (int) progress;
                handler.sendMessage(message);
            }

            @Override
            public void onDownloadFailed() {
                Log.e("zs", "请求失败");
            }

        });
    }

    /**
     * 安装软件
     */
    private void installApk(File file) {
        if (file == null) return;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data;
        String type = "application/vnd.android.package-archive";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            data = Uri.fromFile(file);
        } else {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            data = FileProvider.getUriForFile(mContext, mContext.getPackageName()+".fileProvider", file);
        }
        intent.setDataAndType(data, type);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public void initProgressDialog() {
        mProgressDialog = CustomerProgressDialog.getDefault(ActivityStackManager.getTheLastActivity(), new CustomerProgressDialog.OnClickListener() {
            @Override
            public void onYesClick(View v) {
            }

            @Override
            public void onNoClick(View v) {
                mProgressDialog.dismiss();
                DownloadUtil.get().setCancelDownload(true);
            }
        });
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public void updateProgressBar(long progress) {
        mProgressDialog.setProgress((int) progress);
    }

}