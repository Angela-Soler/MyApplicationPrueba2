package com.finsol.myapplicationprueba.tablas;

public class Transacciones {
    //Nombre de la Base de Datos
    public static final String NameDatabase = "PM01DB";

    /*Creacion de la base de Datos*/
    public static final String TablaPersona = "personas";

    /*Creación de la tabla personas*/
    public static final String id = "id";
    public static final String nombres = "nombre";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";

    //DDL
    public static final String createTablePersona = "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT, apellidos TEXT, edad INTEGER, correo TEXT)";

    public static final String GetPersona = "SELECT * FROM "+Transacciones.TablaPersona;

    public static final String DropTablePersona = "DROP TABLE IF EXISTS personas";

}

