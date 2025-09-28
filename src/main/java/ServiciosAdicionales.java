public class ServiciosAdicionales {

    String[] nombreServicios = {"Consulta medica", "medicamentos", "Laboratorio"};
    int[] costosServicios = {800, 800, 1000};
    boolean[] serviciosUsados;


    public ServiciosAdicionales() {
        serviciosUsados = new boolean[nombreServicios.length];
    }

    public void agregarServicio(int indice) {
        serviciosUsados[indice] = true;
    }

    public int calcularCostoServicios() {
        int total=0;
        for (int i = 0; i < serviciosUsados.length; i++) {
            if (serviciosUsados[i]) {
                total += costosServicios[i];

            }
        } return total;
    }
}








