package Formularios;

import Clases.Clientes;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmClientes extends javax.swing.JFrame {
    // Variables para los campos de texto y tabla (generadas por NetBeans)
    private javax.swing.JButton btnGuardar, btnModificar, btnEliminar, btnCargar;
    private javax.swing.JTextField txtId, txtNombre, txtApellido, txtTelefono, txtDireccion, txtEmail, txtFechaNac;
    private javax.swing.JTable tblClientes;

    public FrmClientes() {
        initComponents();
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Clientes cliente = new Clientes();
        cliente.setId(Integer.parseInt(txtId.getText()));
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setFechaNacimiento(txtFechaNac.getText());
        
        cliente.guardarCliente();
        cargarClientes(); // Actualizar tabla
    }

    private void cargarClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");
        modelo.addColumn("Email");
        modelo.addColumn("Fecha Nac.");

        try (java.sql.Connection con = Clases.Conexion.getConnection()) {
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM Clientes");
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("email"),
                    rs.getString("fecha_nacimiento")
                });
            }
            tblClientes.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar: " + e.getMessage());
        }
    }

    // NetBeans genera automáticamente este método
    private void initComponents() {
        // Diseño del formulario (arrastra los componentes en NetBeans)
    }
}
