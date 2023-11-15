/**
 * Interfaz que define métodos para exportar y leer archivos.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-14
 */
public interface ArchiveInterface {

    /**
     * Exporta datos a algún tipo de archivo.
     */
    void export();
    
    /**
     * Lee datos desde un archivo.
     */
    void read();
}
