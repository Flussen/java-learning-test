package com.app.films.presentation;

import java.util.Scanner;
import com.app.films.negocio.*;

public class CatalogFilmsPresentation {
    public static void main(String[] args) {
        var opcion = -1;
        try (var scanner = new Scanner(System.in)) {
            IFilmCatalog catalogo = new FilmCatalogImpl();

            while(opcion != 0){
                System.out.println("Elige una opción:\n"
                    + "1. Iniciar catalogo de peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar pelicula \n"
                    + "0. Salir");
                opcion = Integer.parseInt(scanner.nextLine());

                switch(opcion){
                    case 1:
                        catalogo.iniciarArchivo();
                        break;
                    case 2:
                        System.out.println("Introduce el nombre de la pelicula");
                        var nombre = scanner.nextLine();
                        catalogo.agregarPelicula(nombre);
                        break;
                    case 3:
                        catalogo.listarPeliculas();
                        break;
                    case 4:
                        System.out.println("Introduce la pelicula a buscar");
                        var buscar = scanner.nextLine();
                        catalogo.buscarPelicula(buscar);
                        break;
                    case 0:
                        System.out.println("Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
