import java.io.*;
import java.util.*;

public class File_Scanner_Logic_Test
{
   public static void main(String[] args)
   throws FileNotFoundException
   {
      Scanner input = new Scanner(new File("hours.txt"));
      PrintStream outP = new PrintStream(new File("hours_out.txt"));
      while (input.hasNextLine())
      {
         String line = input.nextLine();
         if (!line.equals(""))
         {
            Scanner lineScan = new Scanner(line); //So... Basically nextLine transformes the whole line intp one string and then it is possible to build a while loop
            double hours = 0.0;         // it is possible to build a while loop based on this line... why did I again wasted time trying to do it on my own...
            double days = 0.0;
            int id = lineScan.nextInt();
            String name = lineScan.next();
            double check = 0;
            while (lineScan.hasNextDouble() )
            {
               hours += lineScan.nextDouble();
               days += 1;
            }
            outP.printf(name + " (ID#" + id + ") worked %.1f hours (%.2f hours/day)%n", hours, (hours/days));
            outP.print("Testing");
            outP.println("Processing");
         }
      }
   }
}
