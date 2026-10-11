// Tair Moldakhmetov, Student, CS121, Winter 2026, Section 3
// Programming Programming Assignment #11, 06/02/26
// This program tests the average amount of steps needed to go from 0 to x



import java.util.*;
public class HW13_Average_Step_Amount
{ 
   public static String averageRandomWalk() // Creating a string return method
   {
      Scanner console = new Scanner(System.in);
      System.out.print("What size walk do you want to test? "); //Asking user for the amount of steps
      int stepTester = console.nextInt();                    
      int totalSteps = 0;                            // I decided to create and return this variable so that the output is more similar to the task requirment
      Random rand = new Random();   
      for (int i = 1; i <= 10000; i++)
      {
         //It is important to set the variables bellowe to 0 so that the loop works properly
         int position = 0;
         int step = 0;
         while (Math.abs(position) != stepTester) // Simple while loop logic
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
         }
         totalSteps += step;
       }  
       double averageStep = totalSteps/10000;
       //I have decided to return a string variable so that the output looks better
       String output = "For a walk of size " + stepTester + ", after 10,000 tries, on average it took " + averageStep + " steps to get there.";
       return output;
   }
   
   public static void main(String[] args)
   {
      System.out.println(averageRandomWalk());  
   }                                      
}