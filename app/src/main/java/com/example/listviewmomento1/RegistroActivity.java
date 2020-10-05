package com.example.listviewmomento1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listviewmomento1.models.StudentModel;
import com.example.listviewmomento1.operations.NotaOperations;
import com.google.android.material.snackbar.Snackbar;

public class RegistroActivity extends AppCompatActivity {

    private NotaOperations NotaOperations;
    private EditText et_registro_nombre, et_registro_trabajo, et_registro_nota, et_registro_mensaje;
    private Button btn_registro_guardar;
    private StudentModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        NotaOperations = new NotaOperations(getApplicationContext());
        et_registro_nombre = findViewById(R.id.et_registro_nombre);
        et_registro_trabajo = findViewById(R.id.et_registro_trabajo);
        et_registro_nota = findViewById(R.id.et_registro_nota);
        et_registro_mensaje = findViewById(R.id.et_registro_mensaje);

        btn_registro_guardar = findViewById(R.id.btn_registro_guardar);

        btn_registro_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, trabajo, nota, mensaje;
                nombre = et_registro_nombre.getText().toString();
                trabajo = et_registro_trabajo.getText().toString();
                nota = et_registro_nota.getText().toString();
                mensaje = et_registro_mensaje.getText().toString();

                model = new StudentModel(nombre, trabajo, nota, mensaje);
                int a = NotaOperations.insertModel(model);
                NotaOperations.close();
                if (a > 0){
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Snackbar.make(v, "¡¡ERROR¡¡ No se guardó", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}

