import java.util.*;

public class MapDemo {
   public static void main (String[] args) {
      Map<String, Integer> ageMap = new HashMap<>();
      //Map<String, Integer> ageMap = new TreeMap<>();

      ageMap.put ("Marty", 19);
      ageMap.put ("Geneva", 2);
      ageMap.put ("Vicki", 20);
      ageMap.put ("Vicki", 30);
      
      // print the map
      System.out.println (ageMap); // note Vicki,30 will override Vicki,20
      
      /* print the names starting with G
      *
         // grab all names
         Set<String> nameSet = ageMap.keySet();
         for (String name: nameSet) {
              if (name.startsWith ("G") System.out.println (name);
         }  
      // */  
      
      // print ages
      
         // keySet() will give you a nameSet
         // ageMap.get(name) will give you the age
         System.out.print ("Print ages: ");
         for (String name: ageMap.keySet()) {
              System.out.print (ageMap.get(name) + " ");
         }
      /// 

      // Call the method to print the names with age > 18
      //printNames (ageMap);
      
      // Call the method to update the ages, and print the map
    
      countMap ("hello");
      countMap ("....... abc (*&%$$#" );
      
      Map<String, Integer> map = new HashMap<>();
      map.put("Adlet", 10);
      map.put("Alan", 20);
      map.put("Emin", 777);
      map.put("Harun", 15);
      map.put("Ivan", 67);
      
      for(String name: map.keySet())
      {
         if (map.get(name) > 21)
         {
            System.out.println(name);
         }
      }
      
      
      
      // Who received 3.6?
   }
   // write a method to print the names with age > 18
   public static void printNames (Map<String, Integer> map) {
      for (String name: map.keySet()) {
         if (map.get(name) > 18) System.out.print (name + " ");
      }
   }
   
   // write a method to update ages with 10+
   public static void updateAges (Map<String, Integer> map) {

   }
   
   // Hello Count Map from the slides
   public static void countMap (String s) {
     // create a map
     Map<Character, Integer> map = new HashMap<>();

     //extract each letter from s 
     for (int i=0; i<s.length(); i++) {
      char letter = s.charAt(i);
      
      // ask the map, have you seen this letter?
      if (map.containsKey (letter)) { // yes, the letter is in the map
           // put (letter, map.get(letter) +1)
            map.put (letter, map.get(letter)+1);
      } else {// this is the first time seeing the letter, put (letter,1)
            map.put (letter, 1);
      }
     }
      System.out.println (map);
      
     int maxOccurrance = 0; char maxKey=0;

     for (Character c: map.keySet()) {
      
      if (map.get(c) > maxOccurrance) {
         maxOccurrance = map.get(c);
         maxKey = c;
      } 
     }
     System.out.println ("Most frequent letter in " + s+ " is " + maxKey);  
   }
}