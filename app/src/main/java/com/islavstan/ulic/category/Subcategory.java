package com.islavstan.ulic.category;

import android.os.Parcel;
import android.os.Parcelable;



public class Subcategory implements Parcelable {

    private String name;


    public Subcategory(String name) {
        this.name = name;

    }

    protected Subcategory(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Subcategory> CREATOR = new Creator<Subcategory>() {
        @Override
        public Subcategory createFromParcel(Parcel in) {
            return new Subcategory(in);
        }

        @Override
        public Subcategory[] newArray(int size) {
            return new Subcategory[size];
        }
    };
}
