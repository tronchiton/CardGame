package Visual;

import BoardGame.TurnCycle.TurnCycle;
import BoardGame.Write.Write;

import javax.swing.*;
import java.awt.*;

public class GameUI {



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
                TurnCycle.nextTurn();
            });

        }

    }
    public static class Turn extends JLabel {

        public Turn(){
            this.setBounds(0, 0, 50, 10);
            this.setFont(Write.loadFont("pixel",14));
            this.setForeground(Color.BLACK);

        }
        public void update (int value){
        this.setText("Turn:"+value);
        }

    }





    private static ImageIcon ScaledIcon (String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon("Assets/UI/"+ruta+".png");
        Image imagenEscalada = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}
