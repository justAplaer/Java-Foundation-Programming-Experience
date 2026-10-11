import java.util.*;

public class SetDemo {
   public static void main (String[] args) {
      Set<String> nameSet = new HashSet<>(); // Based on Nash index
      //Set<String> nameSet = new TreeSet<>(); // Alphabetic order 
      //Set<String> nameSet = new LinkedHashSet<>(); // Based on insertion order
      
      nameSet.add ("RM"); 
      nameSet.add ("Burt");
      nameSet.add ("ABC");
      nameSet.add ("RM"); // It would not be added since sets does not allow duplicates

      /* set up the for each loop
      */
      for ( String name : nameSet) { // read only
         // ConcurrentModificationException
         // nameSet.remove(name);
         // if (name.startsWith("R"))
              System.out.println(name);
      }
      // */
      System.out.println (nameSet);
   }
}