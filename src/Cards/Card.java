package Cards;

import Tags.Tag;
import Visual.Sprite;

import java.util.ArrayList;

public class Card {

    public enum CardType{
       OBJ, CHAR, BAT
    }
    CardType Type;

    public ArrayList<Tag> Tags= new ArrayList<>();

    String Title;
    String Description;

    Sprite MainSprite;
    Sprite SecSprite;
}
