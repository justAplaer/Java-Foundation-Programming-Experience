import java.util.*;
public class MinToFront
{
   public static void main(String[] args)
   {
      //
      ArrayList<Integer> list = new ArrayList<>(List.of(5, 10, 15, 1));
      ArrayList<Integer> array = new ArrayList<>();
      Random random = new Random();
      Scanner console = new Scanner(System.in);
      System.out.println("Enter the amount of elements you want in an array");
      int loop = console.nextInt();
      for (int i = 0;  i < loop; i++)
      {
         array.add(random.nextInt(1, 10));
      }
      System.out.println(array);
      minToFront(array);
      System.out.println(array);
      
      System.out.println(list);
      minToFront(list);
      System.out.println(list);
      //
      
      /* Testing how random works
      Random random = new Random();
      for (int i = 1; i <= 10; i++)
      {
         System.out.println(random.nextDouble(-0.5, 0.5));
      }
      */
   }
   
   public static void minToFront(ArrayList<Integer> myArray)
   {
      
      int min = Collections.min(myArray);    
      for (int i = myArray.size()-1; i > 0; i--)
      {
         if (myArray.get(i) == min)
         {
            myArray.set(i, myArray.get(i-1));
            myArray.set(i-1, min);
         }
      }
      
   }
}
