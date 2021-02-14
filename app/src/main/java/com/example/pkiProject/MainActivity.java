package com.example.pkiProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.pkiProject.user.User;
import com.example.pkiProject.util.AppConstants;
import com.example.pkiProject.util.DialogUtils;

import java.util.ArrayList;
import java.util.List;

import com.example.pkiProject.products.ProductsActivities;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<User> users = new ArrayList<>();
    private User currentUser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initUI();
    }

    private void initUI(){

        setUpUsers();
        binding.btnSubmit.setOnClickListener(v -> {
            String username =((EditText)binding.etUsername).getText().toString();
            String password =((EditText)binding.etPassword).getText().toString();
            int faund = checkIfUserExist(username, password);
            if(faund==1){
               showAvailableProducts();
            }else{
                showError();
            }

        });
    }

    private int checkIfUserExist(String username, String password){
        int found = 0;
        for(User user:users){
            if(user.getPasword().equals(password) && user.getUsername().equals(username)){
                found= 1;
                currentUser = user;
                break;
            }
        }
        return found;
    }

    private void showError(){
        DialogUtils.showMessagge(MainActivity.this,"Neuspešno logovanje","Korisničko ime ili lozinka su neispravni. Molim Vas pokušajte ponovo.");
    }

    private void showAvailableProducts(){
        Intent intent = new Intent(this, ProductsActivities.class);
        intent.putExtra(AppConstants.CURRENT_USER , currentUser);
        startActivity(intent);
    }

    private void setUpUsers(){
        users.add(new User("Petar Petrov","Balkanska 32, Beograd","065 12345678", "petar","petar123"));
        users.add(new User("Marija Petrov","Dalmatinska 32, Beograd","062 12345678", "userMarija","passwordMarija"));
    }
}