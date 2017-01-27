package com.islavstan.ulic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.islavstan.ulic.adapter.UlicRecyclerAdapter;
import com.islavstan.ulic.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class ShopMainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
       UlicRecyclerAdapter adapter;
    private List<Goods> goodsList = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new UlicRecyclerAdapter(goodsList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareData();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void prepareData() {
        Goods goods =new Goods("Телевизор",5000,R.drawable.tv,"09.06.17");
        goodsList.add(goods);
        goods =new Goods("Ботинки мужские",450,R.drawable.boots,"12.06.17");
        goodsList.add(goods);
        goods =new Goods("Телефон",50,R.drawable.phone,"13.06.17");
        goodsList.add(goods);
        goods =new Goods("Моющее",290,R.drawable.gel,"18.01.17");
        goodsList.add(goods);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

      /*  if (id == R.id.redact_pers_info) {
            Intent intent = new Intent(MainActivity.this, PersInformActivity.class);
            startActivityForResult(intent, 555);
        } else if (id == R.id.setting) {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        }
        */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
