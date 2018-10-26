package com.changcheng.biz.changpda.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.BaseActivity;
import com.changcheng.biz.changpda.base.BaseFragment;
import com.changcheng.biz.changpda.utils.ToastUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private ImageView iv_input,iv_outPut,iv_return_goods,iv_inventory,iv_reported_loss,iv_scan;


    @Override
    public void initBundle(Bundle bundle) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void findViews(View view) {
        iv_input = findViewById(R.id.iv_input);
        iv_outPut = findViewById(R.id.iv_out_put);
        iv_return_goods = findViewById(R.id.iv_return_goods);
        iv_inventory = findViewById(R.id.iv_inventory);
        iv_reported_loss = findViewById(R.id.iv_reported_loss);
        iv_scan = findViewById(R.id.iv_scan);

        iv_input.setOnClickListener(this);
        iv_outPut.setOnClickListener(this);
        iv_return_goods.setOnClickListener(this);
        iv_inventory.setOnClickListener(this);
        iv_reported_loss.setOnClickListener(this);
        iv_scan.setOnClickListener(this);

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
            case R.id.iv_input:
                startActivity(InputActivity.class);
                break;
            case R.id.iv_out_put:
                startActivity(OutStorageActivity.class);
                break;
            case R.id.iv_return_goods:
                startActivity(ReturnGoodsActivity.class);
                break;
            case R.id.iv_reported_loss:
                startActivity(ReportedLossActivity.class);
                break;
            case R.id.iv_inventory:
                startActivity(NotInventoryActivity.class);
                break;
            case R.id.iv_scan:
                startActivity(ScanActivity.class);
                break;
        }
    }
    private long exitTime;
    @Override
    public void onBackPressed() {

        if ((System.currentTimeMillis() - exitTime) > 3000) {
            ToastUtils.showToast(this, R.string.click_exit_app,2000);
            exitTime = System.currentTimeMillis();
        } else {
            AppExit();
        }
    }
}
