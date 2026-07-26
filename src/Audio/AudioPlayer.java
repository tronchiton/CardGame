package Audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class AudioPlayer {

    /**
     * Reproduce un archivo de audio con controles normalizados.
     *
     * @param nombre       Nombre del archivo (sin extensión .wav)
     * @param volumen      Nivel de 0 (silencio) a 100 (máximo volumen)
      Cambio de tono centrado en 0 (0 es normal, -1.0 es la mitad, 1.0 es el doble)
     */
    public static void playSound(String nombre, float volumen) {
        try {
            File archivoAudio = new File("Sounds/" + nombre + ".wav");

            if (!archivoAudio.exists()) {
                System.out.println("No se encontró el archivo de audio.");
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // 1. CONTROL DE VOLUMEN (Escala de 0 a 100)
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                // Mapea el rango 0-100 a un multiplicador lineal entre 0.0001 y 1.0
                float multiplicadorLineal = volumen / 100.0f;
                if (multiplicadorLineal < 0.0f) multiplicadorLineal = 0.0f;
                if (multiplicadorLineal > 1.0f) multiplicadorLineal = 1.0f;

                // Convierte a decibelios (dB)
                float dB = (float) (Math.log(multiplicadorLineal <= 0.0f ? 0.0001f : multiplicadorLineal) / Math.log(10.0) * 20.0);

                dB = Math.max(gainControl.getMinimum(), Math.min(gainControl.getMaximum(), dB));
                gainControl.setValue(dB);
            }


            clip.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir el audio: " + e.getMessage());
        }
    }
}