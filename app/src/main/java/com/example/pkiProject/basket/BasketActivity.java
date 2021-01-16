package com.example.pkiProject.basket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityBasketBinding;
import com.example.pkiProject.user.User;
import com.example.pkiProject.util.Movement;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {

    private ActivityBasketBinding binding;
    private List<BasketItem> itemList = new ArrayList<>();
    private User currentUser;
    private BasketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initUI();
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
                Movement.startUserActivity(this,currentUser);
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
       // ArrayList<Product> products = addProducts();
        // set up the RecyclerView
        RecyclerView recyclerView = binding.rvBasketLines;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BasketAdapter();
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter.setItemList(itemList);
        allowGoBack();
    }

    private void allowGoBack(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


}