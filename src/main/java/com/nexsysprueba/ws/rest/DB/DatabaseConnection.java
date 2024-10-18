package com.nexsysprueba.ws.rest.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://nexsyspruebasvr.czy4awoekwxe.us-east-2.rds.amazonaws.com:3306/nexsys_marketplace";
    private static final String USER = "admin";
    private static final String PASSWORD = "NexsysPrueba2024";
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el controlador MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Error al registrar el driver MySQL");
        }

        // Obtener y devolver la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
