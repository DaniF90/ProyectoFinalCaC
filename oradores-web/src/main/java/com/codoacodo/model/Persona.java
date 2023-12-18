package com.codoacodo.model;

public class Persona {
    
    protected long id;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String email;
    
    public Persona(){}
    
    public Persona(String n, String a) {
        this.nombre = n;
        this.apellido = a;
    }
    
    public Persona(long i, String n, String a, Integer e, String m) {
        this.id = i;
        this.nombre = n;
        this.apellido = a;
        this.edad = e;
        this.email = m;
    }
    
    public Persona(String n, String a, Integer e, String m) {
        this.nombre = n;
        this.apellido = a;
        this.edad = e;
        this.email = m;
    }
    
    //setter de id
    public void setId(long i) {
        this.id = i;
    }
    
    //getter de id
    public long getId() {
        return id;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer Edad) {
        this.edad = edad;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Persona {" + "id= " + id + ", nombre= " + nombre + ", apellido= " + apellido + ", edad= " + edad + '}';
    }

}
