package BoardGame.Cards;

import Audio.AudioPlayer;
import BoardGame.Tags.Effect;
import BoardGame.Tags.Tag;
import BoardGame.Write.Write;
import Entities.Entity;
import Entities.Utils.Point2D;
import Main.Main;
import Visual.Colors;
import Visual.GameUI;
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

    boolean ismouseovercard;
    String ID;
    String Title;
    String Description;


    transient Sprite FrontSprite;
    transient Sprite BackSprite;
    transient Sprite DecorationSprite;
    boolean Selected;

    boolean Up;

    public static final Map<Rarity,Color> RarityToColor = Map.of(
            Rarity.Common, Colors.Common,
            Rarity.Uncommon, Colors.Uncommon,
            Rarity.Rare, Colors.Rare,
            Rarity.Epic, Colors.Epic,
            Rarity.Legendary, Colors.Legendary
    );

    @Override  public void act(){

        this.mouseovercard();

        this.whoble(this.ismouseovercard);

        if (Selected){this.ShowActions((OBJ) this);}

        if (ismouseovercard||this.Selected){this.select();}

    }
    public void ShowActions(OBJ card){

    }

    public void select(){

        if (ismouseovercard){
            if(Main.MouseClicked&&!Selected){
                AudioPlayer.playSound("select",100);
                Selected=true;
            }
        }
        else{
            if(Main.MouseClicked2)
            {
                AudioPlayer.playSound("select",100);
                Selected=false;
            }
        }
    }

    public void mouseovercard(){
        Point2D newpos = Main.Camara.RespectoCamara(this);

        int left = (int) (newpos.getX() - (this.sizex * scale) / 2.0);
        int top  = (int) (newpos.getY() - (this.sizey * scale) / 2.0);

        Rectangle card= new Rectangle(left, top, this.sizex*scale, this.sizey*scale);

        Point mouse=new Point(Main.MouseX,Main.MouseY);

        if(card.contains(mouse)){
            ismouseovercard=true;
        }
        else{
            ismouseovercard=false;
        }

    }

    @Override public void render(Graphics2D g2D){

        AffineTransform oldTransform = g2D.getTransform();

        g2D.setColor(Color.BLUE);
        Point2D newpos = Main.Camara.RespectoCamara(this);

        double renderScale = scale * this.getCurrentScale(); // escala base + crecimiento suave del whoble

        double left = newpos.getX() - (this.sizex * renderScale) / 2.0;
        double top  = newpos.getY() - (this.sizey * renderScale) / 2.0;
        int renderW = (int) Math.round(this.sizex * renderScale);
        int renderH = (int) Math.round(this.sizey * renderScale);

        g2D.rotate(angle, newpos.getX(), newpos.getY());
        if (this.Up) {
            g2D.drawImage(FrontSprite.get(), (int) left, (int) top, renderW, renderH, null);
            g2D.drawImage(DecorationSprite.get(), (int) left+15, (int) top+150, 40*scale , 40*scale, null);


            //texto Title
            Write.write(g2D, Title, "Minecraftia-Regular", RarityToColor.get(this.rarity), 14, (int) newpos.getX(), (int) (top + 23), Write.alignement.center);

            Write.writeOnCard(g2D, Description, "Minecraftia-Regular", Color.BLACK, 14, this, 35, 5);

            Tag.renderTags(this,g2D, (int) left+10, (int) top+50);



            if (Selected==true||ismouseovercard){GameUI.DrawSelected(this,g2D, (int) left, (int) top, renderW, renderH);}



        }
        else{
            g2D.drawImage(BackSprite.get(), (int) left, (int) top, renderW, renderH, null);
        }

        g2D.setTransform(oldTransform);
    }
}