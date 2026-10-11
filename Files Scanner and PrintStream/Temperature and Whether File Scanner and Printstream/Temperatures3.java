import java.io.*;
import java.util.*;

public class Temperatures3 
{
   public static void main(String[] args)
   throws FileNotFoundException 
   {
      
      File weatherFile = new File("weather2.txt");
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
         else
         {
            input.next(); //Throws away unwanted token
         }
      }
  }
}
