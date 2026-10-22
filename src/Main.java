
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTIÓN DE CITAS TALLER ---");
            System.out.println("1. Registrar nueva cita");
            System.out.println("2. Consultar citas por fecha");
            System.out.println("3. Calcular coste de servicio");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            if (opcion == 1) {
                System.out.println("\n--- REGISTRAR NUEVA CITA ---");

                // Pedir datos del vehículo
                System.out.print("Marca del vehículo: ");
                String marca = scanner.nextLine();

                System.out.print("Modelo del vehículo: ");
                String modelo = scanner.nextLine();

                System.out.print("Matrícula: ");
                String matricula = scanner.nextLine().toUpperCase();

                // Validar la fecha usando LocalDate
                LocalDate fecha = null;

                while (fecha == null) {
                    System.out.print("Fecha de la cita (AAAA-MM-DD): ");
                    String fechaTexto = scanner.nextLine();

                    try {
                        fecha = LocalDate.parse(fechaTexto);

                        if (fecha.isBefore(LocalDate.now())) {
                            System.out.println(
                                    "Error: la fecha no puede ser anterior a hoy."
                            );
                            fecha = null;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println(
                                "Fecha no válida. Usa el formato AAAA-MM-DD."
                        );
                    }
                }

                // Mostrar los datos registrados
                System.out.println("\nCita registrada correctamente.");
                System.out.println("Marca: " + marca);
                System.out.println("Modelo: " + modelo);
                System.out.println("Matrícula: " + matricula);
                System.out.println("Fecha de la cita: " + fecha);

            } else if (opcion == 2) {
                System.out.println("Consultar citas por fecha (pendiente).");

            } else if (opcion == 3) {
                System.out.println("Calcular coste de servicio (pendiente).");

            } else if (opcion == 4) {
                salir = true;
                System.out.println("Saliendo del programa...");

            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }
}
