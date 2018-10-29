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
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.adapter.CommonAdapter;
import com.changcheng.biz.changpda.adapter.ViewHolder;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.ApiManage;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.entity.InvtDetailEntity;
import com.changcheng.biz.changpda.entity.RequestEntity;
import com.changcheng.biz.changpda.entity.SubmitSigleEntity;
import com.changcheng.biz.changpda.evevtbus.RefreshEvent;
import com.changcheng.biz.changpda.okhttputils.CallBackUtil;
import com.changcheng.biz.changpda.okhttputils.OkhttpUtil;
import com.changcheng.biz.changpda.utils.Logger;
import com.changcheng.biz.changpda.utils.SPUtils;
import com.changcheng.biz.changpda.utils.TimeUtil;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TitleBar;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_SCODE;
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_EX_SCODE;//SCN_CUST_ACTION_START
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_START;//SCN_CUST_ACTION_CANCEL
import static com.changcheng.biz.changpda.broadcast.SystemBroadCast.SCN_CUST_ACTION_CANCEL;

public class InventoryDetailActivity extends BaseActivity implements BaseRefreshListener, View.OnClickListener {
    private PullToRefreshLayout pullToRefreshLayout;
    private ListView lv_top, lv_bottom;
    private TitleBar titleBar;
    private TextView tv_cod, tv_typ, tv_time;
    private Button btn_submit,btn_scan;

    InvtDetailEntity invtDetailEntity;
    private List<InvtDetailEntity.DataBean.InventoryDetailBean> scanTop = new ArrayList<>();
    private List<InvtDetailEntity.DataBean.InventoryDetailBean> scanBottom = new ArrayList<>();
    private CommonAdapter<InvtDetailEntity.DataBean.InventoryDetailBean> adapterTop;
    private CommonAdapter<InvtDetailEntity.DataBean.InventoryDetailBean> adapterBottom;
    private int page = 1;
    private int rows = 10;
    private String iventId;
    private String userId;
    private int iventType;
    private String fullName;
    private String custCode;
    private  String scanMshg = "";


    @Override
    public void initBundle(Bundle bundle) {
        iventId = bundle.getString(Constants.INVENTORY_ID);
        iventType = bundle.getInt(Constants.INVENTORY_TYPE);
        userId = (String) SPUtils.get(InventoryDetailActivity.this, Constants.USER_ID, "");
        fullName = (String) SPUtils.get(InventoryDetailActivity.this, Constants.FULL_NAME, "");
        custCode = (String) SPUtils.get(InventoryDetailActivity.this, Constants.CUST_CODE, "");
        //ToastUtils.showToast(InventoryDetailActivity.this,iventId,2000);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_inventory_detail;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        lv_top = findViewById(R.id.lv_top);
        lv_bottom = findViewById(R.id.lv_bottom);
        titleBar = findViewById(R.id.title_bar);
        tv_cod = findViewById(R.id.tv_code);
        tv_typ = findViewById(R.id.tv_type);
        tv_time = findViewById(R.id.tv_crt_time);
        btn_submit = findViewById(R.id.btn_submit);
        btn_scan = findViewById(R.id.btn_scan);

        titleBar.setTitle("盘点单明细");
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
        btn_scan.setOnClickListener(this);
        pullToRefreshLayout.setCanRefresh(false);
        pullToRefreshLayout.setCanLoadMore(false);


        View viewTop = LayoutInflater.from(InventoryDetailActivity.this).inflate(R.layout.head_scan_layout, null);
        viewTop.findViewById(R.id.tv_type).setVisibility(View.GONE);
        TextView tv_num =  viewTop.findViewById(R.id.tv_num);
        tv_num.setText("盘点数量");
        View viewBottom = LayoutInflater.from(InventoryDetailActivity.this).inflate(R.layout.head_scannull_layout, null);
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

        getData(page + "", rows + "");

        adapterTop = new CommonAdapter<InvtDetailEntity.DataBean.InventoryDetailBean>(this, R.layout.item_scan_layout, scanTop) {
            @Override
            public void convert(ViewHolder helper, InvtDetailEntity.DataBean.InventoryDetailBean item) {
                helper.setText(R.id.tv_goods_name, item.getProductName())
                        .setText(R.id.tv_code, item.getProductCode())
                        .setText(R.id.tv_num, item.getInventoryBeforeStock() + "")
                        .setText(R.id.tv_scan_num,item.getInventoryAfterStock()+"");
                helper.getConverView().findViewById(R.id.tv_num).setVisibility(View.GONE);
                if ("1".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"瓶" );
                }else if ("2".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"箱" );
                }

            }

        };

        lv_top.setAdapter(adapterTop);

        adapterBottom = new CommonAdapter<InvtDetailEntity.DataBean.InventoryDetailBean>(this, R.layout.item_scannull_layout, scanBottom) {
            @Override
            public void convert(final ViewHolder helper, InvtDetailEntity.DataBean.InventoryDetailBean item) {
                helper.setText(R.id.tv_goods_name, item.getProductName())
                        .setText(R.id.tv_code, item.getProductCode());


                if ("1".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"瓶" );
                }else if ("2".equals(item.getProductUnit())){
                    helper.setText(R.id.tv_unit,"箱" );
                }
                final EditText et_num = helper.getConverView().findViewById(R.id.et_num);


                scanBottom.get(helper.getPosition()).setNumbers(-1);

                et_num.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        int inType = et_num.getInputType(); // backup the input type
                        et_num.setInputType(InputType.TYPE_NULL); // disable soft input
                        et_num.onTouchEvent(event); // call native handler
                        et_num.setInputType(inType); // restore input type
                        et_num.setSelection(et_num.getText().length());

                        return true;
                    }
                });
                    et_num.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            try {
                                String strNum = s.toString();
                                int num = 0;
                                if (TextUtils.isEmpty(strNum)) {
                                    num = 0;
                                } else {
                                    num = Integer.parseInt(strNum);
                                }
                                scanBottom.get(helper.getPosition()).setNumbers(num);
                            }catch (Exception e){
                                //ToastUtils.showToast(InventoryDetailActivity.this,"先进行扫码操作！",2000);
                                scanBottom.get(helper.getPosition()).setNumbers(-1);
                            }
                        }
                    });
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
            ToastUtils.showToast(InventoryDetailActivity.this,"请重新扫码！",2000);
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
        entity.setId(iventId);
        String data = JSON.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        paramsMap.put("page", page);
        paramsMap.put("rows", rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getTmInventoryDetail(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(InventoryDetailActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                //ToastUtils.showToast(InventoryDetailActivity.this,response,2000);
                invtDetailEntity = JSONObject.parseObject(response, InvtDetailEntity.class);
                if ("200".equals(invtDetailEntity.getCode())) {
                    List<InvtDetailEntity.DataBean.InventoryDetailBean> inventoryDetail = invtDetailEntity.getData().getInventoryDetail();
                    tv_cod.setText(invtDetailEntity.getData().getInventory().getInventoryNumber());
                    int type = invtDetailEntity.getData().getInventory().getInventoryType();
                    if (type == 0) {
                        tv_typ.setText("单盘");
                        tv_typ.setTextColor(context.getResources().getColor(R.color.color_6DCC00));
                    } else if (type == 1) {
                        tv_typ.setText("全盘");
                        tv_typ.setTextColor(context.getResources().getColor(R.color.color_005FCC));
                    }
                    tv_time.setText(TimeUtil.format(invtDetailEntity.getData().getInventory().getCreateDate(), TimeUtil.FORMAT_1));

                    for (int i = 0; i < inventoryDetail.size(); i++) {
                        if ("1".equals(inventoryDetail.get(i).getIsScan())) {//需要扫码
                            scanTop.add(inventoryDetail.get(i));
                        } else if ("0".equals(inventoryDetail.get(i).getIsScan())) {//不需要
                            scanBottom.add(inventoryDetail.get(i));
                        }
                    }
                    adapterTop.notifyDataSetChanged();
                    adapterBottom.notifyDataSetChanged();

                } else if ("900".equals(invtDetailEntity.getCode())) {
                    ToastUtils.showToast(InventoryDetailActivity.this, invtDetailEntity.getMsg(), 2000);
                }
                hideLoadDialog();

            }
        });
    }

    private void subMitSigle() {
        RequestEntity entity = new RequestEntity();
        RequestEntity.TmInventoryVo inventoryVo = new RequestEntity.TmInventoryVo();
        inventoryVo.setId(invtDetailEntity.getData().getInventory().getId());
        inventoryVo.setCustomerId(invtDetailEntity.getData().getInventory().getCustomerId());
        inventoryVo.setInventoryName(invtDetailEntity.getData().getInventory().getInventoryName());
        inventoryVo.setInventoryNumber(invtDetailEntity.getData().getInventory().getInventoryNumber());
        inventoryVo.setStatus(2);
        inventoryVo.setInventoryType(0);

        List<RequestEntity.TmInventoryDetailVoList> lists = new ArrayList<>();
        for (int i = 0; i < scanBottom.size(); i++) {
            if (scanBottom.get(i).getNumbers() < 0) {
                ToastUtils.showToast(InventoryDetailActivity.this, "请输入数量", 2000);
                return;
            }
            RequestEntity.TmInventoryDetailVoList list = new RequestEntity.TmInventoryDetailVoList();
            list.setId(scanBottom.get(i).getId());
            list.setInventoryNumber(scanBottom.get(i).getInventoryNumber());
            list.setProductId(scanBottom.get(i).getProductId());
            list.setProductCode(scanBottom.get(i).getProductCode());
            list.setProductName(scanBottom.get(i).getProductName());
            list.setProductUnit(scanBottom.get(i).getProductUnit());
            list.setNumbers(scanBottom.get(i).getNumbers());
            list.setIsScan(scanBottom.get(i).getIsScan());
            lists.add(list);
        }
        /*for (int j = 0; j < scanTop.size(); j++) {
            if (scanTop.get(j).getNumbers() <= 0) {
                ToastUtils.showToast(InventoryDetailActivity.this, "请输入数量", 2000);
                return;
            }
            RequestEntity.TmInventoryDetailVoList list = new RequestEntity.TmInventoryDetailVoList();
            list.setId(scanTop.get(j).getId());
            list.setInventoryNumber(scanTop.get(j).getInventoryNumber());
            list.setProductId(scanTop.get(j).getProductId());
            list.setProductCode(scanTop.get(j).getProductCode());
            list.setProductName(scanTop.get(j).getProductName());
            list.setProductUnit(scanTop.get(j).getProductUnit());
            list.setNumbers(scanTop.get(j).getNumbers());
            list.setIsScan(scanTop.get(j).getIsScan());
            lists.add(list);
        }*/

        entity.setUserId(userId);
        entity.setTmInventoryVo(inventoryVo);
        entity.setTmInventoryDetailVoList(lists);
        String str = JSONObject.toJSONString(entity);

        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getSubmitSingle(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(InventoryDetailActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                //ToastUtils.showToast(InventoryDetailActivity.this,response,2000);
                SubmitSigleEntity entity = JSONObject.parseObject(response, SubmitSigleEntity.class);
                if ("200".equals(entity.getCode())) {
                    ToastUtils.showToast(InventoryDetailActivity.this, entity.getMsg(), 2000);
                    EventBus.getDefault().post(new RefreshEvent(Constants.IS_REFRESH));
                    InventoryDetailActivity.this.finish();

                } else if ("900".equals(entity.getCode())) {
                    ToastUtils.showToast(InventoryDetailActivity.this, entity.getMsg(), 2000);
                }
                hideLoadDialog();
            }
        });

    }

    private void subMitAll() {

        RequestEntity entity = new RequestEntity();
        RequestEntity.TmInventoryVo inventoryVo = new RequestEntity.TmInventoryVo();
        inventoryVo.setId(invtDetailEntity.getData().getInventory().getId());
        inventoryVo.setCustomerId(invtDetailEntity.getData().getInventory().getCustomerId());
        inventoryVo.setInventoryName(invtDetailEntity.getData().getInventory().getInventoryName());
        inventoryVo.setInventoryNumber(invtDetailEntity.getData().getInventory().getInventoryNumber());
        inventoryVo.setStatus(2);
        inventoryVo.setInventoryType(1);

        List<RequestEntity.TmInventoryDetailVoList> lists = new ArrayList<>();
        for (int i = 0; i < scanBottom.size(); i++) {
            if (scanBottom.get(i).getNumbers() < 0) {
                ToastUtils.showToast(InventoryDetailActivity.this, "请输入数量", 2000);
                hideLoadDialog();
                return;
            }
            RequestEntity.TmInventoryDetailVoList list = new RequestEntity.TmInventoryDetailVoList();
            list.setId(scanBottom.get(i).getId());
            list.setProductId(scanBottom.get(i).getProductId());
            list.setNumbers(scanBottom.get(i).getNumbers());
            lists.add(list);
        }
        entity.setUserId(userId);
        entity.setTmInventoryVo(inventoryVo);
        entity.setTmInventoryDetailVoList(lists);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getSubmitAll(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(InventoryDetailActivity.this, R.string.error, 2000);
                hideLoadDialog();

            }

            @Override
            public void onResponse(String response) {
                SubmitSigleEntity entity = JSONObject.parseObject(response, SubmitSigleEntity.class);
                if ("200".equals(entity.getCode())) {
                    ToastUtils.showToast(InventoryDetailActivity.this, entity.getMsg(), 2000);
                    EventBus.getDefault().post(new RefreshEvent(Constants.IS_REFRESH));
                    InventoryDetailActivity.this.finish();

                } else if ("900".equals(entity.getCode())) {
                    ToastUtils.showToast(InventoryDetailActivity.this, entity.getMsg(), 2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void scanCode(){
        RequestEntity entity = new RequestEntity();
        entity.setInventoryNumber(invtDetailEntity.getData().getInventory().getInventoryNumber());
        entity.setBoxCode(scanMshg);
        entity.setCreateName(invtDetailEntity.getData().getInventory().getCreateName());
        entity.setCustomerCode(invtDetailEntity.getData().getInventory().getCustomerCode());
        String data = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", data);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getInventoryScan(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(InventoryDetailActivity.this,R.string.error,2000);
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
                    ToastUtils.showToast(InventoryDetailActivity.this,msg,2000);
                }
                hideLoadDialog();

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                if (iventType == 0) {
                    subMitSigle();
                } else if (iventType == 1) {
                    subMitAll();
                }
                break;

            case R.id.btn_scan:
                //scanCode();
                break;
        }
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
                        ToastUtils.showToast(InventoryDetailActivity.this,"请重新扫码！",2000);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Log.e("in",e.toString());
                }

            }
        }
    };
}
