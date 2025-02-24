package principal;

import Clases.Ave;

public class Principal {
    public static void main(String[] args) {
        Ave aguila = new Ave("Aguila Real", 3.5, 2021, "Camilo Perez");

        System.out.println(aguila.esMayorDeEdad());
    }
}