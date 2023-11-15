import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Implementación de la interfaz para un usuario base con funcionalidades específicas.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-14
 */
public class UsuarioBaseImpl implements BanerInterface, SelectionInterface, LoadInterface, ProfileInterface, ArchiveInterface {
    private String usuario;
    private String contrasena;
    private List<String> listaPrestamo;

    /**
     * Constructor de la clase UsuarioBaseImpl.
     *
     * @param usuario    Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     */
    public UsuarioBaseImpl(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.listaPrestamo = new ArrayList<>();
    }

    /** {@inheritDoc} */
    @Override
    public void showOptions() {
        System.out.println("Opciones para usuario base:");
        System.out.println("1. Agregar recurso.");
        System.out.println("2. Mostrar lista de recursos.");
        System.out.println("3. Definir días de entrega.");
        System.out.println("4. Cambiar contraseña.");
    }

    /** {@inheritDoc} */
    @Override
    public void addResource(String typeResource) {
        if (typeResource.equals("libro") || typeResource.equals("revista")) {
            listaPrestamo.add(typeResource);
            System.out.println(typeResource + " agregado a la lista de préstamos.");
        } else {
            System.out.println("Tipo de recurso no válido.");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void clearResource() {
        listaPrestamo.clear();
        System.out.println("Lista de préstamos vaciada.");
    }

    /**
     * Método privado para obtener los recursos disponibles (ficticio).
     *
     * @return Lista de recursos disponibles.
     */
    private List<String> obtenerRecursosDisponibles() {
        return obtenerRecursosDisponibles();
    }

    /** {@inheritDoc} */
    @Override
    public void showlistResources() {
        System.out.println("Lista de recursos disponibles:");
        List<String> recursosDisponibles = obtenerRecursosDisponibles();
        for (String recurso : recursosDisponibles) {
            System.out.println(recurso);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void returningDays() {
        System.out.println("Definir días de entrega para usuario base:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de días de entrega: ");
        int diasEntrega = scanner.nextInt();
        System.out.println("Días de entrega definidos: " + diasEntrega);
    }

    /** {@inheritDoc} */
    @Override
    public void changePassword(String newPassword) {
        contrasena = newPassword;
        System.out.println("Contraseña cambiada exitosamente.");
    }

    /** {@inheritDoc} */
    @Override
    public void export() {
        try {
            FileWriter fileWriter = new FileWriter("datos_usuario_base.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write("Nombre de usuario,Contraseña,Lista de préstamos");
            bufferedWriter.newLine();
            bufferedWriter.write(usuario + "," + contrasena + ",");
            for (String prestamo : listaPrestamo) {
                bufferedWriter.write(prestamo + ",");
            }

            bufferedWriter.close();
            System.out.println("Datos exportados correctamente para usuario base en formato CSV.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos para usuario base en formato CSV.");
            e.printStackTrace();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datos_usuario_base.csv"));
            String linea;
            List<UsuarioBaseImpl> usuarios = new ArrayList<>();

            while ((linea = bufferedReader.readLine()) != null) {
                String[] campos = linea.split(",");
                String usuario = campos[0];
                String contrasena = campos[1];
                List<String> listaPrestamo = new ArrayList<>();

                for (int i = 2; i < campos.length; i++) {
                    listaPrestamo.add(campos[i]);
                }

                UsuarioBaseImpl nuevoUsuario = new UsuarioBaseImpl(usuario, contrasena);
                nuevoUsuario.listaPrestamo = listaPrestamo;
                usuarios.add(nuevoUsuario);
            }

            bufferedReader.close();
            System.out.println("Datos leídos correctamente para usuarios base desde el archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al leer los datos para usuarios base desde el archivo CSV.");
            e.printStackTrace();
        }
    }
}
