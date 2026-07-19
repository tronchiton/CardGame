package Main;

import BoardGame.Cards.*;
import BoardGame.PlayerRelated.Player;
import Entities.Camera;
import Entities.Entity;
import Visual.Interfaz;

import java.util.ArrayList;


public class Main {
    static long tiempoAnterior = System.nanoTime();
    public static  int scale=3;
    static Interfaz Interfaz= new Interfaz();
    static Interfaz.Pantalla Pantalla=new Interfaz.Pantalla();

    public static ArrayList<Entity> Entities = new ArrayList<>();
    public static ArrayList<Player> Players= new ArrayList<>();

    public static Pile Personajes;
    public static Pile Batallas;
    public static Pile Objetos;

    public static Camera Camara=new Camera(1920, 1080);


    public static void main(String[] args) {

        InitGame.start();


        Interfaz.add(Pantalla);
        Interfaz.setVisible(true);

        new javax.swing.Timer(10, e -> {
            long tiempoActual = System.nanoTime();
            double dt = (tiempoActual - tiempoAnterior) / 1_000_000_000.0;
            tiempoAnterior = tiempoActual;
            if (dt > 0.05) {dt = 0.05;}
            for (Entity ser : Entities) {

                ser.mover(dt);
                ser.whoble();
                ser.act();


            }
            Pantalla.repaint();}).start();


    }
}