package com.platzi.service;

import java.util.Scanner;

import com.platzi.model.Mensaje;
import com.platzi.dao.MensajeDAO;

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
        System.out.println(MensajeDAO.leerMensajesDB());
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIndica el ID del mensaje a borrar: ");
        int idSeleccionado = Integer.parseInt(sc.nextLine());

        MensajeDAO.borrarMensajeDB(idSeleccionado);
    }

    public static void editarMensaje(){

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== Editar un mensaje =====");

        System.out.println("Digite el ID del mensaje a edtiar:");
        int idMensaje = Integer.parseInt(sc.nextLine());

        System.out.println("Escribe tu nuevo mensaje: ");
        String mensaje = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setId_mensaje(idMensaje);

        MensajeDAO.actualizarMensajeDB(registro);

    }
}
