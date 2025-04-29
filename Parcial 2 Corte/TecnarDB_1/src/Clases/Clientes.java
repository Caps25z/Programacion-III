package Clases;

import java.sql.*;

public class Clientes {
   
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String genero;

    public ResultSet listarCliente() {
        Conector db = new Conector();
        ResultSet rs = null;

        try {
            db.conectar();
            String query = "SELECT * FROM clientes";
            rs = db.executeSelect(query);
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return rs;
    }
   

    public int guardarCliente(String nombre, String apellido, String direccion, 
                            String telefono, String email, String genero) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO clientes (nombre, apellido, direccion, telefono, email, genero) VALUES (?, ?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, direccion, telefono, email, genero);
    }


    public int actualizarCliente(int id, String nombre, String apellido, String direccion, 
                               String telefono, String email, String genero) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE clientes SET nombre=?, apellido=?, direccion=?, telefono=?, email=?, genero=? WHERE id=?";
        return db.executeUpdate(query, nombre, apellido, direccion, telefono, email, genero, id);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


}