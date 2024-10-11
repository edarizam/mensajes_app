package com.platzi.dao;

import com.platzi.model.Usuario;
import com.platzi.database.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class UsuarioDAO {

    private static final String cantConnectDatabase = "No se ha podido realizar la conexión con base de datos";
    private static final String cantCreateUser = "No se ha podido realizar la consulta de crear un nuevo usuario";
    private static final String cantFindUser = "No se ha podido realizar la consulta de búsqueda de usuario";
    private static final String cantEditPassword = "No se ha podido realizar la consulta de cambio de contraseña";

    public static void crearUsuarioDb(Usuario usuario) {

        //Creamos un objeto de tipo conexión
        Conexion conexion = new Conexion();

        try (Connection connectionDb = conexion.getConnection()) {
            //Definimos un preparedStatement para realizar la consulta
            PreparedStatement ps = null;

            try {
                //Creamos el cuerpo de la consulta
                String query = "INSERT INTO `usuarios` (`username`, `password`, `full_name`) VALUES (?, ?, ?);";


                //Creamos el preparedStatement y asignamos sus valores
                ps = connectionDb.prepareStatement(query);
                ps.setString(1, usuario.getUsername());
                ps.setString(2, usuario.getPassword());
                ps.setString(3, usuario.getFull_name());

                //Ejecutamos la consulta
                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println(cantCreateUser);
            }

        } catch (SQLException e) {
            System.out.println(cantConnectDatabase);
        }

    }

    public static Usuario validarUsuarioDB(String username, String password) {
        Conexion conexion = new Conexion();
        Usuario usuarioEncontrado = null;

        try(Connection connectionDb = conexion.getConnection()){
            PreparedStatement ps = null;

            try {
                String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?;";

                ps = connectionDb.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId_usuario(rs.getInt("id_usuario"));
                    usuarioEncontrado.setUsername(rs.getString(("username")));
                    usuarioEncontrado.setPassword(rs.getString("password"));
                    usuarioEncontrado.setFull_name(rs.getString("full_name"));

                }

            } catch (SQLException e){
                System.out.println(cantFindUser);
            }
        } catch(SQLException e){
            System.out.println(cantConnectDatabase);
        }

        return usuarioEncontrado;

    }

    public static void editarContraseniaUsuarioDB(String password, String username) {
        Conexion conexion = new Conexion();

        try (Connection connectionDb = conexion.getConnection()) {

            PreparedStatement ps = null;

            try{

                String query = "UPDATE usuarios SET password = ? WHERE username = ?;";

                ps = connectionDb.prepareStatement(query);
                ps.setString(1, password);
                ps.setString(2, username);

                ps.executeUpdate();

            } catch(SQLException e){
                System.out.println(cantEditPassword);
            }

        } catch(SQLException e){
            System.out.println(cantConnectDatabase);
        }
    }
}
