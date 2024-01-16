package com.gm.mundopc.dispositivos;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private double tamano;
    private static int contadorMonitores;

    private Monitor() {
        this.idMonitor = ++contadorMonitores;
    }

    public Monitor(String marca, double tamano) {
        this();
        this.marca = marca;
        this.tamano = tamano;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: " + marca);
        sb.append(", Tamaño: " + tamano);
        return sb.toString();

    }
}
