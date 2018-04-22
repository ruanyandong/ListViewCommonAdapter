package com.example.ai.commonadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.ai.commonadapter.adapter.util.MyViewHolderAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Bean> mDatas;
    //private MyAdapter mAdapter;
    private MyViewHolderAdapter mMyViewHolderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDatas();
    }

    private void initView() {
        mListView=findViewById(R.id.list_view);


    }
    private void initDatas() {
        mDatas=new ArrayList<>();
        Random random=new Random();
        int length=random.nextInt(20);
        for (int i=0;i<length;i++){
            Bean bean=new Bean("Android新技能Get"+i,
                    "Android打造万能的ListView和GridView适配器",
                    "2014-12-12","10086");
            mDatas.add(bean);
        }

        //普通Adapter
        //mAdapter=new MyAdapter(this,mDatas);
        // mListView.setAdapter(mAdapter);

        //万能Adapter,也可以用匿名内部类的形式
        mMyViewHolderAdapter=new MyViewHolderAdapter(this,mDatas,R.layout.item_listview);
        mListView.setAdapter(mMyViewHolderAdapter);

        /**
         * ===========匿名内部类的形式实现============
        mListView.setAdapter(new CommonAdapter<Bean>(this,mDatas) {
            @Override
            public void convert(ViewHolder holder, Bean bean) {

                //链式调用
                holder.setText(R.id.id_title,bean.getTitle()).
                        setText(R.id.id_description,bean.getDescription()).
                        setText(R.id.id_time,bean.getTime()).
                        setText(R.id.id_phone,bean.getPhone());

        CheckBox checkBox=holder.getView(R.id.id_check_box);
        checkBox.setChecked(bean.isChecked());
        checkBox.setOnClickListener(v->{
        //设置一个是否点击过的布尔值，防止点击错乱
        bean.setChecked(checkBox.isChecked());
    });
        }
        });*/


    }


}
