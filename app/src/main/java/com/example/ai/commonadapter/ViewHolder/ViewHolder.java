package com.example.ai.commonadapter.ViewHolder;

import android.util.SparseArray;
import android.view.View;

/**
 * ViewHolder模式超简洁写法.<br/>
 * <br/>
 * 使用方法：
 *
 * <pre>
 * 在Adapter的getView方法这样写:
 *
 * &#64;Override
 * public View getView(int position, View convertView, ViewGroup parent) {
 *     if (convertView == null) {
 *         convertView = LayoutInflater.from(context).inflate(R.layout.xxx, null);
 *     }
 *
 *     // 通过Id查找
 *     ImageView icon = ViewHolder.get(convertView, R.id.icon);
 *     TextView title = ViewHolder.get(convertView, R.id.title);
 *
 *     // 对View进行赋值
 *     icon.setImageResource(R.drawable.ic_launcher);
 *     title.setText("标题");
 *
 *     return convertView;
 * }
 * </pre>
 *
 */
public class ViewHolder {

    private View convertView;

    public ViewHolder(View convertView) {
        this.convertView = convertView;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T get(int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            convertView.setTag(viewHolder);
        }

        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = convertView.findViewById(id);
            viewHolder.put(id, childView);
        }

        return (T) childView;
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View convertView, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();

        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            convertView.setTag(viewHolder);
        }

        View childView = viewHolder.get(id);

        if (childView == null) {
            childView = convertView.findViewById(id);
            viewHolder.put(id, childView);
        }

        return (T) childView;
    }

}
