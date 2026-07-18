package BoardGame.Write;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Write {


    private static final Map<String, Font> FuentesCargadas = new HashMap<>();

    public static Font PixelatedFont= loadFont("Minecraftia-regular",20);


    public static Font loadFont(String name, float size) {
        Font fuenteBase = FuentesCargadas.get(name);

        if (fuenteBase == null) {
            try {
                File archivo = new File("Fonts/" + name + ".ttf");

                if (!archivo.exists()) {
                    throw new IOException("El archivo no existe en: " + archivo.getAbsolutePath());
                }

                fuenteBase = Font.createFont(Font.TRUETYPE_FONT, archivo);

                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(fuenteBase);

                FuentesCargadas.put(name, fuenteBase);

            } catch (FontFormatException e) {
                System.err.println("Error: El formato del archivo para '" + name + "' no es un TrueType valido.");
                return new Font("SansSerif", Font.PLAIN, (int) size); // Fuente de respaldo

            } catch (IOException e) {
                System.err.println("Error al leer la fuente '" + name + "'. Detalle: " + e.getMessage());
                return new Font("SansSerif", Font.PLAIN, (int) size); // Fuente de respaldo
            }
        }

        return fuenteBase.deriveFont(Font.PLAIN, size);
    }

    public void write(Graphics2D g2D){

    }



}
