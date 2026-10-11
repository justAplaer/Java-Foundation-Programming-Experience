import java.util.*;

public class CS123_GetPlanetName
{
	/** Main Program
	 * @author Tair Moldakhmetov
    * The following program outputs the information about a planet from 
    * the Star Wars universe, featuring its name and corresponding population
    * If planet lacks the data or does not provide information about itself
    * program cleverly processes that throguh try and catch exception logic
	 * @param args System OS program flags.
	 */
    public static void main(String[] args) 
    {
        for (int i = 0; i < 25; i++)
        {
               // TODO #2 : The next line tries to get the data from the API Call
               // However
               // if it throws an exception, 
               //    catch the error
               //    output a small error message
               //    lower i by one to keep the loop going.
               //    Set the string to null;

               String data = null; 
               // If try works, data is not null anymore, if not, then first the erros message
               // pops up, and if statement further fails, not encounterin nullPointerException 
               try
               {
                  data = CS123_SW_APIcall.getRandomName();
                  // Uncomment this line to see the data.
                  // System.out.println(1+i + " : " + data);
               }
               
               // Here we want to write a print, not throw the exception, cause otherwise we would
               // catch exception, that ruins the program, to ruin the program
               catch (IllegalStateException e)  
               {
                  System.out.println("Bad Data found, trying again.");  
                  i--;
               }
               
               if (data != null)
               {
                  // TODO #3: if the string is not null (which means the try worked)
                  // use the following lines to extract the exact name from the data. 
                  
                  // Note: In Java, "\"" represents a String containing a single double-quote character (").
                  /*
                     System.out.println("\""); // Output: "
                     System.out.println("He said, \"Hello!\""); // Output: He said, "Hello!"
                  */
                  
                  /*
                     Initially I had a lot of trouble with figuring out what is going on, which really
                     happened because I failed to recall that indexOf is a String method and not something
                     specific to this program. After than further process became smooth
                     Essentially, we use CS123_SW_APIcall.getRandomName(); to get a long string
                     that contains data about corresponding plane in a long string like so:
                     20 : {"name":"Chandrila","rotation_period":"20","orbital_period":"368","diameter":"13500","climate":"temperate","gravity":"1","terrain":"plains, forests","surface_water":"40","population":"1200000000","residents":["https://swapi.dev/api/people/28/"],"films":[],"created":"2014-12-18T11:11:51.872000Z","edited":"2014-12-20T20:58:18.472000Z","url":"https://swapi.dev/api/planets/32/"}
                     
                     Pretty long right? So what we think about is this: Since returned variable is a string
                     and it is in a pretty structured format, why not literally find the location inside the
                     String data that points out to the index of corresponding "infi-holder"
                     int nameLocation = data.indexOf("name"); asks "What is the index of name?"
                     returned value will be the location of "n" in name. Interestingly, here is particular
                     data.indexOf("n"); would have also worked, because first n in any planet data is in name anyway
                     BUT! In bigger structured it is very risky to do. Doing indexOf("p"); would crew up the whole 
                     pattern since p can be found in the planet's actual name or rotation_#P#eriod
                     explicitly using the full string we aim for returns the index of a first letter in that string
                     -1 if it is not found at all
                     
                     Since we know index of n in name and know how a passed string data looks like, we need the data in
                     "DATA", those sweet quotes. If we knew position of adequate quotes, we could do
                     data.substring(quoteStart + 1, quoteEnd); reason for those +1 and is because
                     substring includes the boundaries on the left, but does not on the right though
                     
                     So we take location of n in name and add 5 to it, because after n there is ame" - four symbols BUT
                     if we do int nameLocation2 = data.indexOf("\"", nameLocation + 4); we would set our start exactly at " sing
                     asking "Starting at the quote, where is the neareast quote?" Well that is just where you already are
                     So we add 5 (or other adequate number based on the corresponding data identifying string)
                     This would yield us the left quote so we have #"#DATA"
                     
                     Now, we do nameLocation2 = data.indexOf("\"", nameLocation + 1): and ask "starting from the first
                     character after left quote, where is the neareast quote?" we get and boom, we have our set up
                     doing String theName = data.substring(nameLocation2 + 1, nameLocation3); perfectly extracts the data
                     right in front of name holder, giving us the actual name of a Planet
                     
                  */
                  // Note: doing int nameLocation = data.indexOf("nme"); - notive the typo nme
                  // would return -1. Not Because suddenly there a nme holder at index -1, but
                  // exactly because it does not exist
                  int nameLocation = data.indexOf("name");
                  
                  // System.out.println(nameLocation);
                  
                  int nameLocation2 = data.indexOf("\"", nameLocation + 5);
                  int nameLocation3 = data.indexOf("\"", nameLocation2 + 1);
                  String theName = data.substring(nameLocation2 + 1, nameLocation3);
                  
                  int populationLocation = data.indexOf("population");
                  int populationLocation2 = data.indexOf("\"", populationLocation + 11);
                  int populationLocation3 = data.indexOf("\"", populationLocation2 + 1);
                  String thePopulation = data.substring(populationLocation2 + 1, populationLocation3);
                  
                  // 10 to get to " exactly, hence add 11
                  
                  // TODO #4 : Don't just print off the name, but also find and
                  // print off the population.  
                  // Hint: figure out how the name was extracted, and do something similar.
                  //
                  // The expected output should be something like
                  //  1 : Name = Mon Cala  Population = 27000000000
                  
                  System.out.println(1+i + " : Name = " + theName + "  Population = " + thePopulation);
              }
              
         }
    }
}