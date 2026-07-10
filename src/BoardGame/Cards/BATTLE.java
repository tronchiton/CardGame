package BoardGame.Cards;

public class BATTLE extends Card{


    public BATTLE(double x, double y, int sizex, int sizey) {
        super(x, y, sizex, sizey);
    }

    @Override
    public String toString() {
        return "BATTLE{" +
                "ID='" + ID + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", rarity=" + rarity +
                ", Tags=" + Tags +
                '}';
    }
}
