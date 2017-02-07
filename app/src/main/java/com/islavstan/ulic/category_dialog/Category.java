package com.islavstan.ulic.category_dialog;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;



public class Category extends ExpandableGroup<Subcategory> {


    public Category(String title, List<Subcategory> items) {
        super(title, items);

    }


}