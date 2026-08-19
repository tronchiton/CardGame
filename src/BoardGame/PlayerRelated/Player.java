package BoardGame.PlayerRelated;
import BoardGame.Cards.CHAR;
import BoardGame.Cards.Card;
import BoardGame.Cards.OBJ;
import BoardGame.Cards.Pile;
import BoardGame.Tags.Tag;
import Entities.Utils.Point2D;
import Entities.Utils.Vector2D;
import Main.Main;


import java.util.ArrayList;


public class Player {
   public Point2D Position;
    public ArrayList<OBJ> Hand= new ArrayList<>();
    public ArrayList<OBJ> Active= new ArrayList<>();
    public  boolean HisTurn;
    public int index;
    public ArrayList<Tag> Tags= new ArrayList<>();

    public CHAR race;


    public int life;
    public int DFS;
    public int ATK;
    public int ATKDice;
    public int DFSDice;

    public void draw(OBJ card){
        this.Hand.add(card);
        card.setPosition(this.Position);
        this.UpdateShowHand();
    }
    public void drawFrom(Pile pile){
        if (!pile.Cards.isEmpty()) {
            this.Hand.add((OBJ) pile.Cards.remove(0));
            this.UpdateShowHand();
        }
        else {System.out.println("No quedan cartas en la pila.");}
    }


    public void discard(Card card){
        this.Hand.remove(card);
    }

    public Player(int index, ArrayList<CHAR> personajes, Point2D Position){
        this.index=index;
        this.life=6;
        this.HisTurn=false;
        this.race= personajes.remove(0);
        this.Position=Position;
        Main.Players.add(this);

    }

    public void calculateStats(){
        int atk=0;
        int dfs=0;
        for (OBJ card : this.Active){
            atk+=card.BonusATK;
            dfs+=card.BonusDFS;
        }


        this.DFS=this.race.BaseDFS+dfs;
        this.ATK=this.race.BaseATK+atk;
        this.DFSDice=this.race.DFSDice;
        this.ATKDice=this.race.ATKDice;
    }

    public void UpdateShowHand(){
        int n = this.Hand.size();
        if (n == 0) return;

        double sideMargin = 60;    // margen lateral minimo respecto a los bordes de la pantalla
        double bottomMargin = 30;  // separacion respecto al borde inferior de la pantalla
        double maxRowWidth = 1920 - sideMargin * 2;

        int a=0;
        for (OBJ card : this.Hand){
            int cardWidth  = card.sizex * Main.scale;
            int cardHeight = card.sizey * Main.scale;
            double gap = 12; // separacion entre cartas cuando hay sitio de sobra

            // Si la mano es muy grande, el margen se reduce (e incluso se solapan un poco) para no salirse de la pantalla.
            double spacing = Math.min(cardWidth + gap, maxRowWidth / n);
            spacing = Math.max(spacing, cardWidth * 0.25);

            double offsetX = (a - (n - 1) / 2.0) * spacing; // centra el conjunto en el eje x
            double offsetY = 540 - bottomMargin - cardHeight / 2.0; // pega la fila al borde inferior

            card.setPosition(new Point2D(this.Position, new Vector2D(offsetX, offsetY)));
            a++;
        }

    }


}
