public class Pasajero implements Comparable<Pasajero>{

    private int id;
    private int prioridad;

    public Pasajero(int id, int prioridad) {
        this.id = id;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "id='" + id + '\'' +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pasajero o) {
        return 0;
    }
}
