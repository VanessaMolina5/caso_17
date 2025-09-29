package org.example;

public class ServiciosAdicionales {
    private String tipoServicio;
    private int precioServicio;

    public ServiciosAdicionales(String tipoServicio, int precioServicio) {
        this.tipoServicio = tipoServicio;
        this.precioServicio = precioServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public int getPrecioServicio() {
        return precioServicio;
    }
}
