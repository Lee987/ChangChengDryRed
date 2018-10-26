package com.changcheng.biz.changpda.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.BoxCodeEntity;
import com.changcheng.biz.changpda.entity.GoodsEntity;
import com.changcheng.biz.changpda.entity.OutStorageEntity;
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

import okhttp3.Call;

import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_SCODE;
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_EX_SCODE;

public class ScanActivity extends BaseActivity implements BaseRefreshListener,AdapterView.OnItemClickListener,View.OnClickListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private ListView listView;
    private TitleBar titleBar;
    private TextView tv_bottle_code;
    private TextView tv_name;
    private TextView tv_code;
    private Button btn_submit;
    private ArrayList<GoodsEntity.DataBean.RowsBean> listDatas = new ArrayList<>();
    private ArrayList<GoodsEntity.DataBean.RowsBean> selectDatas = new ArrayList<>();
    private CommonAdapter<GoodsEntity.DataBean.RowsBean> adapter;
    private String custId;
    private String userId;
    private int page = 1;
    private int rows = 10;
    private String message = "";
    private String productId = "";
    @Override
    public void initBundle(Bundle bundle) {
        custId = (String) SPUtils.get(ScanActivity.this, Constants.CUST_ID, "");
        userId = (String) SPUtils.get(ScanActivity.this, Constants.USER_ID, "");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scan;
    }

    @Override
    public void findViews(View view) {
        titleBar = findViewById(R.id.title_bar);
        tv_bottle_code = findViewById(R.id.tv_bottle_code);
        tv_name = findViewById(R.id.tv_goods_name);
        tv_code = findViewById(R.id.tv_code);
        btn_submit = findViewById(R.id.btn_submit);
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pullToRefreshLayout.setRefreshListener(this);
        listView.setOnItemClickListener(this);
        btn_submit.setOnClickListener(this);
    }

    @Override
    public void initData(Context mContext) {
        // Register receiver
        getData(page+"",rows+"");
        /*IntentFilter intentFilter = new IntentFilter(SCN_CUST_ACTION_SCODE);
        registerReceiver(scanDataReceiver,intentFilter);*/

        adapter = new CommonAdapter<GoodsEntity.DataBean.RowsBean>(this, R.layout.item_goods_lv, listDatas) {
            @Override
            public void convert(ViewHolder helper, GoodsEntity.DataBean.RowsBean item) {
                helper.setText(R.id.tv_goods_name, item.getProductName());
                String num = getResources().getString(R.string.txt_stor_num);
                num = String.format(num, item.getStockNum());
                helper.setText(R.id.tv_storage_num, num);
                CheckBox cb = helper.getConverView().findViewById(R.id.cb_goods);
                //判断CheckBox的状态
                if(item.isCheck()){
                    cb.setChecked(true);//选中
                }else {
                    cb.setChecked(false);//未选中
                }

            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(scanDataReceiver);
    }

    @Override
    public void initReceive(String msg) {
        message = msg;
        tv_bottle_code.setText(message);
        getBoxCodeInfo();
    }

    private void getData(String page, String rows) {
        RequestEntity entity = new RequestEntity();
        entity.setCustomerId(custId);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        paramsMap.put("page", page);
        paramsMap.put("rows", rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getScanProducts(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(ScanActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, "----->" + response);
                GoodsEntity entity = JSONObject.parseObject(response, GoodsEntity.class);
                if ("200".equals(entity.getCode())) {
                    listDatas.addAll(entity.getData().getRows());
                    adapter.notifyDataSetChanged();
                } else if ("900".equals(entity.getCode())) {
                    ToastUtils.showToast(ScanActivity.this, entity.getMsg(), 2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void getBoxCodeInfo(){
        RequestEntity entity = new RequestEntity();
        entity.setQrCode(message);
        entity.setType(0);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getProduct(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(ScanActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.d(TAG, response);
                BoxCodeEntity entity = JSONObject.parseObject(response, BoxCodeEntity.class);
                if ("200".equals(entity.getCode())) {
                    tv_name.setText(entity.getData().getProName());
                    tv_code.setText(entity.getData().getProCode());
                    for (GoodsEntity.DataBean.RowsBean bean : listDatas) {//全部设为未选中
                        bean.setCheck(false);
                    }
                    adapter.notifyDataSetChanged();
                } else{
                    ToastUtils.showToast(ScanActivity.this, "未查到相关产品！", 2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void submit(){
        RequestEntity entity = new RequestEntity();
        entity.setBoxCode(message);
        entity.setProductId(productId);
        entity.setOperactionUserId(userId);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getUpdateBarode(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(ScanActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.d(TAG, response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
                    ToastUtils.showToast(ScanActivity.this, msg, 2000);
                } else if ("900".equals(code)) {
                    ToastUtils.showToast(ScanActivity.this, msg, 2000);
                }
                hideLoadDialog();
            }
        });

    }


    private BroadcastReceiver scanDataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(SCN_CUST_ACTION_SCODE)){
                try {
                    message = intent.getStringExtra(SCN_CUST_EX_SCODE).toString();
                    tv_bottle_code.setText(message);

                }catch (Exception e){
                    e.printStackTrace();
                    Logger.e(TAG,e.toString());
                }

            }
        }
    };

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
        int currentNum = -1;
        for (GoodsEntity.DataBean.RowsBean bean : listDatas) {//全部设为未选中
            bean.setCheck(false);
        }
        if(currentNum == -1){ //选中
            listDatas.get(position).setCheck(true);
            currentNum = position;
        }else if(currentNum == position){ //同一个item选中变未选中
            for(GoodsEntity.DataBean.RowsBean bean  : listDatas){
                bean.setCheck(false);
            }
            currentNum = -1;
        }else if(currentNum != position){ //不是同一个item选中当前的，去除上一个选中的
            for(GoodsEntity.DataBean.RowsBean bean : listDatas){
                bean.setCheck(false);
            }
            listDatas.get(position).setCheck(true);
            currentNum = position;
        }

        tv_name.setText(listDatas.get(position).getProductName());
        tv_code.setText(listDatas.get(position).getProductCode());
        productId = listDatas.get(position).getId();
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit:
                if (TextUtils.isEmpty(productId)){
                    ToastUtils.showToast(this,"请选择商品！",2000);
                }else if (TextUtils.isEmpty(message)){
                    ToastUtils.showToast(this,"请扫描商品码！",2000);
                }else {
                    submit();
                }
                break;
        }
    }
}
