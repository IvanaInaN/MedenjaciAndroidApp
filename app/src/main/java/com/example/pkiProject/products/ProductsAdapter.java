package com.example.pkiProject.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ListItemProductBinding;
import com.example.pkiProject.basket.BasketAdapter;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> productList;
    private static ClickListener mOnClickListener ;

    public ProductsAdapter() {
        super();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.binding.ivPicture.setImageDrawable(product.getImageView());
        holder.binding.tvProductName.setText(product.getDescription());
        holder.binding.tvProductPrice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return productList==null ? 0: productList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ListItemProductBinding binding;

        public ViewHolder(View view) {
            super(view);
            binding = ListItemProductBinding.bind(view);
            // Define click listener for the ViewHolder's View

        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
    public void setOnItemClickListener(ClickListener clickListener) {
        ProductsAdapter.mOnClickListener = clickListener;
    }


}
