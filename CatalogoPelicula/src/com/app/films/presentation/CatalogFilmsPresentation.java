package com.app.films.presentation;

import java.util.Scanner;
import com.app.films.negocio.*;

public class CatalogFilmsPresentation {

    private static final int INICIAR_CATALOGO = 1;
    private static final int AGREGAR_PELICULA = 2;
    private static final int LISTAR_PELICULAS = 3;
    private static final int BUSCAR_PELICULA = 4;
    private static final int SALIR = 0;

    public static void main(String[] args) {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        IFilmCatalog catalogo = new FilmCatalogImpl();

        while (opcion != SALIR) {
            mostrarMenu();
            opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case INICIAR_CATALOGO:
                    catalogo.iniciarArchivo();
                    break;
                case AGREGAR_PELICULA:
                    agregarPelicula(scanner, catalogo);
                    break;
                case LISTAR_PELICULAS:
                    catalogo.listarPeliculas();
                    break;
                case BUSCAR_PELICULA:
                    buscarPelicula(scanner, catalogo);
                    break;
                case SALIR:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Elige una opción:\n"
            + "1. Iniciar catálogo de películas\n"
            + "2. Agregar película\n"
            + "3. Listar películas\n"
            + "4. Buscar película\n"
            + "0. Salir");
    }

    private static int obtenerOpcion(Scanner scanner) {
        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido.");
            opcion = -1; // Valor por defecto para mostrar el menú de nuevo
        }
        return opcion;
    }

    private static void agregarPelicula(Scanner scanner, IFilmCatalog catalogo) {
        System.out.println("Introduce el nombre de la película:");
        String nombre = scanner.nextLine();
        catalogo.agregarPelicula(nombre);
    }

    private static void buscarPelicula(Scanner scanner, IFilmCatalog catalogo) {
        System.out.println("Introduce la película a buscar:");
        String buscar = scanner.nextLine();
        catalogo.buscarPelicula(buscar);
    }
}