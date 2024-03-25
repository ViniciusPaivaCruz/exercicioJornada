import java.util.ArrayList;
import java.util.List;

public class Escala {
    private ArrayList<Jornada> jornadas;

    public Escala(ArrayList<Jornada> jornadas) {
        this.jornadas = jornadas;
    }
    
    public List<Jornada> getJornadas() {
        return jornadas;
    }
}