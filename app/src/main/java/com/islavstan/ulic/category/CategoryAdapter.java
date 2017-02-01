package com.islavstan.ulic.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.islavstan.ulic.CreateAdActivity;
import com.islavstan.ulic.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;


public class CategoryAdapter extends ExpandableRecyclerViewAdapter<CategoryViewHolder, SubcategoryViewHolder> {
       CreateAdActivity context;
    public CategoryAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        this.context = (CreateAdActivity) context;
    }

    @Override
    public CategoryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public SubcategoryViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_subcategory, parent, false);
        return new SubcategoryViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(final SubcategoryViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final Subcategory subcategory = ((Category) group).getItems().get(childIndex);
        holder.setArtistName(subcategory.getName());
        holder.getChildTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               context.setCategoryTocategoryET(holder.getChildTextView().getText().toString());
            }
        });


    }

    @Override
    public void onBindGroupViewHolder(CategoryViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {

        holder.setGenreTitle(group);
    }
}