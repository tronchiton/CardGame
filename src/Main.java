
import Visual.Interfaz;



public class Main {

    static Interfaz Interfaz= new Interfaz();
    static Interfaz.Pantalla Pantalla=new Interfaz.Pantalla();


    public static void main(String[] args) {
        Interfaz.add(Pantalla);
        Interfaz.setVisible(true);


        System.out.println("Hello world!");



    }
}