package BoardGame.Cards;


import java.util.Arrays;

public class OBJ extends Card{


  public int BonusATK;
   public int BonusDFS;

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
                 ", Tags=" + Arrays.toString(this.NameTags) +
                 ", BonusATK=" + BonusATK +
                 ", BonusDFS=" + BonusDFS +
                 '}';
      };
   }


