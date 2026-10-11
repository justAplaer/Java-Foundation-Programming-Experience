import java.io.*;
import java.util.*;

public class LW11Ver2_Print_Format_File_Reading_Practice
{
   public static void main(String[] args)
   throws FileNotFoundException
   {
      File jobData = new File("LessonWork11.txt");
      Scanner input = new Scanner(jobData);
      double value = input.nextDouble();
      while (input.hasNext())
      {
         double day = 0.0;
         double hours = 0.0;      
         int id = (int) value;
         String name = input.next();
         value = input.nextDouble();
         
         while (value <= 24 && input.hasNext())
         {
            hours += value;
            day ++;
            value = input.nextDouble();
            
         }
         
         if (!input.hasNext())
         {
            hours += value;
            day ++;
         }

         
         System.out.printf(name + " (ID#" + id + ") worked %.1f hours (%.2f hours/day)%n", hours, (hours/day));  
      }
   }
}