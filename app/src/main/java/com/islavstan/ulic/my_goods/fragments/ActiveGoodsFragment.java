package com.islavstan.ulic.my_goods.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.islavstan.ulic.R;
import com.islavstan.ulic.ShopMainActivity;
import com.islavstan.ulic.model.Goods;
import com.islavstan.ulic.my_goods.adapter.MyGoodsRecAdapter;

import java.util.ArrayList;
import java.util.List;


public class ActiveGoodsFragment extends Fragment {
    List<Goods>goodsList =new ArrayList<>();

RecyclerView recyclerView;
    MyGoodsRecAdapter recAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shop_active_goods_fragment, container, false);


        recyclerView =(RecyclerView)v.findViewById(R.id.my_recycler_view);
        recAdapter =new MyGoodsRecAdapter(goodsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recAdapter);

        prepareGoodsData();





        return v;
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

    }
}
