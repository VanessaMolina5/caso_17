package org.example;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    private static Paciente[] pacientes = new Paciente[100];

    private static int numeroPacientes = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n==== SISTEMA DE GESTIÓN HOSPITALARIA ====");
            System.out.println("1. Registrar Nuevo Paciente");
            System.out.println("2. Agregar Servicios a Paciente");
            System.out.println("3. Calcular Cobro Total");
            System.out.println("4. Generar Ticket de Salida");
            System.out.println("5. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1: registrarPaciente(); break;
                case 2: agregarServicios(); break;
                case 3: cobrar(); break;
                case 4: generarTicket(); break;
                case 5: System.out.println("Cerrando el sistema..."); break;
                default: System.out.println("Error: Opción no válida. Intente de nuevo.");
            }
        }
    }
    
    private static void registrarPaciente() {
        if (numeroPacientes >= pacientes.length) {
            System.out.println("Error: La capacidad máxima del sistema ha sido alcanzada.");
            return;
        }
        
        System.out.println("\n--- Registro de Nuevo Paciente ---");
        System.out.print("Nombre completo del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha de Ingreso (dd/mm/aaaa): ");
        String fecha = scanner.nextLine();
        System.out.print("ID del paciente: ");
        String id = scanner.nextLine();
        
        Paciente p = new Paciente(id, nombre, fecha);
        
        System.out.print("Servicio principal de ingreso (ej. Urgencias): ");
        String tipoServicio = scanner.nextLine();
        System.out.print("Costo del servicio principal: ");
        int costo = Integer.parseInt(scanner.nextLine());
        
        p.setServicioPrincipal(new Servicios(tipoServicio, costo));
        
        pacientes[numeroPacientes] = p;
        numeroPacientes++;
        
        System.out.println("Confirmación: Paciente '" + nombre + "' ha sido registrado(a) exitosamente.");
    }

    private static void agregarServicios() {
        if (numeroPacientes == 0) {
            System.out.println("Aviso: No hay pacientes registrados en el sistema.");
            return;
        }

        System.out.println("\n--- Lista de Pacientes Registrados ---");
        for (int i = 0; i < numeroPacientes; i++) {
            System.out.println(i + ". " + pacientes[i].getNombre());
        }
        System.out.print("Seleccione el número del paciente: ");
        int indice = Integer.parseInt(scanner.nextLine());

        if (indice < 0 || indice >= numeroPacientes) {
            System.out.println("Error: El número seleccionado no es válido.");
            return;
        }
        
        Paciente p = pacientes[indice];

        System.out.println("\nSeleccione la operación para " + p.getNombre() + ":");
        System.out.println("1. Registrar Costo por Día de Hospitalización");
        System.out.println("2. Agregar Servicio Adicional");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        if (opcion == 1) {
            System.out.print("Ingrese el costo por día de hospitalización: ");
            float costoDia = Float.parseFloat(scanner.nextLine());
            p.agregarHospitalizacion(new Hospitalizacion(costoDia, 0));
             System.out.println("Confirmación: Costo por día registrado correctamente.");
        } else if (opcion == 2) {
            System.out.print("Nombre del servicio adicional: ");
            String tipo = scanner.nextLine();
            System.out.print("Costo del servicio: ");
            int costo = Integer.parseInt(scanner.nextLine());
            p.agregarServicioAdicional(new ServiciosAdicionales(tipo, costo));
            System.out.println("Confirmación: Servicio adicional agregado.");
        }
    }
    
    private static void cobrar() {
        if (numeroPacientes == 0) {
            System.out.println("Aviso: No hay pacientes registrados en el sistema.");
            return;
        }

        System.out.println("\n--- Lista de Pacientes Registrados ---");
        for (int i = 0; i < numeroPacientes; i++) {
            System.out.println(i + ". " + pacientes[i].getNombre());
        }
        System.out.print("Seleccione el número del paciente para calcular el cobro: ");
        int indice = Integer.parseInt(scanner.nextLine());

        if (indice < 0 || indice >= numeroPacientes) {
            System.out.println("Error: El número seleccionado no es válido.");
            return;
        }
        
        Paciente p = pacientes[indice];
        
        System.out.print("Para el cálculo, ingrese la fecha de salida (dd/mm/aaaa): ");
        String fechaSalida = scanner.nextLine();
        
        long diasEstancia = calcularDiasEstancia(p.getFechaIngreso(), fechaSalida);
        float total = calcularTotalPaciente(p, diasEstancia);

        System.out.printf("\nEl cobro total para el paciente %s (estancia de %d días) es: $%.2f\n", p.getNombre(), diasEstancia, total);
    }
    
    private static void generarTicket() {
        if (numeroPacientes == 0) {
            System.out.println("Aviso: No hay pacientes para generar un ticket.");
            return;
        }

        System.out.println("\n--- Lista de Pacientes Registrados ---");
        for (int i = 0; i < numeroPacientes; i++) {
            System.out.println(i + ". " + pacientes[i].getNombre());
        }
        System.out.print("Seleccione el número del paciente para generar su ticket: ");
        int indice = Integer.parseInt(scanner.nextLine());

        if (indice < 0 || indice >= numeroPacientes) {
            System.out.println("Error: El número seleccionado no es válido.");
            return;
        }
        
        Paciente p = pacientes[indice];
        
        System.out.print("Ingrese la fecha de salida (dd/mm/aaaa): ");
        String fechaSalida = scanner.nextLine();
        p.setFechaSalida(fechaSalida);

        long diasEstancia = calcularDiasEstancia(p.getFechaIngreso(), p.getFechaSalida());
        float total = calcularTotalPaciente(p, diasEstancia);

        System.out.println("\n**************** TICKET DE PAGO ****************");
        System.out.println("Paciente: " + p.getNombre() + " (ID: " + p.getId() + ")");
        System.out.println("Fecha de Ingreso: " + p.getFechaIngreso());
        System.out.println("Fecha de Salida: " + p.getFechaSalida());
        System.out.println("Días Totales de Estancia: " + diasEstancia);
        System.out.println("----------------------------------------------");
        System.out.println("DETALLE DE CARGOS:");

        System.out.printf("- %-25s: $%d\n", p.getServicioPrincipal().getTipoServicio(), p.getServicioPrincipal().getPrecioServicio());
        
        for (int i = 0; i < p.getNumHospitalizaciones(); i++) {
            Hospitalizacion h = p.getHospitalizaciones()[i];
            float costoTotalEstancia = (float)diasEstancia * h.getCostoPorDia();
            System.out.printf("- Hospitalización (%d días a $%.2f/día): $%.2f\n", diasEstancia, h.getCostoPorDia(), costoTotalEstancia);
        }
        
        for (int i = 0; i < p.getNumServiciosAdicionales(); i++) {
            ServiciosAdicionales sa = p.getServiciosAdicionales()[i];
            System.out.printf("- %-25s: $%d\n", sa.getTipoServicio(), sa.getPrecioServicio());
        }

        System.out.println("----------------------------------------------");
        System.out.printf("TOTAL A PAGAR: $%.2f\n", total);
        System.out.println("**********************************************");
    }
    
    private static long calcularDiasEstancia(String fechaIngreso, String fechaSalida) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate inicio = LocalDate.parse(fechaIngreso, formato);
            LocalDate fin = LocalDate.parse(fechaSalida, formato);
            long dias = ChronoUnit.DAYS.between(inicio, fin);
            return dias == 0 ? 1 : dias;
        } catch (Exception e) {
            System.out.println("Error en el formato de fecha. Se asumirán 0 días de estancia.");
            return 0;
        }
    }


    private static float calcularTotalPaciente(Paciente p, long diasEstancia) {
    float total = 0;
    
    if (p.getServicioPrincipal() != null) {
        total += p.getServicioPrincipal().getPrecioServicio();
    }
    
    for (int i = 0; i < p.getNumHospitalizaciones(); i++) {
        total += diasEstancia * p.getHospitalizaciones()[i].getCostoPorDia();
    }

    for (int i = 0; i < p.getNumServiciosAdicionales(); i++) {
        total += p.getServiciosAdicionales()[i].getPrecioServicio();
    }
    
    return total;
}
}