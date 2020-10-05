package com.example.listviewmomento1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.listviewmomento1.models.StudentModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    TextView tv_detalle_informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_detalle_informacion = findViewById(R.id.tv_detalle_informacion);

        StudentModel result = (StudentModel) getIntent().getSerializableExtra("item");

        String nombreMostrar ="Nombre: " +result.get_nombre();
        String trabajoMostrar = "Trabajo: " + result.get_trabajo();
        String notaMostrar = "Nota: " + result.get_nota();
        String mensajeMostrar = "Mensaje: " + result.get_mensaje();

        tv_detalle_informacion.setText("Detalle: \n\n" + nombreMostrar + "\n" +trabajoMostrar
                + "\n" +notaMostrar + "\n" +mensajeMostrar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
