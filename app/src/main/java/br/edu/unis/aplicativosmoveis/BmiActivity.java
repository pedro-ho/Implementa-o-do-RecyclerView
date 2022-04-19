package br.edu.unis.aplicativosmoveis;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    EditText edtMass;
    EditText edtHeight;
    Button btnCalculate;
    TextView txtBMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        loadWidgets();
        btnCalculateSettings();
    }

    private void loadWidgets() {
        edtMass = findViewById(R.id.edt_bmi_mass);
        edtHeight = findViewById(R.id.edt_bmi_height);
        btnCalculate = findViewById(R.id.btn_bmi_calculate);
        txtBMIResult = findViewById(R.id.txt_bmi_result);
    }

    private void btnCalculateSettings() {
        btnCalculate.setOnClickListener(view -> {
            hideKeyboard();
            float height = Float.parseFloat(edtHeight.getText().toString());
            float mass = Float.parseFloat(edtMass.getText().toString());
            float bmi = calculate(height, mass);
            int bmiRating = rate(bmi);
            showRating(bmiRating);
            cleanFields();
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtMass.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(edtHeight.getWindowToken(), 0);
    }

    private float calculate(float height, float mass) {
        return mass / (height * height);
    }

    @StringRes
    private int rate(float bmi) {
        if (bmi < 16) {
            return R.string.txt_bmi_rating_severe_thinness;
        }
        if (bmi >= 16 && bmi < 17) {
            return R.string.txt_bmi_rating_moderate_thinness;
        }
        if (bmi >= 17 && bmi < 18.5) {
            return R.string.txt_bmi_rating_light_thinness;
        }
        if (bmi >= 18.5 && bmi < 25) {
            return R.string.txt_bmi_rating_healthy;
        }
        if (bmi >= 25 && bmi < 30) {
            return R.string.txt_bmi_rating_overweight;
        }
        if (bmi >= 30 && bmi < 35) {
            return R.string.txt_bmi_rating_obesity_grade_one;
        }
        if (bmi >= 35 && bmi < 40) {
            return R.string.txt_bmi_rating_obesity_grade_two;
        }
        return R.string.txt_bmi_rating_obesity_grade_three;
    }

    private void showRating(int bmiRating) {
        txtBMIResult.setText(bmiRating);
    }

    private void cleanFields() {
        edtMass.setText("");
        edtHeight.setText("");
        edtMass.requestFocus();
    }
}