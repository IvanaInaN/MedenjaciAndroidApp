package com.example.pkiProject.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.AvailableProductsBinding;
import com.example.pkiProject.user.User;
import com.example.pkiProject.user.UserActivity;
import com.example.pkiProject.util.AppConstants;

import java.util.ArrayList;

public class ProductsActivities extends AppCompatActivity {
    private AvailableProductsBinding binding;
    private ProductsAdapter adapter;
    private User currentUser;

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
                startUserActivity();
                return true;
            case R.id.korpa:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startUserActivity(){
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra(AppConstants.CURRENT_USER, currentUser);
        startActivity(intent);
    }

    private void initUI(){
        ArrayList<Product> products = addProducts();
        // set up the RecyclerView
        RecyclerView recyclerView = binding.rvProducts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductsAdapter();
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter.setProductList(products);

        adapter.setOnItemClickListener(new ProductsAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }

    private ArrayList<Product> addProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Propolis 20ml","230.00 din",getDrawable(R.drawable.ic_propolis)));
        products.add(new Product("Propolis 50ml","250.00 din",getDrawable(R.drawable.ic_propolis)));
        products.add(new Product("Propolis 70ml","330.00 din",getDrawable(R.drawable.ic_propolis)));
        return  products;
    }

}