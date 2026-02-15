/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author LABORATORIOS
 */
public class ConexionDB {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String DRIVER;
    
    static {
        try(InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("db.properties")){
            Properties props = new Properties();
            if(input == null){
                throw new RuntimeException("No se lograron cargar las variables del entorno");
            }
            props.load(input);
            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");
            DRIVER = props.getProperty("db.driver");
            Class.forName(DRIVER);
        }catch(IOException | ClassNotFoundException ex){
            throw new RuntimeException("Error al configurar las variables de entorno");
        }
    }
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
