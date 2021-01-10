package com.example.pkiProject.basket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ListBasketItemBinding;

import java.util.List;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder> {

    private List<BasketItem> itemList;

    public BasketAdapter() {
        super();
    }

    @NonNull
    @Override
    public BasketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_basket_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketAdapter.ViewHolder holder, int position) {
        BasketItem item = itemList.get(position);
        holder.binding.ivPicture.setImageDrawable(item.getProduct().getImageView());
        holder.binding.tvProductName.setText(item.getProduct().getDescription());
        holder.binding.tvProductPrice.setText(item.getProduct().getPrice());
        holder.binding.tvCount.setText(item.getCount());
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListBasketItemBinding binding;

        public ViewHolder(View view) {
            super(view);
            binding = ListBasketItemBinding.bind(view);
            // Define click listener for the ViewHolder's View

        }
    }

    public List<BasketItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BasketItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

}