import java.util.*;
import java.io.*;


public class LW12_File_Reading_Practice
{
   public static void main(String[] args) 
   throws FileNotFoundException
   {
      File info = new File("NameWageinfo.dat");
      Scanner input = new Scanner(info);
      while (input.hasNext())
      {
         String name = input.next();
         double hours = input.nextDouble();
         double payment = input.nextDouble();
         System.out.format(name + " should receive $%.2f this week%n", hours*payment);
      }
   }
}