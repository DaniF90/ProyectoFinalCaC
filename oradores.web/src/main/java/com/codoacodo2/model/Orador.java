package com.codoacodo2.model;

/**
 *
 * @author Daniel
 */
import java.util.Date;
import java.sql.Timestamp;



public class Orador {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private String tema;
    private Timestamp fecha_alta;


    public Orador(Integer id_orador, String nombre, String apellido, Integer edad, String email, String tema, Timestamp fecha_alta) {
        this.id = id_orador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.tema = tema;
        this.fecha_alta = fecha_alta;

    }

    public Orador(Integer id_orador, String nombre, String apellido, Integer edad, String email, String tema) {
        this.id = id_orador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.tema = tema;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Timestamp getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Timestamp fecha_alta) {
        this.fecha_alta = fecha_alta;
    }


    
}
