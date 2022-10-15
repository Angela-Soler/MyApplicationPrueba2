package com.finsol.myapplicationprueba.tablas;

import android.app.Person;

public class Personas {
    public Integer id;
    public String nombre;
    public String apellidos;
    public Integer edad;
    public String correo;

    //Constructor de la clase
    public Personas(){
        //Todo
    }

    public Personas(Integer id, String nombre, String apellidos, Integer edad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



}
