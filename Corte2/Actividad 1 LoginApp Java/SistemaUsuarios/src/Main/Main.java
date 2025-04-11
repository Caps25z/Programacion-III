package Main;

import Formularios.FrmLogin;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmLogin().setVisible(true);
            System.out.println("Aplicación iniciada");
        });
    }
}