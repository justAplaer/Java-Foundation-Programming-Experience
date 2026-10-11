public class LW8_Binary_Format_Practice
{
   public static void main(String[] args)
   {
   //So to engage a binary code of a letter '' supposed to be used "" would transfer it to String, which would make an error
      if ('b' > 1)
      {
         System.out.println("Magic");
      }
      if ('b' > 'a')
      {
         System.out.println("Magic");
      }
      int x = 3;
      int y = -17;
      System.out.printf("x is %d and y is %d!\n", x, y); //Here uses binary of x and y
      
      System.out.printf("x is %d and y is %d!\n", y, x, y); //Can input as many variables as you want, while they are udentified, it will work
      //The fisrt %d is related to first variavle, while the second is related to the second
      System.out.format("x is %d and y is %d!%n", x, y, 5); // Doesn't break here
      
      System.out.format("x is %d and y is %d!", 10, 15, x); // Nor here
      
      System.out.format("%%");
      
      System.out.println(); 

      for (int i = 1; i <= 3; i++)
      {
         for (int j = 1; j <= 10; j++)
         {
            System.out.printf("%4d", (i * j)); //Makes the output more "even" and goodlooking
         }
      System.out.println(); 
      }
      
      //double gpa = 3.2545343;
      //System.out.printf("your gpa is %.1%n", gpa);
   }
}