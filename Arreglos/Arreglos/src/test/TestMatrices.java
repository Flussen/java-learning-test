package test;

import domain.Persona;

public class TestMatrices {
    public static void main(String[] args) {
        int edades[][] = new int[3][2];

        edades[0][0] = 5;
        edades[0][1] = 7;
        edades[1][0] = 8;
        edades[1][1] = 4;
        edades[2][0] = 3;
        edades[2][1] = 2;

        String frutas[][] = { { "Naranja", "Limón" }, { "Fresas", "Zarzamora", "Mora" } };

        Persona personas[][] = new Persona[1][2];
        personas[0][0] = new Persona("Juan");
        personas[0][1] = new Persona("Karla");

        imprimir(personas);
    }

    public static void imprimir(Object matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(i + "-" + j + " " + matriz[i][j]);
            }
        }
    }

    public static void imprimirNum(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(i + "-" + j + " " + matriz[i][j]);
            }
        }
    }
}