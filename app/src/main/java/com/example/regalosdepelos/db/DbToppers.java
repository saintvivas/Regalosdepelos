package com.example.regalosdepelos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbToppers extends DbHelper {

    Context context;

    public DbToppers(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarTopper(String nombre, String descripcion, String precio){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("descripcion", descripcion);
            values.put("precio", precio);

            id = db.insert(TABLE_TOPPERS, null, values);
        } catch (Exception ex){
            ex.toString();
        }

        return id;
    }

}
