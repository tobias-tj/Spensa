package com.tj.spensa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tj.spensa.Billetera.CardPage;

public class BilleteraPage extends AppCompatActivity {

    private FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;
    private EditText editTextBilleteraNum,editTextAlias;
    private TextView btnTengoAlias;
    private Boolean tengoAlias = false;
    private LinearLayout linearLayoutSecurity, linearLayoutAlias;
    private Button btnAgregarTarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billetera_page);

        bottomNavigationView = findViewById(R.id.bottomNavigationViewBilletera);
        fab = findViewById(R.id.fabBilletera);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.vacio_btn);
        fab.getDrawable().mutate().setTint(ContextCompat.getColor(this, R.color.opacityColor));

        editTextBilleteraNum = findViewById(R.id.editTextBilleteraNum);
        editTextAlias = findViewById(R.id.editTextAlias);
        btnTengoAlias = findViewById(R.id.btnTengoAlias);
        linearLayoutSecurity = findViewById(R.id.linearLayoutSecurity);
        linearLayoutAlias = findViewById(R.id.linearLayoutAlias);

        btnAgregarTarjeta = findViewById(R.id.btnAgregarTarjeta);

        btnTengoAlias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tengoAlias = !tengoAlias;
                if(tengoAlias){
                    editTextBilleteraNum.setVisibility(View.GONE);
                    editTextAlias.setVisibility(View.VISIBLE);
                    linearLayoutAlias.setVisibility(View.GONE);
                    linearLayoutSecurity.setVisibility(View.GONE);
                }else{
                    editTextBilleteraNum.setVisibility(View.VISIBLE);
                    editTextAlias.setVisibility(View.GONE);
                    linearLayoutAlias.setVisibility(View.VISIBLE);
                    linearLayoutSecurity.setVisibility(View.VISIBLE);
                }
            }
        });

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int selectedIconId = preferences.getInt("selectedIconId", R.id.vacio_btn); // Valor predeterminado: el ícono vacío
        // Seleccionar el mismo ícono en el BottomNavigationView de BilleteraPage
        bottomNavigationView.setSelectedItemId(selectedIconId);
        Menu menu = bottomNavigationView.getMenu();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homePage = new Intent(BilleteraPage.this, HomePage.class);
                startActivity(homePage);
                finish();
            }
        });

        btnAgregarTarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardPage = new Intent(BilleteraPage.this, CardPage.class);
                startActivity(cardPage);
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
                    // No hagas nada aquí, ya estás en BilleteraPage
                    break;
                case R.id.grafico_btn:
                    Intent graficoPage = new Intent(BilleteraPage.this, GraficoPage.class);
                    startActivity(graficoPage);
                    break;
                case R.id.factura_btn:
                    Intent facturaPage = new Intent(BilleteraPage.this, FacturaPage.class);
                    startActivity(facturaPage);
                    break;
                case R.id.perfil_btn:
                    Intent perfilPage = new Intent(BilleteraPage.this, PerfilPage.class);
                    startActivity(perfilPage);
                    break;
                default:
                    break;
            }
            return true;
        });

    }
}