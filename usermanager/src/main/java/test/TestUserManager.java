package test;

import java.sql.*;
import datos.*;
import domain.Usuario;

public class TestUserManager {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            UsuarioDAO usuarioDao = new UsuarioDAO(conexion);

            Usuario cambioUsuario = new Usuario();
            cambioUsuario.setIdUsuario(1);
            cambioUsuario.setUsuario("Homer23");
            cambioUsuario.setPassword("asdg6124");
            usuarioDao.actualizar(cambioUsuario);

            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsuario("Ramirez");
            // nuevoUsuario.setUsuario("Ramirez123");
            nuevoUsuario.setPassword("asdd76");
            usuarioDao.insertar(nuevoUsuario);

            conexion.commit();
            System.out.println("Se ha hecho un commit exitoso!");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Rollback");
                try {
                    conexion.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace(System.out);
                }
        }

        // # - Insert nuevo usuario

        // Usuario usuarioNew = new Usuario("Flussen", "carrodemessi");
        // usuarioDao.insertar(usuarioNew);

        // # - Update usuario

        // Usuario usuarioNew = new Usuario("Ivan", "Blanco", 2);
        // usuarioDao.actualizar(usuarioNew);

        // # - Delete usuario

        // Usuario usuarioNew = new Usuario(3);
        // usuarioDao.borrar(usuarioNew);

        // # - Recopilar datos

        // # - Test transaccion

        // List<Usuario> usuarios = usuarioDao.seleccionar();
        // usuarios.forEach(usuario ->{
        //     System.out.println(usuario);
        // });
    }
}