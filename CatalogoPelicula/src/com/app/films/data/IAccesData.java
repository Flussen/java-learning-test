package com.app.films.data;

import java.util.List;
import com.app.films.domain.Film;
import com.app.films.exceptions.*;

public interface IAccesData {
    boolean existe(String nombreArchivo) throws AccesDatasEx;
    List<Film> listar(String nombre) throws ReadDataEx;
    void escribir(Film pelicula, String nombreArchivo, boolean anexar) throws WriteDataEx;
    String buscar(String nombreArchivo, String buscar) throws AccesDatasEx;
    void crear(String nombreArchivo) throws WriteDataEx;
    void borrar(String nombreArchivo) throws AccesDatasEx;
}
