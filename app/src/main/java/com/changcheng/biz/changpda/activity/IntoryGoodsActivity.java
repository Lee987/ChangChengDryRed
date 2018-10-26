package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

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

public class IntoryGoodsActivity extends BaseActivity implements View.OnClickListener, BaseRefreshListener, AdapterView.OnItemClickListener {
    private TitleBar titleBar;
    private PullToRefreshLayout pullToRefreshLayout;
    private ListView listView;
    private Button btn_next;
    private EditText et_search;
    private ArrayList<IntoryGoodsEntity.DataBean.ListBean> listDatas = new ArrayList<>();
    private ArrayList<IntoryGoodsEntity.DataBean.ListBean> selectDatas = new ArrayList<>();
    private CommonAdapter<IntoryGoodsEntity.DataBean.ListBean> adapter;

    private String from = "";
    private String custId;
    private int page = 1;
    private int rows = 10;
    private String inventoryName;
    private String userId;
    private String search = "";

    @Override
    public void initBundle(Bundle bundle) {
        custId = (String) SPUtils.get(IntoryGoodsActivity.this, Constants.CUST_ID, "");
        userId = (String) SPUtils.get(IntoryGoodsActivity.this, Constants.USER_ID, "");
        inventoryName = bundle.getString(Constants.INVENTORY_NAME);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_intory_goods;
    }

    @Override
    public void findViews(View view) {
        titleBar = findViewById(R.id.title_bar);
        pullToRefreshLayout = findViewById(R.id.ptr_layout);
        listView = findViewById(R.id.lv);
        btn_next = findViewById(R.id.btn_next);
        et_search = findViewById(R.id.et_search_comment);

        pullToRefreshLayout.setRefreshListener(this);
        listView.setOnItemClickListener(this);
        btn_next.setOnClickListener(this);
        titleBar.setTitle("选择商品");
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
                getData(page+"",rows+"",search);

            }
        });
    }

    @Override
    public void initData(Context mContext) {
        getData(page + "", rows + "",search);
        adapter = new CommonAdapter<IntoryGoodsEntity.DataBean.ListBean>(IntoryGoodsActivity.this, R.layout.item_goods_lv, listDatas) {
            @Override
            public void convert(ViewHolder helper, IntoryGoodsEntity.DataBean.ListBean item) {
                helper.setText(R.id.tv_goods_name, item.getProductName());
                helper.getConverView().findViewById(R.id.tv_storage_num).setVisibility(View.GONE);
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
    public void initReceive(String msg) {
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                selectDatas.clear();
                for (int i = 0; i < listDatas.size(); i++) {
                    if (listDatas.get(i).isCheck()) {
                        selectDatas.add(listDatas.get(i));
                    }
                }
                if (selectDatas.size() > 0) {
                    addProductDetail();
                } else {
                    ToastUtils.showToast(IntoryGoodsActivity.this, "请选择商品", 2000);
                }
                break;
        }
    }

    private void getData(String page, String rows,String search) {
        RequestEntity entity = new RequestEntity();
        //entity.setId(custId);
        entity.setProductCode(search);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        paramsMap.put("page", page);
        paramsMap.put("rows", rows);
        showLoadDialog();
        OkhttpUtil.okHttpPost(ApiManage.getIntoryProductList(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(IntoryGoodsActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                Logger.i(TAG, "----->" + response);
                IntoryGoodsEntity entity = JSONObject.parseObject(response, IntoryGoodsEntity.class);
                if ("200".equals(entity.getCode())) {
                    listDatas.addAll(entity.getData().getList());
                    adapter.notifyDataSetChanged();
                } else if ("900".equals(entity.getCode())) {
                    ToastUtils.showToast(IntoryGoodsActivity.this, entity.getMsg(), 2000);
                }
                hideLoadDialog();
            }
        });
    }

    private void addProductDetail() {
        showLoadDialog();
        RequestEntity entity = new RequestEntity();
        RequestEntity.TmInventoryVo inventoryVo = new RequestEntity.TmInventoryVo();
        inventoryVo.setCustomerId(custId);
        inventoryVo.setInventoryName(inventoryName);
        inventoryVo.setStatus(1);
        inventoryVo.setInventoryType(0);
        List<RequestEntity.TmInventoryDetailVoList> lists = new ArrayList<>();
        for (int i = 0; i < selectDatas.size(); i++) {
            RequestEntity.TmInventoryDetailVoList list = new RequestEntity.TmInventoryDetailVoList();
            list.setProductId(selectDatas.get(i).getId());
            lists.add(list);
        }
        entity.setUserId(userId);
        entity.setTmInventoryVo(inventoryVo);
        entity.setTmInventoryDetailVoList(lists);
        String str = JSONObject.toJSONString(entity);
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("data", str);
        OkhttpUtil.okHttpPost(ApiManage.getAddProductDetail(), paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.showToast(IntoryGoodsActivity.this, R.string.error, 2000);
                hideLoadDialog();
            }

            @Override
            public void onResponse(String response) {
                JSONObject object = JSONObject.parseObject(response);
                String code = object.getString("code");
                String msg = object.getString("msg");
                if ("200".equals(code)) {
                    JSONObject data = object.getJSONObject("data");
                    String id = data.getString("id");
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.INVENTORY_ID, id);
                    bundle.putInt(Constants.INVENTORY_TYPE, 0);
                    startActivity(InventoryDetailActivity.class, bundle);
                    IntoryGoodsActivity.this.finish();
                } else {
                    ToastUtils.showToast(IntoryGoodsActivity.this, msg, 2000);
                }
                hideLoadDialog();
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        CheckBox cb = viewHolder.getConverView().findViewById(R.id.cb_goods);
        if (cb.isChecked()) { //true -> false
            cb.setChecked(false);
            listDatas.get(position).setCheck(false);//改变状态并保存下来
        } else {
            cb.setChecked(true);
            listDatas.get(position).setCheck(true);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束刷新
                listDatas.clear();
                page = 1;
                getData(page + "", rows + "",search);
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
                getData(page + "", rows + "",search);
                pullToRefreshLayout.finishLoadMore();
            }
        }, 500);
    }
}
