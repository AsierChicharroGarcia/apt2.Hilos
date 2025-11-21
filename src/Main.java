import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Pasajero> tripulacion = new ArrayList<>();
        Random rand = new Random();


        for (int i = 1; i <= 352; i++) {

            int prioridad = rand.nextInt(4) + 1;
            tripulacion.add(new Pasajero(i, prioridad));
        }

        System.out.println("Tripulación en peligro: " + tripulacion.size() + " personas.");


        Collections.sort(tripulacion);
        System.out.println("Prioridades organizadas. ¡Comienza el rescate!");


        Barco acasta = new Barco("Acasta", 1, 500, tripulacion);
        Barco banff = new Barco("Banff", 2, 1000, tripulacion);
        Barco cadiz = new Barco("Cadiz", 3, 2000, tripulacion);
        Barco deimos = new Barco("Deimos", 4, 4000, tripulacion);
        Barco expedicion = new Barco("Expedición", 5, 8000, tripulacion);


        acasta.start();
        banff.start();
        cadiz.start();
        deimos.start();
        expedicion.start();


        try {
            acasta.join();
            banff.join();
            cadiz.join();
            deimos.join();
            expedicion.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("¡Rescate finalizado! Quedan " + tripulacion.size() + " personas en el agua.");
    }
}