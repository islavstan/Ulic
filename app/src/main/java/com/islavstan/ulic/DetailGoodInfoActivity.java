package com.islavstan.ulic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.islavstan.ulic.adapter.LoopAdapter;
import com.jude.rollviewpager.RollPagerView;

public class DetailGoodInfoActivity extends AppCompatActivity {
    RollPagerView rollPagerView;
    TextView goodsName;
    TextView condition;
    TextView price;
    TextView goodsInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_detail_good_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");


        rollPagerView = (RollPagerView) findViewById(R.id.rollPagerView);
        LoopAdapter adapter = new LoopAdapter(rollPagerView);
        rollPagerView.setAdapter(adapter);
        // rollPagerView.pause();


    }
}
