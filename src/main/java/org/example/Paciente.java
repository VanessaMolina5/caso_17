package org.example;
public class Paciente {
    private String id;
    private String nombre;
    private String fechaIngreso;
    private String fechaSalida;

    private Servicios servicioPrincipal;
    private Hospitalizacion[] hospitalizaciones;
    private ServiciosAdicionales[] serviciosAdicionales;
    private int numHospitalizaciones;
    private int numServiciosAdicionales;

    public Paciente(String id, String nombre, String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.hospitalizaciones = new Hospitalizacion[10];
        this.serviciosAdicionales = new ServiciosAdicionales[10];
        this.numHospitalizaciones = 0;
        this.numServiciosAdicionales = 0;
    }

    public void setServicioPrincipal(Servicios servicio) {
        this.servicioPrincipal = servicio;
    }

    public void agregarHospitalizacion(Hospitalizacion hosp) {
        if (numHospitalizaciones < hospitalizaciones.length) {
            hospitalizaciones[numHospitalizaciones] = hosp;
            numHospitalizaciones++;
        } else {
            System.out.println("Error: No se pueden agregar más hospitalizaciones.");
        }
    }

    public void agregarServicioAdicional(ServiciosAdicionales servicio) {
        if (numServiciosAdicionales < serviciosAdicionales.length) {
            serviciosAdicionales[numServiciosAdicionales] = servicio;
            numServiciosAdicionales++;
        } else {
            System.out.println("Error: No se pueden agregar más servicios adicionales.");
        }
    }

    public String getId() {
         return id; 
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

    public Servicios getServicioPrincipal() { 
        return servicioPrincipal; 
    }

    public Hospitalizacion[] getHospitalizaciones() { 
        return hospitalizaciones; 
    }

    public ServiciosAdicionales[] getServiciosAdicionales() { 
        return serviciosAdicionales; 
    }

    public int getNumHospitalizaciones() { 
        return numHospitalizaciones; 
    }

    public int getNumServiciosAdicionales() { 
        return numServiciosAdicionales; 
    }
    
    public void setFechaSalida(String fechaSalida) {
         this.fechaSalida = fechaSalida; 
        }
}