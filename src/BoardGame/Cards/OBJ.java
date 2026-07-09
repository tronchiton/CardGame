package BoardGame.Cards;


public class OBJ extends Card{


   int BonusATK;
   int BonusDFS;


   @Override
   public String toString() {
      return  "OBJ{" +
                 "ID='" + ID + '\'' +
                 ", Title='" + Title + '\'' +
                 ", Description='" + Description + '\'' +
                 ", rarity=" + rarity +
                 ", BoardGame.Tags=" + Tags +
                 ", BonusATK=" + BonusATK +
                 ", BonusDFS=" + BonusDFS +
                 '}';
      };
   }


