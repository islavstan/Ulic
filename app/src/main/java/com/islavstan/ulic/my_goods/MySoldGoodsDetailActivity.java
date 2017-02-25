package com.islavstan.ulic.my_goods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.islavstan.ulic.R;
import com.islavstan.ulic.adapter.LoopAdapter;
import com.jude.rollviewpager.RollPagerView;

public class MySoldGoodsDetailActivity extends AppCompatActivity {
    RollPagerView rollPagerView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_sold_goods_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");


        rollPagerView = (RollPagerView) findViewById(R.id.rollPagerView);
        LoopAdapter adapter = new LoopAdapter(rollPagerView);
        rollPagerView.setAdapter(adapter);
        // rollPagerView.pause();

    }
}
