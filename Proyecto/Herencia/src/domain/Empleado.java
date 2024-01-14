package domain;

public class Empleado extends Persona {
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    public Empleado() {
        super();
        this.idEmpleado = ++Empleado.contadorEmpleado;
    }

    public Empleado(String nombre, double sueldo) {
        // super(persona.getNombre(), persona.getGenero(), persona.getEdad(),
        // persona.getDireccion());
        this();
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ Persona: ").append(super.toString()).append(" }");
        sb.append(", IDEmpleado: ").append(this.idEmpleado);
        sb.append(", sueldo: ").append(this.sueldo);
        return sb.toString();
    }
}
