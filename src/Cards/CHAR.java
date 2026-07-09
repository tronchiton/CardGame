package Cards;

import PlayerRelated.Player;

public class CHAR extends Card{

    int BaseATK;
    int BaseDFS;
    int ATKDice;
    int DFSDice;


    public CHAR(String id, String title, int atk, int dfs) {
        this.ID = id;
        this.Title = title;
        this.BaseATK = atk;
        this.BaseDFS = dfs;
        this.rarity = Rarity.Common;
    }

    public void equip(Player player){
        player.race=this;

    }

    @Override
    public String toString() {
        return "CHAR{" +
                "ID='" + ID + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", rarity=" + rarity +
                ", Tags=" + Tags +
                ", BaseATK=" + BaseATK +
                ", BaseDFS=" + BaseDFS +
                ", ATKDice=" + ATKDice +
                ", DFSDice=" + DFSDice +
                '}';
    }
}
