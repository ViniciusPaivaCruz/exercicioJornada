import java.util.ArrayList;
public class Jornada {
    ArrayList<ArrayList<float[]>> horarios = new ArrayList<>();
    public Jornada() {
        ArrayList<float[]> horario1 = new ArrayList<>();
        horario1.add(new float[]{0, 2, 1.5f});
        horario1.add(new float[]{2, 12, 1});
        horario1.add(new float[]{12, 14, 1.5f});
        horario1.add(new float[]{14, 24, 2});
 
        ArrayList<float[]> horario2 = new ArrayList<>();
        horario2.add(new float[]{18, 20, 1.5f});
        horario2.add(new float[]{20, 6, 1});
        horario2.add(new float[]{6, 8, 1.5f});
        horario2.add(new float[]{8, 18, 2});

        ArrayList<float[]> horario3 = new ArrayList<>();
        horario3.add(new float[]{22, 6, 2});
        horario3.add(new float[]{6, 8, 1.5f});
        horario3.add(new float[]{8, 18, 1});
        horario3.add(new float[]{18, 22, 1.5f});
 
        horarios.add(horario1);
        horarios.add(horario2);
        horarios.add(horario3);
    }

    public ArrayList<float[]> getHorario(int numero) {
        switch (numero) {
            case 1:
                return horarios.get(0);
            case 2:
                return horarios.get(1);
            case 3:
                return horarios.get(2);
            default:
                return null;
        }
    }
}