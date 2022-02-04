package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contactenos extends AppCompatActivity {

    private Button botonFacebook;
    private Button botonInstagram;
    private String url2;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactenos);

        botonFacebook = findViewById(R.id.botonFacebook);
        url = "https://www.facebook.com/regalosdepelos";
        botonFacebook.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        botonInstagram = findViewById(R.id.botonInstagram);
        url2 = "https://www.instagram.com/regalosdepelos/";
        botonInstagram.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url2);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    public void abrirMenu(View view) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}