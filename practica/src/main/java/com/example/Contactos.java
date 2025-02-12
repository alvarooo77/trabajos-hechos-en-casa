package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contactos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Atributos
    private long id;
    private String nombre;
    private String apellido;
    private int numero = -1;
    private String correo;

    
    public Contactos(String nombre, String apellido, int numero, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.correo = correo;
    }


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


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
