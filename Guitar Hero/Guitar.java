// The Guitar interface specifies a set of methods that can be used to play a
// musical instrument that can play various notes.  You can specify exactly
// which note to play (playNote) or you can specify a character that indicates
// which note to play (pluck).  Different guitar objects will have different
// mappings from characters to notes.  There is a hasString method that lets
// you verify that a particular string exists.  It also has methods for getting
// the current sound sample (the sum of all samples from the strings of the
// guitar), to advance the time forward one "tic," and an optional method for
// determining the current time (the number of times tic has been called).  If
// the time method is not implemented, it returns -1.

import java.util.*;
/**
* Guitar interface is a "contract" signed my Guitar37, ensuring that Guitar37 will feature all methods decribed in this interface
* @author Tair Moldakhmetov
* @version 1.0 (June 2026)
*/

public interface Guitar 
{
   /**
   * Method playNote is responsible to playing the sound based on the given pitch\
   * @param pitch - the pitch of the desired key
   */
    public void playNote(int pitch);
    
    /**
    * Method hasString(char key) checks if the given hey exists in the guitar and returns true if it does, false if does not
    * @param key - the desired key in the Guitar
    * @return the boolean value associated with the existing of passed key in the Guitar
    */
    public boolean hasString(char key);
    
    /**
    * Method pluck() is responsible for playing the sound of the pressed key
    * @param key - the key that is wanted to be played
    */
    public void pluck(char key);
    
    /**
    * Method sample() essentially returns the sombined sound sample of the guitar, sum of all sample of each string
    * @return the double value associated with the sum of all strings' samples
    */
    public double sample();
    
    /** 
    * Method tic is responsible for the "decay" logic of the gutar, making the sound vanish over time
    */ 
    public void tic();
    
    /**
    * Method returns the amount of time method "tic" was called
    * @return the int value of amount of times method tic was called
    */ 
    public int time();
    
    /**
    * Method printHistogram is responsible for the return of a map with information regarding
    * Pressed amount of each key
    * @return the map with the history of clicks of each key
    */
    public Map<Character, Integer> printHistogram();
}
