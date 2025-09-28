package org.example;

public class Servicios {
    int tipoServicio;
    float precioServicio;
    String[] tipoServicios = {"Urgencia", "Internamiento"};


    public Servicios (int tipoServicio, float precioServicio){
     this.tipoServicio= tipoServicio;
     this.precioServicio=precioServicio;

    }
    public int getTipoServicio() {
        return tipoServicio;
    }
    public float getPrecioServicio() {
        return precioServicio;
    }

public String getNombreServicios() {
        return tipoServicios[tipoServicio];
}

}

