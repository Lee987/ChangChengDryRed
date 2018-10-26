package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.InventoryEntity;
import com.changcheng.biz.changpda.entity.RequestEntity;
import com.changcheng.biz.changpda.evevtbus.RefreshEvent;
import com.changcheng.biz.changpda.okhttputils.CallBackUtil;
import com.changcheng.biz.changpda.okhttputils.OkhttpUtil;
import com.changcheng.biz.changpda.utils.SPUtils;
import com.changcheng.biz.changpda.utils.TimeUtil;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TitleBar;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;

public class NotInventoryActivity extends BaseActivity implements View.OnClickListener, BaseRefreshListener, AdapterView.OnItemClickListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private TitleBar titleBar;
    private ListView listView;
    private Button btn_add;
    private ArrayList<InventoryEntity.DataBean.ListBean> listDatas = new ArrayList<>();
    private CommonAdapter<InventoryEntity.DataBean.ListBean> adapter;
    private String custId;
    private int page = 1;
    private int rows = 10;

    @Override
    public void initBundle(Bundle bundle) {
        EventBus.getDefault().register(this);
        custId = (String) SPUtils.get(NotInventoryActivity.this, Constants.CUST_ID, "");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_noinventory;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        titleBar = findViewById(R.id.title_bar);
        btn_add = findViewById(R.id.btn_add);
        titleBar.setTitle(R.string.act_not_inventory);
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_add.setOnClickListener(this);
        pullToRefreshLayout.setRefreshListener(this);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void initData(Context mContext) {


        adapter = new CommonAdapter<InventoryEntity.DataBean.ListBean>(NotInventoryActivity.this, R.layout.item_input_lv, listDatas) {
            @Override
            public void convert(ViewHolder helper, InventoryEntity.DataBean.ListBean item) {
                helper.setText(R.id.tv_code, item.getInventoryNumber())
                        .setText(R.id.tv_shipper, item.getCustomerName())
                        .setText(R.id.tv_crt_time, TimeUtil.format(item.getCreateDate(), TimeUtil.FORMAT_1));

            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void initReceive(String msg) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshEvent(RefreshEvent event) {
       pullToRefreshLayout.autoRefresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listDatas.clear();
        page = 1;
        getData(page + "", rows + "");
    }

    private void getData(String page, String rows) {
        RequestEntity entity = new RequestEntity();
        entity.setCustomerId(custId);
        entity.setStatus(1);
        String data = JSON.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        paramsMap.put("page", page);
        paramsMap.put("rows", rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getTmInventoryList(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(NotInventoryActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                //ToastUtils.showToast(NotInventoryActivity.this,response,2000);
                InventoryEntity entity = JSONObject.parseObject(response, InventoryEntity.class);
                if ("200".equals(entity.getCode())) {
                    listDatas.addAll(entity.getData().getList());
                    adapter.notifyDataSetChanged();
                } else if ("900".equals(entity.getCode())) {
                    ToastUtils.showToast(NotInventoryActivity.this, entity.getMsg(), 2000);
                }
                hideLoadDialog();

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if (listDatas.size() > 0) {
                    ToastUtils.showToast(NotInventoryActivity.this, getString(R.string.no_finish), 2000);

                } else {
                    startActivity(SelectIntoryActivity.class);
                }

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.INVENTORY_ID, listDatas.get(position).getId());
        bundle.putInt(Constants.INVENTORY_TYPE,listDatas.get(position).getInventoryType());
        startActivity(InventoryDetailActivity.class, bundle);

    }
}
