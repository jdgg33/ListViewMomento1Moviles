package com.example.listviewmomento1.operations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.listviewmomento1.database.SQLHelper;
import com.example.listviewmomento1.models.StudentModel;

import java.util.ArrayList;

public class NotaOperations {

    private String BDName = "appNotasmyApp.db";
    private String NOMBRE_TABLA = "Notas";
    private int VERSION = 1;
    public final Context context;
    private SQLiteDatabase database;
    private SQLHelper helper;
    private StudentModel model;
    private ArrayList<StudentModel> list;

    public NotaOperations(Context context) {
        this.context = context;
        helper = new SQLHelper(context, BDName, null, VERSION);
    }

    public static ArrayList<StudentModel> selectAll() {
            return null;
    }

    public static void close() {

    }

    public void openRead() {
        database = helper.getReadableDatabase();
    }

    public void openWrite() {
        database = helper.getWritableDatabase();
    }

    public void closed() {
        database.close();
    }

    public int insert(StudentModel model) {
        try {
            ContentValues values = new ContentValues();
            values.put("Nombre", model.get_nombre());
            values.put("Trabajo", model.get_trabajo());
            values.put("Nota", model.get_nota());
            values.put("Mensaje", model.get_mensaje());
            values.put("Activo", (model.is_activo()) ? 1 : 0);

            openWrite();

            long id = database.insert("Notas", null, values);

            closed();
            return (int) id;

        } catch (Exception e) {
            String TAG = "MyActivity";
            Log.i(TAG, "e " + e);
            return -1;
        }
    }

    public ArrayList<StudentModel> list() {
        list = new ArrayList<StudentModel>();

        try {
            openRead();
            Cursor cursor = database.query("Nota", null, null, null, null, null, null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    int id;
                    String nombre, trabajo, nota, mensaje;


                    id = cursor.getInt(cursor.getColumnIndex("id"));
                    nombre = cursor.getString(cursor.getColumnIndex("Nombre"));
                    trabajo = cursor.getString(cursor.getColumnIndex("Trabajo"));
                    nota = cursor.getString(cursor.getColumnIndex("Nota"));
                    mensaje = cursor.getString(cursor.getColumnIndex("Mensaje"));

                    model = new StudentModel(id, nombre, trabajo, nota, mensaje);
                    list.add(model);

                } while (cursor.moveToNext());
            }
            return list;

        } catch (Exception e) {
            return list;
        }
    }

    public ArrayList<String> selectAllString() {
        ArrayList<String> list = new ArrayList<>();
        try {
            openRead();
            Cursor cursor = database.query("Notas", null, null, null, null, null, null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    int id;
                    String nombre, trabajo, nota, mensaje;

                    id = cursor.getInt(cursor.getColumnIndex("id"));
                    nombre = cursor.getString(cursor.getColumnIndex("Nombre"));
                    trabajo = cursor.getString(cursor.getColumnIndex("Trabajo"));
                    nota = cursor.getString(cursor.getColumnIndex("Nota"));
                    mensaje = cursor.getString(cursor.getColumnIndex("Mensaje"));

                    model = new StudentModel(id, nombre, trabajo, nota, mensaje);
                    list.add(model.toString());

                } while (cursor.moveToNext());
            }
            return list;

        } catch (Exception e) {
            return list;
        }
    }


    public int delete(int id) {
        try {
            String idString = String.valueOf(id);
            String sqlWhere = "id = ?";
            String[] whereArgs = new String[]{idString};

            openWrite();
            return database.delete("Notas", sqlWhere, whereArgs);

        } catch (Exception e) {
            return -1;
        }
    }

    public int updateModel(StudentModel model) {
        try {
            String idString = String.valueOf(model.get_id());
            String sqlWhere = "id = ?";
            String[] whereArgs = new String[]{idString};

            ContentValues values = new ContentValues();
            values.put("Nombre", model.get_nombre());
            values.put("Trabajo", model.get_trabajo());
            values.put("Nota", model.get_nota());
            values.put("Mensaje", model.get_mensaje());

            openWrite();
            return database.update("Notas", values, sqlWhere, whereArgs);

        } catch (Exception e) {
            return -1;
        }
    }

    public int insertModel(StudentModel model) {
            return 0;
    }
}
