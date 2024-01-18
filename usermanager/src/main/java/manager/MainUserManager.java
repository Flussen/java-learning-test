package manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import datos.Conexion;
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
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Usuario nuevoUsuario = new Usuario(user, pwd);
            UsuarioDAO usuarioDao = new UsuarioDAO(conexion);
            usuarioDao.insertar(nuevoUsuario);
            conexion.commit();

        } catch (Exception e1) {
            try {
                if(conexion != null){
                    conexion.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            e1.printStackTrace(System.out);
        }finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void actualizarUsuario(int id_usuario, String user, String pwd) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Usuario nuevoUsuario = new Usuario(user, pwd, id_usuario);
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            usuarioDAO.actualizar(nuevoUsuario);
            conexion.commit();
        } catch (Exception e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            e.printStackTrace(System.out);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void borrarUsuario(int id_usuario) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Usuario usuario = new Usuario(id_usuario);
            UsuarioDAO usuarioDao = new UsuarioDAO(conexion);
            usuarioDao.borrar(usuario);
            conexion.commit();
        } catch (Exception e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            e.printStackTrace(System.out);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}