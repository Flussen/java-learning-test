package com.shop.ventas;

public class Producto {
    private static int contadorProductos;
    private final int idProducto;
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.idProducto = ++contadorProductos;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
