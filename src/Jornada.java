import java.util.ArrayList;
import java.util.List;

public class Jornada {
    private List<float[]> periodos;
    private String nome;
    private String descricao;
    private ArrayList<String> dias;
    private float apos;
    private float adicional;

    public Jornada(List<float[]> periodos, String nome, String descricao, ArrayList<String> dias, float apos, float adicional) {
        this.periodos = periodos;
        this.nome = nome;
        this.dias = dias;
        this.descricao = descricao;
        this.apos = apos;
        this.adicional = adicional;
    }

    public String getNome(){
        return this.nome;
    }
}