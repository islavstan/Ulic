package com.islavstan.ulic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.islavstan.ulic.adapter.LoopAdapter;
import com.jude.rollviewpager.RollPagerView;

public class DetailGoodInfoActivity extends AppCompatActivity {
    RollPagerView rollPagerView;
    TextView goodsName;
    TextView condition;
    TextView price;
    TextView goodsInfo;
    TextView buyBtn;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_detail_good_info);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");


        rollPagerView = (RollPagerView) findViewById(R.id.rollPagerView);
        LoopAdapter adapter = new LoopAdapter(rollPagerView);
        rollPagerView.setAdapter(adapter);
        // rollPagerView.pause();

          buyBtn = (TextView) findViewById(R.id.buyBtn);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailGoodInfoActivity.this,BuyGoodsActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shop_detail_goods, menu);
        return true;
    }



}
