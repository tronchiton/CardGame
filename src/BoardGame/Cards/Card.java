package BoardGame.Cards;

import BoardGame.Tags.Tag;
import Entities.Entity;
import Entities.Utils.Point2D;
import Main.Main;
import Visual.Sprite;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public abstract class Card extends Entity {
    public ArrayList<Tag> Tags= new ArrayList<>();

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


     @Override  public void render(Graphics2D g2D){

         AffineTransform oldTransform = g2D.getTransform();

         g2D.setColor(Color.BLUE);
         Point2D newpos = Main.Camara.RespectoCamara(this);

         double centroX = newpos.getX() + (this.sizex / 2.0);
         double centroY = newpos.getY() + (this.sizey / 2.0);

         this.angle= (double) 0;

         g2D.rotate(angle, centroX, centroY);

         g2D.drawImage(FrontSprite.get(),(int)newpos.getX(),(int) newpos.getY(),null);

         g2D.setTransform(oldTransform);

    }
}
