package com.islavstan.ulic.category_dialog;

import android.view.View;
import android.widget.TextView;

import com.islavstan.ulic.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;


public class SubcategoryViewHolder extends ChildViewHolder {

    private TextView childTextView;

    public SubcategoryViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.list_item_artist_name);
      /*  childTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(childTextView.getContext(), childTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void setArtistName(String name) {
        childTextView.setText(name);
    }

    public TextView getChildTextView() {
        return childTextView;
    }
}