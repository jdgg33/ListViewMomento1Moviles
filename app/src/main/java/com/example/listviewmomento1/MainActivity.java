package com.example.listviewmomento1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listviewmomento1.models.StudentModel;
import com.example.listviewmomento1.operations.NotaOperations;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StudentModel model;
    private NotaOperations operations;
    private TextView uno;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno = findViewById(R.id.uno);
        String nombre = "Nombre del Estudiante";
        String trabajo = "Trabajo de la nota";
        String nota = "Nota del trabajo";
        String mensaje = "Mensaje de la nota";

        operations = new NotaOperations(this);

        model = new StudentModel(nombre, trabajo, nota, mensaje);
        int r = operations.insert(model);
        if (r>0) {
            Toast.makeText(this, "Guardado Correctamente", Toast.LENGTH_LONG).show();
            uno.setText(String.valueOf(r));
        }else{
            Toast.makeText(this, "No se Guardo Correctamente", Toast.LENGTH_LONG).show();
        }

        String consolidadoMostrar = "";
        list = operations.list();
        for (int i = 0; i < list.size(); i++){
            consolidadoMostrar = list.get(i) + "\n----------\n\n";
        }

        uno.setText(consolidadoMostrar);
    }
}