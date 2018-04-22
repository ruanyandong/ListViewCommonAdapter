package com.example.ai.commonadapter.adapter.util;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 万能的ViewHolder
 */

public class ViewHolder {

    private SparseArray<View> mViews;

    private int mPosition;
    private View mConvertView;


    public ViewHolder(Context context,
                      ViewGroup parent,
                      int layoutId,
                      int position){
        this.mPosition=position;
        this.mViews=new SparseArray<>();

        mConvertView= LayoutInflater.from(context).
                inflate(layoutId,parent,false);

        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context,
                                 View convertView,
                                 ViewGroup parent,
                                 int layoutId,
                                 int position){
        if(convertView==null){
            return new ViewHolder(context,parent,layoutId,position);
        }else{
            ViewHolder holder=(ViewHolder)convertView.getTag();
            holder.mPosition=position;
            return holder;
        }

    }

    public View getConvertView(){
        return mConvertView;
    }

    /**
     * 通过viewId获取控件
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId){
        View view=mViews.get(viewId);

        if (view==null){
            view=mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T)view;
    }

    /**
     * 设置TextView的值，链式调用
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId,String text){
        TextView tv=getView(viewId);
        tv.setText(text);
        return this;
    }


}
