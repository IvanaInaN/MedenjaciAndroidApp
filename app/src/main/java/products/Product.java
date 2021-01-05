package products;

import android.graphics.drawable.Drawable;

public class Product {
    String description;
    String price;
    Drawable imageView;

    public Product(String description, String price, Drawable imageView) {
        this.description = description;
        this.price = price;
        this.imageView = imageView;
    }

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
}
