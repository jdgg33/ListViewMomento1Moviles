package com.example.listviewmomento1.models;

import java.io.Serializable;

public class StudentModel implements Serializable {

    private int _id;
    private String _nombre;
    private String _trabajo;
    private String _nota;
    private String _mensaje;
    private boolean _activo;


    public StudentModel(String _nombre, String _trabajo, String _nota, String _mensaje) {
        this._nombre = _nombre;
        this._trabajo = _trabajo;
        this._nota = _nota;
        this._mensaje = _mensaje;

    }

    public StudentModel(int _id, String _nombre, String _trabajo, String _nota, String _mensaje) {

        this._id = _id;
        this._nombre = _nombre;
        this._trabajo = _trabajo;
        this._nota = _nota;
        this._mensaje = _mensaje;
    }

    public StudentModel(int _id, String _nombre, String _trabajo, String _nota, String _mensaje, boolean _activo) {

        this._id = _id;
        this._nombre = _nombre;
        this._trabajo = _trabajo;
        this._nota = _nota;
        this._mensaje = _mensaje;
        this._activo = _activo;
    }

    public StudentModel(String trabajo, String nota, String mensaje) {
        this._nombre = _nombre;
        this._trabajo = _trabajo;
        this._nota = _nota;
        this._mensaje = _mensaje;
    }

    public StudentModel() {
        this._activo = true;
    }



    @Override
    public String toString() {
        return "StudentModel{" +
                "_id=" + _id +
                ", nombre='" + _nombre + '\'' +
                ", trabajo='" + _trabajo + '\'' +
                ", nota='" + _nota + '\'' +
                ", mensaje='" + _mensaje + '\'' +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_trabajo() {
        return _trabajo;
    }

    public void set_trabajo(String _trabajo) {
        this._trabajo = _trabajo;
    }

    public String get_nota() {
        return _nota;
    }

    public void set_nota(String _nota) {
        this._nota = _nota;
    }

    public String get_mensaje() {
        return _mensaje;
    }

    public void set_mensaje(String _mensaje) {
        this._mensaje = _mensaje;
    }

    public boolean is_activo() {
        return _activo;
    }

    public void set_activo(boolean _activo) {
        this._activo = _activo;
    }
}
