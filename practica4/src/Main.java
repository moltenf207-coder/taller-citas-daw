import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

// Único método 1: Formatear fecha
public static String formatearFechaEspanol(LocalDateTime fechaHora) {
    if (fechaHora == null) {
        return "Fecha no disponible";
    }
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.forLanguageTag("es-ES"));
    return fechaHora.format(formato);
}

        // Único método 2: Leer y validar fecha
        public static LocalDateTime leerYValidarFecha(Scanner scanner) {
            String patron = "dd/MM/yyyy HH:mm";
            DateTimeFormatter formato = DateTimeFormatter.ofPattern(patron, Locale.forLanguageTag("es-ES"));

            System.out.print("Introduzca la fecha y hora de la cita (" + patron + "): ");
            String entrada = scanner.nextLine().trim();

            try {
                LocalDateTime fechaParseada = LocalDateTime.parse(entrada, formato);
                System.out.println("Fecha registrada correctamente.");
                return fechaParseada;
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Debe usar exactamente el formato: dd/MM/yyyy HH:mm");
                System.out.println("Se asignará la fecha y hora actual por defecto.");
                return LocalDateTime.now();
            }
        }

        // Único método 3: Probar el flujo
        public static void probarFormatoFecha(Scanner scanner) {
            System.out.println("\n--- CONSULTA Y REGISTRO DE FECHAS ---");

            LocalDateTime ahora = LocalDateTime.now();
            System.out.println("Fecha y hora actual del sistema: " + formatearFechaEspanol(ahora));

            LocalDateTime fechaCita = leerYValidarFecha(scanner);
            System.out.println("Cita fijada para el: " + formatearFechaEspanol(fechaCita));
        }