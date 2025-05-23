package Clases;

public class Usuario {
    private String nombre;
    private String email;
    private String username;
    private String clave;

    public Usuario(String nombre, String email, String username, String clave) {
        this.nombre = nombre;
        this.email = email;
        this.username = username;
        this.clave = clave;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
}