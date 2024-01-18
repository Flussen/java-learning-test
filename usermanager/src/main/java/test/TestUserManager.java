package test;

import java.util.List;
import datos.UsuarioDAO;
import domain.Usuario;

public class TestUserManager {
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDao = new UsuarioDAO();

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

        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario ->{
            System.out.println(usuario);
        });
    }
}
