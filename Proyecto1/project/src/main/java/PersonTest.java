import domain.Person;

public class PersonTest {
    private int contador;

    public static void main(String[] args) {
        Person person1 = new Person("Juan");
        Person person2 = new Person("Pedro");
        Person person3 = new Person("Roberto");

        imprimir(person1);
        imprimir(person2);
        imprimir(person3);
    }

    public static void imprimir(Person person) {
        System.out.println("persona = " + person);
    }

    public int getContador() {
        imprimir(new Person("Carlos"));
        return this.contador = 10;
    }
}
