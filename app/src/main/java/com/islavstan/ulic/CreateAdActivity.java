package com.islavstan.ulic;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.andremion.louvre.Louvre;
import com.andremion.louvre.home.GalleryActivity;
import com.islavstan.ulic.adapter.ChoicePhotoAdapter;
import com.islavstan.ulic.category_dialog.CategoryDialog;
import com.islavstan.ulic.place.PlaceDialog;

public class CreateAdActivity extends AppCompatActivity  implements PlaceDialog.OnCompleteListener {
    //https://github.com/andremion/Louvre/tree/development/sample/src/main/java/com/andremion/louvre/sample
    EditText categoryET;
    EditText placeET;
    CategoryDialog categoryDialog;
    ImageView photo;
    Louvre louvre;

    public Louvre getLouvre() {
        return louvre;
    }


    RecyclerView recyclerView;
    ChoicePhotoAdapter choicePhotoAdapter;
    private static final int LOUVRE_REQUEST_CODE = 1;


    ImageView nameImage;
    ImageView photoCheck;

    EditText nameET;
    TextInputLayout nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_create_ad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Разместить объявление");

        placeET = (EditText) findViewById(R.id.input_place);
        nameImage = (ImageView) findViewById(R.id.ivContactItem1);
        nameET = (EditText) findViewById(R.id.input_name);
        nameInput = (TextInputLayout) findViewById(R.id.input_layout_name);

        photoCheck = (ImageView) findViewById(R.id.ivContactItem0);

        nameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() >= 5) {
                    nameImage.setImageResource(R.drawable.green_checked);
                    nameInput.setError(null);
                } else {
                    nameImage.setImageResource(R.drawable.checked);
                    nameInput.setError("Название должно содержать минимум 5 символов");

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        categoryET = (EditText) findViewById(R.id.input_category);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        choicePhotoAdapter = new ChoicePhotoAdapter(this);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(CreateAdActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        recyclerView.setAdapter(choicePhotoAdapter);

        categoryET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentManager fm = CreateAdActivity.this.getFragmentManager();
                categoryDialog = new CategoryDialog();
                categoryDialog.show(fm, "categoryDialog");
            }
        });

        louvre = Louvre.init(CreateAdActivity.this);
        louvre.setMaxSelection(4);
        photo = (ImageView) findViewById(R.id.photo);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                louvre.setRequestCode(LOUVRE_REQUEST_CODE).open();
            }
        });


        placeET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaceDialog placeDialog = new PlaceDialog();
                final FragmentManager fm = CreateAdActivity.this.getFragmentManager();
                placeDialog.show(fm, "placeDialog");
            }
        });


    }


    public void setCategoryTocategoryET(String category) {
        categoryET.setText(category);
        categoryDialog.dismiss();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOUVRE_REQUEST_CODE && resultCode == RESULT_OK) {
            choicePhotoAdapter.swapData(GalleryActivity.getSelection(data));
            photo.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            photoCheck.setImageResource(R.drawable.green_checked);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onComplete(String place) {

        placeET.setText(place);

    }
}
