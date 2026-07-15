package BoardGame.Fight;

import BoardGame.PlayerRelated.Player;

public class Fight {
    public void encounter(Player atacks, Player defends){
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

}
