package Clases;

import java.sql.*;
import javax.swing.JOptionPane;

public class Clientes {
    private int id;
    private String nombre, apellido, telefono, direccion, email, fechaNacimiento;

    // Getters y Setters (Alt + Insert en NetBeans)
    
    public void guardarCliente() {
        try (Connection con = Conexion.getConnection()) {
            String sql = "INSERT INTO Clientes VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, email);
            ps.setString(7, fechaNacimiento);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Cliente guardado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void modificarCliente() {
        try (Connection con = Conexion.getConnection()) {
            String sql = "UPDATE Clientes SET nombre=?, apellido=?, telefono=?, direccion=?, email=?, fecha_nacimiento=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, telefono);
            ps.setString(4, direccion);
            ps.setString(5, email);
            ps.setString(6, fechaNacimiento);
            ps.setInt(7, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Cliente modificado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarCliente(int id) {
        try (Connection con = Conexion.getConnection()) {
            String sql = "DELETE FROM Clientes WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Cliente eliminado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
