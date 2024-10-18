package com.nexsysprueba.ws.rest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nexsysprueba.ws.rest.DB.DatabaseConnection;

public class ProductDAO {
	
	public ProductDAO() {
	}
	public int saveProduct(String name, double price, int categoryId, String imageUrl) {
        String sql = "INSERT INTO producto_nexsys (name, buy_price, categoty_platzi, image) VALUES (?, ?, ?, ?)";
        int generatedId = -1;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            // Configurar los parámetros
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, categoryId);
            stmt.setString(4, imageUrl);

            // Ejecutar la inserción
            int affectedRows = stmt.executeUpdate();

            // Verificar si se generó un ID
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }
}
