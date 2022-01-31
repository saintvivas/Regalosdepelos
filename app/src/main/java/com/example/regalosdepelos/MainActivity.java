package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    SearchView txtBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBuscar = findViewById(R.id.txtBuscar);
    }
}
