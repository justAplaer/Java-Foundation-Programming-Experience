import java.util.*;

public class MapLeastCommon {
/* Write a method leastCommon that accepts a HashMap whose keys 
are strings and whose values are integers as a parameter and 
returns the integer value that occurs the fewest times in the map. 
For example, if a map named m contains 
{Alyssa=22, Char=25, Dan=25, Jeff=20, Kasey=20, Kim=20, Mogran=25, 
Ryan=25, Stef=22}, the call of leastCommon(m) returns 22. 
If there is a tie, return the smaller integer value. 
If the map is empty, throw an IllegalArgumentException.
*/

    
    public static void main (String [] args) {
      Map<String, Integer> map = new HashMap <>();
      map.put ("Alyssa", 22);  
      map.put ("Char", 25);
      map.put ("Dan", 25);
      map.put ("Jeff", 20);
      map.put ("Kasey", 20);
      map.put ("Kim", 20);
      map.put ("Mogran", 25);
      map.put ("Ryan", 25); 
      map.put ("Stef", 22);
      
      System.out.println (leastCommon(map));
    }
}
