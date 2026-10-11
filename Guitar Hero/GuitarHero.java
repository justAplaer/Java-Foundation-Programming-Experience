// This program constructs a Guitar object that it allows the user to play.
import java.util.*;
public class GuitarHero 
{
    public static void guitarHero()
    {
        System.out.println("Preess l to exit the programm");
        Guitar g = new Guitar37(); 
        // this is an infinite loop--user must quit the application
        for (;;) 
        {
            // check if the user has typed a key; if so, process it   
            if (StdDraw.hasNextKeyTyped())   
            {
                char key = Character.toLowerCase(StdDraw.nextKeyTyped());
                
                if (key == 'l') //Since l is not in the variable KEYBOARD, it is a perfect key to bind to exit logic
                {
                     System.out.println("Below is the statistics showing how many times you played each key:");
                     System.out.println(g.printHistogram()); // Printing the history of pressed keys
                     System.out.print("The amount of times method 'tic()' was called is: ");
                     System.out.println(g.time()); // Printing the amount of times tic was called
                     // Initially, I only used break, but the window of the program did not close, which kept me annoyed
                     // So I conducted a little reserach and found this function fo completely terminate the program
                     for (java.awt.Window window : java.awt.Window.getWindows())
                     {
                         window.dispose();
                     }
                     //System.exit(0); // Exiting the programm and closing the window, nuclear option
                     break;             
                }
                
                else if (g.hasString(key)) 
                {
                    g.pluck(key);
                } 
                
                else 
                {
                    System.out.println("bad key: " + key);
                }
            }
            // send the result to the sound card
            StdAudio.play(g.sample());
            g.tic();
        }

    }
    
    public static void main(String[] args) 
    {
        guitarHero();
        System.out.println("Hey there");
        Scanner console = new Scanner(System.in);
    }
}
 