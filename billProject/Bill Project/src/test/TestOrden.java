package test;

import com.shop.ventas.Orden;
import com.shop.ventas.Producto;

public class TestOrden {
    public static void main(String[] args) {
        Orden orden1 = new Orden();
        System.out.println("Orden creada con ID: " + orden1.getIdOrden());

        Producto producto1 = new Producto("Producto 1", 10.0);
        Producto producto2 = new Producto("Producto 2", 20.0);
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);

        System.out.println("Productos en la orden:");
        for (Producto p : orden1.getProductos()) {
            if (p != null) {
                System.out.println(p.getNombre() + " - $" + p.getPrecio());
            }
        }
    }
}
