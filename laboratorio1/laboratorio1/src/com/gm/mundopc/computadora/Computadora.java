package com.gm.mundopc.computadora;

import com.gm.mundopc.dispositivos.Monitor;
import com.gm.mundopc.dispositivos.Raton;
import com.gm.mundopc.dispositivos.Teclado;

public class Computadora {
    protected final int idComputadora;
    protected String nombre;
    protected Monitor monitor;
    protected Teclado teclado;
    protected Raton raton;
    private static int contadorComputadora;

    private Computadora() {
        this.idComputadora = ++contadorComputadora;
    }

    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton) {
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Raton getRaton() {
        return raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Computadora: " + idComputadora);
        sb.append(" Nombre: " + nombre);
        sb.append(" | ");
        sb.append("Monitor - " + monitor);
        sb.append(" | ");
        sb.append("Teclado - " + teclado);
        sb.append(" | ");
        sb.append("Raton - " + raton);
        return sb.toString();
    }
}