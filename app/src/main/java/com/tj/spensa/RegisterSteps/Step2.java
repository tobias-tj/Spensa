package com.tj.spensa.RegisterSteps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tj.spensa.R;
import com.tj.spensa.RegisterPage;

public class Step2 extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView progressText;
    private Button siguienteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        progressBar = findViewById(R.id.progressBarStep2);
        progressText = findViewById(R.id.progressTextStep2);
        siguienteBtn = findViewById(R.id.btn_registerStep2);

        String progressValue = getIntent().getStringExtra("progress");
        progressText.setText(progressValue);

        int currentStep = Integer.parseInt(progressValue.split("/")[0]);
        progressBar.setMax(3);
        progressBar.setProgress(currentStep);

        siguienteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentStep = progressBar.getProgress();
                if (currentStep < progressBar.getMax()) {
                    currentStep++;

                    SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("progress", currentStep + "/3");
                    editor.apply();

                    Intent intent = new Intent(Step2.this, TokenRegister.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}