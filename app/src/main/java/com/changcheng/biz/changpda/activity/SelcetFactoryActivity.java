package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.constant.Constants;
import com.changcheng.biz.changpda.utils.ToastUtils;
import com.changcheng.biz.changpda.view.TitleBar;

public class SelcetFactoryActivity extends BaseActivity implements View.OnClickListener{
    private TitleBar titleBar;
    private Button btn_next;
    private EditText et_input_factory;

    @Override
    public void initBundle(Bundle bundle) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_factory;
    }

    @Override
    public void findViews(View view) {
        titleBar = findViewById(R.id.title_bar);
        btn_next = findViewById(R.id.btn_next);
        et_input_factory = findViewById(R.id.et_input_factory);

        btn_next.setOnClickListener(this);

        titleBar.setTitle("选择收货仓库或工厂");
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
                String factoryName = et_input_factory.getText().toString();
                if (!TextUtils.isEmpty(factoryName)){
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.FROM,"SelcetFactory");
                    bundle.putString("FACT_NAME",factoryName);
                    startActivity(SelectGoodsActivity.class,bundle);
                    this.finish();
                }else {
                    ToastUtils.showToast(this,"请填写内容！",2000);
                }

                break;
        }
    }
}
