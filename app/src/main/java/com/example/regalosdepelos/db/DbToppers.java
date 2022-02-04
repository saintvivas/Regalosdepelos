package com.example.regalosdepelos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.regalosdepelos.entidades.Toppers;

import java.util.ArrayList;

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

    public ArrayList<Toppers> mostrarToppers(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Toppers> listaToppers = new ArrayList<>();
        Toppers topper = null;
        Cursor cursorToppers = null;

        cursorToppers = db.rawQuery("SELECT * FROM " + TABLE_TOPPERS, null);

        if(cursorToppers.moveToFirst()){
            do{
                topper = new Toppers();
                topper.setId(cursorToppers.getInt(0));
                topper.setNombre(cursorToppers.getString(1));
                topper.setDescripcion(cursorToppers.getString(2));
                topper.setPrecio(cursorToppers.getString(3));
                listaToppers.add(topper);
            } while (cursorToppers.moveToNext());
        }

        cursorToppers.close();

        return listaToppers;

    }

}
