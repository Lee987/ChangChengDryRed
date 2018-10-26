package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.ReceiptDetailEntity;
import com.changcheng.biz.changpda.entity.RequestEntity;
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
import java.util.List;

import okhttp3.Call;

public class InputReceiptActivity extends BaseActivity implements BaseRefreshListener, View.OnClickListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private TitleBar titleBar;
    private ListView listView;
    private TextView tv_code, tv_consignor, tv_time;
    private Button btn_receipt;
    private List<ReceiptDetailEntity.DataBean> listDatas = new ArrayList<>();
    private CommonAdapter<ReceiptDetailEntity.DataBean> adapter;
    private int page = 1;
    private int rows = 10;
    private String orderId;
    private String name;
    private String date;
    private String code;
    private String creatName;

    @Override
    public void initBundle(Bundle bundle) {
        orderId = bundle.getString(Constants.ID);
        name = bundle.getString(Constants.NAME);
        date = bundle.getString(Constants.DATE);
        code = bundle.getString(Constants.CODE);
        creatName = (String) SPUtils.get(this, Constants.CREAT_NAME, "");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_input_receipt;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        tv_code = findViewById(R.id.tv_code);
        tv_consignor = findViewById(R.id.tv_consignor);
        tv_time = findViewById(R.id.tv_time);
        btn_receipt = findViewById(R.id.btn_receipt);

        titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle("入库单签收");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pullToRefreshLayout.setRefreshListener(this);
        btn_receipt.setOnClickListener(this);

        tv_code.setText(code);
        tv_consignor.setText(name);
        tv_time.setText(date);
    }

    @Override
    public void initData(Context mContext) {

        getData(page + "", rows + "");
        adapter = new CommonAdapter<ReceiptDetailEntity.DataBean>(InputReceiptActivity.this, R.layout.item_receipt_lv, listDatas) {
            @Override
            public void convert(ViewHolder helper, ReceiptDetailEntity.DataBean item) {
                helper.setText(R.id.tv_goods_name, (String) item.getProductName())
                        .setText(R.id.tv_code, item.getProductCode())
                        .setText(R.id.tv_num, item.getNumber() + "")
                        .setText(R.id.tv_standard, item.getStandard())
                        .setText(R.id.tv_unit,item.getUnit());
                /*if ("1".equals(item.getUnit())) {
                    helper.setText(R.id.tv_unit, "瓶");
                } else if ("2".equals(item.getUnit())) {
                    helper.setText(R.id.tv_unit, "箱");
                }*/

            }
        };
        View headView = LayoutInflater.from(this).inflate(R.layout.head_receipt_layout, null);
        View footView = LayoutInflater.from(this).inflate(R.layout.foot_receipt_layout, null);
        listView.addHeaderView(headView);
        //listView.addFooterView(footView);
        listView.setAdapter(adapter);
    }

    @Override
    public void initReceive(String msg) {

    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束刷新
                listDatas.clear();
                page = 1;
                getData(page + "", rows + "");
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
                getData(page + "", rows + "");
                pullToRefreshLayout.finishLoadMore();
            }
        }, 500);
    }

    private void getData(String page, String rows) {
        RequestEntity entity = new RequestEntity();
        entity.setEnterLibraryOrderId(orderId);
        String data = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        paramsMap.put("page", page);
        paramsMap.put("rows", rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getDataItemAll(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(InputReceiptActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, response);
                ReceiptDetailEntity entity = JSONObject.parseObject(response, ReceiptDetailEntity.class);
                if ("200".equals(entity.getCode())) {
                    listDatas.addAll(entity.getData());
                    adapter.notifyDataSetChanged();
                } else if ("900".equals(entity.getCode())) {
                    ToastUtils.showToast(InputReceiptActivity.this, entity.getMsg(), 2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void receipt() {
        RequestEntity entity = new RequestEntity();
        entity.setId(orderId);
        entity.setCreateName(creatName);
        String data = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getCollectGoods(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(InputReceiptActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
                    ToastUtils.showToast(InputReceiptActivity.this, msg, 2000);
                    InputReceiptActivity.this.finish();
                } else {
                    ToastUtils.showToast(InputReceiptActivity.this, msg, 2000);
                }
                hideLoadDialog();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_receipt:
                receipt();
                break;
        }
    }
}
