package com.app.films.data;

import java.io.*;
import java.util.*;

import com.app.films.domain.Film;
import com.app.films.exceptions.*;

public class AccesDataImpl implements IAccesData {

    /**
     * Verifica si un archivo existe en el sistema de archivos.
     *
     * @param nombreArchivo El nombre del archivo a verificar.
     * @return boolean Verdadero si el archivo existe, falso en caso contrario.
     */

    @Override
    public boolean existe(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    /**
     * Lista el contenido de un archivo.
     *
     * @param nombreArchivo El nombre del archivo cuyo contenido se va a listar.
     * @throws ReadDataEx Si no se encuentra el archivo o si ocurre un error al
     *                    leerlo.
     */

    @Override
    public List<Film> listar(String nombreArchivo) throws ReadDataEx {
        var archivo = new File(nombreArchivo);
        List<Film> peliculas = new ArrayList<>();
        try (var entrada = new BufferedReader(new FileReader(archivo))) {
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Film(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReadDataEx("Excepción al enlistar peliculas" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReadDataEx("Excepción al enlistar peliculas" + e.getMessage());
        }
        return peliculas;

    }

    // var archivo = new File(nombreArchivo);
    // try (var entrada = new BufferedReader(new FileReader(archivo))) {
    // var lectura = entrada.readLine();
    // while (lectura != null) {
    // System.out.println(lectura);
    // lectura = entrada.readLine();
    // }
    // entrada.close();
    // } catch (FileNotFoundException e) {
    // throw new ReadDataEx("No se consiguió el archivo " + nombreArchivo);
    // } catch (IOException e) {
    // throw new ReadDataEx("Error al leer el archivo, o no se consiguio");
    // }
    //

    /**
     * Escribe información de una película en un archivo.
     *
     * @param pelicula      La película a escribir en el archivo.
     * @param nombreArchivo El nombre del archivo donde se escribirá la película.
     * @param anexar        Si es verdadero, añade la película al final del archivo;
     *                      si es falso, sobrescribe el archivo.
     * @throws WriteDataEx Si ocurre un error al escribir en el archivo.
     */

    @Override
    public void escribir(Film pelicula, String nombreArchivo, boolean anexar) throws WriteDataEx {
        File archivo = new File(nombreArchivo);
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar))) {
            salida.println(pelicula.toString());
            System.out.println("Película escrita en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            throw new WriteDataEx("No se pudo escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Busca una palabra específica dentro de un archivo.
     *
     * @param nombreArchivo El archivo donde se buscará la palabra.
     * @param buscar        La palabra a buscar en el archivo.
     * @return String Mensaje que indica si la palabra fue encontrada o no.
     * @throws AccesDatasEx Si el archivo no se encuentra o si ocurre un error
     *                      durante la búsqueda.
     */

    @Override
    public String buscar(String nombreArchivo, String buscar) throws AccesDatasEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try (var entrada = new BufferedReader(new FileReader(archivo))) {
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            throw new AccesDatasEx("No se consiguió el archivo: " + nombreArchivo + ", " + e.getMessage());
        } catch (IOException e) {
            throw new AccesDatasEx("Error al buscar la palabra" + e.getMessage());
        }
        return resultado;
    }

    // @Override
    // public String buscar(String nombreArchivo, String buscar) throws AccesDatasEx
    // {
    // var archivo = new File(nombreArchivo);
    // boolean encontrado = false;
    // try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
    // String lectura;
    // while ((lectura = entrada.readLine()) != null && !encontrado) {
    // if (lectura.toLowerCase().contains(buscar.toLowerCase())) {
    // encontrado = true;
    // }
    // }
    // } catch (FileNotFoundException e) {
    // throw new AccesDatasEx("No se consiguió el archivo: " + nombreArchivo + ", "
    // + e.getMessage());
    // } catch (IOException e) {
    // throw new AccesDatasEx("Error al buscar la palabra" + e.getMessage());
    // }
    // return encontrado ? "Palabra encontrada: " + buscar : "Palabra '" + buscar +
    // "' no fue encontrada";
    // }

    /**
     * Crea un nuevo archivo en el sistema de archivos.
     *
     * @param nombreArchivo El nombre del archivo a crear.
     * @throws WriteDataEx Si ocurre un error al crear el archivo.
     */

    @Override
    public void crear(String nombreArchivo) throws WriteDataEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo " +
                    nombreArchivo + " Correctamente");
        } catch (IOException e) {
            e.printStackTrace();
            throw new WriteDataEx("Error al crear el archivo " + e.getMessage());
        }
    }

    /*
     * Borra un archivo del sistema de archivos.
     */

    @Override
    public void borrar(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
                System.out.println("Se ha borrado el archivo.");
        }
    }
}