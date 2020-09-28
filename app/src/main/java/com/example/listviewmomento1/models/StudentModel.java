package com.example.listviewmomento1.models;

public class StudentModel {

    private int _id;
    private String nombre;
    private String trabajo;
    private String nota;
    private String mensaje;
    private boolean activo;

    public StudentModel() {
    }

    public StudentModel(String nombre, String trabajo, String nota, String mensaje, boolean activo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.nota = nota;
        this.mensaje = mensaje;
        this.activo = activo;
    }

    public StudentModel(int _id, String nombre, String trabajo, String nota, String mensaje, boolean activo) {
        this._id = _id;
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.nota = nota;
        this.mensaje = mensaje;
        this.activo = activo;
    }

    public StudentModel(String nombre, String trabajo, String nota, String mensaje) {
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", trabajo='" + trabajo + '\'' +
                ", nota='" + nota + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", activo=" + activo +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
