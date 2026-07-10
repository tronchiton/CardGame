package Visual;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    private BufferedImage imagen;


    public Sprite(String nombre) {
        try {
            this.imagen = ImageIO.read(new File( nombre));
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public BufferedImage get() {
        return imagen;
    }
    }
