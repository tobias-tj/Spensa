package com.tj.spensa.RegisterSteps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tj.spensa.HomePage;
import com.tj.spensa.R;

public class Step3 extends AppCompatActivity {

    Button btn_final_register;
    private ProgressBar progressBar;
    private TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);

        btn_final_register = findViewById(R.id.btn_final_register);
        progressBar = findViewById(R.id.progressBarStep3);
        progressText = findViewById(R.id.progressTextStep3);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String progress = preferences.getString("progress", "0/3");

        progressText.setText(progress);
        int currentStep = Integer.parseInt(progress.split("/")[0]);
        progressBar.setMax(3);
        progressBar.setProgress(currentStep);

        btn_final_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step3.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}