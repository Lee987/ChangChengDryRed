package com.changcheng.biz.changpda.holder;

import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * 版    权 ：博智信息
 * 项目名称 : 水井坊
 * 包    名 : com.biz.crm.changchengdryred.holder
 * 作    者 : FLY
 * 创建时间 : 2018/1/11
 * <p>
 * 描述: viewholder的基类
 */

public class BaseHolder {

    protected View mItemView;
    public BaseHolder(View view) {
        mItemView = view;
    }

    /**
     * 给item设置背景
     * @param color
     */
    public void setBackgroundColor(@ColorRes int color) {
        mItemView.setBackgroundResource(color);
    }

    /**
     * 设置背景，以vie的id
     * @param color
     * @param id
     */
    public void setBackgroundColor(int color,@IdRes int id) {
        View view = mItemView.findViewById(id);
        if (view != null) {
            view.setBackgroundColor(color);
        }
    }

    /**
     * 获取itemview
     * @return
     */
    public View getItemView() {
        return mItemView;
    }

    /**
     * 设置view的可见性
     * @param visibility
     */
    public void setVisibility(boolean visibility){
        if (mItemView != null) {
            if (visibility){
                mItemView.setVisibility(View.VISIBLE);
            } else {
                mItemView.setVisibility(View.GONE);
            }
        }
    }
}
