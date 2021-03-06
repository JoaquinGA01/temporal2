package mx.uv.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:mysql://localhost/80640_2021";
    private String username = "root";
    private String password = "";
    private String driverName = "com.mysql.jdbc.Driver";
    private Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Falló la carga de la clase del JDBC");
            e.printStackTrace();
        }
        
        return conn;
    }
}
