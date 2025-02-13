package com.example;

import java.util.List;

public class GestorContactos {
     
    // CRUD

    //Crear
    public void create(String nombre, String apellido, int numero, String correo){
        Contactos nuevoContacto = new Contactos(nombre, apellido, numero, correo);
        GestorPrincipal.em.getTransaction().begin();
        GestorPrincipal.em.persist(nuevoContacto);
        GestorPrincipal.em.getTransaction().commit();
    }

    //leer
    public Contactos leer(long id){

        return GestorPrincipal.em.find(Contactos.class,id);
    }

    //actualizar
    public void update(long id, String nombre, String apellido, int numero, String correo) {
        Contactos miContactos = GestorPrincipal.em.find(Contactos.class, id);
        if (nombre != null)
            miContactos.setNombre(nombre);
        if (apellido != null)
            miContactos.setApellido(apellido);
        if (numero != -1)
            miContactos.setNumero(numero);
        if (correo != null)
            miContactos.setCorreo(correo);

        GestorPrincipal.em.getTransaction().begin();
        GestorPrincipal.em.merge(miContactos);
        GestorPrincipal.em.getTransaction().commit();
    }

    //borrar
    public void delete(Long id) {

        GestorPrincipal.em.getTransaction().begin();
        GestorPrincipal.em.remove(GestorPrincipal.em.find(Contactos.class, id));
        GestorPrincipal.em.getTransaction().commit();

    }

    public List<Contactos> readAll() {

        GestorPrincipal.em.getTransaction().begin();

        List<Contactos> contactos = GestorPrincipal.em.createQuery("SELECT c FROM Contactos c", Contactos.class)
                .getResultList();

        GestorPrincipal.em.getTransaction().commit();
        return contactos;

    }
}
