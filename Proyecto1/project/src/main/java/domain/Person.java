package domain;

public class Person {
    private int idPerson;
    private String nombre;
    private static int contadorPersonas;

    public Person(String nombre) {
        this.nombre = nombre;
        contadorPersonas++;
        this.idPerson = contadorPersonas;
    }

    public int getIdPerson() {
        return this.idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContadorPersonas() {
        return contadorPersonas;
    }

    public void setContadorPersonas(int aContadorPersonas) {
        contadorPersonas = aContadorPersonas;
    }

    @Override
    public String toString() {
        return "Persona {" + "ID: " + idPerson + ", nombre: " + nombre + " }";
    }
}
