package BoardGame.Cards;

import Main.Main;
import Visual.Sprite;
import com.google.gson.Gson;

import java.io.File;
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
            carta.setPosition(-5000,-5000);
            carta.setsizeX(95);
            carta.setsizeY(130);
            carta.setacceleration(0,0);
            carta.setSpeed(0,0);
            carta.setAngularSpeed(0);
            carta.setAngularAcceleration(0);
                Main.Entities.add(carta);


                String rutaBack = "Assets/Backs/" + TYPE + "Back.png";
                String rutaFront = "Assets/Fronts/" + TYPE + "Front.png";

                File archivoBack = new File(rutaBack);
                File archivoFront = new File(rutaFront);

                if (!archivoBack.exists()) {
                    System.out.println("No se encontró el archivo: " + rutaBack + ". Usando DefaultBack.");
                    rutaBack = "Assets/Backs/default.png";
                }

                if (!archivoFront.exists()) {
                    System.out.println("No se encontró el archivo: " + rutaFront + ". Usando DefaultFront.");
                    rutaFront = "Assets/Fronts/default.png";
                }
                carta.BackSprite = new Sprite(rutaBack);
                carta.FrontSprite = new Sprite(rutaFront);

            }




        } catch (IOException e) {
            System.out.println("Error al leer el json: " + e.getMessage());
        }

        return listaCartas;
    }
}
