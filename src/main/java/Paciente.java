public class Paciente {
    String nombre;
    String fechaIngreso;
    String fechaSalida;

    public Paciente(String nombre, String fechaIngreso, String fechaSalida) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;

    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public String getFechaSalida() {
        return fechaSalida;
    }

    public void mostrarPaciente() {
        System.out.println("Ingrese el nombre de la paciente: ");
        System.out.println("Ingrese la fecha de registro del paciente: ");
    }



}
