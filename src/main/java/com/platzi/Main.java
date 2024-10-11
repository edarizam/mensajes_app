package com.platzi;

import java.util.Scanner;

import com.platzi.database.Conexion;
import com.platzi.service.MensajeService;
import com.platzi.service.UsuarioService;
import com.platzi.model.Usuario;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Conexion conexion = new Conexion();
        int opcionMenu = 0;
        boolean sesionIniciada = false;
        Usuario usuarioProceso = null;

        System.out.println("Bienvenido al sistema de mensajería\n");

        do{
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("Digite una opción válida entre las disponibles:");

            try{
                opcionMenu = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Error, debe digitar un único valor numérico entre los disponibles");
                continue;
            }

            switch (opcionMenu){
                case 1:
                    usuarioProceso = UsuarioService.iniciarSesion();

                    if (usuarioProceso == null){
                        System.out.println("\nNo se ha podido realizar el inicio de sesión correctamente\n");
                    }

                    break;

                case 2:
                    usuarioProceso = UsuarioService.registrarse();

                    break;

                default:
                    System.out.println("Error, debe digitar un único valor numérico entre los disponibles");
            }

            if (usuarioProceso != null) {
                sesionIniciada = true;
            }

        } while(!sesionIniciada);

        System.out.println("\nBienvenid@ " + usuarioProceso.getUsername());

        do{
            opcionMenu = 0;

            System.out.println("\n========================");
            System.out.println("Aplicación de Mensajes");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensaje");
            System.out.println("3. Editar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Cambiar contraseña");
            System.out.println("6. Eliminar cuenta");
            System.out.println("7. Salir");
            System.out.println("Selecciona una opción: ");

            try {
                opcionMenu = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error, debe ingresar un único valor numérico entre los disponibles");
                continue;
            }

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
                    UsuarioService.cambiarContrasenia(usuarioProceso);
                    break;

                case 6:
                    UsuarioService.eliminarUsuario(usuarioProceso);
                    break;

                case 7:
                    System.out.println("\nHasta luego, feliz día");
                    break;

                default:
                    System.out.println("Digite una opción válida entre las disponibles");

            }

        }while(opcionMenu != 6 && opcionMenu != 7);

    }
}