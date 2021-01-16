package com.example.pkiProject.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityProductDetailsBinding;
import com.example.pkiProject.user.User;
import com.example.pkiProject.user.UserActivity;
import com.example.pkiProject.util.AppConstants;
import com.example.pkiProject.util.Movement;

public class ProductDetails extends AppCompatActivity {

    private Product productInfo;
    private ActivityProductDetailsBinding binding;
    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getInfo();
        initUI();
        allowGoBack();
    }

    private void getInfo(){
        Intent i = getIntent();
        productInfo = (Product) i.getParcelableExtra(AppConstants.PRODUCT_DETAILS);
        currentUser = (User) i.getSerializableExtra(AppConstants.CURRENT_USER);
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
        binding.tvProductName.setText(productInfo.getDescription());
        binding.ivProduct.setImageDrawable(productInfo.getImageView());
        binding.tvDescription.setText("nacin upotrebe");
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"back", Toast.LENGTH_LONG);
        super.onBackPressed();
    }

    private void allowGoBack(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}