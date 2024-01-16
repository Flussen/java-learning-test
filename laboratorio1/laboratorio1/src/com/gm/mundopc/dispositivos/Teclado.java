package com.gm.mundopc.dispositivos;

public class Teclado extends DispositivoEntrada {
    private final int idTeclado;
    private static int contadorTeclados;

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idTeclado = ++contadorTeclados;
    }

    public int getIdTeclado() {
        return idTeclado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: " + marca);
        sb.append(", Tipo Entrada: " + tipoEntrada);
        return sb.toString();
    }
}
