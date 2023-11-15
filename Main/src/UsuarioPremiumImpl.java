import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementación de la interfaz para un usuario premium con funcionalidades específicas.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-14
 */
public class UsuarioPremiumImpl implements BanerInterface, SelectionInterface, LoadInterface, ProfileInterface, ArchiveInterface {
    private String usuario;
    private String contrasena;
    private List<String> listaPrestamo;

    /**
     * Constructor de la clase UsuarioPremiumImpl.
     *
     * @param usuario    Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     */
    public UsuarioPremiumImpl(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.listaPrestamo = new ArrayList<>();
    }

    /** {@inheritDoc} */
    @Override
    public void showOptions() {
        System.out.println("Opciones para usuario premium:");
        System.out.println("1. Agregar recurso.");
        System.out.println("2. Mostrar lista de recursos.");
        System.out.println("3. Definir días de entrega.");
        System.out.println("4. Cambiar contraseña.");
        System.out.println("5. Seleccionar dirección de envío.");
        System.out.println("6. Aplicar cupón de días adicionales.");
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
        System.out.println("Lista de préstamos vaciada para usuario premium.");
    }

    /** {@inheritDoc} */
    @Override
    public void showlistResources() {
        System.out.println("Lista de recursos disponibles para usuario premium:");
        List<String> recursosDisponibles = obtenerRecursosDisponiblesPremium();
        for (String recurso : recursosDisponibles) {
            System.out.println(recurso);
        }
    }
    
    // Método hipotético para obtener recursos disponibles para usuarios premium
    private List<String> obtenerRecursosDisponiblesPremium() {
        List<String> recursosPremium = new ArrayList<>();
        recursosPremium.add("Libro premium 1");
        recursosPremium.add("Libro premium 2");
        recursosPremium.add("Revista premium 1");
        return recursosPremium;
    }

    /** {@inheritDoc} */
    @Override
    public void returningDays() {
        System.out.println("Definir días de entrega para usuario premium:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de días de entrega: ");
        int diasEntrega = scanner.nextInt();
        System.out.println("Días de entrega definidos para usuario premium: " + diasEntrega);
    }

    /** {@inheritDoc} */
    @Override
    public void changePassword(String newPassword) {
        contrasena = newPassword;
        System.out.println("Contraseña cambiada exitosamente para usuario premium.");
    }

    /**
     * Método privado para obtener datos a exportar en formato CSV.
     *
     * @return Lista de datos para exportar.
     */
    private List<String> obtenerDatosParaExportar() {
        List<String> datosExportar = new ArrayList<>();
        datosExportar.add("Nombre: " + usuario);
        datosExportar.add("Contraseña: " + contrasena);
        datosExportar.add("Lista de préstamos:");

        for (String prestamo : listaPrestamo) {
            datosExportar.add(prestamo);
        }

        return datosExportar;
    }

    /** {@inheritDoc} */
    @Override
    public void export() {
        try {
            FileWriter fileWriter = new FileWriter("datos_usuario_premium.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            List<String> datosUsuarioPremium = obtenerDatosParaExportar();
            
            for (String dato : datosUsuarioPremium) {
                bufferedWriter.write(dato);
                bufferedWriter.newLine();
            }
            
            bufferedWriter.close();
            System.out.println("Datos exportados correctamente para usuario premium en formato CSV.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos para usuario premium en formato CSV.");
            e.printStackTrace();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("datos_usuario_premium.csv"));
            String linea;
            List<String> datosLeidos = new ArrayList<>();

            while ((linea = bufferedReader.readLine()) != null) {
                datosLeidos.add(linea);
            }

            bufferedReader.close();

            for (String dato : datosLeidos) {
                System.out.println(dato);
            }
        } catch (IOException e) {
            System.out.println("Error al leer los datos para usuario premium desde el archivo CSV.");
            e.printStackTrace();
        }
    }
}
