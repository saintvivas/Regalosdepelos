package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abrirCatalogo(View view) {
        Intent intent = new Intent(this, Catalogo.class);
        startActivity(intent);
    }

    public void abrirContactenos(View view) {
        Intent intent = new Intent(this, Contactenos.class);
        startActivity(intent);
    }

    public void abrirUbicanos(View view) {
        Intent intent = new Intent(this, Ubicanos.class);
        startActivity(intent);
    }

    public void abrirOfertas(View view) {
        Intent intent = new Intent(this, Ofertas.class);
        startActivity(intent);
    }
}