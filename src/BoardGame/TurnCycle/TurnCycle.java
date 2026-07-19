package BoardGame.TurnCycle;
import BoardGame.PlayerRelated.CurrentPlayerManager;
import BoardGame.PlayerRelated.Player;
import Main.Main;
public  class TurnCycle {
    public static int turnIndex;
    public static int roundIndex;


    public void whoIsPlaying( int np){
        if (np == 0) {
            return;
        }

        for (Player player : Main.Players){
            player.HisTurn=false;
        }

         Main.Players.get(turnIndex).HisTurn=true;
        CurrentPlayerManager.activePlayer= Main.Players.get(turnIndex);
    }
    public void restart(int np){

        if (turnIndex==np){
            turnIndex=0;
            roundIndex++;
        }
    }
    public void nextTurn() {
        int np=Main.Players.size();
        turnIndex++;
        restart(np);
        whoIsPlaying(np);
    }
    public void startFirstTurn() {
        int np = Main.Players.size();
        turnIndex = 0;
        roundIndex = 0;
        whoIsPlaying(np);
    }

}
