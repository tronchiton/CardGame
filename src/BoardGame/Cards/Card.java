package BoardGame.Cards;

import BoardGame.Tags.Tag;
import BoardGame.Write.Write;
import Entities.Entity;
import Entities.Utils.Point2D;
import Main.Main;
import Visual.Colors;
import Visual.Sprite;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Main.Main.scale;

public abstract class Card extends Entity {
    public ArrayList<Tag> Tags= new ArrayList<>();
    public String [] NameTags;

    public Card(double x, double y, int sizex, int sizey) {
        super(x, y, 95, 130);
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


    public static final Map<Rarity,Color> RarityToColor = Map.of(
            Rarity.Common, Colors.Common,
            Rarity.Uncommon, Colors.Uncommon,
            Rarity.Rare, Colors.Rare,
            Rarity.Epic, Colors.Epic,
            Rarity.Legendary, Colors.Legendary
    );


     @Override  public void render(Graphics2D g2D){

         AffineTransform oldTransform = g2D.getTransform();

         g2D.setColor(Color.BLUE);
         Point2D newpos = Main.Camara.RespectoCamara(this);


         g2D.rotate(angle, this.getX(), this.getY());

         g2D.drawImage(FrontSprite.get(),(int)newpos.getX(),(int) newpos.getY(),this.sizex*scale,this.sizey*scale,null);

         //texto Title


         Write.write(g2D,Title,"Minecraftia-Regular", RarityToColor.get(this.rarity),14,(int)newpos.getX()+this.sizex/2*scale, (int)newpos.getY()+23, Write.alignement.center);

         g2D.setTransform(oldTransform);

    }
}
