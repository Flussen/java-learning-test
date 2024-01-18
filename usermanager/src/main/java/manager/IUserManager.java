package manager;

public interface IUserManager {
    void listarUsuario();
    void agregarUsuario(String user, String pwd);
    void actualizarUsuario(int id_usuario, String user, String pwd);
    void borrarUsuario(int id_usuario);
}
