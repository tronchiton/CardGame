package BoardGame.Cards;

import java.util.Arrays;

public class BATTLE extends Card{


    public BATTLE(double x, double y, int sizex, int sizey) {
        super(x, y, 95, 130);
    }

    @Override
    public String toString() {
        return "BATTLE{" +
                "ID='" + ID + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", rarity=" + rarity +
                ", Tags=" + Arrays.toString(this.NameTags) +
                '}';
    }
}
