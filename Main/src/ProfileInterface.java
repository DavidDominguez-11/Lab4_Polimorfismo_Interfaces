/**
 * Interfaz que define un método para cambiar la contraseña del perfil.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-14
 */
public interface ProfileInterface {

    /**
     * Cambia la contraseña del perfil.
     *
     * @param newPassword Nueva contraseña a establecer.
     */
    void changePassword(String newPassword);
}
