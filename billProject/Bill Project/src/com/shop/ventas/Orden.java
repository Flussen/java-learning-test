package com.shop.ventas;

public class Orden {
    private final int idOrden;
    private Producto[] productos;
    private static int contadorOrdenes;
    private static final int MAX_PRODUCTOS = 10;
    private int contadorProductosActual; // inicia en 0 por default

    public Orden() {
        this.idOrden = ++contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }

    public void agregarProducto(Producto producto) {
        if (this.contadorProductosActual < Orden.MAX_PRODUCTOS) {
            this.productos[this.contadorProductosActual++] = producto;
        } else {
            System.out.println("No se puede agregar más productos a la orden.");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < this.contadorProductosActual; i++) {
            // Producto producto = this.productos[i];
            // total += producto.getPrecio();
            total += this.productos[i].getPrecio();
        }
        return total;
    }

    public void mostrarOrden() {
        System.out.println("Id Orden:" + this.idOrden);
        double totalOrden = this.calcularTotal();
        System.out.println("Total orden: $" + totalOrden);
        System.out.println("Productos de la Orden: ");
        for (int i = 0; i < this.contadorProductosActual; i++) {
            System.out.println(this.productos[i]);
        }
    }
}
