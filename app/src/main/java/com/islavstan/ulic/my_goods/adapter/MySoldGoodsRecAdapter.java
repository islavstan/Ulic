package com.islavstan.ulic.my_goods.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavstan.ulic.R;
import com.islavstan.ulic.model.Goods;
import com.islavstan.ulic.my_goods.MyGoodsDetailActivity;
import com.islavstan.ulic.my_goods.MySoldGoodsDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MySoldGoodsRecAdapter extends RecyclerView.Adapter<MySoldGoodsRecAdapter.CustomViewHolder> {
    private List<Goods> goodsList;


    public MySoldGoodsRecAdapter(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }


    @Override
    public MySoldGoodsRecAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_my_goods_item, parent, false);

        return new MySoldGoodsRecAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MySoldGoodsRecAdapter.CustomViewHolder holder, int position) {
        final Goods goods = goodsList.get(position);
        holder.shopName.setText(goods.getName());
        holder.price.setText(goods.getPrice() + " грн");
        holder.date.setText(goods.getDate());
        Picasso.with(holder.date.getContext()).load(goods.getImage()).into(holder.image);

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(holder.card_view.getContext(), MySoldGoodsDetailActivity.class);
                holder.card_view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView shopName, price, date;
        CardView card_view;
        ImageView image;

        public CustomViewHolder(View itemView) {
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.shop_name);
            price = (TextView) itemView.findViewById(R.id.price);
            date = (TextView) itemView.findViewById(R.id.date);
            image = (ImageView) itemView.findViewById(R.id.image);
            card_view = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}