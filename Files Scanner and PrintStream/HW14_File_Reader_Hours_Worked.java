// Tair Moldakhmetov, Student, CS121, Winter 2026, Section 3
// Programming Programming Assignment #11, 06/02/26
// This program reads a file with information abour worker
// And ouputs the amount of hours each staff member worked, their gross and actual total wage



import java.util.*;
import java.io.*;

public class HW14_File_Reader_Hours_Worked
{
   public static void main(String[] args)
   // At first, I wanted to solve this task the way we did it in class, but then I though "Why bother?"
   // The logic I wrote is much more convient and straightforward than using stroke method
   // Here strokes are unnecessary because, unlike proble in class, there is no problem with Java reading ID(int) and hours worked as
   // Doubles, even though first should be int
   // In this case, the file starts as a string then int, then doubles, so no need to use strokes, simple logic will cover the file readin process
   
   throws FileNotFoundException                // Important strole, it appear without it the prgoram wouldn't work, even if there is a file with that name
   {
      File list = new File("Assignment14.txt");   // Creating file variable
      Scanner input = new Scanner(list);          // Scanner for that file
      while(input.hasNext())                      // Loop for checking all the info
      {
         String name = input.next();              // Assigning a value for string name variable
         double payment = input.nextDouble();     // Assigning a double value for payment per hour
         int shifts = 0;                          // Creating a variable to calculate amoint of shift, important to make it equal to 0 so that each next loop works properly 
         int hours = 0;                           // Hours variable, also important to assign it to 0, same reason as for "shifts" variable
         
         while(input.hasNextInt())
         {
            hours += input.nextDouble();
            shifts++;
         } 
         //At first made a mistake: the stroke below will anyway apply to both outcomes so it is appropriate to put it outside the if logic
         System.out.printf(name + " worked for a total of: " + hours + " hours at " + payment + " an hour for a gross pay of $%.2f.%n", (hours*payment));
         if (payment*hours >= 400)
         {
            // I had a proble with % sign, then remembered I need to double it to outpur just the sign
            System.out.printf("After 33%% taxes their total net pay should be $%.2f.%n%n", (hours*payment)*0.67 );
         }
         else
         {
            System.out.printf("After 25%% taxes their total net pay should be $%.2f.%n%n", (hours*payment)*0.75 );
         }
      }
   }
}