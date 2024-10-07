package com.platzi;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Conexion conexion = new Conexion();
        int opcionMenu = 0;

        do{
            System.out.println("\n========================");
            System.out.println("Aplicación de Mensajes");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensaje");
            System.out.println("3. Editar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Salir");
            System.out.println("Selecciona una opción: ");
            opcionMenu = Integer.parseInt(sc.nextLine());

            switch (opcionMenu) {
                case 1:
                    MensajeService.crearMensaje();
                    break;

                case 2:
                    MensajeService.listarMensajes();
                    break;

                case 3:
                    MensajeService.editarMensaje();
                    break;

                case 4:
                    MensajeService.borrarMensaje();
                    break;

                case 5:
                    System.out.println("\nHasta luego, feliz día");
                    break;

                default:
                    System.out.println("Digite una opción válida entre las disponibles");

            }

        }while(opcionMenu != 5);

    }
}