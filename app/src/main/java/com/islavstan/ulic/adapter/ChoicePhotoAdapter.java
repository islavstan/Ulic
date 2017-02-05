package com.islavstan.ulic.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.islavstan.ulic.CreateAdActivity;
import com.islavstan.ulic.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ChoicePhotoAdapter extends RecyclerView.Adapter<ChoicePhotoAdapter.ViewHolder> {
    Uri drawableUri = Uri.parse("android.resource://com.islavstan.ulic/drawable/image");
    private final List<Uri> mData;
    CreateAdActivity context;
    private static final int LOUVRE_REQUEST_CODE = 1;

    public ChoicePhotoAdapter(Context context) {
        mData = new ArrayList<>();
        this.context = (CreateAdActivity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Uri data = mData.get(position);
        Picasso.with(holder.mImageView.getContext())
                .load(data)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .fit()
                .centerCrop()
                .into(holder.mImageView);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mData.get(mData.size() - 1) == drawableUri && position == mData.size() - 1) {
                    context.getLouvre().setRequestCode(LOUVRE_REQUEST_CODE).open();

                }
            }
        });


        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void swapData(@Nullable List<Uri> data) {
        if (!mData.equals(data)) {
            mData.clear();
            if (data != null) {
                mData.addAll(data);
                if (mData.size() < 4)
                    mData.add(drawableUri);
            }
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private ImageButton deleteBtn;

        private ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.photo);
            deleteBtn = (ImageButton) itemView.findViewById(R.id.deleteBtn);
        }
    }


}