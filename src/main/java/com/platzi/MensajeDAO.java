package com.platzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajeDAO {

    public static void crearMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.getConnection()){

            PreparedStatement preparedStatement = null;

            try{

                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?);";
                preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setString(1, mensaje.getMensaje());
                preparedStatement.setString(2, mensaje.getAutor_mensaje());
                preparedStatement.executeUpdate();
                System.out.println("Mensaje creado");

            }catch (SQLException e){
                e.printStackTrace();
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void leerMensajeDB(){

    }

    public static void borrarMensajeDB(int id_mensaje){

    }

    public static void actualizarMensajeDB(Mensaje mensaje){

    }
}
