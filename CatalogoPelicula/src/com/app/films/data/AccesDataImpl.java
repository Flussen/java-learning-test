package com.app.films.data;

import java.io.*;
import java.util.*;

import com.app.films.domain.Film;
import com.app.films.exceptions.*;

public class AccesDataImpl implements IAccesData {

    @Override
    public boolean existe(String nombreArchivo) {
        return new File(nombreArchivo).exists();
    }

    @Override
    public List<Film> listar(String nombreArchivo) throws ReadDataEx {
        File archivo = new File(nombreArchivo);
        List<Film> peliculas = new ArrayList<>();
        try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = entrada.readLine()) != null) {
                peliculas.add(new Film(linea));
            }
        } catch (FileNotFoundException e) {
            throw new ReadDataEx("Excepción al enlistar peliculas: " + e.getMessage());
        } catch (IOException e) {
            throw new ReadDataEx("Excepción al enlistar peliculas: " + e.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Film pelicula, String nombreArchivo, boolean anexar) throws WriteDataEx {
        try (PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar))) {
            salida.println(pelicula.toString());
            System.out.println("Película escrita en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            throw new WriteDataEx("No se pudo escribir en el archivo: " + e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws AccesDatasEx {
        File archivo = new File(nombreArchivo);
        try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int indice = 1;
            while ((linea = entrada.readLine()) != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    return "Pelicula " + linea + " encontrada en el indice " + indice;
                }
                indice++;
            }
        } catch (FileNotFoundException e) {
            throw new AccesDatasEx("No se consiguió el archivo: " + e.getMessage());
        } catch (IOException e) {
            throw new AccesDatasEx("Error al buscar la palabra: " + e.getMessage());
        }
        return "Pelicula no encontrada";
    }

    @Override
    public void crear(String nombreArchivo) throws WriteDataEx {
        try (PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo))) {
            System.out.println("Se ha creado el archivo " + nombreArchivo + " Correctamente");
        } catch (IOException e) {
            throw new WriteDataEx("Error al crear el archivo: " + e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists() && archivo.delete()) {
            System.out.println("Se ha borrado el archivo.");
        }
    }
}
