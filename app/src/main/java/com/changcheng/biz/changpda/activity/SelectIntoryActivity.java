package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.RequestEntity;
import com.changcheng.biz.changpda.okhttputils.CallBackUtil;
import com.changcheng.biz.changpda.okhttputils.OkhttpUtil;
import com.changcheng.biz.changpda.utils.SPUtils;
import com.changcheng.biz.changpda.utils.TimeUtil;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TitleBar;

import java.util.HashMap;

import okhttp3.Call;

public class SelectIntoryActivity extends BaseActivity implements View.OnClickListener{
    private TitleBar titleBar;
    private Button btn_next;
    private LinearLayout ll_single,ll_all;
    private ImageView iv_single,iv_all;
    private EditText et_name;
    private int select = 0;
    private String custId;
    private String userId;
    @Override
    public void initBundle(Bundle bundle) {
        custId = (String) SPUtils.get(SelectIntoryActivity.this, Constants.CUST_ID, "");
        userId = (String) SPUtils.get(SelectIntoryActivity.this,Constants.USER_ID,"");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_intory;
    }

    @Override
    public void findViews(View view) {
        titleBar = findViewById(R.id.title_bar);
        btn_next = findViewById(R.id.btn_next);
        ll_single = findViewById(R.id.ll_single);
        ll_all = findViewById(R.id.ll_all);
        iv_single = findViewById(R.id.iv_single);
        iv_all = findViewById(R.id.iv_all);
        et_name = findViewById(R.id.et_inventory_name);

        btn_next.setOnClickListener(this);
        ll_single.setOnClickListener(this);
        ll_all.setOnClickListener(this);

    }

    @Override
    public void initData(Context mContext) {
        titleBar.setTitle("选择盘点类型");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initReceive(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                String name = et_name.getText().toString();
                if (!TextUtils.isEmpty(name)){
                    if (select==0){
                        Bundle bundle = new Bundle();
                        bundle.putString(Constants.INVENTORY_NAME,name);
                        startActivity(IntoryGoodsActivity.class,bundle);
                        this.finish();
                    }else {
                        addProductDetail(name);
                    }
                }else {
                    ToastUtils.showToast(SelectIntoryActivity.this,"请填写盘点名称",2000);
                }

                break;

            case R.id.ll_single:
                iv_single.setImageResource(R.mipmap.selected);
                iv_all.setImageResource(R.mipmap.unselect);
                select = 0;
                break;

            case R.id.ll_all:
                iv_single.setImageResource(R.mipmap.unselect);
                iv_all.setImageResource(R.mipmap.selected);
                select = 1;
                break;
        }
    }

    private void addProductDetail(String name){
        showLoadDialog();
        RequestEntity entity = new RequestEntity();
        RequestEntity.TmInventoryVo inventoryVo = new RequestEntity.TmInventoryVo();
        inventoryVo.setInventoryName(name);
        inventoryVo.setInventoryType(1);
        inventoryVo.setStatus(1);
        inventoryVo.setCustomerId(custId);
        entity.setUserId(userId);
        entity.setTmInventoryVo(inventoryVo);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        OkhttpUtil.okHttpPost(ApiManage.getSubmitAll(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(SelectIntoryActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                JSONObject object =  JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)){
                    JSONObject data = object.getJSONObject("data");
                    String id = data.getString("id");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.INVENTORY_ID,id);
                    bundle.putInt(Constants.INVENTORY_TYPE,1);
                    startActivity(InventoryDetailActivity.class,bundle);
                    SelectIntoryActivity.this.finish();
                }else {
                    ToastUtils.showToast(SelectIntoryActivity.this, msg, 2000);
                }
                hideLoadDialog();
            }
        });
    }
}
