package com.example.pkiProject.products;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Serializable, Parcelable {
    String description;
    String price;
    Drawable imageView;

    public Product(String description, String price, Drawable imageView) {
        this.description = description;
        this.price = price;
        this.imageView = imageView;
    }

    protected Product(Parcel in) {
        description = in.readString();
        price = in.readString();
        Bitmap bitmap = (Bitmap)in.readParcelable(getClass().getClassLoader());
        // Convert Bitmap to Drawable:
        imageView = new BitmapDrawable(bitmap);
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Drawable getImageView() {
        return imageView;
    }

    public void setImageView(Drawable imageView) {
        this.imageView = imageView;
    }

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(price);
        Bitmap bitmap = (Bitmap)((BitmapDrawable) imageView).getBitmap();
        // Serialize bitmap as Parcelable:
        dest.writeParcelable(bitmap, flags);
    }
}
