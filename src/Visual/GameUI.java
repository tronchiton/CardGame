package Visual;

import BoardGame.TurnCycle.TurnCycle;

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

            this.addActionListener(e -> {
                TurnCycle.nextTurn();
            });
        }

    }






    private static ImageIcon ScaledIcon (String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon("Assets/UI/"+ruta+".png");
        Image imagenEscalada = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}
