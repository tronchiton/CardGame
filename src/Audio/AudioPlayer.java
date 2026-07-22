package Audio;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.swing.JOptionPane;

public class AudioPlayer {

    public static void Play(String Nombre){
        try{
            File archivoAudio = new File("Sounds/"+Nombre+".wav");

            if (archivoAudio.exists()){
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

            }
            else {
                System.out.println("No se encontró el archivo de audio.");
            }
        }

        catch (Exception e){
            System.out.println("Error al reproducir el audio: " + e.getMessage());
        }


    }

}
