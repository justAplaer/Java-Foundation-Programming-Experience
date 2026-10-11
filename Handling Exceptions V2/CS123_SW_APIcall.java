// Tair Moldakhemtov 09/10/2026 CS 123 Fall 2026
// The following program cleverly handles some exceptions
// on Java to prevent the program breaking and rather
// process the critical cases

// Note:
/*
API stands for Application Programming Interface.
The basic idea: an API is a structured way for one program to ask another program or service for information.
In this program:
Java program sends a request to SWAPI:
   https://swapi.dev/api/planets/32/
SWAPI receives it and returns planet information as text in JSON format:
   {"name":"Chandrila","population":"1200000000", ...}
Program searches that returned text, extracts the planet’s name and population, then prints them.
*/

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.URI;
import java.util.*;

/** This class contains an API call to the website
 *  <em> swapi.dev </em> which will find a random
 * planet from the "Star Wars" universe.
 */

public class CS123_SW_APIcall {

   /** This method will pull a random planet from the 
    *  Star Wars API database and return it as a string.
	*  @returns The unparsed data file string.
	*/
   public static String getRandomName() 
   {
   /*
      Code below creates the “letter” your program sends to the Star Wars website asking for one planet.
      
      HttpRequest request = HttpRequest.newBuilder()
      Starts building an HttpRequest object. An HTTP request is a message sent from your program to a website.
      
      .uri(URI.create("https://swapi.dev/api/planets/" + pn + "/"))
      Sets the web address to visit.
      
      If pn is 32, Java combines the pieces into:
      https://swapi.dev/api/planets/32/
      That tells SWAPI: “Please give me the data for planet number 32.”
      
      .method("GET", HttpRequest.BodyPublishers.noBody())
      Says what kind of request you are sending.
      GET means: “I only want to retrieve information.” You are not changing anything on the site.
      noBody() means: “I am not sending extra information with this request.” That is normal for a simple GET request.
      
      .build();
      Finishes creating the request and stores it in the variable named request.
      In plain English, the whole block means:
      Build a request that visits the Star Wars API’s planet page for a random planet number and asks it to send back the planet’s information.
      
      It does not contact the website yet. The website is contacted later here:
      response = HttpClient.newHttpClient().send(
         request,
         HttpResponse.BodyHandlers.ofString()
      );
      That line sends the prepared request and receives the response as a String.
   */
   
      int pn = new Random().nextInt(100);
   
      HttpRequest request = HttpRequest.newBuilder()
         	.uri(URI.create("https://swapi.dev/api/planets/"+pn+"/"))
         	.method("GET", HttpRequest.BodyPublishers.noBody())
         	.build();       
                
      HttpResponse<String> response = null;

      try 
      {
         Thread.sleep(50); // Pause this part of the program for 50 milliseconds
         response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      } 
      
      catch (IOException e) 
      {
         e.printStackTrace();
      } 
      
      catch (InterruptedException e) 
      {
         e.printStackTrace();
      }
            
      String dataFromWebsite = response.body();

     // TODO #1  : If the string does not contain the substring "name" throw
     // an IllegalStateException
     // Literally asking whether our long String of data has name placeholder in it so that
     // our maing can work properly and extract name and population from the data string
     // if now we throw IllegalStateException, which is handled in main so that the program does not
     // crush and just outputs an error message
     if (!dataFromWebsite.contains("name"))
     {
         throw new IllegalStateException();
     }
    
  
     return dataFromWebsite;
   }
} 

// Note: try and catch structure also have a third component named
      // "finally", yet it is quite niche to specific circumstances
      /*
      It is primarily used for cleanup code—such as closing file streams, database connections, 
      or input scanners—so resources aren't left open even if your program crashes inside the try block.
      try 
      {
          // Code that might throw an exception
          int result = 10 / 0; 
      } 
      
      catch (ArithmeticException e) 
      {
          // Code that runs ONLY if an ArithmeticException happens
          System.out.println("Cannot divide by zero!");
      } 
      
      finally 
      {
          // Code that ALWAYS runs no matter what happens above
          System.out.println("Cleanup: This block always executes.");
      }
      
      The issue is that Putting code sequentially after a try-catch block works only 
      if the method completes without early exits or uncaught errors.
      A finally block guarantees execution in two critical situations where 
      code placed after try-catch gets completely skipped:
      
       public static int processFile() 
       {
          try 
          {
              // Read file...
              return 1; // Method exits here!
          } 
          
          catch (Exception e) 
          {
              return 0;
          }
   
       // THIS NEVER RUNS because of the return statements above!
       System.out.println("Closing file resource..."); 
       }
       
       public static int processFile() 
       {
          try 
          {
              // Read file...
              return 1; 
          } 
          
          catch (Exception e) 
          {
             return 0;
          } 
          
          finally 
          {
              // THIS ALWAYS RUNS right before the method returns 1 or 0!
              System.out.println("Closing file resource..."); 
          }
       }
      */


