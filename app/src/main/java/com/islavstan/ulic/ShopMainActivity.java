package com.islavstan.ulic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import com.islavstan.ulic.adapter.UlicRecyclerAdapter;
import com.islavstan.ulic.model.Goods;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;
//   https://github.com/Suleiman19/Android-Material-Design-for-pre-Lollipop
public class ShopMainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    UlicRecyclerAdapter adapter;
    private List<Goods> goodsList = new ArrayList<>();
    private RecyclerView recyclerView;
    ImageButton viewType1Btn, viewType2Btn, viewType4Btn;
    Animation animationUp;
    Animation animationDown;
    NestedScrollView llBottomSheet;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // получение вью нижнего экрана
        llBottomSheet = (NestedScrollView) findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        // bottomSheetBehavior.setHideable(true);


        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ShopMainActivity.this, CreateAdActivity.class);
                startActivity(intent);
            }
        });



        animationUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);


        animationDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        viewType1Btn = (ImageButton) findViewById(R.id.view1Btn);
        viewType2Btn = (ImageButton) findViewById(R.id.view2Btn);
        viewType4Btn = (ImageButton) findViewById(R.id.view4Btn);


        animationDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bottomSheetBehavior.setPeekHeight(0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        viewType1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewType1Btn.setImageResource(R.drawable.view_one_select);
                viewType2Btn.setImageResource(R.drawable.ic_view_two);
                viewType4Btn.setImageResource(R.drawable.view_four);

                adapter.setView(1);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ShopMainActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

            }
        });
        viewType2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewType1Btn.setImageResource(R.drawable.view_one);
                viewType2Btn.setImageResource(R.drawable.ic_view_two_select);
                viewType4Btn.setImageResource(R.drawable.view_four);
                adapter.setView(2);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(ShopMainActivity.this, 2);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

            }
        });


        viewType4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewType1Btn.setImageResource(R.drawable.view_one);
                viewType2Btn.setImageResource(R.drawable.ic_view_two);
                viewType4Btn.setImageResource(R.drawable.view_four_select);
                adapter.setView(4);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(ShopMainActivity.this, 4);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

            }
        });


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


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    llBottomSheet.startAnimation(animationDown);

                }

                //fabAddNew.hide();

                else if (dy < 0) {
                    llBottomSheet.startAnimation(animationUp);
                    bottomSheetBehavior.setPeekHeight(170);
                  /*  if(bottomSheetBehavior.getPeekHeight()==0){
                       //
                    }*/
                }


            }
        });


    }

    private void prepareData() {
        Goods goods = new Goods("Телевизор", 5000, R.drawable.tv, "09.06.17");
        goodsList.add(goods);
        goods = new Goods("Ботинки мужские", 450, R.drawable.boots, "12.06.17");
        goodsList.add(goods);
        goods = new Goods("Телефон", 50, R.drawable.phone, "13.06.17");
        goodsList.add(goods);
        goods = new Goods("Моющее", 290, R.drawable.gel, "18.01.17");
        goodsList.add(goods);
        goods = new Goods("Ботинки мужские", 450, R.drawable.boots, "12.06.17");
        goodsList.add(goods);
        goods = new Goods("Телефон", 50, R.drawable.phone, "13.06.17");
        goodsList.add(goods);
        goods = new Goods("Моющее", 290, R.drawable.gel, "18.01.17");
        goodsList.add(goods);
        goods = new Goods("Ботинки мужские", 450, R.drawable.boots, "12.06.17");
        goodsList.add(goods);
        goods = new Goods("Телефон", 50, R.drawable.phone, "13.06.17");
        goodsList.add(goods);
        goods = new Goods("Моющее", 290, R.drawable.gel, "18.01.17");
        goodsList.add(goods);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

  /*     if (id == R.id.redact_pers_info) {
            Intent intent = new Intent(MainActivity.this, PersInformActivity.class);
            startActivityForResult(intent, 555);
        } else if (id == R.id.setting) {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
