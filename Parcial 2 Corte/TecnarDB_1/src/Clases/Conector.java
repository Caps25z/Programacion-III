package Clases;

import java.sql.*;

public class Conector {

    private static final String URL = "jdbc:mysql://localhost/TecnarApp";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;


    public void conectar() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            try {
                this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa a la base de datos.");
            } catch (SQLException ex) {
                System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
                throw ex;
            }
        }
    }


    public void desconectar() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Desconexión exitosa de la base de datos.");
            }
        } catch (SQLException ex) {
            System.err.println("Error al desconectar de la base de datos: " + ex.getMessage());
        }
    }


    public ResultSet executeSelect(String query, Object... parameters) throws SQLException {
        PreparedStatement statement = prepareStatement(query, parameters);
        return statement.executeQuery();
    }


    public ResultSet executeSelect(String query) throws SQLException {
        PreparedStatement statement = prepareStatement(query);
        return statement.executeQuery(); 
    }


    public int executeUpdate(String query, Object... parameters) throws SQLException {
        try (PreparedStatement statement = prepareStatement(query, parameters)) {
            return statement.executeUpdate();
        }
    }


    private PreparedStatement prepareStatement(String query, Object... parameters) throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            conectar();
        }
        PreparedStatement statement = this.connection.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        return statement;
    }


    public Connection getConnection() {
        return this.connection;
    }
}
