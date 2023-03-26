import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    private static final String RUTA_CSV = "datos.csv";
    private static final String SEPARADOR_CSV = ",";
    private static List<Registro> registros = new ArrayList<>();

    public static void main(String[] args) {
        leerCSV();
        mostrarMenu();
    }

    private static void leerCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(SEPARADOR_CSV);
                Registro registro = new Registro(datos[0], datos[1], datos[2], datos[3]);
                registros.add(registro);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar todos los registros");
            System.out.println("2. Buscar registro por ID");
            System.out.println("3. Buscar registro por nombre");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarRegistros(registros);
                    break;
                case 2:
                    System.out.print("Ingrese el ID del registro a buscar: ");
                    String id = scanner.next();
                    Registro registroId = buscarRegistroPorId(id);
                    if (registroId != null) {
                        mostrarRegistro(registroId);
                    } else {
                        System.out.println("Registro no encontrado");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del registro a buscar: ");
                    String nombre = scanner.next();
                    List<Registro> registrosNombre = buscarRegistrosPorNombre(nombre);
                    if (!registrosNombre.isEmpty()) {
                        mostrarRegistros(registrosNombre);
                    } else {
                        System.out.println("Registros no encontrados");
                    }
                    break;
                case 4:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println();
        } while (opcion != 4);
        scanner.close();
    }

    private static void mostrarRegistros(List<Registro> registros) {
        System.out.println("Registros:");
        for (Registro registro : registros) {
            mostrarRegistro(registro);
        }
    }

    private static void mostrarRegistro(Registro registro) {
        System.out.println(registro.getId() + ", " + registro.getNombre() + ", " + registro.getApellido() + ", " + registro.getCorreoElectronico());
    }

    private static Registro buscarRegistroPorId(String id) {
        for (Registro registro : registros) {
            if (registro.getId().equals(id)) {
                return registro;
            }
        }
        return null;
    }

    private static List<Registro> buscarRegistrosPorNombre(String nombre) {
        List<Registro> resultados = new ArrayList<>();
        for (Registro registro : registros) {
            if (registro.getNombre().equals(nombre)) {
                resultados.add(registro);
            }
        }
        return resultados;
    }

}
