// skeleton version of the class
import java.util.*;

/**
* Guitar37 class is essentially a class, that programms the logic for 37 keyboard keys to produce a sound upon pressing
* @author Tair Moldakhmetov
* @version 1.0 (June 2026)
*/
public class Guitar37 implements Guitar 
{
   public static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
   private GuitarString[] strings; // Array for the strings themselves
   private Map<Character, Integer> map = new LinkedHashMap<Character, Integer>(); // A Map to keep track of pressed keys
   private int ticAmount = 0; // A variable to trackt he amount of times tic() was called
   
   /**
   * Method Guitar37() initializes the class itself, creates and fills array of Guitar Strings 
   * And also initizlizes a LinkedHashMap to keep track of the amoun of times each jey was pressed
   */
   public Guitar37()
   {
      strings = new GuitarString[37];
      for (int i = 0; i < strings.length; i++)
      {
         strings[i] = new GuitarString(440*Math.pow(2, (i-24)/12) );
         map.put(KEYBOARD.charAt(i), 0); // For now, assigning value of 0 to each key since none of them were yet pressed
      }
   }
   
   /**
   * Method playNote essentially plays the sound based on the inputted pitch
   * @param pitch - the pitch of the desired sound
   */
   public void playNote(int pitch)
   {
      if (pitch >= -24 && pitch <= 12) //Checking that the passed pitch is withing the possible bounds of the guitar
      {
          strings[pitch+24].pluck(); // adding 24 to pitch ensures tre proper logic of the program
      }
   }
   
   /**
   * Method hasString(char key) returns true if the Guitar37 does indeed contatin the passed key
   * @param key - the desired key in the Guitar37
   * @return the boolean value associated with the existence of passed key in the Guitar37
   */
   public boolean hasString(char key)
   {
      return KEYBOARD.indexOf(key) != -1; // keyboard has the key, the value will not be -1, therefore, true will be returned
   }
   
   /**
   * Method pluck(pass char key) plays the passed
   * @param key - a key that is wanted to be played
   */
   public void pluck(char key)
   { 
      int index = KEYBOARD.indexOf(key);
      if (index != -1) // if the index is not -1, then that key is inside the strings - safe to go
      {
         map.put(KEYBOARD.charAt(index), map.get(KEYBOARD.charAt(index)) + 1); // Adding 1 to the value of key associated with the one just pressed
         strings[index].pluck();
      }
   }
   
   /**
   * Method sample() returns the sum of all samples of each GuitarString in strings
   * @return the sum of all samples of each GuitarString
   */
   public double sample()
   {
      double returnValue = 0.0;
      
      for (int i = 0; i < strings.length; i++)
      {
         returnValue += strings[i].sample();
      }
      
      return returnValue;
   }
   
   /**
   * Method tic is responsible for teh decaying logic of a string sound over time
   * In addition, it keeps track of each time method tic() was called
   */
   public void tic() 
    {
        for (int i = 0; i < strings.length; i++)
        {
            strings[i].tic();
        }
        ticAmount++; // Adding 1 to the variable tracking the amount of times tic() was called
    }

   /**
   * Method time() returns the amount of times mehtod tic() was called
   * @return the amount of times method tic() was called
   */
   public int time() 
    {
        return ticAmount; // Returning the ticAmount value
    }
    
   /**
   * Method printHistogram returns a map with the information regarding the amount of times each key in Guitar37 was pressed
   * @return the Map with the information regarding the amount of times each key was pressed in Guitar37
   */
   public Map<Character, Integer> printHistogram()
    {
        return map; // Returning the Map
    }
}
