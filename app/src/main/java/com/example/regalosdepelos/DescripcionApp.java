package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DescripcionApp extends AppCompatActivity {

    ImageButton imageBotonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_app);

        imageBotonMenu = findViewById(R.id.imageBotonMenu);

        imageBotonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MenuPrincipal.class);
                startActivity(intent);
            }
        });

    }
}