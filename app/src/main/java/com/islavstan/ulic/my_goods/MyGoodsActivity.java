package com.islavstan.ulic.my_goods;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.islavstan.ulic.R;
import com.islavstan.ulic.my_goods.adapter.MyGoodsViewPagerAdapter;

public class MyGoodsActivity extends AppCompatActivity {
    ViewPager view_pager;
    MyGoodsViewPagerAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_my_goods);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Мои товары");
        TabLayout tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("Активные объявления"));
        tab_layout.addTab(tab_layout.newTab().setText("Проданные"));
        view_pager = (ViewPager) findViewById(R.id.pager);
        view_pager.setOffscreenPageLimit(2);
        adapter = new MyGoodsViewPagerAdapter
                (getSupportFragmentManager(), tab_layout.getTabCount());
        view_pager.setAdapter(adapter);



        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));

        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }
}
