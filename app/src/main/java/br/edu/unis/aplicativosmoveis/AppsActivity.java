package br.edu.unis.aplicativosmoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppsActivity extends AppCompatActivity {

    View btnBmiApp;
    View btnFuelApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);
        loadWidgets();
        buttonBMISettings();
        buttonFuelSettings();
    }

    private void loadWidgets() {
        btnBmiApp = findViewById(R.id.linear_apps_bmi);
        btnFuelApp = findViewById(R.id.linear_apps_fuel);
    }

    private void buttonFuelSettings() {
        btnFuelApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppsActivity.this, FuelActivity.class);
                startActivity(intent);
            }
        });
    }

    private void buttonBMISettings() {
        btnBmiApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppsActivity.this, BmiActivity.class);
                startActivity(intent);
            }
        });
    }
}