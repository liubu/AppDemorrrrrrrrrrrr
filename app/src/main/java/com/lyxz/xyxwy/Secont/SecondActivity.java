package com.lyxz.xyxwy.Secont;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.lyxz.xyxwy.appdemo.MainActivity;
import com.lyxz.xyxwy.appdemo.R;

/**
 * Created by john on 2015/11/4.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    private Button bt_two;
    private ImageView iv_two;
    private String str;
    private boolean boo;

    /*
        @Override
        public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
            super.onCreate(savedInstanceState, persistentState);
            setContentView(R.layout.secont_two);
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secont_two);
        init();

    }

    private void init() {
        initView();
        initOnClick();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        str = extras.getString("str");
        boo = extras.getBoolean("boo");


    }

    /**
     *
     */
    private void initOnClick() {
        bt_two.setOnClickListener(this);
        iv_two.setOnClickListener(this);
    }

    /**
     * fang fa
     */
    private void initView() {
        bt_two = (Button) findViewById(R.id.bt_two);
        iv_two = (ImageView) findViewById(R.id.iv_two);
    }

    /**
     * dianji shi jian
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bt_two:
                if (boo) {
                    Toast.makeText(SecondActivity.this, str, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, "获取到的值为假啊", Toast.LENGTH_SHORT).show();
                    finish();
                }


                break;
            case R.id.iv_two:
                Toast.makeText(SecondActivity.this, "好人一生平安", Toast.LENGTH_SHORT).show();


                break;

            default:
                break;

        }
    }
}
