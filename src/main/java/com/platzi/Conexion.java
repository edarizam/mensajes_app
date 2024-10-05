package com.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection getConnection(){
        Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");

            if (conection != null){
                System.out.println("Conexión Exitosa");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return conection;
    }
}
