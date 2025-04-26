package Clases;

import java.sql.*;
import javax.swing.JOptionPane;

public class Usuarios {
    private int id;
    private String nombre, contraseña;

    // Getters y Setters
    
    public void guardarUsuario() {
        try (Connection con = Conexion.getConnection()) {
            String sql = "INSERT INTO Usuarios VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, contraseña);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Usuario guardado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
