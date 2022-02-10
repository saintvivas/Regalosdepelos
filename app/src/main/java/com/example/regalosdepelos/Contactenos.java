package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Contactenos extends AppCompatActivity {

    ImageButton imageBotonMenu;

    ImageView imageFacebook;
    ImageView imageInstagram;

    private String url2;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactenos);

        imageBotonMenu = findViewById(R.id.imageBotonMenu);

        imageBotonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MenuPrincipal.class);
                startActivity(intent);
            }
        });

        imageFacebook = findViewById(R.id.imageFacebook);
        url = "https://www.facebook.com/regalosdepelos";
        imageFacebook.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imageInstagram = findViewById(R.id.imageInstagram);
        url2 = "https://www.instagram.com/regalosdepelos/";
        imageInstagram.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url2);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

}