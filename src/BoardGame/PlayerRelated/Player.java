package BoardGame.PlayerRelated;
import BoardGame.Cards.CHAR;
import BoardGame.Cards.Card;
import Main.Main;


import java.util.ArrayList;


public class Player {
    public ArrayList<Card> Hand= new ArrayList<>();
    public ArrayList<Card> Active= new ArrayList<>();
    public  boolean HisTurn;
    public int index;

    public CHAR race;
    public Card Selected;

    public int life;
    public int DFS;
    public int ATKDice;
    public int DFSDice;

    public void draw(Card card){
        this.Hand.add(card);
    }


    public void discard(Card card){
        this.Hand.remove(card);
    }

    public Player(int index, ArrayList<CHAR> personajes){
        this.index=index;
        this.life=6;
        this.HisTurn=false;
        this.race= personajes.remove(0);
        Main.Players.add(this);

    }

}
