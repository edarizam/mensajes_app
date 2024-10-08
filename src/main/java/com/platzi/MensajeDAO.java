package com.platzi;

import javax.crypto.spec.PSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static void leerMensajesDB(){
        //Creamos un objeto de conexión para realizar la conexion a la base de datos
        Conexion conexion = new Conexion();

        //Definimos la variables a usar
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Creamos una conexion a la base de datos por medio de la clase que obtiene la conexion
        try(Connection conexionBD = conexion.getConnection()){

            //Es una buena práctica definir un try aisaldo que controle únicamente cierto tipo de excepción para generar un log apropiado según el error ocurrido
            try{
                //Definimos el query a usar
                String query = "SELECT * FROM mensajes";

                //Asignamos un preparedStatement según el RDBMS al que nos estamos conectando
                ps = conexionBD.prepareStatement(query);

                //Asignamos al resultSet el retorno de la ejecución del query
                rs = ps.executeQuery();

                //Imprimos en pantalla el resultSet obtenido
                while(rs.next()){
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("Contenido: " + rs.getString("mensaje"));
                    System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                    System.out.println();
                }

            } catch(SQLException e){
                e.printStackTrace(); //Crear un mensaje que notifique que no se puede ejecutar la consulta
            }

        } catch(SQLException e){
            e.printStackTrace(); //Crear un mensaje que notifique que no se ha podido acceder a la base de datos
        }

    }

    public static void borrarMensajeDB(int id_mensaje){

    }

    public static void actualizarMensajeDB(Mensaje mensaje){

    }
}
