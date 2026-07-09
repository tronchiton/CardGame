
import Cards.*;
import Visual.Interfaz;

import java.util.ArrayList;
import java.util.Collections;


public class Main {

    static Interfaz Interfaz= new Interfaz();
    static Interfaz.Pantalla Pantalla=new Interfaz.Pantalla();


    public static void main(String[] args) {

        ArrayList<CHAR> personajes= Cardloader.load("CHAR");
        Collections.shuffle(personajes);
        Pile Personajes=new Pile(personajes);

        ArrayList<OBJ> objetos=Cardloader.load("OBJ");
        Collections.shuffle(objetos);
        Pile Objetos=new Pile(objetos);

        ArrayList<BATTLE> batallas=Cardloader.load("BATTLE");
        Collections.shuffle(batallas);
        Pile Batallas=new Pile(batallas);

        Interfaz.add(Pantalla);
        Interfaz.setVisible(true);






    }
}