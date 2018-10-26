package com.changcheng.biz.changpda.view;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.TextView;

import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.entity.ChooseDateEntity;
import com.changcheng.biz.changpda.holder.TimePickerHolder;


/**
 * 版    权 ：成都博智信息
 * 项目名称 : heroicalliance
 * 包    名 : com.biz.crm.changchengdryred.widget
 * 作    者 : FLY
 * 创建时间 : 2018/1/25
 * <p>
 * 描述:
 */


public class TimePickViewDialog {
    public static void createDialog(Context context, TextView textView){
        BottomSheetDialog dialog=new BottomSheetDialog(context);
        View view=View.inflate(context, R.layout.dialog_time_picker_layout,null);
        TimePickerHolder.createViewHolder(view,dialog,textView);
        dialog.setContentView(view);
        dialog.show();
    }
}
