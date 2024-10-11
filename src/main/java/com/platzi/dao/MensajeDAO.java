package com.platzi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.platzi.database.Conexion;
import com.platzi.model.Mensaje;

public class MensajeDAO {

    public static void crearMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.getConnection()){

            PreparedStatement preparedStatement = null;

            try{

                String query = "INSERT INTO `mensajes` (`fk_usuario`, `mensaje`, `autor_mensaje` ) VALUES (?, ?, ?);";

                preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setInt(1, mensaje.getId_usuario());
                preparedStatement.setString(2, mensaje.getMensaje());
                preparedStatement.setString(3, mensaje.getAutor_mensaje());

                preparedStatement.executeUpdate();
                System.out.println("Mensaje creado");

            }catch (SQLException e){
                e.printStackTrace();
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static String leerMensajesDB(){

        //Creamos el string a retornar
        StringBuilder mensajesDB = new StringBuilder();
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
                    mensajesDB.append(
                            "\nID: " + rs.getInt("id_mensaje") + "\n" +
                            "Autor: " + rs.getString("autor_mensaje") + "\n" +
                            "Contenido: " + rs.getString("mensaje") + "\n" +
                            "Fecha: " + rs.getString("fecha_mensaje") + "\n"
                    );
                }

            } catch(SQLException e){
                e.printStackTrace(); //Crear un mensaje que notifique que no se puede ejecutar la consulta
            }

        } catch(SQLException e){
            e.printStackTrace(); //Crear un mensaje que notifique que no se ha podido acceder a la base de datos
        }

        return mensajesDB.toString();

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
