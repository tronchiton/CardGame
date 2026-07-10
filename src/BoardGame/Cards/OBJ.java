package BoardGame.Cards;


public class OBJ extends Card{


   int BonusATK;
   int BonusDFS;

   public OBJ(double x, double y, int sizex, int sizey) {
      super(x, y, 95, 130);
   }


   @Override
   public String toString() {
      return  "OBJ{" +
                 "ID='" + ID + '\'' +
                 ", Title='" + Title + '\'' +
                 ", Description='" + Description + '\'' +
                 ", rarity=" + rarity +
                 ", Tags=" + Tags +
                 ", BonusATK=" + BonusATK +
                 ", BonusDFS=" + BonusDFS +
                 '}';
      };
   }


