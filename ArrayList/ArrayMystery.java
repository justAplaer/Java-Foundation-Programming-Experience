import java.util.*;

public class ArrayMystery {

   public static void collectionMystery1(List<Integer> list) {
       for (int i = 0; i < list.size(); i++) {
           int n = list.get(i);
           list.remove(i);
           if (n % 2 == 0) {
               list.add(i);
           }
       }
       System.out.println(list);
   }
   
   public static void main (String[] args) {
      List<Integer> list = new ArrayList<>();
      list.add (3); list.add (5); list.add (8); list.add (9); list.add (2); 
      
      collectionMystery1(list);
   }
}