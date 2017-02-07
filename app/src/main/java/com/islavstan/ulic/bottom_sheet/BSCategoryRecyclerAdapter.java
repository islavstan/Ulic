package com.islavstan.ulic.bottom_sheet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islavstan.ulic.R;

import java.util.List;

public class BSCategoryRecyclerAdapter extends RecyclerView.Adapter<BSCategoryRecyclerAdapter.CustomViewHolder> {
    private List<String> categoryList;


    public BSCategoryRecyclerAdapter(List<String> categoryList) {
        this.categoryList = categoryList;

    }


    @Override
    public BSCategoryRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_for_bottom_sheet, parent, false);


        return new BSCategoryRecyclerAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BSCategoryRecyclerAdapter.CustomViewHolder holder, int position) {
        holder.category_text.setText(categoryList.get(position));


    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView category_text;

        public CustomViewHolder(View itemView) {
            super(itemView);

            category_text = (TextView) itemView.findViewById(R.id.category_text);


        }
    }
}