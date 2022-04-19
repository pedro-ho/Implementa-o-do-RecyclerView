package br.edu.unis.aplicativosmoveis;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FuelActivity extends AppCompatActivity {

    private EditText edtGas;
    private EditText edtAlcohol;
    private TextView txtBestFuel;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);
        loadWidgets();
        buttonSettings();
    }

    private void loadWidgets() {
        edtGas = findViewById(R.id.edt_fuel_gas);
        edtAlcohol = findViewById(R.id.edt_fuel_alcohol);
        txtBestFuel = findViewById(R.id.txt_best_fuel);
        btnCalculate = findViewById(R.id.btn_fuel_calculate);
    }

    private void buttonSettings() {
        btnCalculate.setOnClickListener(view -> {
            hideKeyboard();
            if (!validateFields()) {
                Toast.makeText(
                    FuelActivity.this,
                    getString(R.string.txt_fuel_validate_fields),
                    Toast.LENGTH_LONG
                ).show();
            } else {
                Double result = calculate();
                int fuel = getFuel(result);
                showResult(fuel);
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtGas.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(edtAlcohol.getWindowToken(), 0);
    }

    private boolean validateFields() {
        boolean hasGasValue = edtGas.getText().toString().isEmpty();
        boolean hasAlcoholValue = edtAlcohol.getText().toString().isEmpty();
        if (hasGasValue || hasAlcoholValue) {
            return false;
        }
        boolean hasInvalidGasValue = edtGas.getText().toString().startsWith("0");
        boolean hasInvalidAlcoholValue = edtAlcohol.getText().toString().startsWith("0");
        return !hasInvalidGasValue && !hasInvalidAlcoholValue;
    }

    private double calculate() {
        String textGasValue = edtGas.getText().toString();
        Double gasValue = Double.parseDouble(textGasValue);
        String textAlcoholValue = edtAlcohol.getText().toString();
        Double alcoholValue = Double.parseDouble(textAlcoholValue);
        return alcoholValue / gasValue;
    }

    @StringRes
    private int getFuel(Double result) {
        if (result > 0.69) {
            return R.string.txt_fuel;
        }
        return R.string.txt_alcohol;
    }

    private void showResult(int fuel) {
        txtBestFuel.setText(fuel);
        AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle(getString(R.string.txt_fuel_best_fuel))
            .setMessage(fuel)
            .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> cleanFields())
            .create();
        dialog.show();
    }

    private void cleanFields() {
        edtGas.setText("");
        edtAlcohol.setText("");
        txtBestFuel.setText("");
        edtGas.requestFocus();
    }
}