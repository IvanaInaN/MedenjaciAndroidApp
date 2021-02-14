package com.example.pkiProject.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.databinding.UserActivityBinding;
import com.example.pkiProject.util.AppConstants;
import com.example.pkiProject.util.Movement;

public class UserActivity extends AppCompatActivity {

    private User currentUser;
    private UserActivityBinding binding;
    boolean editable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        binding = UserActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getCurrentUser();
        initUI();
        allowGoBack();
    }

    private void getCurrentUser(){
        Intent intent = getIntent();
        currentUser = (User)intent.getSerializableExtra(AppConstants.CURRENT_USER);
    }

    private void initUI(){
        if(currentUser ==null) return;
        binding.txtIme.setText(currentUser.getName());
        binding.txtAdresa.setText(currentUser.getAddress());
        binding.txtTelefon.setText(currentUser.getPhone());
        binding.txtKorisnickoIme.setText(currentUser.getUsername());
        binding.txtLozinka.setText(currentUser.getPasword());
        allowedEditing(false);
        binding.btnEdit.setOnClickListener(v -> {
            if (!editable) {
                editUserData();
            }else{
                saveChanges();
            }
        });
    }

    private void allowedEditing(Boolean allow){
        binding.txtIme.setEnabled(allow);
        binding.txtAdresa.setEnabled(allow);
        binding.txtTelefon.setEnabled(allow);
        binding.txtKorisnickoIme.setEnabled(allow);
        binding.txtLozinka.setEnabled(allow);
    }

    private void editUserData(){
        editable= true;
        allowedEditing(editable);
        binding.btnEdit.setText("POTVRDI");
    }

    private void saveChanges(){
        editable= false;
        currentUser.setName(((EditText)binding.txtIme).getText().toString());
        currentUser.setAddress(((EditText)binding.txtAdresa).getText().toString());
        currentUser.setPhone(((EditText)binding.txtTelefon).getText().toString());
        currentUser.setPasword(((EditText)binding.txtLozinka).getText().toString());
        currentUser.setUsername(((EditText)binding.txtIme).getText().toString());
        allowedEditing(editable);
        binding.btnEdit.setText("PROMENI");
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
                Movement.startBasketActivity(this, currentUser);
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void allowGoBack(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }



}