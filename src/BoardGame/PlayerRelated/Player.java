package BoardGame.PlayerRelated;
import BoardGame.Cards.CHAR;
import BoardGame.Cards.Card;


import java.util.ArrayList;


public class Player {

    public ArrayList<Card> Hand= new ArrayList<>();
    public ArrayList<Card> Active= new ArrayList<>();

    public CHAR race;
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
}
