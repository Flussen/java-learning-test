import java.util.Scanner;
import manager.*;

public class App {

    private static final int LISTAR_USUARIOS = 1;
    private static final int AGREGAR_USUARIO = 2;
    private static final int ACTUALIZAR_USUARIO = 3;
    private static final int BORRAR_USUARIO = 4;
    private static final int SALIR = 0;

    public static void main(String[] args) {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        IUserManager userManager = new MainUserManager();

        while(opcion != SALIR){
            mostrarMenu();
            opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case LISTAR_USUARIOS:
                    userManager.listarUsuario();
                    break;
                case AGREGAR_USUARIO:
                    agregarUsuario(scanner, userManager);
                    break;
                case ACTUALIZAR_USUARIO:
                    actualizarUsuario(scanner, userManager);
                    break;
                case BORRAR_USUARIO:
                    borrarUsuario(scanner, userManager);
                    break;
                    case SALIR:
                    System.out.print("Cerrando el programa");
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(500);
                            System.out.print(".");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Interrupción inesperada");
                        }
                    }
                    System.out.println("\nPrograma cerrado.");
                    break;
                default:
                    System.out.println("Opción no reconocida");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("");
        System.out.println("Database Manager, elige una opción:\n"
            + "1. Listar Usuarios\n"
            + "2. Agregar Usuario\n"
            + "3. Actualizar Usuario\n"
            + "4. Borrar Usuario\n"
            + "0. Salir");
        System.out.println("");
    }
    private static int obtenerOpcion(Scanner scanner){
        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido!");
            opcion = -1;
        }
        return opcion;
    }

    private static void agregarUsuario(Scanner scanner, IUserManager userManager){
        System.out.println("Introduce el nombre de usuario:");
        String user = scanner.nextLine();
        System.out.println("Introduce la contraseña:");
        String pwd = scanner.nextLine();
        System.out.println("Usuario "+user+" añadido exitosamente");
        System.out.println("");
        userManager.agregarUsuario(user, pwd);
    }

    private static void actualizarUsuario(Scanner scanner, IUserManager userManager){
        System.out.println("Introduce el ID a cambiar");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido");
            return;
        }
        System.out.println("Introduce el nuevo nombre");
        String user = scanner.nextLine();
        System.out.println("Introduce la nueva contraseña");
        String pwd = scanner.nextLine();
        System.out.println("Usuario "+user+" actualizado exitosamente");
        System.out.println("");

        userManager.actualizarUsuario(id, user, pwd);
    }

    private static void borrarUsuario(Scanner scanner, IUserManager userManager) {
        System.out.println("Introduce el ID del usuario a borrar:");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido para el ID!");
            return;
        }
        System.out.println("Usuario borrado existosamente");
        System.out.println("");
        userManager.borrarUsuario(id);
    }
    
}