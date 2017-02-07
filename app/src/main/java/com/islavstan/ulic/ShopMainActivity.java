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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.islavstan.ulic.adapter.UlicRecyclerAdapter;
import com.islavstan.ulic.bottom_sheet.BSCategoryRecyclerAdapter;
import com.islavstan.ulic.model.Goods;

import java.util.ArrayList;
import java.util.List;

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
    Toolbar toolbar;

    private RecyclerView rubricsRecycler;
    ExpandableRelativeLayout rubricExpandableLayout;
    ImageView down_image;
    TextView rubricsBtn;
    List<String> category = new ArrayList<>();

    private RecyclerView categoryRecycler;
    ExpandableRelativeLayout categoryExpandableLayout;
    ImageView categoryDownImage;
    TextView categoryBtn;



    private RecyclerView sortRecycler;
    ExpandableRelativeLayout sortExpandableLayout;
    ImageView sortDownImage;
    TextView sortBtn;
    List<String> sortList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        changeViewTypeMainRecyclerView();
        initBottomSheetExpandable();
        prepareCategory();
        initMainInterface();
        prepareGoodsData();
        prepareSortData();
    }


    private void initMainInterface() {

        fab = (FloatingActionButton) findViewById(R.id.fab);
        llBottomSheet = (NestedScrollView) findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        animationUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        animationDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new UlicRecyclerAdapter(goodsList);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopMainActivity.this, CreateAdActivity.class);
                startActivity(intent);
            }
        });


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


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

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

                } else if (dy < 0) {
                    llBottomSheet.startAnimation(animationUp);
                    bottomSheetBehavior.setPeekHeight(170);

                }


            }
        });


    }


    private void changeViewTypeMainRecyclerView() {

        //-----------смена вида RecyclerView-----------
        viewType1Btn = (ImageButton) findViewById(R.id.view1Btn);
        viewType2Btn = (ImageButton) findViewById(R.id.view2Btn);
        viewType4Btn = (ImageButton) findViewById(R.id.view4Btn);


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


    }


    private void initBottomSheetExpandable() {


        //--------рубрики----------
        rubricsBtn = (TextView) findViewById(R.id.categoryBtn);
        down_image = (ImageView) findViewById(R.id.down_image);
        rubricExpandableLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
        rubricsRecycler = (RecyclerView) findViewById(R.id.categoryRecycler);
        BSCategoryRecyclerAdapter rubricsRecyclerAdapter = new BSCategoryRecyclerAdapter(category);
        RecyclerView.LayoutManager rubricsManager = new LinearLayoutManager(ShopMainActivity.this);
        rubricsRecycler.setLayoutManager(rubricsManager);
        rubricsRecycler.setAdapter(rubricsRecyclerAdapter);
        rubricExpandableLayout.setListener(new ExpandableLayoutListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {

            }

            @Override
            public void onPreOpen() {

            }

            @Override
            public void onPreClose() {

            }

            @Override
            public void onOpened() {
                down_image.setImageResource(R.drawable.drop_up);
            }

            @Override
            public void onClosed() {
                down_image.setImageResource(R.drawable.drop_down);
            }
        });

        rubricsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rubricExpandableLayout.toggle();
            }
        });


        //--------категории----------
        categoryRecycler = (RecyclerView) findViewById(R.id.categoryRecycler2);
        categoryExpandableLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        categoryDownImage = (ImageView) findViewById(R.id.down_image2);
        categoryBtn = (TextView) findViewById(R.id.categoryBtn2);
        categoryRecycler = (RecyclerView) findViewById(R.id.categoryRecycler2);
        BSCategoryRecyclerAdapter categoryRecyclerAdapter2 = new BSCategoryRecyclerAdapter(category);
        RecyclerView.LayoutManager categoryManager2 = new LinearLayoutManager(ShopMainActivity.this);
        categoryRecycler.setLayoutManager(categoryManager2);
        categoryRecycler.setAdapter(categoryRecyclerAdapter2);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryExpandableLayout.toggle();
            }
        });
        categoryExpandableLayout.setListener(new ExpandableLayoutListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {

            }

            @Override
            public void onPreOpen() {

            }

            @Override
            public void onPreClose() {

            }

            @Override
            public void onOpened() {
                categoryDownImage.setImageResource(R.drawable.drop_up);
            }

            @Override
            public void onClosed() {
                categoryDownImage.setImageResource(R.drawable.drop_down);
            }
        });


        //----------------сортировка-------------
        sortRecycler = (RecyclerView) findViewById(R.id.sortRecycler);
        sortExpandableLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        sortDownImage = (ImageView) findViewById(R.id.down_image3);
        sortBtn = (TextView) findViewById(R.id.sortBtn);
        BSCategoryRecyclerAdapter sortRecyclerAdapter = new BSCategoryRecyclerAdapter(sortList);
        RecyclerView.LayoutManager sortManager = new LinearLayoutManager(ShopMainActivity.this);
        sortRecycler.setLayoutManager(sortManager);
        sortRecycler.setAdapter(sortRecyclerAdapter);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortExpandableLayout.toggle();
            }
        });
        sortExpandableLayout.setListener(new ExpandableLayoutListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {

            }

            @Override
            public void onPreOpen() {

            }

            @Override
            public void onPreClose() {

            }

            @Override
            public void onOpened() {
                sortDownImage.setImageResource(R.drawable.drop_up);
            }

            @Override
            public void onClosed() {
                sortDownImage.setImageResource(R.drawable.drop_down);
            }


        });


    }


    private void prepareGoodsData() {
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


    private void prepareCategory() {
        category.add("Компьютеры");
        category.add("Недвижимость");
        category.add("Еда");
        category.add("Одежда");
        category.add("Велосипеды");
        category.add("Компьютеры");
    }


    private void prepareSortData(){
        sortList.add("сортировать по дате добавления");
        sortList.add("сортировать по цене");
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
