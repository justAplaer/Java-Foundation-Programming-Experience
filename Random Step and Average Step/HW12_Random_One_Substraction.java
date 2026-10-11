// Tair Moldakhmetov, Student, CS121, Winter 2026, Section 3
// Programming Programming Assignment #11, 06/02/26
// This program randomly add or subtracts 1 until the positin variable wouldn't match the inputted variable



import java.util.*;
public class HW12_Random_One_Substraction
{ 
   public static String randomWalk(int x) // Creating a string return method
   {
      int position = 0;
      int step = 0;
      String output;  // I decided to create and return this variable so that the output is more similar to the task requirment
      Random rand = new Random();
      System.out.println("position = " + position); // Decided to put additional println so that the output contains the first positin value as well
     
      while (Math.abs(position) != x) // Simple while loop logic
      {   
         int randomStep = rand.nextInt(2);
         if (randomStep == 0)
         {
            position -= 1;
         }
         else
         {
            position += 1;
         }
         step++;
         System.out.println("position = " + position);
      }
      System.out.println();
      output = "Steps : " + step; // Preparing the return variable...
      return output; //Returning the variable
   }
   public static void main(String[] args)
   {
      System.out.println(randomWalk(30)); // When I first tried to run the program with x equal to 30, I got 670748 steps... 
   }                                      // Then I have noticed that it is needed to compare the absolute vlau of position to x
}