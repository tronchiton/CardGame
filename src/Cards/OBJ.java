package Cards;


public class OBJ extends Card{


   int BonusATK;
   int BonusDFS;

    public enum Rarity{
        Common, Uncommon, Rare, Epic, Legendary
    }

    public OBJ() {
        this.Type = CardType.OBJ;
    }
}
