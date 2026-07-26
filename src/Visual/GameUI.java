package Visual;

import Audio.AudioPlayer;
import BoardGame.Cards.Card;
import BoardGame.TurnCycle.TurnCycle;
import BoardGame.Write.Write;

import javax.swing.*;
import java.awt.*;

import static Main.Main.scale;

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
                AudioPlayer.playSound("select",100);
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


    public static void DrawSelected(Card card, Graphics2D g2d, int cx, int cy){
        Sprite selected = new Sprite("Assets/UI/selector.png");
        int x = selected.get().getWidth();
        int y = selected.get().getHeight();

        // 1. Esquina Superior Izquierda (Normal)
        g2d.drawImage(selected.get(), cx-x, cy-y, x * scale, y * scale, null);

        // 2. Esquina Inferior Derecha (Invertido en X e Y)
        g2d.drawImage(selected.get(), cx+x + (card.sizex * scale), cy+y + (card.sizey * scale), -x * scale, -y * scale, null);

        // 3. Esquina Inferior Izquierda (Invertido en Y)
        g2d.drawImage(selected.get(), cx-x, cy+y + (card.sizey * scale), x * scale, -y * scale, null);

        // 4. Esquina Superior Derecha (Invertido en X)
        g2d.drawImage(selected.get(), cx+x + (card.sizex * scale), cy-y, -x * scale, y * scale, null);
    }



}
