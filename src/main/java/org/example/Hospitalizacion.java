package org.example;

public class Hospitalizacion {
    private float costoPorDia;
    private int diasEstancia;

    public Hospitalizacion(float costoPorDia, int diasEstancia) {
        this.costoPorDia = costoPorDia;
        this.diasEstancia = diasEstancia;
    }

    public float getCostoTotal() {
        return costoPorDia * diasEstancia;
    }

    public float getCostoPorDia() {
        return costoPorDia;
    }

    public int getDiasEstancia() {
        return diasEstancia;
    }
}