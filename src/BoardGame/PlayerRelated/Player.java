package BoardGame.PlayerRelated;
import BoardGame.Cards.CHAR;
import BoardGame.Cards.Card;
import BoardGame.Cards.OBJ;
import Entities.Utils.Point2D;
import Main.Main;


import java.awt.*;
import java.util.ArrayList;


public class Player {
   public Point2D Position;
    public ArrayList<Card> Hand= new ArrayList<>();
    public ArrayList<OBJ> Active= new ArrayList<>();
    public  boolean HisTurn;
    public int index;

    public CHAR race;
    public Card Selected;

    public int life;
    public int DFS;
    public int ATK;
    public int ATKDice;
    public int DFSDice;

    public void draw(Card card){
        this.Hand.add(card);
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

}
