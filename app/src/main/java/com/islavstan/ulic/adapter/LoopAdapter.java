package com.islavstan.ulic.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.islavstan.ulic.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;



public class LoopAdapter extends LoopPagerAdapter {
    private int[] imgs = {
            R.drawable.boots,
            R.drawable.gel,
            R.drawable.tv,
            R.drawable.phone,
    };

    public LoopAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return imgs.length;
    }
}
