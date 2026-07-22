package BoardGame.Fight;

import BoardGame.Cards.BATTLE;
import BoardGame.PlayerRelated.Player;
import BoardGame.Tags.Effect;
import BoardGame.Tags.Tag;
import Main.Main;

import java.util.ArrayList;

import static BoardGame.Tags.Effect.Target.*;

public class Fight {

    public Player atacks;
    public Player defends;
    public BATTLE battle;

    public Fight(Player atacks, Player defends) {
        this.atacks = atacks;
        this.defends = defends;
    }

    public void encounter(){
        atacks.calculateStats();
        defends.calculateStats();
        int atkdiced=Dice.lanzarDados(atacks.ATKDice,6);
        int dfsdiced=Dice.lanzarDados(defends.DFSDice,6);

        int ATKSCORE=atkdiced+atacks.ATK;
        int DFSSCORE=dfsdiced+defends.DFS;

        if (ATKSCORE<=DFSSCORE){
            win(defends);
            lose(atacks);
        }
        if (ATKSCORE>DFSSCORE){
            win(atacks);
            lose(defends);
        }
    }

    public void win(Player winner){
        System.out.println("Player"+winner.index+" won");
    }

    public void lose(Player looser){
        System.out.println("Player"+looser.index+" lost");
    }

    public void checkEffects(Player player, Player otherplayer){
        ArrayList<Effect> effects= new ArrayList<>();
        for (Tag tag: player.Tags){
            effects.addAll(tag.effects);
        }
        for (Effect effect: effects){
        if (effect.Target==Battle){
            if (this.battle.Tags.contains(effect.Trigger)){
                applyeffects(effect,player);
            }

        }
        if (effect.Target==Opponent){
            if (otherplayer.Tags.contains(effect.Trigger)){
                applyeffects(effect,player);
            }

         }
         if (effect.Target==You){
             if (player.Tags.contains(effect.Trigger)){
                 applyeffects(effect,player);
             }
         }
         if (effect.Target==AnyPlayer){
             for (Player play:Main.Players){
                 if    (play.Tags.contains(effect.Trigger)){
                     applyeffects(effect,player);
                 }
             }
         }

        }


    }
    public void applyeffects(Effect effect, Player player){

    }
}