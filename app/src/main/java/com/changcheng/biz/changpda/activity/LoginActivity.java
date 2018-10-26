package com.changcheng.biz.changpda.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.ActivityStackManager;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.RequestEntity;
import com.changcheng.biz.changpda.entity.UserInfoEntity;
import com.changcheng.biz.changpda.okhttputils.CallBackUtil;
import com.changcheng.biz.changpda.okhttputils.OkhttpUtil;
import com.changcheng.biz.changpda.utils.AppUtils;
import com.changcheng.biz.changpda.utils.DownLoadService;
import com.changcheng.biz.changpda.utils.DownloadUtil;
import com.changcheng.biz.changpda.utils.SPUtils;
import com.changcheng.biz.changpda.utils.ToastUtils;

import java.io.File;
import java.util.HashMap;

import okhttp3.Call;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_name,et_pwd;
    private Button btn_login;
    private CheckBox cb_remember_pwd;
    private ImageView pwdCanSeeIv;
    private TextView tv_versions_num;

    private String user_name;
    private String user_pwd;
    private boolean isPwdCanSee = false;
    private Boolean isRemember;
    @Override
    public void initBundle(Bundle bundle) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void findViews(View view) {
        et_name = findViewById(R.id.ed_login_account);
        et_pwd = findViewById(R.id.ed_login_password);
        btn_login = findViewById(R.id.btn_login);
        cb_remember_pwd = findViewById(R.id.cb_remember_pwd);
        pwdCanSeeIv = findViewById(R.id.img_login_see_pwd);
        tv_versions_num = findViewById(R.id.tv_versions_num);

        btn_login.setOnClickListener(this);
        pwdCanSeeIv.setOnClickListener(this);

        //isUpdata();

    }

    @Override
    public void initData(Context mContext) {
        isRemember = (Boolean) SPUtils.get(LoginActivity.this,Constants.REMEMBER_PASSWORD,false);
        cb_remember_pwd.setChecked(isRemember);

        user_name = (String) SPUtils.get(LoginActivity.this,Constants.ACCOUNT,"");
        user_pwd = (String) SPUtils.get(LoginActivity.this,Constants.PASSWORD,"");
        et_name.setText(user_name);
        et_pwd.setText(user_pwd);
        et_name.setSelection(user_name.length());
        et_pwd.setSelection(user_pwd.length());

        tv_versions_num.setText("版本号："+ AppUtils.getVerName(this));
    }

    @Override
    public void initReceive(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:

                user_name = et_name.getText().toString().trim();
                user_pwd = et_pwd.getText().toString().trim();
                if (cb_remember_pwd.isChecked()) {
                    SPUtils.put(LoginActivity.this,Constants.ACCOUNT, user_name);
                    SPUtils.put(LoginActivity.this,Constants.PASSWORD, user_pwd);
                    SPUtils.put(LoginActivity.this,Constants.REMEMBER_PASSWORD, true);
                    login(user_name,user_pwd);
                } else {
                    SPUtils.put(LoginActivity.this,Constants.ACCOUNT, "");
                    SPUtils.put(LoginActivity.this,Constants.PASSWORD, "");
                    SPUtils.put(LoginActivity.this,Constants.REMEMBER_PASSWORD, false);
                    if (user_name!=null&&!user_name.equals("")){
                        login(user_name,user_pwd);
                    }else {
                        ToastUtils.showToast(LoginActivity.this,"用户名或密码不能为空！",2000);
                    }
                }

                break;
            case R.id.img_login_see_pwd:
                if (isPwdCanSee) {
                    et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    et_pwd.setSelection(et_pwd.getText().length());
                    pwdCanSeeIv.setImageResource(R.mipmap.lock);
                } else {
                    et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    et_pwd.setSelection(et_pwd.getText().length());
                    pwdCanSeeIv.setImageResource(R.mipmap.open);
                }
                isPwdCanSee = !isPwdCanSee;
                break;
        }
    }

    private void login(String userName,String userPwd){
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setUserName(userName);
        requestEntity.setPassword(userPwd);
        String data = JSON.toJSONString(requestEntity);
        HashMap<String,String> paramsMap = new HashMap<>();
        paramsMap.put("data",data);
        showLoadDialog();

        OkhttpUtil.okHttpPost(ApiManage.getLogin(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(LoginActivity.this,getString(R.string.error),2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                //ToastUtils.showToast(LoginActivity.this,response,2000);
                UserInfoEntity entity = JSONObject.parseObject(response, UserInfoEntity.class);
                if ("200".equals(entity.getCode())){
                    UserInfoEntity.DataBean.UserInfoBean userInfo = entity.getData().getUserInfo();
                    String custId = (String) userInfo.getCustId();
                    String custName = (String) userInfo.getCustName();
                    String custCode = (String) userInfo.getCustCode();
                    String fullName = userInfo.getFullName();
                    String userId = userInfo.getId();

                    SPUtils.put(LoginActivity.this, Constants.CUST_ID,custId);
                    SPUtils.put(LoginActivity.this, Constants.CUST_NAME,custName);
                    SPUtils.put(LoginActivity.this, Constants.CUST_CODE,custCode);
                    SPUtils.put(LoginActivity.this, Constants.USER_ID,userId);
                    SPUtils.put(LoginActivity.this, Constants.FULL_NAME,fullName);
                    startActivity(MainActivity.class);

                }else if ("900".equals(entity.getCode())){
                    ToastUtils.showToast(LoginActivity.this,entity.getMsg(),2000);
                }
                hideLoadDialog();
            }
        });
    }

    public void isUpdata() {
        AlertDialog.Builder dialog = new AlertDialog.
                Builder(LoginActivity.this);
        dialog.setTitle("提示！");//对话框最上面的字
        dialog.setMessage("版本更新？");//对话框中部的字
        dialog.setCancelable(false);//如果是false，点击其他位置或者返回键无效，这个地方默认为true
        //以下为对话框最下面的选择项
        dialog.setPositiveButton("确认", new DialogInterface.
                OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                DownloadUtil.get().setCancelDownload(false);
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, DownLoadService.class);
                intent.putExtra(DownLoadService.APK_PATH, "http://greatewall.oos-bj2.ctyunapi.cn/upload/file/1536057730210_1203ab53-5069-4f3c-a595-99753340b0e2.apk");//http://greatewall.oos-bj2.ctyunapi.cn/upload/file/1536057730210_1203ab53-5069-4f3c-a595-99753340b0e2.apk
                startService(intent);
            }

        });
        //需要第二个按钮才添加如下的setNegativeButton()
        dialog.setNegativeButton("取消", new DialogInterface.
                OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ActivityStackManager.finish();
            }

        });
        dialog.show();



    }
}
