package com.changcheng.biz.changpda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li on 2016/9/22.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected int layoutId;

    public CommonAdapter(Context mContext, int layoutId ,List<T> mDatas) {
        mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.layoutId = layoutId;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext, convertView, parent, layoutId, position);
        convert(viewHolder, getItem(position));
        return viewHolder.getConverView();
    }

    public abstract void convert(ViewHolder helper, T item);

}
