package Visual;


import Entities.Entity;
import Main.Main;
import  javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {



    public Interfaz(){

        this.setLayout(null);
        this.setSize(1920,1080);
        this.setTitle("Super Slime Jump");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setUndecorated(true);
        ImageIcon Icon= new ImageIcon("Assets/Icons/Battle.png");
        this.setIconImage(Icon.getImage());


    }
    public static class Pantalla extends JPanel {
        public Pantalla() {
            this.setLayout(null);
            Color Cielo = new Color(225, 220, 220);
            this.setBackground(Cielo);
            this.setBounds(0,0,1920,1080);
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            for (Entity ser : Main.Entities) {
                ser.render(g2D);
            }}}}

