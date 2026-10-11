import java.util.*;

public class UniqueCheck 
{
   public static void main (String[] args) 
   {
      List<String> list = new ArrayList<>();
      list.add("Hello"); list.add("Hi"); list.add("Hello"); 
      list.add("Howdy"); list.add("Howdy"); 
      
      System.out.println (list.size());
      System.out.println (list.get(0).equals (list.get(2)));
      
      List<String> uniqueWords = new ArrayList<>();
      
      for (int i=0; i<list.size(); i++)
      {
         String word = list.get(i);
         
         if (!uniqueWords.contains(word))
         {
            uniqueWords.add (word);
         }
      }
      System.out.println (uniqueWords.size());
     
    }
}
      