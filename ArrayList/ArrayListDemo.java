import java.util.*; // For ArrayList

public class ArrayListDemo
{
   public static void main (String[] args) 
   {
     List<Integer> list = new ArrayList<Integer>();
     
     for (int i=1; i<=15; i++) 
     {
        list.add (i*10);
     }
     
     System.out.println("List before removal: " + list);
     
     for (int i = 0; i < list.size(); i++)
     {
         list.remove(i);
         i--;
     }
     
     for (int i=1; i<=5; i++) 
     {
        list.add (i*10);
     }
     
     int size = list.size();
     for (int i = 0; i < list.size()+1; i+=2)
     {   
         list.add(i, 42);
     }
     
     System.out.println("42: " + list);
     //or 
     //for (int i = list.size()-1, i >= 0, i--)
     //{
           //list.remove(i);
     //}
     
     System.out.println("List after removal: " + list);
     
     //System.out.println (list.get(0)); // print out the content in 0
     //System.out.println ("Index of 40: " + list.indexOf (40));
     //System.out.println ("Data under the index 5: " + list.get(5));

     list.add (0, 20);
     
     list.set(3, 1000); // Will set a veriable under the index of 3 to 1000
     
     System.out.println("Context of the list: " + list.get(0));
    // list.clear();
     
     System.out.println ("Index of 40: " + list.indexOf (40));
     System.out.println ("Content of the list: " + list); // will call toString()
     
     list.remove (0);
     
     // remove the last box
     
     list.set (3, 1000);
     System.out.println ("Size of the list: " + list.size());

     addSeven (list);
     System.out.println(list);  // expecting []?

   }
   
   // write a method to add 7 between numbers
   // [10, 7, 20, 7, 30, 7, .... 90, 7, 100]
   public static void addSeven (List<Integer> list )
    {
      for (int i=1; i<list.size(); i+=2)
      {
         list.add(i, 7);
      }
   }
   
   // write a method to remove 7 between numbers

}