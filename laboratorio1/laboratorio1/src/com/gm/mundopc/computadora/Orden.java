package com.gm.mundopc.computadora;

public class Orden {
    private int idOrden;
    private Computadora computadoras[];
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private static final int MAX_COMPUTADORAS = 10;

    public Orden() {
        this.idOrden = ++contadorOrdenes;
        this.computadoras = new Computadora[MAX_COMPUTADORAS];
    }

    public void agregarComputadora(Computadora computadora) {
        if (this.contadorComputadoras < MAX_COMPUTADORAS) {
            this.computadoras[contadorComputadoras++] = computadora;
        } else {
            System.out.println("Has alcanzado el número máximo de computadoras en una orden!");
        }
    }

    public void mostrarOrden() {
        System.out.println("ID orden: " + this.idOrden);
        for (int i = 0; i < contadorComputadoras; i++) {
            System.out.println("{ " + computadoras[i] + "}");
        }
    }
}
