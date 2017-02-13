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
    public static final int PHOTO = 0;
    public static final int ADD_PHOTO = 1;
    public static final int MAX_PHOTO_COUNT = 4;
    LayoutInflater layoutInflater;

    public ChoicePhotoAdapter(Context context) {
        mData = new ArrayList<>();
        this.context = (CreateAdActivity) context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == PHOTO) {
            return new ViewHolder(layoutInflater.inflate(R.layout.photo_item, parent, false), viewType);
        } else
            return new ViewHolder(layoutInflater.inflate(R.layout.add_photo_item, parent, false), viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Uri data = mData.get(position);

        if (data == drawableUri) {
            holder.addImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.getLouvre().setRequestCode(LOUVRE_REQUEST_CODE).open();

                }
            });

        } else {

            Picasso.with(holder.mImageView.getContext())
                    .load(data)
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .fit()
                    .centerCrop()
                    .into(holder.mImageView);

            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mData.remove(position);
                    notifyItemRangeChanged(position, getItemCount());
                    notifyItemRemoved(position);
                    context.setMaxPhotoForLouvre(MAX_PHOTO_COUNT - mData.size() + 1);
                    if (mData.size() < MAX_PHOTO_COUNT) {
                        if (!mData.contains(drawableUri)) {
                            mData.add(drawableUri);
                            notifyItemInserted(mData.size() - 1);
                            context.setMaxPhotoForLouvre(MAX_PHOTO_COUNT - mData.size() + 1);
                        }


                    }

                }
            });
        }

    }


    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) == drawableUri)
            return ADD_PHOTO;
        else return PHOTO;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void swapData(List<Uri> data) {
        if (mData.size() >= 1 && mData.size() <= MAX_PHOTO_COUNT) {
            mData.remove(mData.size() - 1);
            mData.addAll(data);

            if (mData.size() < MAX_PHOTO_COUNT) {
                mData.add(drawableUri);
                context.setMaxPhotoForLouvre(MAX_PHOTO_COUNT - mData.size() + 2);
            } else {
                context.setMaxPhotoForLouvre(MAX_PHOTO_COUNT - mData.size() + 1);
            }


            notifyDataSetChanged();

        } else if (!mData.equals(data)) {
            mData.clear();
            if (data != null) {
                mData.addAll(data);
                if (mData.size() < MAX_PHOTO_COUNT)
                    mData.add(drawableUri);
                context.setMaxPhotoForLouvre(MAX_PHOTO_COUNT - mData.size() + 2);
            }
            context.setMaxPhotoForLouvre(MAX_PHOTO_COUNT - mData.size() + 1);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private ImageView addImage;
        private ImageButton deleteBtn;

        private ViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case 0:
                    mImageView = (ImageView) itemView.findViewById(R.id.photo);
                    deleteBtn = (ImageButton) itemView.findViewById(R.id.deleteBtn);
                    break;
                case 1:
                    addImage = (ImageView) itemView.findViewById(R.id.add_photo);
                    break;


            }

        }
    }


}