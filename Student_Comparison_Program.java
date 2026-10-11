// Tair Moldakhmetov, Student, CS121, Winter 2026, Section 3
// Programming Programming Assignment #10, 15/02/26
// This programm collects and compares SAT or ACT exam scores and GPA result of 2 students



import java.util.*;
public class Student_Comparison_Program
{
   public static int answer(String word, int lowerBorder, int higherBorder) //Function that returns the value in each subject 
   {
      int result = 0;                                       //Creating a variable that would be returned
      Scanner score =  new Scanner(System.in);              //Creating a Scanner variable
      while (result < lowerBorder || result > higherBorder) //User oriented loop
      {
         System.out.println("Enter score in " + word);
         System.out.println("Note that answer must be an integer value between " + lowerBorder + " to " + higherBorder);
         result = score.nextInt();
         if (lowerBorder <= result & result <= higherBorder)
         {
            System.out.println("Accepted\n");
         }
         else
         {
            System.out.println("ERROR. Entered answer must be an integer value between " + lowerBorder + " to " + higherBorder);
            System.out.println("Please try again");
         }
      }
      return result;      //returning the value
   }
   
   public static String examCheck()  //A function that checks the exam type
   {
      Scanner score =  new Scanner(System.in);
      String examType = "";
      while (!examType.equals("SAT") & !examType.equals("ACT")) //User oriented loop
         {
            System.out.println("Does a student have SAT scores or ACT scores?");
            examType = score.next();
            if (examType.equals("SAT") || examType.equals("ACT"))
            {
               System.out.println("Accepted\n");  
            }
            else
            {
               System.out.println("ERROR. Entered answers must be either 'SAT' or 'ACT'");
               System.out.println("Please try again:");
            }
         }
      return examType; //returning the exam type
   }
   
   public static double scoreSAT(int math, int reading, int writing) //Function that returned the score in SAT based on the inputted value
   {
      double satScore = (2.0*math + reading + writing)/32.0;
      return satScore;
   }
   public static double scoreACT(int english, int math, int reading, int science) //Function that calculates the score in ACT based on the inputted value
   {
      double actScore = (english + math*2.0 + reading + science)/1.8;
      return actScore;
   } 
   
   public static double multiplier() //Function that returns trascript multiplier
   {
      Scanner score =  new Scanner(System.in);
      double transcript = 0.0;
      while(transcript < 0.8 || transcript > 1.0) 
      {
         System.out.println("Enter tracnsript multiplier value");
         System.out.println("Note that input must be a value between 0.8 to 1.0");
         transcript = score.nextDouble();
         if (transcript < 0.8 || transcript > 1.0)
         {
            System.out.println("ERROR. Please try again");
         }
         else
         {
            System.out.println("Accepted\n");
         }
      }
      return transcript; //Returning transcript multiplier value
   }
   public static double gpaCalc(double gpaValue, double gpaM, double multi) //Returning GPA value, taking transcript multiplier in account
   {
      double gpaOut = (gpaValue/gpaM)*multi*100;
      return gpaOut;
   }
    
   public static double studentScore() //I am really proud of this particular function: it is a huge return, which engages all other functions and as a finale retunrs an overall student score
   {      
      //Creting variables for futher checks and calculations 
      double examscore;
      Scanner score =  new Scanner(System.in);
      double gpaScore = 1.0;
      double gpaMax = 0.0;
      double gpa = 0.0;
      String exam = examCheck(); 
      double value;
      double finalValue = 0.0;
                  
      if (exam.equals("SAT"))
      {   
         //Using answer function, assigning values
         int mathSAT = answer("math", 200, 800);
         int readingSAT = answer("reading", 200, 800);
         int writingSAT = answer("writing", 200, 800);  
         examscore = scoreSAT(mathSAT, readingSAT, writingSAT);
         System.out.printf("exam score = %.1f%n", + examscore); //Output of exam value with 1 decimal place
      }  
      else
      {
         //Using answer function, assigning values
         int englishACT = answer("English", 1, 36);
         int mathACT = answer("math", 1, 36);
         int readingACT = answer("reading", 1, 36);
         int scienceACT = answer("science", 1, 36);
         examscore = scoreACT(englishACT, mathACT, readingACT, scienceACT);
         System.out.printf("exam score = %.1f%n", examscore); //Output of exam value with 1 decimal place
      }
      //In first version of a program, I made code longer than it could be
      //I did not think that the GPA logic can be outside if and else 
      //Since anyway it is a part of both statements
      //In addition, I created one variable for exam score. I makes the code slightly shorter and does not break the logic
      //Because only one of if statements can be accomplished, so no conflict there and the code is more compact
      while (gpaScore > gpaMax || gpaMax < 0 || gpaScore < 0)
         {
            System.out.println("Enter maximum GPA value that can be received by a student in their academic grading system");
            gpaMax = score.nextDouble();
            System.out.println("Enter overall GPA value, received by a student in their academic grading system");  
            gpaScore = score.nextDouble();
            if (gpaScore > gpaMax || gpaMax < 0 || gpaScore < 0)
            {
               System.out.println("ERROR. Make sure that input information is correct and appropriate, and try again");
            }
            else
            {
               System.out.println("Accepted\n");
            }gilse
          }
          value = multiplier(); //Assingning transcript multiplier value to the "value" variable
          gpa = gpaCalc(gpaScore, gpaMax, value); //Calculating GPA
          System.out.printf("GPA score = %.1f%n%n", gpa); //output of GPA value with 1 decimal place
          finalValue = examscore + gpa;
      return finalValue;
   }  
   public static void main(String[] args)
   {
      double student1 = studentScore();  //Student1 is a variable for first student's score
      double student2 = studentScore();  //Student2 is a varible for the second student's score
      System.out.printf("First applicant overall score = %.1f%n", student1); //Outputting final first student score with 1 decimal place
      System.out.printf("Second applicant overall score = %.1f%n", student2); //Outputting final exam value for the second student with 1 decimal place
      //I wanted to create a separate function for comparing the students, but understood it is pointless, even outside the borders of this programm
      //If there are more than 2 students, then the mehtod would not work since it will be required to compare more than 2 students, so 
      //In terms of this exact code and overall it is more convenient to write "if" part manually
      if (student1 > student2)
      {
         System.out.println("The first applicant seems to be better");
      }
      
      else if (student1 < student2)
      {
         System.out.println("The second applicant seems to be better");
      }
      
      else
      {
         System.out.println("Both of the applicants seem to be equal");
      }   
   }
}