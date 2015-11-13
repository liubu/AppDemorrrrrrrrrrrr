package com.lyxz.xyxwy.appdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lyxz.xyxwy.Secont.SecondActivity;
import com.lyxz.xyxwy.thread.ThredActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String Tag = "hao";
    private Button bt_one;
    private ImageView iv_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_one = (Button) findViewById(R.id.bt_one);
        iv_one = (ImageView) findViewById(R.id.iv_one);

        bt_one.setOnClickListener(this);
        iv_one.setOnClickListener(this);
        Log.d(Tag,"bt_one-------");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_one:

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("str","renren");
                bundle.putBoolean("boo", false);

                intent.putExtras(bundle);
                startActivity(intent);

                break;

            case R.id.iv_one:

                Intent inte = new Intent(MainActivity.this, ThredActivity.class);
                inte.putExtra("gou", "zhongguo");
                inte.putExtra("bb",true);
                startActivity(inte);



                break;

            default:
                break;
        }
    }
}
