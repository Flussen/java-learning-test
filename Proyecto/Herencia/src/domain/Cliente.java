package domain;

import java.util.Date;

public class Cliente extends Persona {
    private int idCliente;
    private Date fechaRegistro;
    private boolean vip;
    private static int contadorCliente;

    public Cliente(Persona persona, boolean vip, Date fechaRegistro) {
        super(persona.getNombre(), persona.getGenero(), persona.getEdad(), persona.getDireccion());
        this.idCliente = ++Cliente.contadorCliente;
        this.vip = vip;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(super.nombre);
        sb.append(", Genero: ").append(super.genero);
        sb.append(", Edad: ").append(super.edad);
        sb.append(", Direccion: ").append(super.direccion);
        sb.append("|");
        sb.append(", IDCliente: ").append(this.idCliente);
        sb.append(", Registro: ").append(this.fechaRegistro);
        sb.append(", VIP: ").append(this.vip);
        return sb.toString();
    }

}
