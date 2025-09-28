

public class Hospitalizacion {
    Paciente paciente;
    int diasEstancia;
    float costoDia;

    public Hospitalizacion(Paciente paciente, float costoDia, int diasEstancia) {
        this.paciente = paciente;
        this.costoDia=costoDia;
        this.diasEstancia = diasEstancia;

    }

    public Paciente getPaciente() {
        return paciente;
    }

    public float getCostoDia() {

        return costoDia;
    }


    public int getDiasEstancia() {
        return diasEstancia;
    }

    public float getCalcularTotal() {
        return costoDia * diasEstancia;
    }


}

