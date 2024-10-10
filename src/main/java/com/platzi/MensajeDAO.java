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

        Conexion conexion = new Conexion();
        try (Connection connectionDb = conexion.getConnection()){

            PreparedStatement ps = null;

            try {

                String query = "DELETE FROM mensajes WHERE id_mensaje = ?;";

                ps = connectionDb.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();

                System.out.println("\nEl mensaje ha sido eliminado con éxito");

            } catch(SQLException e){
                e.printStackTrace(); //Mensaje en caso de que no se pueda borrar el mensaje
            }

        } catch(SQLException e){
            e.printStackTrace(); //Mensaje en caso de que no se pueda establecer la conexión con la DB
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje){

        Conexion conexion = new Conexion();

        try(Connection connectionDb = conexion.getConnection()){

            PreparedStatement ps = null;

            try {

                String query = "UPDATE mensajes set mensaje = ? WHERE id_mensaje = ?;";

                ps = connectionDb.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();

                System.out.println("\nEl mensaje ha sido actualizado con éxito");

            } catch(SQLException e) {
                e.printStackTrace(); // Mostrar mensaje en caso de que no se haya podido realizr la modificacióon del mensaje
            }
        } catch(SQLException e){
            e.printStackTrace(); // Mostrar mensaje en caso de que no se pueda realizar la conexión con la DB
        }

    }
}
