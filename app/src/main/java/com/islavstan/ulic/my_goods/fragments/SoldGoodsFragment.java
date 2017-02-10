package com.islavstan.ulic.my_goods.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.islavstan.ulic.R;


public class SoldGoodsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shop_sold_goods_fragment, container, false);
        return v;
    }
}
