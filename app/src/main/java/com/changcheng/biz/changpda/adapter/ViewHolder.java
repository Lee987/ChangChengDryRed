package com.changcheng.biz.changpda.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Li on 2016/9/22.
 */

public class ViewHolder {
    private SparseArray<View> mView;
    private View mConverView;
    private int position;
    private Context context;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mView = new SparseArray<>();
        this.position = position;
        this.context = context;
        mConverView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConverView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context, View convertView,
                                           ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }else {
            return (ViewHolder) convertView.getTag();
        }
    }

    public <T extends View> T getView(int viewId) {
        View view = mView.get(viewId);
        if (view == null) {
            view = mConverView.findViewById(viewId);
            mView.put(viewId, view);
        }
        return (T) view;
    }

    public View getConverView() {
        return mConverView;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为TextView设置字体颜色
     *
     * @param viewId
     * @param textColor
     * @return
     */
    public ViewHolder setTextColor(int viewId,int textColor){
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * @param viewId
     * @param textColorRes
     * @return
     */
    public ViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(ContextCompat.getColor(context,textColorRes));
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param bm
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 网络加载图片
     *
     * @param viewId
     * @param url
     * @return
     */
//    public ViewHolder setImageByurl(int viewId,String url){
//        ImageView view = getView(viewId);
//        Glide.with(context)
//                .load(url)
//                .into(view);
//
//        return this;
//    }

    /**
     * 背景颜色
     *
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setBackgroundColor(int viewId,int color){
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public ViewHolder setBackgroundRes(int viewId, int res){
        View view = getView(viewId);
        view.setBackgroundResource(res);
        return this;
    }

    /**
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public int getPosition() {
        return position;
    }
}
