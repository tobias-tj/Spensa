package com.tj.spensa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tj.spensa.Billetera.CardPage;

public class GraficoPage extends AppCompatActivity {

    FrameLayout backgroundTutorial;
    ScrollView scrollViewGrafico;
    private FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_page);

        backgroundTutorial = findViewById(R.id.backgroundTutorial);

        backgroundTutorial.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    backgroundTutorial.setVisibility(View.GONE);
                }
                return false;
            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigationViewGrafic);
        fab = findViewById(R.id.fabGrafic);

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
                Intent homePage = new Intent(GraficoPage.this, HomePage.class);
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
                    Intent billeteraPage = new Intent(GraficoPage.this, BilleteraPage.class);
                    startActivity(billeteraPage);
                    break;
                case R.id.grafico_btn:
                    break;
                case R.id.factura_btn:
                    Intent facturaPage = new Intent(GraficoPage.this, FacturaPage.class);
                    startActivity(facturaPage);
                    break;
                case R.id.perfil_btn:
                    Intent perfilPage = new Intent(GraficoPage.this, PerfilPage.class);
                    startActivity(perfilPage);
                    break;
                default:
                    break;
            }
            return true;
        });
    }
}