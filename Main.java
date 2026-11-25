public class Main {
    public static void main(String[] args) {
        ContadorOperacionesDia tableroCajeros = ContadorOperacionesDia.getInstancia();
        ContadorOperacionesDia tableroApp = ContadorOperacionesDia.getInstancia();

        // Los cajeros suman 2 éxitos y 1 error
        tableroCajeros.sumarExito();
        tableroCajeros.sumarExito();
        tableroCajeros.sumarError();

        // La app móvil suma 1 éxito más
        tableroApp.sumarExito();

        // El gerente mira el resumen completo consolidado
        tableroApp.mostrarResumenDia();
        System.out.println("¿Mismo contador?: " + (tableroCajeros == tableroApp));
    }
}