package Cards;

import Tags.Tag;
import Visual.Sprite;

import java.util.ArrayList;

public abstract class Card {
    public ArrayList<Tag> Tags= new ArrayList<>();

    public enum Rarity{
        Common, Uncommon, Rare, Epic, Legendary
    }
    Rarity rarity;

    String ID;
    String Title;
    String Description;

    Sprite BackSprite;
    Sprite DecorationSprite;
}
