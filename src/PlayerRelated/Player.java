package PlayerRelated;
import Cards.Card;
import java.util.ArrayList;

public class Player {

    public ArrayList<Card> Hand= new ArrayList<>();
    public ArrayList<Card> Active= new ArrayList<>();
    int life;


    public void draw(Card card){
        this.Hand.add(card);
    }
    public void discard(Card card){
        this.Hand.remove(card);
    }
}
