package com.platzi.service;

import com.platzi.dao.UsuarioDAO;
import com.platzi.model.Usuario;

import java.util.Scanner;

public class UsuarioService {

    public static Usuario registrarse() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nRegistrarse\n");

        System.out.println("Digite su nombre completo:");
        String nombreCompleto = sc.nextLine();

        System.out.println("Digite su nombre de usuario:");
        String username = sc.nextLine();

        System.out.println("Digite su contraseña:");
        String password = sc.nextLine();

        Usuario usuarioProceso = new Usuario();
        usuarioProceso.setFull_name(nombreCompleto);
        usuarioProceso.setUsername(username);
        usuarioProceso.setPassword(password);

        UsuarioDAO.crearUsuarioDb(usuarioProceso);

        return usuarioProceso;

    }

    public static Usuario iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        Usuario usuarioProceso = null;

        boolean finalizarProceso = false;

        System.out.println("Digite su nombre de usuario:");
        String username = sc.nextLine();

        System.out.println("Digite su contraseña:");
        String password = sc.nextLine();

        usuarioProceso = UsuarioDAO.validarUsuario(username, password);

        return usuarioProceso;
    }
}
