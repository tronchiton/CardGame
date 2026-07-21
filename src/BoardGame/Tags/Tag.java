package BoardGame.Tags;

import BoardGame.Cards.Card;
import Visual.Sprite;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static Main.Main.scale;

public class Tag {
   public transient  Sprite Sprite;
    final String ID;
    ArrayList<Effect> effects;

    public Tag(String ID){
        this.ID=ID;
        String Ruta="Assets/Tags/" + ID + ".png";
        File Imagen = new File(Ruta);
        if (Imagen.exists()){this.Sprite= new Sprite(Ruta);}
        else{this.Sprite= new Sprite("Assets/Tags/default.png");}



    }
    public Tag(String ID, ArrayList<Effect> effects ){
        this.ID=ID;

        String Ruta="Assets/Tags/" + ID + ".png";
        File Imagen = new File(Ruta);
        if (Imagen.exists())
        {this.Sprite= new Sprite(Ruta);}
        else{this.Sprite= new Sprite("Assets/Tags/default.png");}

        this.effects=effects;


    }
    public static void renderTags(Card Card, Graphics2D g2d, int x, int y){
        int a=0;
        for (Tag tag: Card.Tags){
            g2d.drawImage( tag.Sprite.get(),  x+a*16*scale, y, 100*scale , 100*scale, null);
            a++;
        }
    }

}
