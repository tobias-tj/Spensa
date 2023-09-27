package com.tj.spensa.Billetera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tj.spensa.BilleteraPage;
import com.tj.spensa.FacturaPage;
import com.tj.spensa.GraficoPage;
import com.tj.spensa.HomePage;
import com.tj.spensa.PerfilPage;
import com.tj.spensa.R;

public class CardPage extends AppCompatActivity {

    private FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_page);

        bottomNavigationView = findViewById(R.id.bottomNavigationViewCard);
        fab = findViewById(R.id.fabCard);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.vacio_btn);
        fab.getDrawable().mutate().setTint(ContextCompat.getColor(this, R.color.opacityColor));

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int selectedIconId = preferences.getInt("selectedIconId", R.id.vacio_btn); // Valor predeterminado: el ícono vacío
        // Seleccionar el mismo ícono en el BottomNavigationView de BilleteraPage
        bottomNavigationView.setSelectedItemId(selectedIconId);
        Menu menu = bottomNavigationView.getMenu();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homePage = new Intent(CardPage.this, HomePage.class);
                startActivity(homePage);
                finish();
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            fab.getDrawable().mutate().setTint(ContextCompat.getColor(this, R.color.opacityColor));
            for (int i = 0; i < menu.size(); i++) {
                MenuItem menuItem = menu.getItem(i);
                menuItem.setCheckable(true);
            }

            int selectedId = item.getItemId(); // Obtener el ID del elemento seleccionado

            // Utilizar un switch para determinar la acción en función del elemento seleccionado
            switch (selectedId) {
                case R.id.billetera_btn:
                    break;
                case R.id.grafico_btn:
                    Intent graficoPage = new Intent(CardPage.this, GraficoPage.class);
                    startActivity(graficoPage);
                    break;
                case R.id.factura_btn:
                    Intent facturaPage = new Intent(CardPage.this, FacturaPage.class);
                    startActivity(facturaPage);
                    break;
                case R.id.perfil_btn:
                    Intent perfilPage = new Intent(CardPage.this, PerfilPage.class);
                    startActivity(perfilPage);
                    break;
                default:
                    break;
            }
            return true;
        });
    }
}