package BoardGame.Tags;

import Visual.Sprite;

import java.io.File;
import java.util.ArrayList;

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

}
