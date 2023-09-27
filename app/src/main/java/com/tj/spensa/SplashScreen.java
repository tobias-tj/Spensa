package com.tj.spensa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tj.spensa.Presentations.PresentationPage;

public class SplashScreen extends AppCompatActivity {

    ImageView iniciarSesionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        iniciarSesionBtn = findViewById(R.id.imageView3);

        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashScreen.this, PresentationPage.class));
            }
        });
    }
}