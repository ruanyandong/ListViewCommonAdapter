package com.example.ai.commonadapter.adapter.util;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ai.commonadapter.Bean;
import com.example.ai.commonadapter.R;

import java.util.List;

/**
 * 万能Adapter
 */

public class MyViewHolderAdapter extends CommonAdapter<Bean> {


    public MyViewHolderAdapter(Context mContext, List<Bean> mList,int layoutId) {
        super(mContext,mList,layoutId);
    }


    @Override
    public void convert(ViewHolder holder, Bean bean) {

        //((TextView)holder.getView(R.id.id_title)).setText(bean.getTitle());
        //((TextView)holder.getView(R.id.id_description)).setText(bean.getDescription());
        //((TextView)holder.getView(R.id.id_time)).setText(bean.getTime());
        //((TextView)holder.getView(R.id.id_phone)).setText(bean.getPhone());

        /**
         * 链式调用
         */
        holder.setText(R.id.id_title,bean.getTitle()).
                setText(R.id.id_description,bean.getDescription()).
                setText(R.id.id_time,bean.getTime()).
                setText(R.id.id_phone,bean.getPhone());

        CheckBox checkBox=holder.getView(R.id.id_check_box);
        checkBox.setChecked(bean.isChecked());
        checkBox.setOnClickListener(v->{
            /**
             * 设置一个是否点击过的布尔值，防止点击错乱
             */
            bean.setChecked(checkBox.isChecked());
        });
    }
}
