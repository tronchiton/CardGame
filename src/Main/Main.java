package Main;

import BoardGame.Cards.*;
import BoardGame.PlayerRelated.Player;
import Entities.Camera;
import Entities.Entity;
import Visual.Interfaz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    static long tiempoAnterior = System.nanoTime();
    public static  int scale=3;
    static Interfaz Interfaz= new Interfaz();
    static Interfaz.Pantalla Pantalla=new Interfaz.Pantalla();

    public static ArrayList<Entity> Entities = new ArrayList<>();
    public static ArrayList<Player> Players= new ArrayList<>();

    public static Camera Camara=new Camera(960,540);


    public static void main(String[] args) {
        ArrayList<CHAR> personajes= Cardloader.load("CHAR");
        Collections.shuffle(personajes);
        Pile Personajes=new Pile(personajes);


        int players=4;
        for (int a=1; a<=players; a++){
            new Player(a, personajes);
        }


        CHAR test=personajes.get(0);
        System.out.println(test.toString());
        test.setPosition(1000,800);


        ArrayList<OBJ> objetos=Cardloader.load("OBJ");
        Collections.shuffle(objetos);
        Pile Objetos=new Pile(objetos);

        ArrayList<BATTLE> batallas=Cardloader.load("BATTLE");
        Collections.shuffle(batallas);
        Pile Batallas=new Pile(batallas);

        Interfaz.add(Pantalla);
        Interfaz.setVisible(true);
        new javax.swing.Timer(10, e -> {
            long tiempoActual = System.nanoTime();
            double dt = (tiempoActual - tiempoAnterior) / 1_000_000_000.0;
            tiempoAnterior = tiempoActual;
            if (dt > 0.05) {dt = 0.05;}


            for (Entity ser : Entities) {

                ser.mover(dt);

            }
            Pantalla.repaint();

        }).start();





    }
}