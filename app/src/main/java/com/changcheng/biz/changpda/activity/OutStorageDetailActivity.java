package com.changcheng.biz.changpda.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.changcheng.biz.changpda.entity.InvtDetailEntity;
import com.changcheng.biz.changpda.entity.OutStorDetailEntity;
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

import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_SCODE;
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_EX_SCODE;//SCN_CUST_ACTION_START
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_START;//SCN_CUST_ACTION_CANCEL
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_CANCEL;

import okhttp3.Call;

public class OutStorageDetailActivity extends BaseActivity implements View.OnClickListener, BaseRefreshListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private ListView lv_top, lv_bottom;
    private TitleBar titleBar;
    private TextView tv_cod, tv_consignor, tv_consignee;
    private Button btn_submit,btn_scan;

    private List<OutStorDetailEntity.DataBean.RowsBean> scanTop = new ArrayList<>();
    private List<OutStorDetailEntity.DataBean.RowsBean> scanBottom = new ArrayList<>();
    private CommonAdapter<OutStorDetailEntity.DataBean.RowsBean> adapterTop;
    private CommonAdapter<OutStorDetailEntity.DataBean.RowsBean> adapterBottom;
    private int page = 1;
    private int rows = 10;
    private String storeId;
    private String userId;
    private String code;
    private String custId;
    private String consignee;
    private String shipper;
    private  String scanMshg = "";


    @Override
    public void initBundle(Bundle bundle) {
        userId = (String) SPUtils.get(OutStorageDetailActivity.this, Constants.USER_ID, "");
        custId = (String) SPUtils.get(OutStorageDetailActivity.this, Constants.CUST_ID, "");
        storeId = bundle.getString(Constants.STORE_ID);
        code = bundle.getString(Constants.CODE);
        consignee = bundle.getString(Constants.CONSIGNEE);
        shipper = bundle.getString(Constants.CONSIGNER);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_outstorage_detail;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        lv_top = findViewById(R.id.lv_top);
        lv_bottom = findViewById(R.id.lv_bottom);
        titleBar = findViewById(R.id.title_bar);
        tv_cod = findViewById(R.id.tv_code);
        tv_consignor = findViewById(R.id.tv_consignor);
        tv_consignee = findViewById(R.id.tv_consignee);
        btn_submit = findViewById(R.id.btn_submit);
        btn_scan = findViewById(R.id.btn_scan);

        titleBar.setTitle("出库单明细");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setActionTextColor(Color.WHITE);
        titleBar.addAction(new TitleBar.TextAction("首页") {
            @Override
            public void performAction(View view) {
                startActivity(MainActivity.class);
                finish();
            }
        });

        btn_submit.setOnClickListener(this);
        pullToRefreshLayout.setRefreshListener(this);
        pullToRefreshLayout.setCanRefresh(false);
        pullToRefreshLayout.setCanLoadMore(false);

        tv_cod.setText(code);
        tv_consignee.setText(consignee);
        tv_consignor.setText(shipper);

        View viewTop = LayoutInflater.from(OutStorageDetailActivity.this).inflate(R.layout.head_scan_layout, null);
        TextView top_type = viewTop.findViewById(R.id.tv_type);
        top_type.setText("发货数量");
        View viewBottom = LayoutInflater.from(OutStorageDetailActivity.this).inflate(R.layout.head_scannull_layout, null);
        TextView bottom_type = viewBottom.findViewById(R.id.tv_type);
        bottom_type.setText("发货数量");
        lv_top.addHeaderView(viewTop);
        lv_bottom.addHeaderView(viewBottom);
        btn_scan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    onTouchButton();
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    onReleaseButton();
                }
                return false;
            }
        });
    }

    @Override
    public void initData(Context mContext) {
        // Register receiver
        //IntentFilter intentFilter = new IntentFilter(SCN_CUST_ACTION_SCODE);
        //registerReceiver(scanDataReceiver,intentFilter);
        getData();
        adapterTop = new CommonAdapter<OutStorDetailEntity.DataBean.RowsBean>(this, R.layout.item_scan_layout, scanTop) {
            @Override
            public void convert(ViewHolder helper, OutStorDetailEntity.DataBean.RowsBean item) {
                helper.setText(R.id.tv_goods_name, item.getProductName())
                        .setText(R.id.tv_code, item.getProductCode())
                        .setText(R.id.tv_num, item.getProductNum() + "");

                String scanNum = String.valueOf(item.getScanNum());
                if ("null".equals(scanNum)){
                   helper.setText(R.id.tv_scan_num,  "0");
                }else {
                    helper .setText(R.id.tv_scan_num,item.getScanNum()+"");
                }
                if ("1".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"瓶" );
                }else if ("2".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"箱" );
                }

            }
        };

        lv_top.setAdapter(adapterTop);

        adapterBottom = new CommonAdapter<OutStorDetailEntity.DataBean.RowsBean>(this, R.layout.item_scannull_layout, scanBottom) {
            @Override
            public void convert(final ViewHolder helper, OutStorDetailEntity.DataBean.RowsBean item) {
                helper.setText(R.id.tv_goods_name, item.getProductName())
                        .setText(R.id.tv_code, item.getProductCode());


                if ("1".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"瓶" );
                }else if ("2".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"箱" );
                }
                final EditText et_num = helper.getConverView().findViewById(R.id.et_num);
                et_num.setInputType(InputType.TYPE_NULL);
                et_num.setText(item.getProductNum()+"");
            }
        };

        lv_bottom.setAdapter(adapterBottom);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(scanDataReceiver);
    }

    @Override
    public void initReceive(String msg) {
        scanMshg = msg;
        if (!TextUtils.isEmpty(scanMshg)){
            scanCode();
        }else {
            ToastUtils.showToast(OutStorageDetailActivity.this,"请重新扫码！",2000);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                doOut();
                break;
        }

    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束刷新
                scanTop.clear();
                scanBottom.clear();
                page = 1;
                getData();
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
                getData();
                pullToRefreshLayout.finishLoadMore();
            }
        }, 500);
    }

    private void getData() {
        RequestEntity entity = new RequestEntity();
        entity.setOutTreasuryCode(code);
        String data = JSON.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getOutTreasuryDetails(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(OutStorageDetailActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG,response);
                OutStorDetailEntity detailEntity = JSONObject.parseObject(response, OutStorDetailEntity.class);
                if ("200".equals(detailEntity.getCode())) {
                    for (int i = 0; i < detailEntity.getData().getRows().size(); i++) {
                        if ("1".equals(detailEntity.getData().getRows().get(i).getIsScan())) {//需要扫码
                            scanTop.add(detailEntity.getData().getRows().get(i));
                        } else if ("0".equals(detailEntity.getData().getRows().get(i).getIsScan())) {//不需要
                            scanBottom.add(detailEntity.getData().getRows().get(i));
                        }
                    }
                    adapterTop.notifyDataSetChanged();
                    adapterBottom.notifyDataSetChanged();

                }else if ("900".equals(detailEntity.getCode())) {
                    ToastUtils.showToast(OutStorageDetailActivity.this, detailEntity.getMsg(), 2000);
                }
                    hideLoadDialog();
            }
        });

    }


    private void doOut() {
        RequestEntity entity = new RequestEntity();
        entity.setUserId(userId);
        entity.setCustId(custId);
        //entity.setTerminalInfoId(storeId);
        entity.setOutTreasuryCode(code);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        OkhttpUtil.okHttpPost(ApiManage.getdoOut(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(OutStorageDetailActivity.this, R.string.error, 2000);
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG,response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
//                    JSONObject data = object.getJSONObject("data");
//                    String outCode = data.getString("outTreasuryCode");
//                    Bundle bundle = new Bundle();
//                    bundle.putString(Constants.CODE, outCode);
                    ToastUtils.showToast(OutStorageDetailActivity.this, msg, 2000);
                    OutStorageDetailActivity.this.finish();
                } else {
                    ToastUtils.showToast(OutStorageDetailActivity.this, msg, 2000);
                }
            }
        });
    }

    private void scanCode(){
        RequestEntity entity = new RequestEntity();
        entity.setOutTreasuryId(storeId);
        entity.setBoxCode(scanMshg);
        entity.setUserId(userId);
        entity.setCustomerId(custId);
        String data = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getOutTreasuryScan(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(OutStorageDetailActivity.this,R.string.error,2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.d(TAG,response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)){
                    pullToRefreshLayout.autoRefresh();
                }else if ("900".equals(code)){
                    ToastUtils.showToast(OutStorageDetailActivity.this,msg,2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void onTouchButton() {
        Intent scannerIntent = new Intent(SCN_CUST_ACTION_START);
        sendBroadcast(scannerIntent);
    }

    private void onReleaseButton() {
        Intent scannerIntent = new Intent(SCN_CUST_ACTION_CANCEL);
        sendBroadcast(scannerIntent);
    }

    private BroadcastReceiver scanDataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(SCN_CUST_ACTION_SCODE)){
                try {
                    scanMshg = intent.getStringExtra(SCN_CUST_EX_SCODE).toString();
                    if (!TextUtils.isEmpty(scanMshg)){
                        scanCode();
                    }else {
                        ToastUtils.showToast(OutStorageDetailActivity.this,"请重新扫码！",2000);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Logger.e(TAG,e.toString());
                }

            }
        }
    };
}
