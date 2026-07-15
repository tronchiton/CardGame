package BoardGame.Fight;

import java.util.Random;

public class Dice {
     static Random random = new Random();

    public static int lanzarDado(int lados){
        if (lados < 1) {
            throw new IllegalArgumentException("El número de lados debe ser al menos 1");
        }
        return random.nextInt(lados) + 1;
    }
    public static int lanzarDados(int ndados, int lados){
        if (ndados < 1) {
            throw new IllegalArgumentException("La cantidad de dados debe ser al menos 1");
        }
        // La validación de 'lados' la hereda el método lanzarDado

        int totalSuma = 0;
        for (int i = 0; i < ndados; i++) {
            totalSuma += lanzarDado(lados);
        }

        return totalSuma;
    }
}
