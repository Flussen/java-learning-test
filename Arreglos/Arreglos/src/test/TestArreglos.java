package test;

public class TestArreglos {
    public static void main(String[] args) {
        int edades[] = new int[3];
        System.out.println("edades = " + edades);
        edades[0] = 10;
        edades[1] = 5;
        for (int i = 0; i < edades.length; i++) {
            System.out.println("Edades elemento: " + i + ": " + edades[i]);
        }
        String frutas[] = { "Naranja", "Banana", "Uva" };
        for (int i = 0; i < frutas.length; i++) {
            System.out.println(frutas[i]);
        }
        double numeros[] = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
}