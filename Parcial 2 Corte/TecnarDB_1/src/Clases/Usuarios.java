
package Clases;
import Clases.Conector;
import java.sql.*;

public class Usuarios {
    String nombre;
    String apellido;
    String username;
    String password;
    String tipo;
    

    public boolean verificarCredenciales(String pUsername, String pPassword) {
        Conector db = new Conector();
        
        try {
            db.conectar();
            String query = "SELECT * FROM usuarios WHERE username = ? AND clave = ?";
            ResultSet rs = db.executeSelect(query, pUsername, pPassword);
            return rs.next();
            
        }catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }finally {
           db.desconectar();
        }
       
    }
    
    
   public ResultSet listarUsuarios() {
    Conector db = new Conector();
    ResultSet rs = null;

    try {
        db.conectar();
        String query = "SELECT * FROM usuarios";
        rs = db.executeSelect(query);
    } catch (SQLException e) {
        System.err.println("Error al listar los clientes Metodo: " + e.getMessage());
    }

    return rs;
}
   

    public int guardarUsuario(String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO usuarios (nombre, apellido, username, email, clave) VALUES (?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, username, email, clave);
    }


    public int actualizarUsuario(int id,String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE usuarios SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE id = ?";
        return db.executeUpdate(query, nombre, apellido, username, email, clave, id);
    }


    public int eliminarUsuario(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM usuarios WHERE id = ?";
        return db.executeUpdate(query, id);
    } 
   
}
