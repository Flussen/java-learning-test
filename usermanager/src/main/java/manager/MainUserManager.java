package manager;

import java.util.List;

import datos.UsuarioDAO;
import domain.Usuario;

public class MainUserManager implements IUserManager{

    private final UsuarioDAO internDao;

    public MainUserManager(){
        this.internDao = new UsuarioDAO();
    }

    @Override
        public void listarUsuario() {
        try {
            List<Usuario> usuarios = this.internDao.seleccionar();
            if(usuarios.isEmpty()){
                System.out.println("No hay usuarios en la base de datos!");
            }else {
                System.out.println("");
                usuarios.forEach(usuario ->{
                    System.out.println("ID: " + usuario.getIdUsuario() + ", Usuario: " + usuario.getUsuario() + ", Password: " + usuario.getPassword());
                });
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void agregarUsuario(String user, String pwd) {
        try {
            Usuario usuario = new Usuario(user, pwd);
            this.internDao.insertar(usuario);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void actualizarUsuario(int id_usuario, String user, String pwd) {
        try {
            Usuario usuario = new Usuario(user, pwd, id_usuario);
            this.internDao.actualizar(usuario);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void borrarUsuario(int id_usuario) {
        try {
            Usuario usuario = new Usuario(id_usuario);
            this.internDao.borrar(usuario);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
}