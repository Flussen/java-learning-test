package com.shop.ventas;

public class Orden {
    private static int contadorOrdenes;
    private final int idOrden;
    private Producto[] productos;
    private static final int MAX_PRODUCTOS = 10;
    private int contadorProductosActual = 0;

    public Orden() {
        this.idOrden = ++contadorOrdenes;
        this.productos = new Producto[MAX_PRODUCTOS];
    }

    public void agregarProducto(Producto producto) {
        if (contadorProductosActual < MAX_PRODUCTOS) {
            productos[contadorProductosActual++] = producto;
        } else {
            System.out.println("No se puede agregar más productos a la orden.");
        }
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getIdOrden() {
        return idOrden;
    }

}
