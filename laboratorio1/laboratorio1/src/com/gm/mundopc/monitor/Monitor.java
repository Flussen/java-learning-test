package com.gm.mundopc.monitor;

public class Monitor {
    private int idMonitor;
    private String marca;
    private double tamano;
    private static int contadorMonitores;

    public Monitor(String marca, double tamano) {
        this.marca = marca;
        this.tamano = tamano;
        this.idMonitor = ++contadorMonitores;
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
