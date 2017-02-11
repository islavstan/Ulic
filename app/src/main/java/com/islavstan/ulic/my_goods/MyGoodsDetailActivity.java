package com.islavstan.ulic.my_goods;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.islavstan.ulic.BuyGoodsActivity;
import com.islavstan.ulic.DetailGoodInfoActivity;
import com.islavstan.ulic.R;
import com.islavstan.ulic.adapter.LoopAdapter;
import com.jude.rollviewpager.RollPagerView;

public class MyGoodsDetailActivity extends AppCompatActivity {
    RollPagerView rollPagerView;
    TextView goodsName;
    TextView condition;
    TextView price;
    TextView goodsInfo;
    TextView buyBtn;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_my_goods_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");


        rollPagerView = (RollPagerView) findViewById(R.id.rollPagerView);
        LoopAdapter adapter = new LoopAdapter(rollPagerView);
        rollPagerView.setAdapter(adapter);
        // rollPagerView.pause();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shop_my_goods, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.redact) {
            Intent intent = new Intent(MyGoodsDetailActivity.this, ChangeMyGoodsActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.delete) {
            showDeleteDialog();
        }


        return true;
    }

    private void showDeleteDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View promptView = layoutInflater.inflate(R.layout.dialog_for_delete, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCustomTitle(promptView);
        alertDialogBuilder.setMessage("Вы уверены, что хотите удалить объявление?");
        alertDialogBuilder
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
        Button button = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setTextColor(Color.BLACK);
        //  button.setTypeface(Typeface.DEFAULT_BOLD);
        Button button2 = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        button2.setTextColor(Color.BLACK);

    }
}