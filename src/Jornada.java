import java.util.ArrayList;
import java.util.List;

public class Jornada {
    private List<float[]> periodos;
    private String nome;
    private String descricao;
    private float apos;
    private float adicional;

    public Jornada(List<float[]> periodos, String nome, String descricao, float apos, float adicional) {
        this.periodos = periodos;
        this.nome = nome;
        this.descricao = descricao;
        this.apos = apos;
        this.adicional = adicional;
    }
}