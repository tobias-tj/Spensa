package com.tj.spensa.RegisterSteps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tj.spensa.R;

public class TokenRegister extends AppCompatActivity {


    Button btn_registerToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_register);

        btn_registerToken = findViewById(R.id.btn_registerToken);

        btn_registerToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TokenRegister.this, TokenRegister2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}