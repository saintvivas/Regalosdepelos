package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.regalosdepelos.adaptadores.ListaToppersAdapter;
import com.example.regalosdepelos.db.DbToppers;
import com.example.regalosdepelos.entidades.Toppers;

import java.util.ArrayList;

public class Registros extends AppCompatActivity {

    RecyclerView listaToppers;
    ArrayList<Toppers> listaArrayToppers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
        listaToppers = findViewById(R.id.listaToppers);
        listaToppers.setLayoutManager(new LinearLayoutManager(this));

        DbToppers dbToppers = new DbToppers(Registros.this);

        listaArrayToppers = new ArrayList<>();

        ListaToppersAdapter adapter = new ListaToppersAdapter(dbToppers.mostrarToppers());

        listaToppers.setAdapter(adapter);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_registro, (Menu) menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuRegistro:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, IngresoTopper.class);
        startActivity(intent);
    }

}