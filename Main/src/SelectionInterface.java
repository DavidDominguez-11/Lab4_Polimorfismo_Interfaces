/**
 * Interfaz que define métodos para agregar recursos y limpiar recursos.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-14
 */
public interface SelectionInterface {

    /**
     * Agrega un recurso del tipo especificado.
     *
     * @param typeResource Tipo de recurso a agregar.
     */
    void addResource(String typeResource);
    
    /**
     * Limpia todos los recursos.
     */
    void clearResource();
}
