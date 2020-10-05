package com.example.listviewmomento1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listviewmomento1.adapters.ListViewAdapter;
import com.example.listviewmomento1.models.StudentModel;
import com.example.listviewmomento1.operations.NotaOperations;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StudentModel model;
    private NotaOperations operations;
    private TextView uno;
    private ArrayList<StudentModel> list;


    private FloatingActionButton fab_main_nuevo;
    private ListView lv_main_contactos;
    private NotaOperations NotaOperation;

    private ListViewAdapter adapter;
    private Object NotaOperations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        uno = findViewById(R.id.uno);
        String nombre = "Nombre del Estudiante";
        String trabajo = "Trabajo de la nota";
        String nota = "Nota del trabajo";
        String mensaje = "Mensaje de la nota";

        fab_main_nuevo = findViewById(R.id.fab_main_nuevo);
        lv_main_contactos = findViewById(R.id.lv_main_contactos);
        NotaOperations = new NotaOperations(getApplicationContext());

        list = ((com.example.listviewmomento1.operations.NotaOperations) NotaOperations).selectAll();
        ((com.example.listviewmomento1.operations.NotaOperations) NotaOperations).close();

        adapter = new ListViewAdapter (list, getApplicationContext());

        lv_main_contactos.setAdapter(adapter);

        lv_main_contactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentModel seleccionado = list.get(position);
                Intent detalle = new Intent(MainActivity.this, DetalleActivity.class);
                detalle.putExtra("item", seleccionado);
                startActivity(detalle);

            }
        });

        fab_main_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        operations = new NotaOperations(this);

        boolean activo = false;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class DetalleActivity extends AppCompatActivity {

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


}
    
