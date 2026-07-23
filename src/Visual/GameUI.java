package Visual;

import Audio.AudioPlayer;
import BoardGame.TurnCycle.TurnCycle;
import BoardGame.Write.Write;

import javax.swing.*;
import java.awt.*;

public class GameUI {
static int Turnshow;
static int Roundshow;
public static Turn TurnLabel;
public static Round RoundLabel;

    public static void update(int TurnIndex, int RoundIndex){
        if (TurnLabel ==null)return;
        TurnLabel.updater(TurnIndex);
        RoundLabel.updater(RoundIndex);
    }


    public static class NextTurn extends JButton{
        private final ImageIcon imgBase=ScaledIcon("ArrowbuttonUp",100,100);
        private final ImageIcon imgHover=ScaledIcon("ArrowbuttonDown",100,100);

        public NextTurn(){
            this.setIcon(imgBase);
            this.setPressedIcon(imgHover);
            this.setBorderPainted(false);
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setBounds(1820, 0, 100, 100);

            this.addActionListener(e -> {
                AudioPlayer.PlaySound("select");
                TurnCycle.nextTurn();
            });

        }

    }
    public static class Turn extends JLabel {

        public Turn(){
            this.setBounds(1700, 10, 150, 50);
            this.setFont(Write.loadFont("pixel",20));
            this.setForeground(Color.BLACK);
            this.setText("Player  1");
        }
        public void updater(int value){
        this.setText("Player  "+(value+1));
        }

    }
    public static class Round extends JLabel {

        public Round(){
            this.setBounds(1700, 35, 150, 50);
            this.setFont(Write.loadFont("pixel",20));
            this.setForeground(Color.BLACK);
            this.setText("Round 1");
        }
        public void updater(int value){
            this.setText("Round "+(value+1));
        }

    }





    private static ImageIcon ScaledIcon (String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon("Assets/UI/"+ruta+".png");
        Image imagenEscalada = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}
