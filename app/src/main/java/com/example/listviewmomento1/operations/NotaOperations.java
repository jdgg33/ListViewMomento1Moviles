package com.example.listviewmomento1.operations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.listviewmomento1.database.SQLHelper;
import com.example.listviewmomento1.models.StudentModel;

import java.util.ArrayList;

public class NotaOperations {

    private String BDName = "appNotasmomyApp.db";
    private int VERSION = 1;
    public final Context context;
    private SQLiteDatabase database;
    private SQLHelper helper;
    private StudentModel model;
    private ArrayList<String> list;

    public NotaOperations(Context context) {
        this.context = context;
        helper = new SQLHelper(context, BDName, null, VERSION);
    }

    public void openRead(){
        database = helper.getReadableDatabase();
    }

    public void openWrite(){
        database = helper.getWritableDatabase();
    }

    public void closed(){
        database.close();
    }

    public int insert(StudentModel model){

        ContentValues content = new ContentValues();
        content.put("nombre", model.getNombre());
        content.put("trabajo", model.getTrabajo());
        content.put("nota", model.getNota());
        content.put("mensaje", model.getMensaje());

        openWrite();

        long id = database.insert("Notas", null, content);

        closed();
        return (int)id;
    }

    public ArrayList<String> list(){
        list = new ArrayList<>();
        openRead();

        Cursor cursor = database.query("Nota", null, null, null, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            int id;
            String nombre, trabajo, nota, mensaje, consolidado;

            do{
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                trabajo = cursor.getString(cursor.getColumnIndex("trabajo"));
                nota = cursor.getString(cursor.getColumnIndex("nota"));
                mensaje = cursor.getString(cursor.getColumnIndex("mensaje"));

                consolidado = String.valueOf(id) + "-" + nombre;
                list.add(consolidado);


            }while (cursor.moveToNext());
        }

        closed();
        return list;
    }
}
