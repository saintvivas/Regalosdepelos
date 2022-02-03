package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Catalogo extends AppCompatActivity {

    FragmentTopper fragTopper;
    FragmentMesa fragMesa;
    FragmentRepisa fragRepisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        fragTopper = new FragmentTopper();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, fragTopper).commit();

    }

    public void onClick(View view) {

        fragMesa = new FragmentMesa();
        fragRepisa = new FragmentRepisa();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.botonTopper:
                transaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, fragTopper);
                break;

            case R.id.botonMesa:
                transaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, fragMesa);
                break;

            case R.id.botonRepisa:
                transaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, fragRepisa);

        }transaction.commit();

    }

    public void abrirMenu(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}