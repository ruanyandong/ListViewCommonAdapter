package com.example.ai.commonadapter.adapter.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.ai.commonadapter.R;

import java.util.List;

/**
 * 抽取公共代码，通用的Adapter,getView()方法没有实现
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;

    protected LayoutInflater mLayoutInflater;
    private int layoutId;

    public CommonAdapter(Context context, List<T> datas,int layoutId){
        this.mContext=context;
        this.mDatas=datas;
        mLayoutInflater=LayoutInflater.from(context);
        this.layoutId=layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent){

        ViewHolder viewHolder=ViewHolder.get(mContext,
                convertView,
                parent, layoutId,
                position);

        convert(viewHolder,(T)getItem(position));

        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T t);

}
