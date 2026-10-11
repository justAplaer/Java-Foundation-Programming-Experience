import java.util.*;
public class Test
{
   public static void main(String[] args)
   {
      String name = "Bob";
      double average = 5.0;
      List<String> list = new ArrayList<String>();
      list.add(name);
      System.out.println(list);
      String trick = ""+average;
      list.add(trick);
      System.out.println(list);
   }
}