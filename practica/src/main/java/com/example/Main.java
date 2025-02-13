package com.example;

import java.util.List;
import java.util.Scanner;

import javax.naming.ldap.ControlFactory;

public class Main {

    private static GestorContactos miGestorContactos;
    private static GestorPrincipal miGestorPrincipal;

    public static void main(String[] args) {
    
        miGestorPrincipal = new GestorPrincipal();
        miGestorPrincipal.iniciar();
        miGestorContactos = new GestorContactos();

        menuPpal();

        miGestorPrincipal.salir();
    }

    private static void menuPpal() {

        String opcion = null;
        Scanner teclado = new Scanner(System.in);

        do {
            mostrarOpcionesPpal();
            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    menuCrear(teclado);
                    break;

                case "2":
                    menuLeer(teclado);
                    break;

                case "3":
                    menuActualizar(teclado);
                    break;

                case "4":
                    menuBorrar(teclado);
                    break;

                case "5":
                    menuLeerTodos();
                    break;
                default:
                    break;
            }
        } while (!opcion.equals("6"));

    }

    private static void menuCrear(Scanner teclado) {
        System.out.println("***   MENU INSERTAR CONTACTO   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce nombre Contacto: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce Apellido contacto: ");
        String apellido = teclado.nextLine();

        System.out.print("Introduce numero contacto: ");
        int numero = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Introduce correo contacto: ");
        String correo = teclado.nextLine();

        

        miGestorContactos.create(nombre, apellido, numero, correo);
        System.out.println();
    }

    private static void menuLeer(Scanner teclado) {
        System.out.println("***   MENU LEER CONTACTO   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Contacto a leer: ");
        Long id = teclado.nextLong();
        teclado.nextLine();
        System.out.println(miGestorContactos.leer(id));
    }

    private static void menuActualizar(Scanner teclado) {
        System.out.println("***   MENU ACTUALIZAR CONTACTO   ***");
        System.out.println("--------------------------------");
        System.out.println("INTRODUCE ID DEL CONTACTO A ACTUALIZAR");
        Long id = teclado.nextLong();
        teclado.nextLine();
        Contactos miContacto = miGestorContactos.leer(id);
        System.out.println("Introduce elemento a actualizar o ENTER para no actualizarlo");

        System.out.print("Introduce nombre contacto: ");
        String nombre = teclado.nextLine();
        if (!nombre.equals(""))
            miContacto.setNombre(nombre);

        System.out.print("Introduce Apellido cliente: ");
        String apellido = teclado.nextLine();
        if (!apellido.equals(""))
            miContacto.setApellido(apellido);

        System.out.print("Introduce numero cliente: ");
        int numero = teclado.nextInt();
        if (numero!=0) miContacto.setNumero(numero);

        System.out.print("Introduce correo cliente: ");
        String correo = teclado.nextLine();
        if (!correo.equals(""))
            miContacto.setCorreo(correo);
       
        
        miGestorContactos.update(miContacto.getId(), miContacto.getNombre(), miContacto.getApellido(),
        miContacto.getNumero(), miContacto.getCorreo());
        System.out.println();

    }

    private static void menuBorrar(Scanner teclado) {
        System.out.println("***   MENU BORRAR CONTACTO   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Contacto a borrar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();
        miGestorContactos.delete(id);
    }

    public static void menuLeerTodos() {
        List<Contactos> listado = miGestorContactos.readAll();

        for (Contactos contactos : listado) {
            System.out.println(contactos);

        }

    }

    private static void mostrarOpcionesPpal() {
        System.out.println("***   INTRODUCE OPCION:   ***");
        System.out.println("-----------------------------");
        System.out.println("1) Introducir Contacto");
        System.out.println("2) Mostrar Contacto");
        System.out.println("3) Modificar Contacto");
        System.out.println("4) Borrar Contacto");
        System.out.println("5) Mostrar todos los Contactos");
        System.out.println("6) SALIR");
    }
}