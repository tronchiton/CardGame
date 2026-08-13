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
        int a=0;

        for (OBJ card : this.Hand){
            Point2D newpos=new Point2D(this.Position,new Vector2D(-960+card.sizex,540-card.sizex));
            card.setPosition(new Point2D(newpos,new Vector2D(a*card.sizex,0)));
         a++;
        }

    }

}
