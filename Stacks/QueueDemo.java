import java.util.*;

public class QueueDemo 
{
   public static void main (String [] args) 
   {
   
      // TODO 1. Declare a Queue<Integers> variable named q and initialize with the linkedlist
      Queue<Integer> q = new LinkedList <>();
   /*
   *   
      q.add(10);
      q.add(20);
      q.add(30);
      
      System.out.println (q);
      
      while (!q.isEmpty()) 
      {
         q.remove();
      }
      System.out.println (q);
   // */
  /*
  */
      q.add(42);
      q.add(23);
      q.add(10);
      
      System.out.println ("The original queue: " + q);
      
      int size = q.size();
      for (int i = 0; i < size; i++) 
      {
         int element = q.remove(); 
         if (element % 2 == 1) q.add(element);   
      }
      
      System.out.println ("The updated queue: " + q);
      
      Stack<Integer> stack = new Stack<>();
      for (int i = 1; i <= 5; i++)
      {
         stack.push(i);
      }
      System.out.println("After the for loop: " + stack);
      changeStack(stack);
      System.out.println("After the method: " + stack);
   // */

   }
   
      public static void changeStack(Stack<Integer> s) 
      {
      Queue<Integer> q = new LinkedList<>();
      
      // s->q 
      while (!s.isEmpty()) 
      {
         q.add(s.pop());
      }
      
      // q->s
      while (!q.isEmpty()) 
      {
         s.push(q.remove());
      }
      
      // s->q
      while (!s.isEmpty()) 
      {
         q.add(s.pop());
      }

      // q->s and repeat evens
      while (!q.isEmpty()) 
      {
         
         if (q.peek()% 2 == 0) 
         {
            s.push(q.peek()); 
            s.push(q.remove());
         } 
         else 
         {
            s.push(q.remove());
         }
      }
   }
 }