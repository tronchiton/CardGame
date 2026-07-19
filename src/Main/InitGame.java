package Main;

import BoardGame.Cards.*;
import BoardGame.PlayerRelated.Player;
import BoardGame.TurnCycle.TurnCycle;
import Entities.Utils.Point2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static BoardGame.TurnCycle.TurnCycle.roundIndex;
import static BoardGame.TurnCycle.TurnCycle.turnIndex;

public class InitGame {
    public static void start(){
        ArrayList<CHAR> personajes= Cardloader.load("CHAR");
        Collections.shuffle(personajes);
        Main.Personajes=new Pile(personajes);

        int players=4;
        for (int a=1; a<=players; a++){
            new Player(a,
                    personajes,
                    new Point(a*1920,a*1080)
            );
        }


        CHAR test= (CHAR) Main.Personajes.getCards().get(0);
        System.out.println(test.toString());

        test.setPosition(Main.Players.get(0).Position);

        ArrayList<OBJ> objetos=Cardloader.load("OBJ");
        Collections.shuffle(objetos);
        Pile PileObjetos=new Pile(objetos);


        ArrayList<BATTLE> batallas=Cardloader.load("BATTLE");
        Collections.shuffle(batallas);
        Pile PileBatallas=new Pile(batallas);




        roundIndex = 0;
        turnIndex = 0;
        TurnCycle turnCycle = new TurnCycle();
        turnCycle.startFirstTurn();
    }
}
