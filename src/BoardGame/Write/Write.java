package BoardGame.Write;

import BoardGame.Cards.Card;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Main.Main;



public class Write {

    public enum alignement{
        center, left,right

    }

    private static final Map<String, Font> FuentesCargadas = new HashMap<>();



    public static Font loadFont(String name, float size) {

        switch ((name.toLowerCase())) {
            case "pixel", "minecraft","p" -> name = "Minecraftia-Regular";
        }



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

    public static void write(Graphics2D g2D, String Text, String Font, Color Color, float size, int x, int y, alignement align){

        Font Fonty= loadFont(Font,size);
        FontMetrics metric = g2D.getFontMetrics(Fonty);

        g2D.setColor(Color);
        g2D.setFont(Fonty);

        if (align == alignement.center){
        g2D.drawString(Text,x-metric.stringWidth(Text)/2,y+metric.getHeight());
        }
        if (align == alignement.left){
            g2D.drawString(Text,x,y+metric.getHeight());
        }
        if (align == alignement.right){
            g2D.drawString(Text,x+metric.stringWidth(Text),y+metric.getHeight());
        }
    }
    public static void writeOnCard(Graphics2D g2D, String text, String fontName, Color color, float size, Card card, int yRelativeToCard, int margin) {

        // 1. Configurar fuente, métricas y color
        Font fonty = loadFont(fontName, size);
        FontMetrics metric = g2D.getFontMetrics(fonty);
        g2D.setColor(color);
        g2D.setFont(fonty);

        // 2. Obtener la posición del centro de la carta respectiva a la cámara
        Entities.Utils.Point2D cardPosInCam = Main.Camara.RespectoCamara(card);

        // 3. Calcular bordes reales escalados (Igual que en tu método render)
        double leftEdge = cardPosInCam.getX() - (card.sizex * Main.scale) / 2.0;
        double topEdge  = cardPosInCam.getY() - (card.sizey * Main.scale) / 2.0;

        // 4. Calcular los límites de dibujo aplicando el margen y el escalado
        int scaledMargin = (int) (margin * Main.scale);
        int startX = (int) (leftEdge + scaledMargin);
        int maxWidth = (int) ((card.sizex * Main.scale) - (scaledMargin * 2));

        int lineHeight = metric.getHeight();
        // El offset 'y' recibido se escala para que encaje proporcionalmente si la carta se agranda/achica
        int currentY = (int) (topEdge + (yRelativeToCard * Main.scale));

        // 5. Separar el texto en palabras y procesar líneas
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            String testLine = currentLine.length() == 0 ? word : currentLine + " " + word;
            int testWidth = metric.stringWidth(testLine);

            if (testWidth <= maxWidth) {
                currentLine.append(currentLine.length() == 0 ? word : " " + word);
            } else {
                // Dibujar la línea en la coordenada calculada
                g2D.drawString(currentLine.toString(), startX, currentY);
                currentY += lineHeight;
                currentLine = new StringBuilder(word);
            }
        }

        // 6. Dibujar la última línea restante
        if (currentLine.length() > 0) {
            g2D.drawString(currentLine.toString(), startX, currentY);
        }
    }



}
