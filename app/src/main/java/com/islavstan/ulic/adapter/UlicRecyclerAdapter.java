package com.islavstan.ulic.adapter;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavstan.ulic.DetailGoodInfoActivity;
import com.islavstan.ulic.R;
import com.islavstan.ulic.model.Goods;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UlicRecyclerAdapter extends RecyclerView.Adapter<UlicRecyclerAdapter.CustomViewHolder> {
    private List<Goods> goodsList;
    public Handler hRefresh;


    public UlicRecyclerAdapter(List<Goods> goodsList) {
        this.goodsList = goodsList;
        hRefresh = new Handler() {
            public void handleMessage(android.os.Message msg) {
                notifyDataSetChanged();
            }
        };
    }

    public void setNewData(List<Goods> newList) {
        goodsList = newList;//.remove(0);
        hRefresh.sendEmptyMessage(1);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goods_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        final Goods goods = goodsList.get(position);
        holder.shopName.setText(goods.getName());
        holder.price.setText(goods.getPrice()+" грн");
        holder.date.setText(goods.getDate());
        Picasso.with(holder.date.getContext()).load(goods.getImage()).into(holder.image);
        holder.favorite.setTag(R.drawable.star_border);

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = (int)holder.favorite.getTag();
                if( id == R.drawable.star_border){
                    holder.favorite.setTag(R.drawable.star);
                    holder.favorite.setImageResource(R.drawable.star);

                }else {
                    holder.favorite.setTag(R.drawable.star_border);
                    holder.favorite.setImageResource(R.drawable.star_border);
                }
            }
        });





        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(holder.shopName.getContext(), DetailGoodInfoActivity.class);
                holder.shopName.getContext().startActivity(intent);



               /* Intent intent=new Intent(holder.name.getContext(), DetailInfoActivity.class);
                intent.putExtra("name",discount.getName());
                intent.putExtra("percent",discount.getDiscount_percent());
                intent.putExtra("code",discount.getCode());
                intent.putExtra("access",discount.getPublicAccess());
                holder.name.getContext().startActivity(intent);*/
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
        ImageView image, favorite;

        public CustomViewHolder(View itemView) {
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.shop_name);
            price = (TextView) itemView.findViewById(R.id.price);
            date = (TextView) itemView.findViewById(R.id.date);
            image = (ImageView) itemView.findViewById(R.id.image);
            favorite = (ImageView) itemView.findViewById(R.id.favorite);
            card_view = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}