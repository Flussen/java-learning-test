package com.app.films.negocio;

import com.app.films.data.*;
import com.app.films.domain.Film;
import com.app.films.exceptions.*;

public class FilmCatalogImpl implements IFilmCatalog{

    private final IAccesData datos;

    public FilmCatalogImpl() {
        this.datos = new AccesDataImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Film pelicula = new Film(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesDatasEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Film pelicula : peliculas) {
                System.out.println("pelicula = "  + pelicula.getNombre());
            }
        } catch (AccesDatasEx e) {
            System.out.println("Error de acceso de datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesDatasEx e) {
            System.out.println("Error de acceso de datos");
        }
        System.out.println(resultado);
    }

    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesDatasEx e) {
            System.out.println("Error de acceso de datos");
            e.printStackTrace(System.out);
        }
    }
}
