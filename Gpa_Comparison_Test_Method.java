import java.util.*;
public class Gpa_Comparison_Test_Method
{ 
   public static double gpa()
   {
      Scanner score =  new Scanner(System.in);
      double gpaScore = 1.0;
      double gpaMax = 0.0;
      String gpaReturn = "";
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
               gpaReturn = (String) gpaMax + (String) gpaScore;
            }
          }
   }
   public static void main(String[] args)
   {
   String test = gpa();
   double test2 = (double) test.substring(0, 1);
   double test3 = (double) test.substring(2,3);
   }
}