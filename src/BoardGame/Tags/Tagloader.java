package BoardGame.Tags;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class Tagloader {

    private static final String RUTA_JSON_FIJA = "Data/Tags.json";

    // Todas las variables ahora son estáticas (compartidas a nivel global)
    private static final Gson gson;
    private static final HashMap<String, Tag> diccionarioTags = new HashMap<>();

    // Bloque de inicialización estático: se ejecuta AUTOMÁTICAMENTE una sola vez
    // la primera vez que se use la clase Tagloader en el juego.
    static {
        JsonDeserializer<Tag> tagDeserializer = (json, typeOfT, context) -> {
            JsonObject jsonObject = json.getAsJsonObject();

            String id = jsonObject.get("ID").getAsString();

            ArrayList<Effect> effectsList = new ArrayList<>();
            if (jsonObject.has("effects")) {
                Type listType = new TypeToken<ArrayList<Effect>>(){}.getType();
                effectsList = context.deserialize(jsonObject.get("effects"), listType);
            }

            Tag created = new Tag(id, effectsList);

            if (jsonObject.has("effects")) {
                diccionarioTags.put(created.ID, created);
            }

            return created;
        };

        gson = new GsonBuilder()
                .registerTypeAdapter(Tag.class, tagDeserializer)
                .create();

        // Ejecuta la carga del archivo inmediatamente
        cargarDesdeArchivoFijo();
    }

    // Constructor privado para evitar que alguien intente hacer "new Tagloader()" por error
    private Tagloader() {}

    /**
     * Lee de forma interna el archivo de configuración único y llena el diccionario.
     */
    private static void cargarDesdeArchivoFijo() {
        try (FileReader reader = new FileReader(RUTA_JSON_FIJA)) {
            Type tipoLista = new TypeToken<ArrayList<Tag>>(){}.getType();
            gson.fromJson(reader, tipoLista);
            System.out.println("¡Tagloader Estático Inicializado! Diccionario cargado con " + diccionarioTags.size() + " etiquetas.");
        } catch (IOException e) {
            System.err.println("CRÍTICO: No se pudo cargar el archivo estático en " + RUTA_JSON_FIJA);
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una etiqueta del diccionario mediante su ID de forma global.
     */
    public static Tag getTag(String id) {
        return diccionarioTags.get(id);
    }
}