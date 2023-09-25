package com.tj.spensa.RegisterSteps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tj.spensa.R;

public class TokenRegister2 extends AppCompatActivity {

    Button btn_registerToken2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_register2);

        btn_registerToken2 = findViewById(R.id.btn_registerToken2);

        btn_registerToken2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TokenRegister2.this, Step3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}