package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DescripcionApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_app);
    }

    public void abrirMenu(View view) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}