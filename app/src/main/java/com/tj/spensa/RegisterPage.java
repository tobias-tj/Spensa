package com.tj.spensa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tj.spensa.Presentations.PresentationPage;
import com.tj.spensa.RegisterSteps.Step2;

public class RegisterPage extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView progressText;
    private Button siguienteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        progressBar = findViewById(R.id.progressBar);
        progressText = findViewById(R.id.progressText);
        siguienteBtn = findViewById(R.id.btn_register);


        progressBar.setMax(3);
        progressBar.setProgress(1);
        progressText.setText("1/3");

        siguienteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentStep = progressBar.getProgress();
                if(currentStep < progressBar.getMax()){
                    currentStep++;
                    Intent intent = new Intent(RegisterPage.this, Step2.class);
                    intent.putExtra("progress",currentStep + "/3");
                    startActivity(intent);
                    finish();

                }
            }
        });


    }
}