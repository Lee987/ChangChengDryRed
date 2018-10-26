package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.ChooseDateEntity;
import com.changcheng.biz.changpda.entity.InventoryEntity;
import com.changcheng.biz.changpda.entity.RequestEntity;
import com.changcheng.biz.changpda.entity.ReturnGoodsEntity;
import com.changcheng.biz.changpda.okhttputils.CallBackUtil;
import com.changcheng.biz.changpda.okhttputils.OkhttpUtil;
import com.changcheng.biz.changpda.utils.SPUtils;
import com.changcheng.biz.changpda.utils.TimeUtil;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TimePickViewDialog;
import com.changcheng.biz.changpda.view.TitleBar;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

public class ReturnGoodsActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, BaseRefreshListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private TitleBar titleBar;
    private ListView listView;
    private LinearLayout ll_select_data;
    private TextView tv_time;
    private Button btn_add;
    private EditText et_search;
    private ArrayList<ReturnGoodsEntity.DataBean.RowsBean> listDatas = new ArrayList<>();
    private CommonAdapter<ReturnGoodsEntity.DataBean.RowsBean> adapter;
    private String custId;
    private int page = 1;
    private int rows = 10;
    private String search = "";

    @Override
    public void initBundle(Bundle bundle) {
        custId = (String) SPUtils.get(ReturnGoodsActivity.this, Constants.CUST_ID, "");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_return_goods;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        titleBar = findViewById(R.id.title_bar);
        ll_select_data = findViewById(R.id.ll_select_data);
        tv_time = findViewById(R.id.tv_time);
        btn_add = findViewById(R.id.btn_add);
        et_search = findViewById(R.id.et_search_comment);

        ll_select_data.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        pullToRefreshLayout.setRefreshListener(this);
        btn_add.setOnClickListener(this);

        titleBar.setTitle("待出库退货单");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search = et_search.getText().toString();
                listDatas.clear();
                page = 1;
                getData(page + "", rows + "", search);

            }
        });
    }

    @Override
    public void initData(Context mContext) {

        adapter = new CommonAdapter<ReturnGoodsEntity.DataBean.RowsBean>(ReturnGoodsActivity.this, R.layout.item_input_lv, listDatas) {
            @Override
            public void convert(ViewHolder helper, ReturnGoodsEntity.DataBean.RowsBean item) {
                helper.setText(R.id.tv_code, item.getReturnGoodsCode())
                        .setText(R.id.tv_type,"收货方：")
                        .setText(R.id.tv_shipper, item.getReceivingPartyName())
                        .setText(R.id.tv_time_type, "创建时间：")
                        .setText(R.id.tv_crt_time, TimeUtil.format(item.getCreateDate(), TimeUtil.FORMAT_1));

            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listDatas.clear();
        page = 1;
        getData(page + "", rows + "", search);
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
            case R.id.btn_add:
                startActivity(SelcetFactoryActivity.class);
                break;
        }
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束刷新
                listDatas.clear();
                page = 1;
                getData(page + "", rows + "", search);
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
                page++;
                getData(page + "", rows + "", search);
                pullToRefreshLayout.finishLoadMore();
            }
        }, 500);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.STORE_ID,listDatas.get(position).getId());
        bundle.putString(Constants.CODE, listDatas.get(position).getReturnGoodsCode());
        bundle.putString(Constants.CONSIGNEE, listDatas.get(position).getReceivingPartyName());
        bundle.putString(Constants.CONSIGNER, listDatas.get(position).getReturnPartyName());
        startActivity(StorageDetailActivity.class, bundle);

    }

    private void getData(String page, String rows, String search) {
        RequestEntity entity = new RequestEntity();
        entity.setCustomerId(custId);
        entity.setReturnGoodsCode(search);
        entity.setStatus(1);
        String data = JSON.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        paramsMap.put("page", page);
        paramsMap.put("rows", rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getReturnGoodsList(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(ReturnGoodsActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                //ToastUtils.showToast(NotInventoryActivity.this,response,2000);
                ReturnGoodsEntity entity = JSONObject.parseObject(response, ReturnGoodsEntity.class);
                if ("200".equals(entity.getCode())) {
                    listDatas.addAll(entity.getData().getRows());
                    adapter.notifyDataSetChanged();
                } else if ("900".equals(entity.getCode())) {
                    ToastUtils.showToast(ReturnGoodsActivity.this, entity.getMsg(), 2000);
                }
                hideLoadDialog();

            }
        });

    }
}
