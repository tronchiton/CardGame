package Cards;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Cardloader {


    public static <T extends Card> ArrayList<T> load(String TYPE) {
        Gson gson = new Gson();

        ArrayList<T> listaCartas = new ArrayList<>();

        Class<?> claseArray;
        switch (TYPE.toUpperCase()) {
            case "CHAR":
                claseArray = CHAR[].class;
                break;
            case "BATTLE":
                claseArray = BATTLE[].class;
                break;
            case "OBJ":
                claseArray = OBJ[].class;
                break;

            default:
                System.out.println("Error: El tipo de carta '" + TYPE + "' no está registrado.");
                return listaCartas;
        }


        try (FileReader reader = new FileReader("Data/Cards" + TYPE + ".json")) {

            T[] cartasCargadas = (T[]) gson.fromJson(reader, claseArray);

            if (cartasCargadas != null) {
                listaCartas.addAll(Arrays.asList(cartasCargadas));
            }

            for (T carta : listaCartas) {
                System.out.println("Carta cargada en ArrayList: " + carta.toString());
            }

        } catch (IOException e) {
            System.out.println("Error al leer el json: " + e.getMessage());
        }

        return listaCartas;
    }
}
