package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TitleBar;

public class SelectLossActivity extends BaseActivity implements View.OnClickListener{
    private TitleBar titleBar;
    private Button btn_next;
    private LinearLayout ll_single,ll_all;
    private ImageView iv_single,iv_all;
    private EditText et_name;
    private int select = 0;
    @Override
    public void initBundle(Bundle bundle) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_loss;
    }

    @Override
    public void findViews(View view) {
        titleBar = findViewById(R.id.title_bar);
        btn_next = findViewById(R.id.btn_next);
        ll_single = findViewById(R.id.ll_single);
        ll_all = findViewById(R.id.ll_all);
        iv_single = findViewById(R.id.iv_single);
        iv_all = findViewById(R.id.iv_all);
        et_name = findViewById(R.id.et_inventory_name);

        btn_next.setOnClickListener(this);
        ll_single.setOnClickListener(this);
        ll_all.setOnClickListener(this);

        titleBar.setTitle("选择报损类型");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setLeftImageResource(R.drawable.selector_back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initData(Context mContext) {

    }

    @Override
    public void initReceive(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                String remarks = et_name.getText().toString();
                if (!TextUtils.isEmpty(remarks)){
                    Bundle bundle = new Bundle();
                    bundle.putString("REMARK",remarks);
                    bundle.putString(Constants.INVENTORY_TYPE,select+"");
                    startActivity(LossGoodsActivity.class,bundle);
                    this.finish();
                }else {
                    ToastUtils.showToast(this,"请填写内容！",2000);
                }

                break;

            case R.id.ll_single:
                iv_single.setImageResource(R.mipmap.selected);
                iv_all.setImageResource(R.mipmap.unselect);
                select = 0;
                break;

            case R.id.ll_all:
                iv_single.setImageResource(R.mipmap.unselect);
                iv_all.setImageResource(R.mipmap.selected);
                select = 1;
                break;
        }
    }
}
