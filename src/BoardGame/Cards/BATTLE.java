package BoardGame.Cards;

public class BATTLE extends Card{


    @Override
    public String toString() {
        return "BATTLE{" +
                "ID='" + ID + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", rarity=" + rarity +
                ", BoardGame.Tags=" + Tags +
                '}';
    }
}
