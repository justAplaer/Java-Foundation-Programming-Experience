import java.util.*;

public class SetIteratorDemo {
   public static void main (String[] args) {
      Set<String> nameSet = new HashSet<>();
           
      nameSet.add ("RM"); 
      nameSet.add ("Kurt");
      nameSet.add ("ABC");
      nameSet.add ("RM");

      Iterator<String> itr = nameSet.iterator();
      while (itr.hasNext()) {
         String name = itr.next();
         if (name.endsWith ("M")) itr.remove();
      }
     
      System.out.println (nameSet);
   }
}