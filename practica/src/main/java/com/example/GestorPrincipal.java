package com.example;

import java.lang.classfile.instruction.StackInstruction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestorPrincipal{

    // Atributos
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    
    GestorPrincipal(){
        em = null;
    }

    public void iniciar(){

        //Creamos el factory
        emf = Persistence.createEntityManagerFactory("contactosPU");

        // a traves del factory con los metodos creamos lo entitymanager
        em = emf.createEntityManager();

    }

    protected void salir(){
        if (em != null) {
            em.close();
        }

        if (emf != null) {
            emf.close();
        }
    }
}