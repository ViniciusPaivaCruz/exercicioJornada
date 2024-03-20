import java.util.ArrayList;
public class Main {
    public static float horas_trabalhadas(ArrayList<float[]> horario, float h1, float h2) {
        float result = 0;
 
        if(h1 > h2){
            if(24 - h1 + h2 >= 6){ result += 1.5f; }
        } else {
            if(h2 - h1 > 6){ result += 1.5f; }
        }
        for (float[] intervalo : horario) {
            float inicio = intervalo[0];
            float fim = intervalo[1];
            float valor = intervalo[2];
 
            if (inicio > fim) {
                result = calcular(result, h1, h2, inicio, 24, valor);
                result = calcular(result, h1, h2, 0, fim, valor);
            } else {
                result = calcular(result, h1, h2, inicio, fim, valor);
            }
        }
        return result;
    }
 
    public static float calcular(float result, float h1, float h2, float inicio, float fim, float valor) {
        if (h1 > h2) {
            float x = 0;
            x = calcular(result, h1, 24, inicio, fim, valor);
            x = calcular(x, 0, h2, inicio, fim, valor);
            return x;
        }
        if (h1 >= inicio && h1 < fim) {
            if (h2 < fim) {
                result += (h2 - h1) * valor;
            } else {
                result += (fim - h1) * valor;
            }
        } else if (h2 > inicio) {
            if (h2 <= fim) {
                result += (h2 - inicio) * valor;
            } else if (h1 < inicio && h2 > fim){
                result += (fim - inicio) * valor;
            }
        }
        return result;
    }
 
    public static void main(String[] args) {
        Jornada jornada = new Jornada();
        ArrayList<float[]> horario = jornada.getHorario(3);
        System.out.println(horas_trabalhadas(horario, 8,12));
        System.out.println(horas_trabalhadas(horario, 13,18));
        System.out.println(horas_trabalhadas(horario, 8, 18));
        System.out.println(horas_trabalhadas(horario, 14, 19));
        System.out.println(horas_trabalhadas(horario, 6, 12));
        System.out.println(horas_trabalhadas(horario, 6, 13));
        System.out.println(horas_trabalhadas(horario, 17, 23));
        System.out.println(horas_trabalhadas(horario, 0, 9));
        System.out.println(horas_trabalhadas(horario, 22, 2));
        System.out.println(horas_trabalhadas(horario, 14, 2));
 
        // Referencia
        // horario3.add(new float[]{8, 18, 1});
        // horario3.add(new float[]{18, 22, 1.5f});
        // horario3.add(new float[]{22, 6, 2});
        // horario3.add(new float[]{6, 8, 1.5f});
    }
}