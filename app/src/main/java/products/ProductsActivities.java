package products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.AvailableProductsBinding;
import com.example.pkiProject.user.UserActivity;

import java.util.ArrayList;

public class ProductsActivities extends AppCompatActivity {
    private AvailableProductsBinding binding;
    private ProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AvailableProductsBinding.inflate(getLayoutInflater());
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
        startActivity(intent);
    }

    private void initUI(){
        ArrayList<Product> products = new ArrayList<>();
        //add products to list
        products.add(new Product("Propolis 20ml","230.00 din",getDrawable(R.drawable.ic_propolis)));
        products.add(new Product("Propolis 50ml","230.00 din",getDrawable(R.drawable.ic_propolis)));
        products.add(new Product("Propolis 70ml","230.00 din",getDrawable(R.drawable.ic_propolis)));

        // set up the RecyclerView
        RecyclerView recyclerView = binding.rvProducts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductsAdapter();
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter.setProductList(products);
    }

}