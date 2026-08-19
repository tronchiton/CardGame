package Visual;

import Audio.AudioPlayer;
import BoardGame.Cards.Card;
import BoardGame.Cards.OBJ;
import BoardGame.PlayerRelated.CurrentPlayerManager;
import BoardGame.TurnCycle.TurnCycle;
import BoardGame.Write.Write;

import javax.swing.*;
import java.awt.*;

import static Main.Main.Camara;
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


    public static void DrawSelected(Card card, Graphics2D g2d, int cx, int cy, int cardWidth, int cardHeight){
        Sprite selected = new Sprite("Assets/UI/selector.png");
        int x = selected.get().getWidth();
        int y = selected.get().getHeight();

        // 1. Esquina Superior Izquierda (Normal)
        g2d.drawImage(selected.get(), cx-x, cy-y, x * scale, y * scale, null);

        // 2. Esquina Inferior Derecha (Invertido en X e Y)
        g2d.drawImage(selected.get(), cx+x + cardWidth, cy+y + cardHeight, -x * scale, -y * scale, null);

        // 3. Esquina Inferior Izquierda (Invertido en Y)
        g2d.drawImage(selected.get(), cx-x, cy+y + cardHeight, x * scale, -y * scale, null);

        // 4. Esquina Superior Derecha (Invertido en X)
        g2d.drawImage(selected.get(), cx+x + cardWidth, cy-y, -x * scale, y * scale, null);
    }

public static class Equip extends JButton{
    private final ImageIcon imgBase=ScaledIcon("ArrowbuttonUp",100,100);
    private final ImageIcon imgHover=ScaledIcon("ArrowbuttonDown",100,100);
    OBJ card;


    public Equip(OBJ card){
        this.card=card;
        this.setIcon(imgBase);
        this.setPressedIcon(imgHover);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBounds((int) Camara.RespectoCamara(card).getX(), (int) Camara.RespectoCamara(card).getY(), 100, 100);

        this.addActionListener(e -> {
            AudioPlayer.playSound("select",100);
            CurrentPlayerManager.activePlayer.Active.add(card);
        });

    }

}

}
