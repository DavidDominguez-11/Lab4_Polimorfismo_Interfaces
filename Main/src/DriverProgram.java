import java.util.Scanner;

/**
 * Clase que contiene el programa principal para la gestión de usuarios.
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-14
 */
public class DriverProgram {
    /**
     * Método principal que inicia la interacción con el programa.
     * Permite acceder como Usuario Base, Usuario Premium, crear un nuevo usuario o salir del programa.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioBaseImpl usuarioBase = new UsuarioBaseImpl("usuarioBase", "contrasenaBase");
        UsuarioPremiumImpl usuarioPremium = new UsuarioPremiumImpl("usuarioPremium", "contrasenaPremium");

        int opcion;
        do {
            System.out.println("Bienvenido al programa de gestión de usuarios:");
            System.out.println("1. Acceder como Usuario Base");
            System.out.println("2. Acceder como Usuario Premium");
            System.out.println("3. Crear nuevo usuario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    interactuarConUsuario(usuarioBase);
                    break;
                case 2:
                    interactuarConUsuario(usuarioPremium);
                    break;
                case 3:
                    crearNuevoUsuario();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    /**
     * Método para interactuar con un Usuario Base.
     *
     * @param usuario Usuario Base con el que se interactuará.
     */
    public static void interactuarConUsuario(UsuarioBaseImpl usuario) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            usuario.showOptions();
            System.out.print("Seleccione una opción o ingrese 0 para volver al menú principal: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    usuario.addResource("libro"); // Cambiar el tipo de recurso según sea necesario
                    break;
                case 2:
                    usuario.showlistResources();
                    break;
                case 3:
                    usuario.returningDays();
                    break;
                case 4:
                    System.out.print("Ingrese la nueva contraseña: ");
                    String nuevaContrasena = scanner.next();
                    usuario.changePassword(nuevaContrasena);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }
        } while (opcion != 0);
        
        scanner.close();
    }

    /**
     * Método para interactuar con un Usuario Premium.
     *
     * @param usuario Usuario Premium con el que se interactuará.
     */
    public static void interactuarConUsuario(UsuarioPremiumImpl usuario) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            usuario.showOptions();
            System.out.print("Seleccione una opción o ingrese 0 para volver al menú principal: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    usuario.addResource("libro"); // Cambiar el tipo de recurso según sea necesario
                    break;
                case 2:
                    usuario.showlistResources();
                    break;
                case 3:
                    usuario.returningDays();
                    break;
                case 4:
                    System.out.print("Ingrese la nueva contraseña: ");
                    String nuevaContrasena = scanner.next();
                    usuario.changePassword(nuevaContrasena);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    break;
            }
        } while (opcion != 0);
        
        scanner.close();
    }

    /**
     * Método para crear un nuevo usuario según el plan seleccionado (Gratis o Premium).
     */
    public static void crearNuevoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creación de nuevo usuario:");
        System.out.print("Ingrese el nombre de usuario: ");
        String nuevoUsuario = scanner.next();
        System.out.print("Ingrese la contraseña: ");
        String nuevaContrasena = scanner.next();
        System.out.println("Seleccione el plan: ");
        System.out.println("1. Gratis");
        System.out.println("2. Premium");
        System.out.print("Seleccione el plan (1 o 2): ");
        int plan = scanner.nextInt();

        if (plan == 1) {
            UsuarioBaseImpl nuevoUsuarioBase = new UsuarioBaseImpl(nuevoUsuario, nuevaContrasena);
            System.out.println("Usuario base creado con éxito.");
            interactuarConUsuario(nuevoUsuarioBase);
        } else if (plan == 2) {
            UsuarioPremiumImpl nuevoUsuarioPremium = new UsuarioPremiumImpl(nuevoUsuario, nuevaContrasena);
            System.out.println("Usuario premium creado con éxito.");
            interactuarConUsuario(nuevoUsuarioPremium);
        } else {
            System.out.println("Plan no válido. Creación de usuario cancelada.");
        }

        scanner.close();
    }
}
