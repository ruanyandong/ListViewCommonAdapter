package com.example.ai.commonadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 普通的Adapter
 */
public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private List<Bean> mList;

    public MyAdapter(Context mContext, List<Bean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(mContext).
                    inflate(R.layout.item_listview,parent,false);
            viewHolder=new ViewHolder();

            viewHolder.mTitle=convertView.findViewById(R.id.id_title);
            viewHolder.mDescription=convertView.findViewById(R.id.id_description);
            viewHolder.mTime=convertView.findViewById(R.id.id_time);
            viewHolder.mPhone=convertView.findViewById(R.id.id_phone);

            convertView.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.mTitle.setText(mList.get(position).getTitle());
        viewHolder.mDescription.setText(mList.get(position).getDescription());
        viewHolder.mTime.setText(mList.get(position).getTime());
        viewHolder.mPhone.setText(mList.get(position).getPhone());

        return convertView;
    }


    /**
     * 普通ViewHolder
     */
    private class ViewHolder{
        TextView mTitle;
        TextView mDescription;
        TextView mTime;
        TextView mPhone;

    }
}
