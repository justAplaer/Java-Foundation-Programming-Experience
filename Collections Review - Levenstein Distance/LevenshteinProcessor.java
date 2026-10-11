// Tair Moldakhmetov CS 123 Fall 2026 10/01/2026
// The following class provides necessary logic to find the 
// Levenstein distance between two different words of the same length

/*
   The Levenshtein distance, named for its creator Vladimir Levenshtein, 
   is a measure of the distance between two words. The edit distance between 
   two strings is the minimum number of operations that are needed to transform 
   one sting into the other. For a full implementation of the distance, 
   we would need to account for three different types of operations, 
   removing a letter, adding a letter, or changing a letter.
*/

/*
   Note on List and ArayList differences:
   The primary difference is that List is an interface, while ArrayList is a concrete class that implements List
   What it is: 
      List: An interface (java.util.List). 
      ArrayList: A class (java.util.ArrayList).

   Role: 
      List: Defines a contract/blueprint of methods (add, get, remove, etc.). 
      ArrayList: Provides the actual implementation using a dynamically resizable array.

   Instantiation: 
      List: Cannot be instantiated directly (new List<>() will not compile). 
      ArrayList: Can be instantiated (new ArrayList<>()).
   
   Flexibility: 
      List: High (represents any list implementation). 
      ArrayList: Specific (represents only array-backed lists).

   Other Implementations: 
      List: ArrayList, LinkedList, Vector, Stack. 
      ArrayList: N/A (It is an implementation itself).
*/

// Imports to use Set
import java.util.*;
import java.io.*;

/**
* @author Tair Moldakhmetov
* @version 4.0
* LevenshteinProcessor class provides necessary method to find so-called
* Levenshtein distance between two words. It is not only capable of outputting
* the numerical distance, but also to actually find it and display the path
* It is important, however, that  there is a separate dictionary.txt file that 
* would provide word of English language. Methods heavily relly on this since 
* otherwise it is practically impossible to find levenshteinDistance without
* knowing any other words than starting and ending ones.
*/
public class LevenshteinProcessor
{
   // Class fields
   private String wordStart;
   private String wordEnd;
   private Map<String, Set<String>> wordNeighborMap = new HashMap<String, Set<String>>();
   private List<String> path = new ArrayList<String>();
   private int distance = -99;
   
   //Constructor
   /**
   * @param String wordStart - starting word from which the path will be calculated and found
   * @param String wordEnd - the "target" word to which distance is to be found
   * @param Set<String> wordBank - huge "database" of English word in form of a set
   */
   public LevenshteinProcessor(String wordStart, String wordEnd, Set<String> wordBank)
   {
      if (wordStart.length() != wordEnd.length()) { 
         throw new IllegalArgumentException("Words must be of the same length");
      }
      
      // Since exception will be thrown in case wordStart.length() != wordEnd.length()
      // It is now safe to deploy two following lines of code
      this.wordStart = wordStart;
      this.wordEnd = wordEnd;
      
      Set<String> list = new TreeSet<String>();
      
      // Loop below will delete all the "noise" - words that are of a different length than 
      // starting and ending words, which by definition must be of the same length
      for (String word : wordBank)
      {
         if (word.length() == wordStart.length())
         {
            list.add(word);
         }
      }
      
      for (String word1 : list)
      {
         // Here it is VERY important to make the for loop filling exactly this way
         // When I tested apples and length there was a problem - apples did not seem to
         // have members and initially I added a word to a map WITH a setHolder
         // ONLY if it had at least one neighbot. You see the problem... if word does not have neighbors, 
         // it will not be added to the map, but because it is either starting or ending
         // word it will eventually pop up in findDistance(String word1, String word2) method 
         // and then it will throw a null exception - because once it tries to access its
         // Set guess what, it will be null - and that is a big problem. This way ensures
         // that every word in wordNeighborMap has an empty Set - and in that case
         // it is possible to work it out (cause it is NOT null and rather an empty set)
         Set<String> setHolder = new TreeSet<String>();
         wordNeighborMap.put(word1, setHolder);
         for (String word2 : list)
         {  
            // only now do we check the differentLetters method and in case we di have neighbors,
            // add the neighbor to corresponding Set
            if (countDifferentLetters(word1, word2) == 1)
            {
               wordNeighborMap.get(word1).add(word2);
            }
         }
      } 
      
      // Following strokes have some of the "helper" prints I used to test the program behavior
      // System.out.println(wordNeighborMap);
      
      // System.out.println(distance);
      this.distance = findDistance(this.wordStart, this.wordEnd);
      
      // System.out.println(distance); //HELPER PRINT
      
      // BELOW IS REDUNDANT AND WRONG EXPLANATIONS - I left them for history and future review
      /*
      // This check is also important - because in case distance is zero, meaning
      // an array should be null, we literally cannot use any method relates to array
      // cause we technically have it as null. So even simple path = null wouldn't work
      // Not so much because lists and nulls are incomparible - but because the path List
      // itself is INHERENTLY null in the program, so it is not even possible to assign
      // it to null. Setting it equal to a normal array would have worked, but to null
      // breaks because it is already null... gosh
    
      if (distance > 0)
      {
         this.path = new ArrayList(findPath(this.wordStart, this.wordEnd));
      }
      */
      
      // findPath method has a correct note on this part of the code
      
      // The following check is CRUCIAL - it made me go mad with this code
      // I kept on getting Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.Collection.toArray()" because "c" is null
   	// at java.base/java.util.ArrayList.<init>(ArrayList.java:182) and was so concerned by it  
      // Initially I just had this.path = new ArrayList(findPath(this.wordStart, this.wordEnd));
      // BUT - if distance is 1 or negative, list from this.path = new ArrayList(findPath(this.wordStart, this.wordEnd));
      // would be null and ArrayList(null) is... illegal to say the least
      // That is why checking for EITHER distance == 1 OR distance < 0 is crucial
      // distance < 2 works just fine. Distance is int and list will have at least 1 element
      // if and only if distance is at least 2s

      if (distance < 2)
      {
         this.path = null;
      }
      
      else
      {
         this.path = new ArrayList(findPath(this.wordStart, this.wordEnd)); 
      }
      
      
      // System.out.println(path);
      
      // System.out.println(wordNeighborMap);
   }
   
   // The following method is a helper method to the constructor to find the distance between two words
   private int findDistance(String word1, String word2)
   {
      // In a very specific case not to calculate distance between the initially established words
      // Once again, just return the distance that is already stored in memory
      if (word1.equals(this.wordStart) && this.wordEnd.equals(word2) && this.distance > 0)
      {
         return this.distance;
      }
      
      Set<String> setOne = new HashSet<String>();
      Set<String> setTwo = new HashSet<String>();
      int counter = 0;
      
      setTwo.add(word1);
      /*
      The logic here is actually very interesting and peculiar. We add our initial word to the setTwo
      and the while loop start because setOne and setTwo are of a difference size and, by definition,
      setTwo does NOT containt word2 (word2, NOT word1). Then we add all elements of setTwo to setOne
      This will make more sense on the future rounds. Either way, now we think "Okay... so word1 is
      our start, word2 is the target... word1 has its neighbor and SOME of them should be closr to
      target word2 or even BE the target word in case word1 and word2 differ only by 1 letter... well
      let's just add all neighbor words or words in setOne to setTwo and check if they are adequate!"
      So we add. Suppose we are unlucky on the first try - now what? Now we think again "Okay so now in 
      set 2 we have the initial word (which role on its own is not so significant anymore) and a bunch
      of its neighbors... MOST of the neigbor words are the noise - they are not necessarily closer... but
      some are... They neighbors of word1 also have neighbors who are now different from corresponding
      neighbor of word1 (NOT the word1 itself). Most neighbors of neighbors are also just noise... but some
      of them are likely to be closer to word2. Morever, if solution exists, it is guaranteed to be true!".
      We literally repeat this while loop as many times as there are word in txt to the point where setTwo
      contains word2 - target word. Each full loop is one "step" because from thousand noise words some are
      adequate and get us closer 1 step to the target word. That is why we put count after two of the for
      each loop are done - because that is when we add all neighbors of neighbors, that is when all of
      the adequate candidates show up. 
      But what is there is not path? Well pay attention to how loop works - we clear setTwo in the beggining, 
      but in the end - it is once again filled with all neigbors out there and all the noise possible.
      Eventually, we will most literally "brute force" our way to the complete end - there will be no new
      neighbor words. Because we work with set, no duplicates allowed, so, if there is not solution, at some
      point, setTwo and setOne will be of an equal length. if that happens we catch it through the if statement
      outside the loop - and in case there is word2 in setTwo, we did our best, there is no path. If there IS
      a way, it will be caught by !setTwo.contains(word2) and this would mean setTwo finally contains word2
      and there is a path. In case we add everything thereis, but there is a path, if statement outsude will
      not affect the outcome and counter will be returned as intended.
      
      This method is rather a brute force one rather than efficient one, but still quite elegant
      */
      while (setOne.size() != setTwo.size() && !setTwo.contains(word2))
      {         
         for (String element : setTwo)
         {
            setOne.add(element);
         } 
         
         setTwo.clear();
         
         for (String elementOut : setOne) 
         {
            setTwo.add(elementOut);
            for (String elementIn : wordNeighborMap.get(elementOut))
            {
               setTwo.add(elementIn);
            }
         }
        
         counter++;
      }
      
      // Check see whether there is an actual path between two words...
      if (!setTwo.contains(word2))
      {
         return -1;
      }
      
      return counter;
   } 
   
   /**
   * @return null or returnString - based on whether there is LevenshteinDistance or now, either returns null 
   * or a String that represents the path from starting word to the target word
   */
   public String getPath()
   {
      if (distance < 0)
      {
         return null;
      }
      
      String returnString = this.wordStart;
         if (path == null)
         {
            returnString = returnString + "->" + this.wordEnd;
            return returnString;
         }
         
         for (int i = 0; i < path.size(); i++)
         {
            returnString += "->" + path.get(i);
            
            /* Note In Java, String objects are immutable, meaning their values cannot be changed once created.

              The + operator creates a new String result in memory, but if you do not 
              assign that result back to returnString, the expression executes and is immediately discarded.
              
            /* Other variants:
               returnString += "->";
               returnString += path.get(i);
               
               returnString = returnString + "->";
               returnString = returnString + path.get(i);
            */
         }
      
      
      returnString = returnString + "->" + this.wordEnd;
      
      return returnString;
   }
   
   /**
   * @return distance or return findDistance(this.wordStart, this.wordEnd); - return the amount
   * of "steps" need to go from starting word to ending word. In case it is already found, which
   * means that it is stored in the memory, it is returned directly, program does NOT inefficiently 
   * run a whole searcht the second time
   */
   public int getDistance()
   {
      if (distance != -99)
      {
         return distance;
      }
      
      else 
      {
         return findDistance(this.wordStart, this.wordEnd);
      }
   }
   
   // The following method return the path from starting word to the ending
   private List<String> findPath(String a, String b)
   {
      List<String> list = new ArrayList<String>();
      
      String middleMan = a;
      
      // the this.distance > 0 check is crucial. If it gets removed, then
      // while loop can go forever(length and apples - no Levenshtein distance)
      // that check prevents it. Cause if distance is negative,
      // there is not point in trying to find it, it simply DNE
      while (findDistance(middleMan, b) != 1 && this.distance > 0)
      {
          for (String element : wordNeighborMap.get(middleMan))
          {
             if (findDistance(element, b) < findDistance(middleMan, b))
             {
               middleMan = element;
               list.add(element);
             }
             
             if (findDistance(middleMan, b) == 1)
             {
               return list;
             }
          }
      } 
      
      // I left this check... just in case. After all I went through with null and list...
      // I wanna make sure program WORKS
     
      if (list.isEmpty() && distance < 2)
      {
         return null;
      }
      
      return list;   
   }

   // Below is a helper method used in the constructor - by simply counting how
   // many letter do not match in two words, it counts the "difference" between two
   // word. Though whether such path actually exists is another questions.
   // We use to find neighbor words - those different only by one letter
   private int countDifferentLetters(String a, String b)
   {
      if (a.length() != b.length())
      {
         return 0;
      }
      
      int returnValue = 0;
      
      for (int i = 0; i < a.length(); i++)
      {
         if (a.charAt(i) != b.charAt(i))
         {
            returnValue++;
         }
      }
      
      /*
      if (this.wordStart.equals(word1) && this.wordEnd.equals(word2))
      {
         this.distance = returnValue;
      }
      */
            
      return returnValue;
   }
}
// Below is redundant method to find distance between two words - the issue is that it kinda does do that
// By checking which letters are unequal - but just becuase user inputted two words does not mean they
// exists in English language (or in our case file.txt) and there is an actual path between them that DOES
// Exist. Currently implemented findDistance method works properly to check that
// In addition, sometimes the whole path is not just amount of different letter. As with apple and words
// different letter are 5 (notably all) but the path is 13 - because we must use existing
// english words to find this path

/*
 private int findDistance(String word1, String word2)
   {
      // Essentially, if statement below is not necessary in our case - loop in the constructor alreadt prevents this
      // Potential issue, but theoretically, if an extension to the program is to be done, to prevent "incontrolled"
      // exceptions in the terminal, this if statement is important
      if (word1.length() != word2.length())
      {
         throw new IllegalArgumentException("Words must be of the same length");
      }
      
      int returnValue = 0;
      
      for (int i = 0; i < word1.length(); i++)
      {
         if (word1.charAt(i) != word2.charAt(i))
         {
            returnValue++;
         }
      }
      
      if (this.wordStart.equals(word1) && this.wordEnd.equals(word2))
      {
         this.distance = returnValue;
      }
            
      return returnValue;
   }
*/