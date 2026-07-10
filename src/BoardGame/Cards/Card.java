package BoardGame.Cards;

import BoardGame.Tags.Tag;
import Entities.Entity;
import Visual.Sprite;

import java.util.ArrayList;

public abstract class Card extends Entity {
    public ArrayList<Tag> Tags= new ArrayList<>();

    public Card(double x, double y, int sizex, int sizey) {
        super(x, y, sizex, sizey);
    }

    public enum Rarity{
        Common, Uncommon, Rare, Epic, Legendary
    }
    Rarity rarity;

    String ID;
    String Title;
    String Description;


    transient Sprite FrontSprite;
    transient Sprite BackSprite;
    transient Sprite DecorationSprite;


    public void renderFront(){


    }
}
