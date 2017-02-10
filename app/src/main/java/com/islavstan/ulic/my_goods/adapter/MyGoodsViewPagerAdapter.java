package com.islavstan.ulic.my_goods.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.islavstan.ulic.my_goods.fragments.ActiveGoodsFragment;
import com.islavstan.ulic.my_goods.fragments.SoldGoodsFragment;

/**
 * Created by islav on 10.02.2017.
 */

public class MyGoodsViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MyGoodsViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ActiveGoodsFragment tab1 = new ActiveGoodsFragment();
                return tab1;
            case 1:
                SoldGoodsFragment tab2 = new SoldGoodsFragment();
                return tab2;
            default:
                return null;
        }
    }


    @Override
    public int getItemPosition(Object object) {
      /*  if (object instanceof MyCardsFragment) {
            ((MyCardsFragment) object).update("");
        }*/
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}