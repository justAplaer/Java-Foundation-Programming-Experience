import java.io.*;
import java.util.*;

public class LW11_NextLine_File_Reading_Practice
{
   public static void main(String[] args)
   throws FileNotFoundException
   {
      File jobData = new File("LessonWork11.txt");
      Scanner input = new Scanner(jobData);
      while (input.hasNextLine())
      {
         String line = input.nextLine();
         if (line != "")
         {
            Scanner lineScan = new Scanner(line); //So... Basically nextLine transformes the whole line intp one string and then it is possible to build a while loop
            double hours = 0.0;         // it is possible to build a while loop based on this line... why did I again wasted time trying to do it on my own...
            double day = 0.0;
            int id = lineScan.nextInt();
            String name = lineScan.next();
            double check = 0;
            while (lineScan.hasNextDouble() )
            {
               hours += lineScan.nextDouble();
               day += 1;
            }
            System.out.printf(name + " (ID#" + id + ") worked %.1f hours (%.2f hours/day)%n", hours, (hours/day));
         }
      }
   }
}