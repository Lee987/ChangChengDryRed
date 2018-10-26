package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
import com.changcheng.biz.changpda.entity.GoodsEntity;
import com.changcheng.biz.changpda.entity.IntoryGoodsEntity;
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

public class NumStorageActivity extends BaseActivity implements View.OnClickListener, BaseRefreshListener{
    private PullToRefreshLayout pullToRefreshLayout;
    private TitleBar titleBar;
    private ListView listView;
    private Button btn_next;
    private TextView tv_consignor, tv_consignee;
    private ArrayList<GoodsEntity.DataBean.RowsBean> listDatas = new ArrayList<>();
    private CommonAdapter<GoodsEntity.DataBean.RowsBean> adapter;
    private String from = "";
    private String userId;
    private String custId;
    private String storeId;
    private String custName;
    private String consignee;
    private String titleName;
    private String fact_name;
    private String type;

    @Override
    public void initBundle(Bundle bundle) {
        from = bundle.getString(Constants.FROM);
        if ("OutGoods".equals(from)) {
            storeId = (String) bundle.get(Constants.STORE_ID);
            consignee = bundle.getString(Constants.CONSIGNEE);//收货人
            titleName = "填写出库数量";
        } else if ("SelectLoss".equals(from)) {
            titleName = "填写报损数量";
            type = bundle.getString(Constants.INVENTORY_TYPE);
            consignee = bundle.getString("FACT_NAME");
        } else if ("SelcetFactory".equals(from)) {
            titleName = "填写退货数量";
            consignee = bundle.getString("FACT_NAME");

        }
        listDatas = (ArrayList<GoodsEntity.DataBean.RowsBean>) bundle.getSerializable(Constants.SELECT_GOODS);
        userId = (String) SPUtils.get(NumStorageActivity.this, Constants.USER_ID, "");
        custId = (String) SPUtils.get(NumStorageActivity.this, Constants.CUST_ID, "");
        custName = (String) SPUtils.get(NumStorageActivity.this, Constants.CUST_NAME, "");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_num_storage;
    }

    @Override
    public void findViews(View view) {
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        btn_next = findViewById(R.id.btn_next);
        tv_consignee = findViewById(R.id.tv_consignee);
        tv_consignor = findViewById(R.id.tv_consignor);

        titleBar = findViewById(R.id.title_bar);

        titleBar.setTitle(titleName);

        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pullToRefreshLayout.setRefreshListener(this);
        btn_next.setOnClickListener(this);

        tv_consignee.setText(consignee);
        tv_consignor.setText(custName);

    }

    @Override
    public void initData(Context mContext) {

        adapter = new CommonAdapter<GoodsEntity.DataBean.RowsBean>(NumStorageActivity.this, R.layout.item_write_lv, listDatas) {
            @Override
            public void convert(final ViewHolder helper, final GoodsEntity.DataBean.RowsBean item) {
                helper.setText(R.id.tv_goods_name, item.getProductName())
                        .setText(R.id.tv_code, item.getProductCode());

                if ("1".equals(item.getProductUnit())) {
                    helper.setText(R.id.tv_unit, "瓶");
                } else if ("2".equals(item.getProductUnit())) {
                    helper.setText(R.id.tv_unit, "箱");
                }

                final EditText et_num = helper.getConverView().findViewById(R.id.et_num);
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
//                        if (item.getStockNum() <= 0) {
//                            ToastUtils.showToast(NumStorageActivity.this, "商品对应编码库存不足无法创建订单", 2000);
//                        } else {
                            String strNum = et_num.getText().toString().trim();
                            int num;
                            if (TextUtils.isEmpty(strNum)) {
                                num = 0;
                            } else {
                                num = Integer.parseInt(strNum);
                            }
                            listDatas.get(helper.getPosition()).setNumbers(num);
                        }
//                    }
                });
            }
        };
        View headView = LayoutInflater.from(this).inflate(R.layout.head_num_storage_lyout, null);
        listView.addHeaderView(headView);
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
                pullToRefreshLayout.finishRefresh();
            }
        }, 2000);
    }

    @Override
    public void loadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束加载更多
                pullToRefreshLayout.finishLoadMore();
            }
        }, 2000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if ("OutGoods".equals(from)) {
                    doOut();
                } else if ("SelectLoss".equals(from)) {
                    submitLoss();
                } else if ("SelcetFactory".equals(from)) {
                    returnDoOut();
                }
                break;
        }

    }

    private void doOut() {
        RequestEntity entity = new RequestEntity();
        List<RequestEntity.TmOutTreasuryDetails> lists = new ArrayList<>();
        for (int i = 0; i < listDatas.size(); i++) {
            if (listDatas.get(i).getNumbers() <= 0) {
                ToastUtils.showToast(NumStorageActivity.this, "请输入数量", 2000);
                hideLoadDialog();
                return;
            }
            RequestEntity.TmOutTreasuryDetails list = new RequestEntity.TmOutTreasuryDetails();
            list.setProductId(listDatas.get(i).getId());
            list.setProductNum(listDatas.get(i).getNumbers());
            lists.add(list);
        }
        entity.setTmOutTreasuryDetails(lists);
        entity.setUserId(userId);
        entity.setCustId(custId);
        entity.setTerminalInfoId(storeId);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        OkhttpUtil.okHttpPost(ApiManage.getdoOut(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(NumStorageActivity.this, R.string.error, 2000);
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
                    ToastUtils.showToast(NumStorageActivity.this, msg, 2000);
//                    JSONObject data = object.getJSONObject("data");
//                    String outCode = data.getString("outTreasuryCode");
//                    Bundle bundle = new Bundle();
//                    bundle.putString(Constants.CODE, outCode);
                    NumStorageActivity.this.finish();
                } else {
                    ToastUtils.showToast(NumStorageActivity.this, msg, 2000);
                    NumStorageActivity.this.finish();
                    JSONObject data = object.getJSONObject("data");
                    String outCode = data.getString("outTreasuryCode");
                    String id = data.getString("outId");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.CODE,outCode);
                    bundle.putString(Constants.STORE_ID,id);
                    bundle.putString(Constants.CONSIGNEE,consignee);
                    bundle.putString(Constants.CONSIGNER,custName);
                    startActivity(OutStorageDetailActivity.class,bundle);

                }
            }
        });
    }

    private void returnDoOut() {
        RequestEntity entity = new RequestEntity();
        List<RequestEntity.TmReturnGoodsDetails> lists = new ArrayList<>();
        for (int i = 0; i < listDatas.size(); i++) {
            if (listDatas.get(i).getNumbers() <= 0) {
                ToastUtils.showToast(NumStorageActivity.this, "请输入数量", 2000);
                hideLoadDialog();
                return;
            }
            RequestEntity.TmReturnGoodsDetails list = new RequestEntity.TmReturnGoodsDetails();
            list.setProductId(listDatas.get(i).getId());
            list.setProductNum(listDatas.get(i).getNumbers());
            lists.add(list);
        }
        entity.setTmReturnGoodsDetails(lists);
        entity.setUserId(userId);
        entity.setCustId(custId);
        entity.setReceivingPartyName(consignee);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        OkhttpUtil.okHttpPost(ApiManage.getReturnDoOut(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(NumStorageActivity.this, R.string.error, 2000);
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, response);
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
                    /*JSONObject data = object.getJSONObject("data");
                    String outCode = data.getString("returnGoodsCode");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.CODE, outCode);*/
                    ToastUtils.showToast(NumStorageActivity.this, msg, 2000);
                    NumStorageActivity.this.finish();
                } else {
                    ToastUtils.showToast(NumStorageActivity.this, msg, 2000);
                    NumStorageActivity.this.finish();
                    JSONObject data = object.getJSONObject("data");
                    String returnCode = data.getString("returnGoodsCode");
                    String returnId = data.getString("returnGoodsId");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.STORE_ID,returnId);
                    bundle.putString(Constants.CODE, returnCode);
                    bundle.putString(Constants.CONSIGNEE, consignee);
                    bundle.putString(Constants.CONSIGNER, custName);
                    startActivity(StorageDetailActivity.class, bundle);
                }
            }
        });
    }


    private void submitLoss() {
        RequestEntity entity = new RequestEntity();
        List<RequestEntity.ReportLossDetails> lists = new ArrayList<>();
        for (int i = 0; i < listDatas.size(); i++) {
            if (listDatas.get(i).getNumbers() <= 0) {
                ToastUtils.showToast(NumStorageActivity.this, "请输入数量", 2000);
                hideLoadDialog();
                return;
            }
            RequestEntity.ReportLossDetails list = new RequestEntity.ReportLossDetails();
            list.setCommodityId(listDatas.get(i).getId());
            list.setQuantity(listDatas.get(i).getNumbers());
            lists.add(list);
        }
        entity.setReportLossDetails(lists);
        entity.setUserId(userId);
        entity.setCustId(custId);
        entity.setReportLossType(type);
        entity.setIgnoreChecked(false);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        OkhttpUtil.okHttpPost(ApiManage.getSubmitLoss(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(NumStorageActivity.this, R.string.error, 2000);
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
                    ToastUtils.showToast(NumStorageActivity.this, msg, 2000);
                    NumStorageActivity.this.finish();
                } else {
                    ToastUtils.showToast(NumStorageActivity.this, msg, 2000);
                    NumStorageActivity.this.finish();
                    JSONObject data = object.getJSONObject("data");
                    String lossCode = data.getString("reportLossCode");
                    String lossId = data.getString("reportLossId");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.CODE,lossCode);
                    bundle.putString(Constants.ID,lossId);
                    bundle.putString("REMARK",consignee);
                    bundle.putString(Constants.INVENTORY_TYPE,type);
                    startActivity(LossDetailActivity.class,bundle);

                }
            }
        });
    }
}
