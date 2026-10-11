//map "Steff" = 3.6, "Marty" = 2.9
import java.util.*;

public class OppositeMappingDemo
{
   public static void main (String[] args)
   {
      Map<String, Double> mapGPA = new HashMap<String, Double>();
      mapGPA.put("Ryan", 3.5);
      mapGPA.put("Nicholas", 4.0);
      mapGPA.put("Alice", 3.5);
      mapGPA.put("Bob", 3.8);
      mapGPA.put("Jackson", 4.0);
      System.out.println(mapGPA);
      
      Map<Double, Set<String>> map = addStudent(mapGPA);
      System.out.println(map);
      
      Map<Double, Set<String>> map2 = addStudent2(mapGPA);
      System.out.println(map2);
   }
   
   public static Map<Double, Set<String>> addStudent (Map<String, Double> map) 
   {
      Map<Double, Set<String>> newMap = new HashMap<>();
      
      //grab all names one by one
      for (String name : map.keySet()) 
      {
         double gpa = map.get(name);
         
         // newMap, have you seen this gpa?
         if (!newMap.containsKey (gpa)) 
         {
            // no, 1. put (gpa, empty set)
            newMap.put (gpa, new TreeSet<String>());
            
            // 2. grab the set, add the name to the set
            newMap.get(gpa).add(name);
         } 
         
         else 
         { 
            // yes 
            // grab the set, add the name to the set         
            newMap.get(gpa).add(name);    
         }
       }
       return newMap;
   }
   
   public static Map<Double, Set<String>> addStudent2 (Map<String, Double> map) 
   {
      Map<Double, Set<String>> newMap = new HashMap<>();
      
      //grab all names one by one
      for (String name : map.keySet()) 
      {
         double gpa = map.get(name);
         
         // newMap, have you seen this gpa?
         if (!newMap.containsKey (gpa)) 
         {
            // no, put (gpa, empty set)
            newMap.put (gpa, new TreeSet<String>());
         }     
         
         newMap.get(gpa).add(name);
  
      }   
      return newMap;
   }
}