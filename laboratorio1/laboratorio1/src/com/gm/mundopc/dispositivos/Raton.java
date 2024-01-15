package com.gm.mundopc.dispositivos;

public class Raton extends DispositivoEntrada {
    private int idRaton;
    private static int contadorRatones;

    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idRaton = ++contadorRatones;
    }

    public int getIdRaton() {
        return idRaton;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: " + marca);
        sb.append(", Tipo Entrada: " + tipoEntrada);
        return sb.toString();
    }
}
