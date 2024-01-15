package test;

import com.gm.mundopc.computadora.Computadora;
import com.gm.mundopc.computadora.Orden;
import com.gm.mundopc.dispositivos.Raton;
import com.gm.mundopc.dispositivos.Teclado;
import com.gm.mundopc.monitor.Monitor;

public class TestMundoPC {
    public static void main(String[] args) {
        Monitor monitor1 = new Monitor("Asus", 24);
        Teclado teclado1 = new Teclado("USB", "Logitech");
        Raton raton1 = new Raton("USB-C", "Razer");

        Monitor monitor2 = new Monitor("Samsung", 26);
        Teclado teclado2 = new Teclado("Bluetooh", "Logitech");
        Raton raton2 = new Raton("USB-C", "Razer");

        Computadora pc1 = new Computadora("Gamer PC", monitor1, teclado1, raton1);
        Computadora pc2 = new Computadora("Office PC", monitor2, teclado2, raton2);
        Orden orden1 = new Orden();
        orden1.agregarComputadora(pc1);
        orden1.agregarComputadora(pc2);
        orden1.mostrarOrden();
    }
}