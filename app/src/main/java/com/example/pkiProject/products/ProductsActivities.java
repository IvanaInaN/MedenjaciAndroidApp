package com.example.pkiProject.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.AvailableProductsBinding;
import com.example.pkiProject.user.User;
import com.example.pkiProject.user.UserActivity;
import com.example.pkiProject.util.AppConstants;
import com.example.pkiProject.util.Movement;

import java.util.ArrayList;

public class ProductsActivities extends AppCompatActivity implements ProductsAdapter.ListItemClickListener {
    private AvailableProductsBinding binding;
    private ProductsAdapter adapter;
    private User currentUser;
    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AvailableProductsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getCurrentUser();
        initUI();
    }

    private void getCurrentUser(){
        Intent i = getIntent();
        currentUser = (User)i.getSerializableExtra(AppConstants.CURRENT_USER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.korisnik:
                Movement.startUserActivity(this, currentUser);
                return true;
            case R.id.korpa:
                Movement.startBasketActivity(this);
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void initUI(){
        products = addProducts();
        // set up the RecyclerView
        RecyclerView recyclerView = binding.rvProducts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductsAdapter(this::onListItemClick);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter.setProductList(products);



    }

    private ArrayList<Product> addProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Propolis 20ml","230.00 din",getDrawable(R.drawable.ic_propolis)));
        products.add(new Product("Propolis 50ml","250.00 din",getDrawable(R.drawable.ic_propolis)));
        products.add(new Product("Propolis 70ml","330.00 din",getDrawable(R.drawable.ic_propolis)));
        return  products;
    }

    @Override
    public void onListItemClick(int position) {
        Intent intent = new Intent(ProductsActivities.this , ProductDetails.class);
        intent.putExtra(AppConstants.PRODUCT_DETAILS, (Parcelable) products.get(position));
        intent.putExtra(AppConstants.CURRENT_USER, currentUser);
        startActivity(intent);
    }
}