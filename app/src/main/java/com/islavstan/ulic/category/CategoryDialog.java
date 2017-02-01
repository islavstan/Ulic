package com.islavstan.ulic.category;


import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.islavstan.ulic.R;

import static com.islavstan.ulic.category.CategoryDataFactory.makeCategory;

public class CategoryDialog extends DialogFragment{
     CategoryAdapter adapter;
    RecyclerView rv;
    ImageButton backBtn;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this.getActivity());
        LayoutInflater inflater = this.getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_for_category, null);
        dialogBuilder.setView(dialogView);
        backBtn = (ImageButton) dialogView.findViewById(R.id.back_button);
        rv = (RecyclerView) dialogView.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new CategoryAdapter(makeCategory(), getActivity());
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
        final AlertDialog dialog = dialogBuilder.create();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        return dialog;

    }
}
