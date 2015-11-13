package com.lyxz.xyxwy.thread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lyxz.xyxwy.appdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2015/11/4.
 */


public class ThredActivity extends Activity implements View.OnClickListener {

    private Button bt_three;
    private ImageView iv_three;
    private String gou;
    private boolean bb;
    private ListView lv;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_t);

        initVie();
        initClick();
        initData();

    }

    private void initData() {
        Intent intent = getIntent();
        gou = intent.getStringExtra("gou");
        bb = intent.getBooleanExtra("bb", true);





    }

    private void initClick() {
    bt_three.setOnClickListener(this);
    iv_three.setOnClickListener(this);

        list = new ArrayList<String>();
        for(int i=0; i<30; i++) list.add("中国人===" + i);


        MyBaseAdapter adapter = new MyBaseAdapter();
        lv.setAdapter(adapter);


    }

    private void initVie() {
        bt_three = (Button) findViewById(R.id.bt_three);
        iv_three = (ImageView) findViewById(R.id.iv_three);
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_three:
                if(bb){
                    Toast.makeText(ThredActivity.this,gou,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ThredActivity.this,"我是假",Toast.LENGTH_SHORT).show();
                    finish();
                }
            break;
            case R.id.iv_three:
                finish();

            break;

            default:
                break;
        }

    }

    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null){
                viewHolder = new ViewHolder();
                convertView = View.inflate(ThredActivity.this, R.layout.three_item,null);
               viewHolder.item_bt = (TextView) convertView.findViewById(R.id.item_bt);
               viewHolder.item_iv = (ImageView) convertView.findViewById(R.id.item_iv);
               viewHolder.item_ll = (LinearLayout) convertView.findViewById(R.id.item_ll);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.item_bt.setText(list.get(position)+"-------");


            return convertView;
        }
    }


    class ViewHolder{
        TextView item_bt;
        ImageView item_iv;
        LinearLayout item_ll;
    }

}
