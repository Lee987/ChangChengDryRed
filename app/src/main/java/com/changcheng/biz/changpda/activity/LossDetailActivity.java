package com.changcheng.biz.changpda.activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.LossDetailEntity;
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

public class LossDetailActivity extends BaseActivity implements View.OnClickListener, BaseRefreshListener {
    private PullToRefreshLayout pullToRefreshLayout;
    private ListView lv_top, lv_bottom;
    private TitleBar titleBar;
    private TextView tv_cod, tv_type, tv_remark;
    private Button btn_submit, btn_scan;

    private List<LossDetailEntity.DataBean> scanTop = new ArrayList<>();
    private List<LossDetailEntity.DataBean> scanBottom = new ArrayList<>();
    private CommonAdapter<LossDetailEntity.DataBean> adapterTop;
    private CommonAdapter<LossDetailEntity.DataBean> adapterBottom;
    private int page = 1;
    private int rows = 10;
    private String lossId;
    private String userId;
    private String lossCode;
    private String custId;
    private String lossType;
    private String remark;
    private String scanMshg = "";
    private boolean isIgnore = false;

    @Override
    public void initBundle(Bundle bundle) {
        userId = (String) SPUtils.get(LossDetailActivity.this, Constants.USER_ID, "");
        custId = (String) SPUtils.get(LossDetailActivity.this, Constants.CUST_ID, "");
        lossCode = bundle.getString(Constants.CODE);
        lossId = bundle.getString(Constants.ID);
        lossType = bundle.getString(Constants.INVENTORY_TYPE);
        remark = bundle.getString("REMARK");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_loss_detail;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        lv_top = findViewById(R.id.lv_top);
        lv_bottom = findViewById(R.id.lv_bottom);
        titleBar = findViewById(R.id.title_bar);
        tv_cod = findViewById(R.id.tv_code);
        tv_type = findViewById(R.id.tv_loss_type);
        tv_remark = findViewById(R.id.tv_remark);
        btn_submit = findViewById(R.id.btn_submit);
        btn_scan = findViewById(R.id.btn_scan);

        titleBar.setTitle("报损单明细");
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

        tv_cod.setText(lossCode);
        tv_remark.setText(remark);
        if ("0".equals(lossType)) {
            tv_type.setText(getResources().getString(R.string.txt_loss));
            tv_type.setTextColor(getResources().getColor(R.color.color_CC003D));
        } else if ("1".equals(lossType)) {
            tv_type.setText(getResources().getString(R.string.txt_out_time));
            tv_type.setTextColor(getResources().getColor(R.color.color_CDBB00));
        }

        View viewTop = LayoutInflater.from(this).inflate(R.layout.head_scan_layout, null);
        TextView top_type = viewTop.findViewById(R.id.tv_type);
        top_type.setText("发货数量");
        View viewBottom = LayoutInflater.from(this).inflate(R.layout.head_scannull_layout, null);
        TextView bottom_type = viewBottom.findViewById(R.id.tv_type);
        bottom_type.setText("发货数量");
        lv_top.addHeaderView(viewTop);
        lv_bottom.addHeaderView(viewBottom);

        btn_scan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    onTouchButton();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
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
        //registerReceiver(scanDataReceiver, intentFilter);
        getData();
        adapterTop = new CommonAdapter<LossDetailEntity.DataBean>(this, R.layout.item_scan_layout, scanTop) {
            @Override
            public void convert(ViewHolder helper, LossDetailEntity.DataBean item) {
                helper.setText(R.id.tv_goods_name, item.getCommodityName())
                        .setText(R.id.tv_code, item.getCommodityCode())
                        .setText(R.id.tv_num, item.getQuantity() + "");
                String scanNum = String.valueOf(item.getScanQuantity());
                if ("null".equals(scanNum)){
                    helper.setText(R.id.tv_scan_num,  "0");
                }else {
                    helper .setText(R.id.tv_scan_num,item.getScanQuantity()+"");
                }
                if ("1".equals(item.getCommodityUnit())) {
                    helper.setText(R.id.tv_unit, "瓶");
                } else if ("2".equals(item.getCommodityUnit())) {
                    helper.setText(R.id.tv_unit, "箱");
                }

            }
        };

        lv_top.setAdapter(adapterTop);

        adapterBottom = new CommonAdapter<LossDetailEntity.DataBean>(this, R.layout.item_scannull_layout, scanBottom) {
            @Override
            public void convert(final ViewHolder helper, LossDetailEntity.DataBean item) {
                helper.setText(R.id.tv_goods_name, item.getCommodityName())
                        .setText(R.id.tv_code, item.getCommodityCode());


                if ("1".equals(item.getCommodityUnit())) {
                    helper.setText(R.id.tv_unit, "瓶");
                } else if ("2".equals(item.getCommodityUnit())) {
                    helper.setText(R.id.tv_unit, "箱");
                }
                final EditText et_num = helper.getConverView().findViewById(R.id.et_num);
                et_num.setInputType(InputType.TYPE_NULL);
                et_num.setText(item.getQuantity() + "");
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
        if (!TextUtils.isEmpty(scanMshg)) {
            scanCode();
        } else {
            ToastUtils.showToast(LossDetailActivity.this, "请重新扫码！", 2000);
        }
    }

    private void getData() {
        RequestEntity entity = new RequestEntity();
        entity.setReportLossCode(lossCode);
        //entity.setReportLossId(lossId);
        String data = JSON.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getFindLossDetail(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(LossDetailActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, response);
                LossDetailEntity detailEntity = JSONObject.parseObject(response, LossDetailEntity.class);
                if ("200".equals(detailEntity.getCode())) {
                    for (int i = 0; i < detailEntity.getData().size(); i++) {
                        if (1 == detailEntity.getData().get(i).getIsScan()) {//需要扫码
                            scanTop.add(detailEntity.getData().get(i));
                        } else if (0 == detailEntity.getData().get(i).getIsScan()) {//不需要
                            scanBottom.add(detailEntity.getData().get(i));
                        }
                    }
                    adapterTop.notifyDataSetChanged();
                    adapterBottom.notifyDataSetChanged();

                } else if ("900".equals(detailEntity.getCode())) {
                    ToastUtils.showToast(LossDetailActivity.this, detailEntity.getMsg(), 2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void submitLoss() {
        RequestEntity entity = new RequestEntity();
        entity.setReportLossCode(lossCode);
        entity.setUserId(userId);
        entity.setCustId(custId);
        entity.setIgnoreChecked(isIgnore);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getSubmitLoss(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(LossDetailActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
                    /*JSONObject data = object.getJSONObject("data");
                    String outCode = data.getString("outTreasuryCode");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.CODE, outCode);*/
                    ToastUtils.showToast(LossDetailActivity.this, msg, 2000);
                    LossDetailActivity.this.finish();
                } else if ("501".equals(code)) {
                    AlertDialog.Builder dialog = new AlertDialog.
                            Builder(LossDetailActivity.this);
                    dialog.setTitle("请选择！");//对话框最上面的字
                    dialog.setMessage("当前报损单还有未扫码产品，是否确认报损？");//对话框中部的字
                    dialog.setCancelable(false);//如果是false，点击其他位置或者返回键无效，这个地方默认为true
                    //以下为对话框最下面的选择项
                    dialog.setPositiveButton("确认", new DialogInterface.
                            OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            isIgnore= true;
                    }

                    });
                    //需要第二个按钮才添加如下的setNegativeButton()
                    dialog.setNegativeButton("取消", new DialogInterface.
                            OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            isIgnore = false;
                        }

                    });
                    dialog.show();
                } else {
                    ToastUtils.showToast(LossDetailActivity.this, msg, 2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void scanCode() {
        RequestEntity entity = new RequestEntity();
        entity.setTmReportLossId(lossId);
        entity.setBoxCode(scanMshg);
        entity.setOperactionUserId(userId);
        String data = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getLossScan(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(LossDetailActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.d(TAG, response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
                    pullToRefreshLayout.autoRefresh();
                } else if ("900".equals(code)) {
                    ToastUtils.showToast(LossDetailActivity.this, msg, 2000);
                }
                hideLoadDialog();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                submitLoss();
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
            if (intent.getAction().equals(SCN_CUST_ACTION_SCODE)) {
                try {
                    scanMshg = intent.getStringExtra(SCN_CUST_EX_SCODE).toString();
                    if (!TextUtils.isEmpty(scanMshg)) {
                        scanCode();
                    } else {
                        ToastUtils.showToast(LossDetailActivity.this, "请重新扫码！", 2000);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.e(TAG, e.toString());
                }

            }
        }
    };
}
