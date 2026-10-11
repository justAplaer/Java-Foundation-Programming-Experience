import java.util.*;
import java.io.*;

public class Boy_Or_Girl_File_Reader
{
   public static void boyGirl(Scanner console)
      {
          int boys = 0;
          int girls = 0;
          int boysSum = 0;
          int girlsSum = 0;
          while (console.hasNext())
          {
             String name = console.next();
             if (name.equals("Sylvia") || name.equals("Lisa") || name.equals("Charlotte"))
             {
               girls++;
               girlsSum += console.nextInt();
             }
             else if (name.equals("Steve") || name.equals("Craig") || name.equals("Brian") || name.equals("Jordan"))
             {
               boys++;
               boysSum += console.nextInt(); 
             }
          }
          System.out.println(boys + " boys, " + girls + " girls");
          System.out.print("Difference between boys' and girls' sums: " + (boysSum - girlsSum));
      }

   public static void main(String[] args)
   {
   }
}
