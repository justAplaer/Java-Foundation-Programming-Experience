import java.util.*;
/**
* The GuitarString class is essentially the most crucial part of GuitarHero logic
* It simulates the real world behaviour of a guitar string, as its name suggests
* It feature a private Queue, where the "amplitude" of a string movement is uploaded
* As well as int size, which is responsible for the amount of that "movements" in a 
* Ringubuffer based on the given frequence or a passed.
* @author Tair Moldakhmetov
* @version 1.0 (June 2026)
*/
public class GuitarString
{
   // Data fields
   private Queue <Double> ringbuffer;
   private int size;
   // Decay factor is a pretty simple term. It defined how long will it take for a sound to completely vanish and stop making any noice
   // The smaller the decay factor, the faster the sound vanishes
   double decayFactor = 0.996;
   
   // Constructors
   
   /**
     * Constructs a GuitarString of a given frequency. 
     * Calculates the size of the ringbuffer based on the passed frequency value 
     * rate and initializes the ringbuffer with zeros to represent a "white noise".
     * @param frequency The physical frequency of the note in Hertz (Hz)
     * @throws IllegalArgumentException if frequency is less than or equal to 0
     */
     
   public GuitarString(double frequency)
   {
      if (frequency <= 0)
      {
         throw new IllegalArgumentException();
      }
      
      size = Math.round ((float)(StdAudio.SAMPLE_RATE/frequency));
      ringbuffer = new LinkedList<>();
      
      if (size < 2)
      {
         throw new IllegalArgumentException();
      }
      
      for (int i = 1; i <= size; i++)
      {
         ringbuffer.add(0.0);
      }
   }
   
   /**
   * Constructs a GuitarString with rather already provided ringbuffer values
   * This particular piece of code is not engaged in the main logic of GuitarHero, it is used for testing
   * @param init. The "movement" of the string over time
   * @throws IllegalArgumentException if init is null or its length is less than 2
   */
   
   public GuitarString(double[] init)
   {
      if (init == null || init.length < 2) // I have added another null check in case passed array is completely empty so that the programm won't crash
      {
         throw new IllegalArgumentException();
      }
       
      size = init.length;             // it is important to pass a value to size in here so that future methods such as pluck work properly
      ringbuffer = new LinkedList<>();
      
      for (int i = 0; i < size; i++)
      {
         ringbuffer.add(init[i]);
      }
   }
   /*
   I was first highly confused by the logic of this program so I decided to understand the "physics" of the process throuhg real world analogy
   I didn't understand why the outputted sound of keys A and C remains the same for each of them. Shouldn't random values of ringbuffer make it
   random on each type? But the physics process is very logicall. Frequence is more of a "fixed" property for each object. The force acting upon a
   String with frequency 440 Hz would never change that value since more energy means more distance travelled, which evens out that impact difference
   That is exactly why random numbers in ringbuffer, especially after being "averged" don't change the outputted frequence or time it takes for the
   sound to vanish. I am looking forward to start working on the second part. Maybe I could make it possible to arrange frequence for each key for
   a user. I will think about about posibilities. There are a lot of them in such big project.
   */
   
   /**
   * Essentially creates a "silent" string by filling out the ringbuffer with random values from -0.5 to 0.5
   * This method simulates the physical pluck of a string in the real world
   */
   public void pluck()
   {
      Random random = new Random();
      ringbuffer = new LinkedList<>(); // Cleaning the queue
      
      // I had noticed that boundries can be set by inputing values inside random methods, so I have decided to include that solution as well
      /*
      for (int i = 0; i < size; i++)
      {
         ringbuffer.add(random.nextDouble(-0.5, 0.5));
      }   
      */
      
      // To ensure the proper compilation, the actuall solution is more "general"
      
      for (int i = 0; i < size; i++)
      {
         ringbuffer.add(random.nextDouble() - 0.5);
      }
   }
   
   /**
   * method tic simulates the decay of a string. This piece of code is exactly what makes sound
   * from the string be more silent over time, eventually stopping producing any noice at all
   */
   // Tic is one of the most crucial parts of this project. It is the logic that actually "decays" the sound overtime, making it dimmer and dimmer
   public void tic()
   {
      double remove = ringbuffer.remove();
      
      double peek = ringbuffer.peek();
      
      double average = (remove+peek)/2.0;
      
      double finalValue = average*decayFactor;
      
      ringbuffer.add(finalValue);
   }
   
   /**
     * Returns the current audio sample at the front of the ring buffer.
     * @return The double value representing the current displacement of the string
     */
   public double sample()
   {
      return ringbuffer.peek(); // Returning the peeked value
   }
}