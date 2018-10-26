package com.changcheng.biz.changpda.holder;

import android.app.Dialog;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.BaseApplication;
import com.changcheng.biz.changpda.entity.ChooseDateEntity;
import com.changcheng.biz.changpda.utils.TimeUtil;
import com.jzxiang.pickerview.TimeWheel;
import com.jzxiang.pickerview.config.PickerConfig;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.data.WheelCalendar;
import com.jzxiang.pickerview.wheel.OnWheelChangedListener;
import com.jzxiang.pickerview.wheel.WheelView;

import java.util.Calendar;



/**
 * 版    权 ：成都博智信息
 * 项目名称 : heroicalliance
 * 包    名 : com.biz.crm.changchengdryred.holder
 * 作    者 : FLY
 * 创建时间 : 2018/1/24
 * <p>
 * 描述:
 */


public class TimePickerHolder extends BaseHolder {
    private PickerConfig mPickerConfig;
    private TimeWheel timeWheel;
    private WheelView year;
    private WheelView month;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private TextView mTvSwitch;
    private EditText mEdStart;
    private TextView mTvTo;
    private EditText mEdEnd;
    private LinearLayout mLl1;
    private LinearLayout mLlStart;
    private View mStartView;
    private LinearLayout mLlEnd;
    private View mEndView;
    private ChooseDateEntity chooseDateEntity;



    private LinearLayout mLinearWheel;


    private boolean isSingle = false;


    private EditText nowSelectorEd;
    private View nowSelectorView;

    public TimePickerHolder(View view, final Dialog dialog, final TextView textView) {
        super(view);
        initPickConfig();
        initView(view);
        initWheel(view);
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        mTvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseDateEntity=new ChooseDateEntity();
                Calendar calendar=Calendar.getInstance();
                chooseDateEntity.isSingle=isSingle;
                if (isSingle){
                    String text=mEdStart.getText().toString();
                    chooseDateEntity.start= TimeUtil.parse(text,TimeUtil.FORMAT_YYYYMM);
                    calendar.setTimeInMillis(chooseDateEntity.start);
                    calendar.add(Calendar.MONTH, 1);
                    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
                    chooseDateEntity.end=calendar.getTime().getTime()-1;
                    if (!TextUtils.isEmpty(mEdStart.getText().toString())){
                        textView.setText("请选择时间");
                    }
                    textView.setText(TimeUtil.format(chooseDateEntity.start, TimeUtil.FORMAT_YYYYMM));
                }else {
                    String text1=mEdStart.getText().toString();
                    String text2=mEdEnd.getText().toString();
                    chooseDateEntity.start=TimeUtil.parse(text1,TimeUtil.FORMAT_YYYYMM);
                    calendar.setTimeInMillis(TimeUtil.parse(text2,TimeUtil.FORMAT_YYYYMM));
                    calendar.add(Calendar.MONTH, 1);
                    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
                    chooseDateEntity.end=calendar.getTime().getTime()-1;
                    if (!TextUtils.isEmpty(mEdStart.getText().toString())&&!TextUtils.isEmpty(mEdEnd.getText().toString())){
                        textView.setText("请选择时间");
                    }
                    textView.setText(TimeUtil.format(TimeUtil.parse(text1,TimeUtil.FORMAT_YYYYMM), TimeUtil.FORMAT_YYYYMM) + "至" +
                            TimeUtil.format(TimeUtil.parse(text2,TimeUtil.FORMAT_YYYYMM), TimeUtil.FORMAT_YYYYMM));
                }


                dialog.dismiss();
            }
        });
    }

    private void initWheel(View view) {
        mLinearWheel = (LinearLayout) view.findViewById(R.id.linear_wheel);
        timeWheel=new TimeWheel(view,mPickerConfig);
        year=view.findViewById(R.id.year);
        month=view.findViewById(R.id.month);
        year.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                setTime();
            }
        });
        month.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                setTime();
            }
        });
    }

    private void initView(View view) {
        mLl1 = (LinearLayout) view.findViewById(R.id.ll1);
        mTvCancel = (TextView)view. findViewById(R.id.tv_cancel);
        mTvConfirm = (TextView) view.findViewById(R.id.tv_confirm);
        mTvSwitch = (TextView) view.findViewById(R.id.tv_switch);
        mEdStart = (EditText)view. findViewById(R.id.ed_start);
        mTvTo = (TextView) view.findViewById(R.id.tv_to);
        mEdEnd = (EditText) view.findViewById(R.id.ed_end);
        mLlStart = (LinearLayout) view.findViewById(R.id.llStart);
        mStartView = (View) view.findViewById(R.id.startView);
        mLlEnd = (LinearLayout) view.findViewById(R.id.llEnd);
        mEndView = (View) view.findViewById(R.id.endView);

        mEdStart.setInputType(InputType.TYPE_NULL);
        mEdEnd.setInputType(InputType.TYPE_NULL);

        mEdEnd.setTag("END");
        mEdStart.setTag("START");

        mTvSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSingle){
                    mTvSwitch.setText(R.string.text_more_than_month);
                    mLlEnd.setVisibility(View.VISIBLE);
                    mTvTo.setVisibility(View.VISIBLE);
                }else {
                    mTvSwitch.setText(R.string.text_signle_month);
                    mLlEnd.setVisibility(View.GONE);
                    mTvTo.setVisibility(View.GONE);
                }
                isSingle=!isSingle;
                changeSelectorEdStatus(mEdStart,mStartView);
            }
        });

        mEdEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSelectorEdStatus(mEdEnd,mEndView);
            }
        });

        mEdStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSelectorEdStatus(mEdStart,mStartView);
            }
        });

        nowSelectorEd=mEdStart;
        nowSelectorView=mStartView;
        mLlStart.performClick();

    }

    private void initPickConfig() {
        mPickerConfig=new PickerConfig();
        mPickerConfig.mType = Type.YEAR_MONTH;
        Calendar minCalendar=Calendar.getInstance();
        minCalendar.set(2000,0,1);
        mPickerConfig.mMinCalendar= new WheelCalendar(minCalendar.getTimeInMillis());
        Calendar maxCalendar=Calendar.getInstance();
        maxCalendar.set(2101,0,0);
        mPickerConfig.mMaxCalendar= new WheelCalendar(maxCalendar.getTimeInMillis());
        mPickerConfig.mThemeColor= BaseApplication.getIntance().getResources().getColor(R.color.color_333333);
    }

    private void setTime(){
        nowSelectorEd.setText(timeWheel.getCurrentYear()+"-"+timeWheel.getCurrentMonth());

    }

    public static void createViewHolder(View view, Dialog dialog,TextView textView) {
        new TimePickerHolder(view,dialog,textView);
    }

    private void changeSelectorEdStatus(EditText editText,View view){
        nowSelectorView.setBackgroundColor(getColor(R.color.color_edit_hint_9));
        nowSelectorEd.setHintTextColor(getColor(R.color.color_edit_hint_9));
        nowSelectorEd.setTextColor(getColor(R.color.color_edit_hint_9));

        nowSelectorEd=editText;
        nowSelectorView=view;

        nowSelectorView.setBackgroundColor(getColor(R.color.blue_light));
        nowSelectorEd.setHintTextColor(getColor(R.color.blue_light));
        nowSelectorEd.setTextColor(getColor(R.color.blue_light));
    }

    private int getColor(int color ){
        return BaseApplication.getIntance().getResources().getColor(color);
    }

}
