import java.util.*; // Stack

public class StackDemo 
{
   public static void main (String [] args) 
   {
      // TODO 1. create a new stack that stores Integer values
      Stack<Integer> stack = new Stack<>();
      // TODO 2. add three integers (1, 2, 3) onto the stack
      for (int i = 1; i <= 3; i++)
      {
         stack.push(i);
      }
      // TODO 3: print the top value without removing it (Hint: use peek())
      System.out.println(stack.peek());
      System.out.println(stack.get(1)); //Gets you a value under the index of 1
      // TODO 4: print the stack
      System.out.println(stack);
      // TODO 5. remove and print the top element 
      System.out.println(stack.pop());
      // TODO 6: print the stack again after removing the top
      System.out.println(stack);
      
      //System.out.println (isPalindrome ("racecar")); // true
      //System.out.println (isPalindrome ("Hello")); // false

      //System.out.println (isBalanced (" if (x) { ")); // false
      //System.out.println (isBalanced ("if (a(4) > 9) { foo(a(2)); }"); // true    
   }
   
   
   /* 
   * Palindrome Checker 
   */        
   public static boolean isPalindrome (String s) 
   {
      Stack<Character> st = new Stack<>();
      
      // push all characters to the stack
      for (int i=0; i<s.length(); i++) 
      {
         st.push (s.charAt(i));
      }
      
      // pop characters and compare with original string
      for (int i=0; i<s.length(); i++) 
      {
         if (st.pop() != s.charAt(i)) 
         return false;
      }
      return true;
   }
   
   /* TODO: Write a method named iaBalanced that accepts a string of source code and 
   uses a Stack to check whether the braces/parentheses are balanced. 
   
   Every ( or { must be closed by a } or ) in the opposite order. 
   Return false if an imbalance occurs, or true if the string is balanced. 
 
   Constraints: Use a single stack as auxiliary storage.

   */
   
   /*
   */
   public static boolean isBalanced (String s) 
   {
   
      Stack<Character> stack = new Stack<>();
      
      for (int i = 0; i < s.length(); i++) 
      {
         char c = s.charAt(i);
         // if c is an opening paren '(' or '{', push it to the stack
         if (c == '(' || c == '{') stack.push(c); // Любопытно...
         
         // else if (c==')' or '}' stack.pop() and compare with c
            // if mismatch , return false
         // else do nothing (letters, numbers, etc)
      }
      return true;
   }
   
   public static int max(Stack<Integer> s)
   {
      Stack<Integer> backup = new Stack<Integer>();
      int maxValue = s.get(0);
      backup.push(maxValue);
      
      while (!s.isEmpty()) 
      {
         int next = s.pop();
         backup.push(next);
         maxValue = Math.max(maxValue, next);
      }
      
      while (!backup.isEmpty()) 
      {
         s.push(backup.pop());
      }
      
      return maxValue;
      
   }
   //*/
 }