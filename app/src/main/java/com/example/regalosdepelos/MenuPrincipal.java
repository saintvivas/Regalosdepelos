package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    private Button botonUbicanos;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        botonUbicanos = findViewById(R.id.botonUbicanos);
        url = "https://www.google.com/maps/place/Regalos+de+Pelos+corte+y+grabado+laser/@2.4590285,-76.5964732,17z/data=!4m5!3m4!1s0x8e300320785da1b5:0x2a74793454922555!8m2!3d2.460294!4d-76.5957962";
        botonUbicanos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    public void abrirCatalogo(View view) {
        Intent intent = new Intent(this, Catalogo.class);
        startActivity(intent);
    }

    public void abrirContactenos(View view) {
        Intent intent = new Intent(this, Contactenos.class);
        startActivity(intent);
    }

    public void abrirOfertas(View view) {
        Intent intent = new Intent(this, Ofertas.class);
        startActivity(intent);
    }
}