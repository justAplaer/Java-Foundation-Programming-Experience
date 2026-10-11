// Tair Moldakhmetov CS 123 - Java Data Structures Fall 2026 03/10/2026
// The following program pairs with CS123Week2Main and provides multiple
// static methods - methods, that can be used in the main (or any other
// location if corresponding class is imported) without actually
// creating a variable of corresponding class - the wat math
// wors, for example: Math.round(), Math.pi - no need to do
// Math mymath = new Math(); or something like that to use methods

import java.util.*;

/**
* @author Tair Moldakhmetov
* @version 4.0
* The following class provides multiple methods to work with String[] Arrays
*/
public class StringArrayTools
{
   // The situation with contructor here is interesting - because there isn't really
   // anything we want to do upon creation of StringArrayTools class since it is a
   // "static" class, we don't really need a contructor. We can just skip it completely
   // and it will work since java does provide a deffault contructor if it is not there
   // I decided to create public StringArrayTools(){} just to show that empty contructor is a valid thing
   // Contructor
   /**
   * The following method is a contructor for StringArrayTools class
   */
   public StringArrayTools()
   {
      
   }
   
   /**
   * @param String[] theArray - provided string array that is used in the logic of the method
   * The following method substitues every elements of the passed array to null
   */
   public static void clearArray(String[] theArray)
   {
      // I have decided to add such check EVERYWHERE because in the last Levenshtein program I got
      // SO MANY errors with an array being null and Java not been able to envoke any method 
      // related to an array because it is null - so I have added this check everywhere in the program to prevent this
      if (theArray == null)
      {
         // Our type is void and empty return works, null wouldn't work though
         // In other return types it is possible to return null, but not with void
         // With void, only empty return; works to "stop" the method

         return; 
      }
      
      for (int i = 0; i < theArray.length; i++)
      {
         theArray[i] = null; // Making each element null
      }
   }
   
   /**
   * @param String[] theArray - provided string array that is used in the logic of the method
   * @return null or returnArrayCopy - returns null in case passed array is null or a COPY of
   * passed array that has reversed elements in it
   */
   public static String[] copyAndReverse(String[] theArray)
   {
      // My favorite (no) check
      if (theArray == null)
      {
         return null;
      }
      
      // I have decided to create a separate int length not only because it looks better, but
      // also because I have heard that it is more efficient for a computer to save
      // array.length or list.size() in a separate variable and use it, without the need to
      // always go back to the memory to get its value
      int length = theArray.length;
      String[] reverseArrayCopy = new String[length];
      
      for (int i = 0; i < length; i++)
      {
         reverseArrayCopy[i] = theArray[length-1-i]; 
      }
      
      return reverseArrayCopy;
   }
   
   /**
   * @param String[] theArray - provided string array that is used in the logic of the method
   * The following method takes passed array and reversed its order
   */
   public static void reverseArray(String[] theArray)
   {
      // I had some struggle here as well. I initially had an idea to instanteneously swap
      // two elements of an array (i and length-i-1), but I initially falsely thought that doig
      // length/2 would not be enough - and spoiler it is
      // If there is an even amount of elements, they will be properly swapped, if there is an
      // uneven amount, like 5, 5/2 will be 2. So 1st and 5th element will be swapped, 2nd and 4th,
      // then 3rd... there is not much to swap and at that point i=2 so loop wouldn't even work - nice
      // In this specific program, we do not really work with uneven arrays, but all in all, it
      // is important to conside such cases
      int length = theArray.length;
      
      for (int i = 0; i < length/2; i++)
      {
         String middleMan = theArray[i];
         theArray[i] = theArray[length-1-i];
         theArray[length-1-i] = middleMan;
      }
   }
   
   /**
   * @param String[] theArray - provided string array that is used in the logic of the method
   * @return "[No Array]" or returnString - returns "[No Array]" if passed Stng[] array is null or
   * or a String representation of the passed array if it does have some elements in it
   */
   public static String stringArrayToString(String[] theArray)
   {
      // Here in case passed array is null, we want to return "[No Array] to match the output"
      if (theArray == null)
      {
         return "[No Array]";
      }
      
      String returnString = "{" + theArray[0];
      
      for (int i = 1; i < theArray.length; i++)
      {
         returnString = returnString + "-" + theArray[i];
      }
      
      return returnString + "}";
   }
   
   /**
   * @param String[] theArray - provided string array that is used in the logic of the method
   * The following method makes all elements of a String[] array to go to upperCase
   */
   public static void upperCaseAll(String[] theArray)
   {
      if (theArray == null)
      {
         return;
      }
      
      for (int i = 0; i < theArray.length; i++)
      {
         theArray[i] = theArray[i].toUpperCase();
      }
   }
}