import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Barco extends Thread {

    private String nombre;
    private int capacidad;
    private int tiempoRescate;
    private Semaphore sem;
    private List<Pasajero> pasajeros;

    public Barco(String nombre, int capacidad, int tiempoRescate, List<Pasajero> listaCompartida, Semaphore sem) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempoRescate = tiempoRescate;
        this.sem = sem;
        this.pasajeros = listaCompartida;
    }

    @Override
    public void run() {
        while (true) {
            List<Pasajero> rescatadosEnEsteViaje = new ArrayList<>();

            try {
                // Sección Crítica: Acceso a la lista compartida protegido por Semáforo
                sem.acquire(); 
                try {
                    if (pasajeros.isEmpty()) {
                        break; // Sale del bucle while, ejecutando finally antes
                    }

                    // Llenar el barco
                    for (int i = 0; i < capacidad; i++) {
                        if (!pasajeros.isEmpty()) {
                            Pasajero p = pasajeros.remove(0);
                            rescatadosEnEsteViaje.add(p);
                        }
                    }
                } finally {
                    sem.release(); // Liberar el semáforo
                }

                // Simular tiempo de rescate (fuera de la sección crítica para permitir concurrencia)
                if (!rescatadosEnEsteViaje.isEmpty()) {
                    System.out.println("El barco " + nombre + " ha rescatado a " + rescatadosEnEsteViaje.size() + " personas: " + rescatadosEnEsteViaje);
                    Thread.sleep(tiempoRescate);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(">>> " + nombre + " ha terminado su labor de rescate.");
    }
}
