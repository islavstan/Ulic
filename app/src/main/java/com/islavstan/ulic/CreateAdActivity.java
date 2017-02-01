package com.islavstan.ulic;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.islavstan.ulic.category.CategoryDialog;

public class CreateAdActivity extends AppCompatActivity {
 EditText categoryET;
    CategoryDialog categoryDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_create_ad);
        categoryET =(EditText)findViewById(R.id.input_category);

        categoryET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentManager fm = CreateAdActivity.this.getFragmentManager();
                 categoryDialog =new CategoryDialog();
                categoryDialog.show(fm,"categoryDialog");
            }
        });
    }


    public void setCategoryTocategoryET(String category){
        categoryET.setText(category);
        categoryDialog.dismiss();

    }
}
