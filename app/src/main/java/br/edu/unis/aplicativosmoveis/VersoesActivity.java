package br.edu.unis.aplicativosmoveis;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VersoesActivity extends AppCompatActivity {

    RecyclerView rvVersoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versoes);

        rvVersoes = findViewById(R.id.rv_versoes);
        rvVersoes.setLayoutManager(new LinearLayoutManager(this));

        List<Versao> versoes = new ArrayList<>();
        versoes.add(new Versao("Android 9.0", "Pie", "06/08/2018", com.google.android.material.R.color.design_default_color_on_primary));

        VersoesAdapter adapter = new VersoesAdapter(versoes);
        rvVersoes.setAdapter(adapter);
    }
}