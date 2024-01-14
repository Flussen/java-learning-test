package test;

import domain.Persona;

public class TestUtileria {
    public static void main(String[] args) {
        System.out.println();

        final Persona persona1 = new Persona();
        // persona1 = new Persona();
        persona1.setNombre("juan");
        System.out.println("persona1 = " + persona1.getNombre());
    }
}
