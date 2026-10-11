import java.util.*;

public class Weather_Question
{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.println("How many days' temperatures? ");
      int days = console.nextInt();
      int[] list;
      list = new int[0];
      double[] coldest = {0, 0};
      double[] hottest = {0, 0};
      for (int i = 0; i < list.length; i++)
      {
         System.out.println("Enter " + (i+1) + " day temperature: ");
         int temperature = console.nextInt();
      }
   }
}