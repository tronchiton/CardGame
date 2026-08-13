package BoardGame.Cards;

import BoardGame.PlayerRelated.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pile<T extends Card> {
    public ArrayList<T> Cards;

    public Pile (ArrayList<T> Cards){
        this.Cards=Cards;
    }

    public void shuffle(){
        Collections.shuffle(this.Cards);
    }

    public List<T> getCards() {
        return Cards;
    }
}
