package products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ListItemProductBinding;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> productList;

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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListItemProductBinding binding;

        public ViewHolder(View view) {
            super(view);
            binding = ListItemProductBinding.bind(view);
            // Define click listener for the ViewHolder's View

        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

}
