import java.util.ArrayList;
import java.util.List;

public class Barco extends Thread {


    private String nombre;
    private int capacidad;
    private int tiempoRescate;


    private List<Pasajero> pasajeros;

    public Barco(String nombre, int capacidad, int tiempoRescate, List<Pasajero> listaCompartida) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempoRescate = tiempoRescate;

        this.pasajeros = listaCompartida;
    }

    @Override
    public void run() {

        while (true) {
            List<Pasajero> rescatadosEnEsteViaje = new ArrayList<>();

            synchronized (pasajeros) {
                if (pasajeros.isEmpty()) {
                    break;
                }


                for (int i = 0; i < capacidad; i++) {
                    if (!pasajeros.isEmpty()) {

                        Pasajero p = pasajeros.remove(0);
                        rescatadosEnEsteViaje.add(p);
                    }
                }
            }

            if (!rescatadosEnEsteViaje.isEmpty()) {
                System.out.println("El barco " + nombre + " ha rescatado a: " + rescatadosEnEsteViaje);
                try {
                    Thread.sleep(tiempoRescate);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(nombre + " ha terminado su rescate.");
    }
}