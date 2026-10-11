import java.util.*;
import java.io.*;

public class StackProgramming 
{
   public static void main(String [] args)  
   {
      /*
      * Building a integer stack, testing max
      */
      Stack<Integer> s = new Stack<>();
      s.push (40); s.push(20); s.push(30);
      System.out.println (s);
      System.out.println ("Max value in the stack: " + max(s));
      System.out.println (s);
      
      Stack<Integer> s2 = new Stack<>();
      s2.push (-40); s2.push(-20); s2.push(-30);
      
      System.out.println ("Max value in the stack: " + max(s2));
      System.out.println (s2);
      
      Stack<Integer> s3 = new Stack<>();
      s3.push (10); s3.push(-5); s3.push(0);
      
      System.out.println ("Max value in the stack: " + max(s3));
      System.out.println (s3);
      
      Stack<Integer> s4 = new Stack<>();
      System.out.println ("Max value in the stack: " + max(s4));
      System.out.println (s4);
      
      //*/
   
      Stack<String> stack = new Stack<>();
      stack.push("hello");
      stack.push ("hi");
      stack.push ("goodbye");
      stack.push ("howdy");
            
      System.out.println (stack);
      printLongest (stack);
     
      
   
      System.out.println (solvePostFix ("5 2 4 * + 7 -"));
      System.out.println (solvePostFix ("1 1 +"));
      System.out.println (solvePostFix ("1 2 3 * + 4 +"));
      System.out.println (solvePostFix (" 2 3 1 * + 9 -"));
  
      
      /*
      * parenthesis matching program
      * {[]} is balanced, where {{}}} is not
      * write a method called parenthesisCheck to check the matching parenthesis
      * and return true if they match, and false otherwise
      */
      
      System.out.println (parenthesisCheck("{}")); //should return true
      System.out.println (parenthesisCheck("{(}")); // should return false
      System.out.println (parenthesisCheck("{())}")); // should return false
      System.out.println (parenthesisCheck("[{()}[][]{}")); // should return false
      System.out.println (parenthesisCheck("( {()}[][]{}}"));
   }
   

   // accepts stack of integers and returns largest number in the stack
   public static int max (Stack<Integer> a) 
   {
      if (a.isEmpty())
      {  
         System.out.println("Passed stack was empty, returned value is 0");
         return 0;
      }
      
      Stack<Integer> copy = new Stack();
      copy.addAll(a);
      
      // Since integers can be negative and we need something to compare
      // each element to inside a while loop, setting up int max equal to
      // copy.pop(); sets the program on track properly
      
      int max = copy.pop();
      
      int middleMan = 0;
      while (!copy.isEmpty())
      {
         middleMan = copy.pop();
         if (middleMan > max)
         {
            max = middleMan;
         }
      }
      
      return max;
   }
   
   public static boolean parenthesisCheck(String word)
   {
      if (word == null)
      {
         return false;
      }
      
      Stack<Character> roundBracketsLeft = new Stack<>();
      Stack<Character> squareBracketsLeft = new Stack<>();
      Stack<Character> curlyBracketsLeft = new Stack<>();
      
      Stack<Character> roundBracketsRight = new Stack<>();
      Stack<Character> squareBracketsRight = new Stack<>();
      Stack<Character> curlyBracketsRight = new Stack<>();
      
      for (int i = 0; i < word.length(); i++)
      {
         if (word.charAt(i) == '(')
         {
            roundBracketsLeft.add(word.charAt(i));
         }
         
         else if (word.charAt(i) == '[')
         {
            squareBracketsLeft.add(word.charAt(i));
         }
         
         else if (word.charAt(i) == '{')
         {
            curlyBracketsLeft.add(word.charAt(i)); 
         }
         
         else if (word.charAt(i) == ')')
         {
            roundBracketsRight.add(word.charAt(i));
         }
         
         else if (word.charAt(i) == ']')
         {
            squareBracketsRight.add(word.charAt(i));
         }
         
         else if (word.charAt(i) == '}')
         {
            curlyBracketsRight.add(word.charAt(i));
         }
      }
      
      try
      {
         if ( (roundBracketsLeft.size() == roundBracketsRight.size() ) 
         && (squareBracketsLeft.size() == squareBracketsRight.size() ) 
         && (curlyBracketsLeft.size() == curlyBracketsRight.size() ) ) 
         {
            return true;
         }
         
         return false;
      }
      
      catch (NullPointerException e)
      {
         return false;
      }
   }
   
     
   
   // using one additional stack, print the longest word
   // do not detroy the original stack
   public static void printLongest (Stack<String> s) 
   {
      Stack<String> backup = new Stack<>();
      String longestWord = s.pop();
      backup.push(longestWord);
      
      while (!s.isEmpty()) 
      {
         String str = s.pop();
         if (str.length() > longestWord.length()) longestWord = str;
         backup.push(str);
      }
      
      // backup -> s
      while (!backup.isEmpty()) 
      {
         s.push(backup.pop());
      }

     // print the longest
     System.out.println (longestWord);
   }  
   
    public static int solvePostFix (String exp) 
    {
      // create a Stack
      Stack<Integer> s = new Stack<>();
      Scanner linescan = new Scanner (exp);
      
      while (linescan.hasNext()) 
      {
         // if it is a number, push into s
         if (linescan.hasNextInt()) s.push(linescan.nextInt());
         
         // if it is a operator, pop two from s
         else 
         {
            String op = linescan.next();
            int var1 = s.pop();
            int var2 = s.pop();
            
            if (op.equals("+")) s.push(var2 + var1);
            else if (op.equals("-")) s.push(var2 - var1);
            else if (op.equals("*")) s.push(var2 * var1);
            else if (op.equals("/")) s.push (var2 / var1);
         }
      }// end of while
      return s.pop();
   } 
}