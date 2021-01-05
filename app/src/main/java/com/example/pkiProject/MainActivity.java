package com.example.pkiProject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.pkiProject.user.User;

import java.util.ArrayList;
import java.util.List;

import products.ProductsActivities;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<User> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initUI();
    }

    private void initUI(){
        users.add(new User("Petar Petrov","Balkanska 32, Beograd","065 12345678", "userPetar","passwordPetar"));
        users.add(new User("Marija Petrov","Dalmatinska 32, Beograd","062 12345678", "userMarija","passwordMarija"));

        binding.btnSubmit.setOnClickListener(v -> {
            String username =((EditText)binding.etUsername).getText().toString();
            String password =((EditText)binding.etPassword).getText().toString();
            int found = 0;
            for(User user:users){
                if(user.getPasword() == password && user.getUsername() == username){
                    found= 1;
                    break;
                }
            }
            if(found==1){
                Intent intent = new Intent(this, ProductsActivities.class);
                startActivity(intent);
            }else{
                //AlertDialog dialod = new AlertDialog();
            }

        });
    }
}