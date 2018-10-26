package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.RequestEntity;
import com.changcheng.biz.changpda.entity.UserStoreEntity;
import com.changcheng.biz.changpda.okhttputils.CallBackUtil;
import com.changcheng.biz.changpda.okhttputils.OkhttpUtil;
import com.changcheng.biz.changpda.utils.Logger;
import com.changcheng.biz.changpda.utils.SPUtils;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TitleBar;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;


import okhttp3.Call;

public class SelectStoreActivity extends BaseActivity implements View.OnClickListener,AdapterView.OnItemClickListener,BaseRefreshListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private TitleBar titleBar;
    private ListView listView;
    private ArrayList<UserStoreEntity.DataBean.RowsBean> listDatas = new ArrayList<>();
    private CommonAdapter<UserStoreEntity.DataBean.RowsBean> adapter;
    private String custId ;
    private int page = 1;
    private int rows = 10;
    private String serach = "";
    private EditText et_serach;
    @Override
    public void initBundle(Bundle bundle) {
       custId = (String)SPUtils.get(SelectStoreActivity.this, Constants.CUST_ID,"");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_store;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        titleBar = findViewById(R.id.title_bar);
        et_serach = findViewById(R.id.et_search_comment);

        listView.setOnItemClickListener(this);
        pullToRefreshLayout.setRefreshListener(this);

        titleBar.setTitle("选择收获门店");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        et_serach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                serach =  et_serach.getText().toString();
                listDatas.clear();
                page = 1;
                getData(page+"",rows+"",serach);

            }
        });

    }

    @Override
    public void initData(Context mContext) {

        getData(page+"",rows+"",serach);
        adapter = new CommonAdapter<UserStoreEntity.DataBean.RowsBean>(SelectStoreActivity.this,R.layout.item_storage_lv,listDatas) {
            @Override
            public void convert(ViewHolder helper, UserStoreEntity.DataBean.RowsBean item) {
                helper.setText(R.id.tv_code,item.getCode());
                helper.setText(R.id.tv_sign,item.getSign());
                helper.setText(R.id.tv_phone,item.getPhone());

            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    public void initReceive(String msg) {

    }

    private void getData(String page,String rows,String serach){
        RequestEntity entity = new RequestEntity();
        entity.setCustomerId(custId);
        entity.setCode(serach);
        String str = JSONObject.toJSONString(entity);
        HashMap<String,String> paramsMap = new HashMap<>();
        paramsMap.put("data",str);
        paramsMap.put("page",page);
        paramsMap.put("rows",rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getUserTerminal(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(SelectStoreActivity.this,R.string.error,2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG,"----->"+response);
                UserStoreEntity entity = JSONObject.parseObject(response, UserStoreEntity.class);
                if ("200".equals(entity.getCode())){
                    listDatas.addAll(entity.getData().getRows());
                    adapter.notifyDataSetChanged();
                }else if ("900".equals(entity.getCode())){
                    ToastUtils.showToast(SelectStoreActivity.this,entity.getMsg(),2000);
                }
                hideLoadDialog();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STORE_ID,listDatas.get(position).getId()+"");
        bundle.putString(Constants.CONSIGNEE,listDatas.get(position).getSign());
        startActivity(OutGoodsActivity.class,bundle);
        this.finish();
    }


    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束刷新
                listDatas.clear();
                page = 1;
                getData(page+"",rows+"",serach);
                pullToRefreshLayout.finishRefresh();
            }
        }, 500);
    }

    @Override
    public void loadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束加载更多
                page ++;
                getData(page+"",rows+"",serach);
                pullToRefreshLayout.finishLoadMore();
            }
        }, 500);
    }
}
