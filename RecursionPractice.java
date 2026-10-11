// CS 123 Fall 2026 09/25/2026 Tair Moldakhmetov
// The following program provides basic example of recursion, which give an intuition of recursion as problem solving method

/**
* @author Tair Moldakhmetov
* @version 1.0
* The following program uses recursion to solve several programming problems
*/
public class RecursionPractice
{
   public static void main(String[] args)
   {
      System.out.println(isPalindrome("madam"));
      //System.out.println(isPalindrome("Hello"));
      System.out.println(isPalindrome("racecar"));
      //System.out.println(isPalindrome("Racecar"));
      System.out.println(isPalindrome("step on no pets"));
      System.out.println(isPalindrome("able was I ere I saw elba"));
      System.out.println(isPalindrome("Java"));
      System.out.println(isPalindrome("rotater"));
      System.out.println(isPalindrome("byebye"));
      System.out.println(isPalindrome("notion"));
      
      writeSquare(8);
      System.out.println();
      writeSquare(11);
      System.out.println();
      writeSquare(6);
      System.out.println();
      writeSquare(7);
   }  
   
/**
* @param String word - a word that will be checked whether it is a palindrome or not
* The following method uses recursion to check if a word is Palindrome
* its base case if word is just 1 character - then it is indeed a palindrome
* Othewise, it checks if the most outer letters from both left and right side of a word match
* Then method calls itself and now input a word with no letters it just checked
* For madam, it will compare M as Madam and M as madaM. Then pass ada - and do same thing here
* After a chain of calls, method will either reach base case and return true, or return false
* as part of one of the checks
*/
   public static boolean isPalindrome(String word)
   {
      if (word.length() == 1)
      {
         return true;
      }
      
      if ( word.charAt(0) == word.charAt(word.length()-1) ) 
      {
         String input = word.substring(1, word.length()-1);
         return isPalindrome(input);
      }
      
      else
      {
         return false;
      }
   }
   
   /**
   * @param int n - the number which squares will be outputed
   * The following mehtod takes in an integer number n and then outputs n squares
   * first it outputs odd squares in descending order and then even squares in ascending order
   * For example, if input is 4 output is 9(3^2) 1(1^2) 4(2^2) 16(4^2)
   */
   public static void writeSquare(int n)
   {
      // As I was doing this method, I discovered that even in void a certain return is possible - the void return
      // Passing any value will break the loop, but doing just return; perfectly works as a base case and acts as
      // a stopper once the end is reached
      if (n <= 0)
        {
            return;
        }
       
       // The logic is fairly simple: if passed number is not even, then remainder is not 0
       // Hence number is odd, so we first output its square(cause it will be its own biggest square)
       // Then we pass n-1 through the loop
       if (n % 2 == 1) 
       {
           System.out.print(n * n + " ");
           writeSquare(n - 1);
       }
        
       // Now if number IS even, we do not print it out yet - it is suppose to be printed later in ascending order
       // So here we first pass n-1 - it will be odd and its square printed out immideately
       // After that we print out the even square - but recall what will writeSquare trigger - another level
       // to our program. So The most first even number to be printed out will also be the smallest one
       // that is how it works - like a pyramid with layers
       else     
       {
           writeSquare(n - 1);
           System.out.print(n * n + " ");
       }
   }
}