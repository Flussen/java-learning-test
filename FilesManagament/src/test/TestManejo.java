package test;

import static filemanagement.FM.*;

public class TestManejo {
    public static void main(String[] args) {
        var nombreArchivo = "prueba.txt";
        // crearArchivo(nombreArchivo);
        // escribirArchivo(nombreArchivo, "adios");
        // anexarArchivo(nombreArchivo, "Hola desde java");
        leerArchivo(nombreArchivo);
    } 
}
