package com.platzi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== Crear un mensaje =====");

        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Escribe tu nombre: ");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajeDAO.crearMensajeDB(registro);

    }

    public static void listarMensajes(){
        System.out.println();
        MensajeDAO.leerMensajesDB(); //Realmente no deberían haber prints en la clase MensajeDAO, pero esto es más práctico
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIndica el ID del mensaje a borrar: ");
        int idSeleccionado = Integer.parseInt(sc.nextLine());

        MensajeDAO.borrarMensajeDB(idSeleccionado);
    }

    public static void editarMensaje(){}
}
