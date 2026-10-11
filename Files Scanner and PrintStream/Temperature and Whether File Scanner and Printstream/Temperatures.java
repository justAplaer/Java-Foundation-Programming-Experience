

import java.io.*;
import java.util.*;

public class Temperatures 
{
   public static void main(String[] args)
   throws FileNotFoundException 
   {
      
      File weatherFile = new File("weather.txt");
      Scanner input = new Scanner(weatherFile);
      double prev = input.nextDouble();
      while (input.hasNext())
      {
         if (input.hasNextDouble())
         {
            double next = input.nextDouble();
            System.out.printf("%.1f to %.1f change = %.1f%n", prev, next, (next - prev) );
            prev = next;
         }
         else if (input.hasNext())
         {
            String nextText = input.next();
            System.out.println(nextText);
         }
      }
  }
}
