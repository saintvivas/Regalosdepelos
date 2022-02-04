package com.example.regalosdepelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.regalosdepelos.db.DbToppers;

public class IngresoTopper extends AppCompatActivity {

    EditText txtNombre, txtDescripcion, txtPrecio;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_topper);

        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtPrecio = findViewById(R.id.txtPrecio);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbToppers dbToppers = new DbToppers(IngresoTopper.this);
                long id = dbToppers.insertarTopper(txtNombre.getText().toString(), txtDescripcion.getText().toString(), txtPrecio.getText().toString());

                if(id > 0){
                    Toast.makeText(IngresoTopper.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else{
                    Toast.makeText(IngresoTopper.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
    }

}