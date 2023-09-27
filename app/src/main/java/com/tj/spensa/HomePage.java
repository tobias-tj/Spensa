package com.tj.spensa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tj.spensa.Adapter.UserWalletAdapter;
import com.tj.spensa.Domain.UserWallet;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    private FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;

    private ImageView buttonNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);
        buttonNuevo = findViewById(R.id.buttonNuevo);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.vacio_btn);

        fab.getDrawable().mutate().setTint(ContextCompat.getColor(this, R.color.colorGradient));


        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            menuItem.setCheckable(false);
        }


        fab.setOnClickListener(v -> {
            fab.getDrawable().mutate().setTint(ContextCompat.getColor(this, R.color.colorGradient));
            // Desactivar la selección de todos los ítems al presionar el FAB
            for (int i = 0; i < menu.size(); i++) {
                MenuItem menuItem = menu.getItem(i);
                menuItem.setCheckable(false);
                menuItem.setChecked(false);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            fab.getDrawable().mutate().setTint(ContextCompat.getColor(this, R.color.opacityColor));
            for (int i = 0; i < menu.size(); i++) {
                MenuItem menuItem = menu.getItem(i);
                menuItem.setCheckable(true);
            }
            int selectedIconId = item.getItemId();
            SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("selectedIconId", selectedIconId);
            editor.apply();
            switch (selectedIconId){
                case R.id.fab:
                    Intent homePage = new Intent(HomePage.this, HomePage.class);
                    startActivity(homePage);
                    break;
                case R.id.billetera_btn:
                    Intent billeteraPage = new Intent(HomePage.this, BilleteraPage.class);
                    startActivity(billeteraPage);
                    break;
                case R.id.grafico_btn:
                        Intent graficoPage = new Intent(HomePage.this, GraficoPage.class);
                        startActivity(graficoPage);
                        break;
                case R.id.factura_btn:
                    Intent facturaPage = new Intent(HomePage.this, FacturaPage.class);
                    startActivity(facturaPage);
                    break;
                case R.id.perfil_btn:
                    Intent perfilPage = new Intent(HomePage.this, PerfilPage.class);
                    startActivity(perfilPage);
                    break;
                default:
                    break;
            }
            return true;
        });


        //Fragmento de Iconos (Nuevo/Ingreso/Egreso/Online)
        buttonNuevo.setOnClickListener(c->{
            new AddNewTransaction().show(getSupportFragmentManager(),null);
        });



        recyclerViewWallet();
    }

    private void recyclerViewWallet() {
        LinearLayoutManager linearLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.viewHolderRows);
        recyclerView.setLayoutManager(linearLayout);

        ArrayList<UserWallet> userWalletArrayList = new ArrayList<>();

        userWalletArrayList.add(new UserWallet("Transferencia Recibida", 100000,"15/08/2023", "bancoitaulogo", "₲"));
        userWalletArrayList.add(new UserWallet("Compra Online", 50000, "18/08/2023", "tiendamialogo", "₲"));
        userWalletArrayList.add(new UserWallet("Compra", 40000,"20/08/2023","mcdonalslogo", "₲"));

        adapter = new UserWalletAdapter(userWalletArrayList);
        recyclerView.setAdapter(adapter);
    }
}