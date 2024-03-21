import java.util.ArrayList;
import java.util.List;

public class Escala {
    private List<Jornada> jornadas;

    public Escala() {
        this.jornadas = new ArrayList<>();
    }
    public void adicionarJornada(Jornada jornada) {
        jornadas.add(jornada);
    }
    
    public List<Jornada> getJornadas() {
        return jornadas;
    }
}