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
        Toppers topper;
        Cursor cursorToppers;

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

    public Toppers verTopper(int id){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toppers topper = null;
        Cursor cursorToppers;

        cursorToppers = db.rawQuery("SELECT * FROM " + TABLE_TOPPERS + " WHERE id = " + id + " LIMIT 1", null);

        if(cursorToppers.moveToFirst()){
            topper = new Toppers();
            topper.setId(cursorToppers.getInt(0));
            topper.setNombre(cursorToppers.getString(1));
            topper.setDescripcion(cursorToppers.getString(2));
            topper.setPrecio(cursorToppers.getString(3));

        }

        cursorToppers.close();

        return topper;

    }

    public boolean editarTopper(int id, String nombre, String descripcion, String precio){

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_TOPPERS + " SET nombre = '"+ nombre +"', descripcion = '"+ descripcion +"', precio = '"+ precio +"' WHERE id = '"+ id +"' ");
            correcto = true;
        } catch (Exception ex){
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarTopper(int id){

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_TOPPERS + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex){
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

}
