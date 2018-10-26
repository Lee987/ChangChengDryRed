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
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.ChooseDateEntity;
import com.changcheng.biz.changpda.entity.OutStorageEntity;
import com.changcheng.biz.changpda.entity.ReceiptEntity;
import com.changcheng.biz.changpda.entity.RequestEntity;
import com.changcheng.biz.changpda.okhttputils.CallBackUtil;
import com.changcheng.biz.changpda.okhttputils.OkhttpUtil;
import com.changcheng.biz.changpda.utils.Logger;
import com.changcheng.biz.changpda.utils.SPUtils;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TimePickViewDialog;
import com.changcheng.biz.changpda.view.TitleBar;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;

public class InputActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, BaseRefreshListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private TitleBar titleBar;
    private ListView listView;
    private LinearLayout ll_select_data;
    private TextView tv_time;
    private EditText et_search_comment;
    private ArrayList<ReceiptEntity.DataBean> listDatas = new ArrayList<>();
    private CommonAdapter<ReceiptEntity.DataBean> adapter;
    private String custId;
    private int page = 1;
    private int rows = 10;
    private String search = "";

    @Override
    public void initBundle(Bundle bundle) {
        custId = (String) SPUtils.get(InputActivity.this, Constants.CUST_ID, "");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_input;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        titleBar = findViewById(R.id.title_bar);
        ll_select_data = findViewById(R.id.ll_select_data);
        tv_time = findViewById(R.id.tv_time);
        et_search_comment = findViewById(R.id.et_search_comment);

        ll_select_data.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        pullToRefreshLayout.setRefreshListener(this);

        titleBar.setTitle(R.string.act_input);
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        et_search_comment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search = et_search_comment.getText().toString();
                listDatas.clear();
                page = 1;
                getData(page+"",rows+"",search);

            }
        });


    }

    @Override
    public void initData(Context mContext) {

        adapter = new CommonAdapter<ReceiptEntity.DataBean>(InputActivity.this, R.layout.item_input_lv, listDatas) {
            @Override
            public void convert(ViewHolder helper, ReceiptEntity.DataBean item) {
                helper.setText(R.id.tv_code,item.getDeliveryCode())
                        .setText(R.id.tv_shipper,item.getReceivingPartyName())
                        .setText(R.id.tv_crt_time,item.getCreateDate());

            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listDatas.clear();
        page = 1;
        getData(page + "", rows + "",search);
    }

    @Override
    public void initReceive(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_select_data:
                TimePickViewDialog.createDialog(this, tv_time);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ID,listDatas.get(position).getId());
        bundle.putString(Constants.NAME,listDatas.get(position).getReceivingPartyName());
        bundle.putString(Constants.CODE,listDatas.get(position).getDeliveryCode());
        bundle.putString(Constants.DATE,listDatas.get(position).getCreateDate());
        startActivity(InputReceiptActivity.class,bundle);
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束刷新
                listDatas.clear();
                page = 1;
                getData(page+"",rows+"",search);
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
                getData(page+"",rows+"",search);
                pullToRefreshLayout.finishLoadMore();
            }
        }, 500);
    }

    private void getData(String page, String rows,String deliveryCode) {
        RequestEntity entity = new RequestEntity();
        entity.setOrgId(custId);
        entity.setDeliveryCode(deliveryCode);
        String data = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        paramsMap.put("page", page);
        paramsMap.put("rows", rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getDataByParames(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(InputActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, "----->" + response);
                ReceiptEntity entity = JSONObject.parseObject(response, ReceiptEntity.class);
                if ("200".equals(entity.getCode())){
                    listDatas.addAll(entity.getData());
                    adapter.notifyDataSetChanged();
                }else if ("900".equals(entity.getCode())){
                    ToastUtils.showToast(InputActivity.this,entity.getMsg(),2000);
                }
                hideLoadDialog();
            }
        });

    }

}
