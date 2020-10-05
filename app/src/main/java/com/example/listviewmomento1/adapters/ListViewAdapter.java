package com.example.listviewmomento1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listviewmomento1.R;
import com.example.listviewmomento1.models.StudentModel;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<StudentModel> modelArrayList;
    private StudentModel model;

    public ListViewAdapter(Context context, ArrayList<StudentModel> modelArrayList, StudentModel model) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.model = model;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater layaoutInflater = LayoutInflater.from(this.context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listviewmomento1, parent, false);
            convertView = layaoutInflater.inflate(R.layout.listviewmomento1, parent, false);
        }

        TextView tv_listviewmomento1_nombre, tv_listviewmomento1_trabajo, tv_listviewmomento1_nota, tv_listviewmomento1_mensaje;
        tv_listviewmomento1_nombre = itemView.findViewById(R.id.tv_listviewmomento1_nombre);
        tv_listviewmomento1_trabajo = itemView.findViewById(R.id.tv_listviewmomento1_trabajo);
        tv_listviewmomento1_nota = itemView.findViewById(R.id.tv_listviewmomento1_nota);
        tv_listviewmomento1_mensaje = itemView.findViewById(R.id.tv_listviewmomento1_mensaje);

        model = modelArrayList.get(position);

        String nombreMostrar = model.get_nombre() + " - " ;
        String trabajoMostrar = "Trabajo: " + model.get_trabajo();
        String notaMostrar = "Nota: " + model.get_nota();
        String mensajeMostrar = "Mensaje: " + model.get_mensaje();

        tv_listviewmomento1_nombre.setText(nombreMostrar);
        tv_listviewmomento1_trabajo.setText(trabajoMostrar);
        tv_listviewmomento1_nota.setText(notaMostrar);
        tv_listviewmomento1_mensaje.setText(mensajeMostrar);

        return itemView;


    }
}
