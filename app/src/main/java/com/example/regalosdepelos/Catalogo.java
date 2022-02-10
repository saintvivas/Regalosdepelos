package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Catalogo extends AppCompatActivity {

    ImageButton imageBotonMenu;

    FragmentTopper fragTopper;
    FragmentMesa fragMesa;
    FragmentRepisa fragRepisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        imageBotonMenu = findViewById(R.id.imageBotonMenu);

        fragTopper = new FragmentTopper();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, fragTopper).commit();

        imageBotonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MenuPrincipal.class);
                startActivity(intent);
            }
        });

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



}