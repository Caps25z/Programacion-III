package Clases;

import java.time.Year;

public class Ave extends Animal {
    private int añoNacimiento;
    private String propietario;

    public Ave(String nombre, double peso, int añoNacimiento, String propietario) {
        super(nombre, peso);
        this.añoNacimiento = añoNacimiento;
        this.propietario = propietario;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        if (añoNacimiento > 1900) {
            this.añoNacimiento = añoNacimiento;
        } else {
            throw new IllegalArgumentException("Año de nacimiento no valido");
        }
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int calcularEdad() {
        int añoActual = Year.now().getValue();
        return añoActual - this.añoNacimiento;
    }

    public String esMayorDeEdad() {
        int edad = calcularEdad();
        if (edad >= 5) {
            return getNombre() + " tiene " + edad + " años y es mayor de edad";
        } else {
            return getNombre() + " tiene " + edad + " años y es menor de edad";
        }
    }
}