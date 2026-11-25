public class ContadorOperacionesDia {
    private static ContadorOperacionesDia instancia;
    private int operacionesExitosas;
    private int operacionesFallidas;

    private ContadorOperacionesDia() {
        this.operacionesExitosas = 0;
        this.operacionesFallidas = 0;
    }

    public static ContadorOperacionesDia getInstancia() {
        if (instancia == null) {
            instancia = new ContadorOperacionesDia();
        }
        return instancia;
    }

    public void sumarExito() {
        operacionesExitosas++;
    }

    public void sumarError() {
        operacionesFallidas++;
    }

    public void mostrarResumenDia() {
        System.out.println("=== RESUMEN DE ACTIVIDAD DEL BANCO ===");
        System.out.println("Operaciones exitosas: " + operacionesExitosas);
        System.out.println("Operaciones con error: " + operacionesFallidas);
        System.out.println("Total procesado: " + (operacionesExitosas + operacionesFallidas));
    }
}