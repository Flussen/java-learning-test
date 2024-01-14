package test;

import java.util.Date;
import domain.Cliente;
import domain.Empleado;
import domain.Persona;

public class TestHerencia {
    public static void main(String[] args) {
        // var fecha = new Date();

        // Persona persona1 = new Persona("Juan", 'H', 21, "Street 2");
        Empleado empleado1 = new Empleado("Juan", 5000.0);

        // Cliente cliente1 = new Cliente(persona1, true, fecha);
        // System.out.println(persona1);
        System.out.println(empleado1);
        // System.out.println(cliente1);
    }
}
