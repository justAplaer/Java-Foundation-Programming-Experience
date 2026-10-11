import java.util.*;

/** 
 * @author Tair Moldakhmetov
 * This class will keep track of the current status of sports teams, and all the
 * games this team has won during the current season.
 * @version 1.0
 */
public class Team implements Comparable<Team>
{
   String city = "";
   String nickName = "";
   List<Integer> points;
   int totalWins = 0;
   int totalPoints = 0;
    /** Constructor to set the team name and identifier.
     *  The intial list of points is set to a empty list.
     *  @param city A string version of the name of the city.
     *  @param nickName A string version of the nickname of the team.
     *  @throws IllegalArgumentException if the city or nickName is null.
     */
    public Team(String city, String nickName) 
    {
      if (city == null || nickName == null)
      {
         throw new IllegalArgumentException("City and Nickname cannot be null");
      }
      
      this.city = city;
      this.nickName = nickName;
      points = new ArrayList<Integer>();
    }

    /** Constructor to set the team name and identifier.  The full name should be a combination
     *  of the city plus nickName with an underscore <b> "_" </b> between them
     *  for example <em>Denver_Mountaineers</em>.
     *  The intial list of points is set to a empty list.
     *  @param fullName A string version of the name of the city plus the nickname.
     *  @throws IllegalArgumentException if the fullName is null.
     *  @throws IllegalArgumentException if the full name does not have an underscore '_' in it.
     */
    public Team(String fullName) 
    {
      // It is important to FIRST check whether fullName is null cause if it is. you cannot engage contains() method
       if (fullName == null || !fullName.contains("_")) 
       {
         throw new IllegalArgumentException("Full name must contain an underscore that divides the city and nickname and cannot be null");
       }
       
       int counter = 0;
       
       // The first loop goes until it actually hits the underscope _, after which is stops
       while (fullName.charAt(counter) != '_')
       {
          this.city = this.city += fullName.charAt(counter);
          counter++;
       }
       
       // System.out.println(this.city); // checking this.city value
       
       // Becuase at this point in the program fullName.charAt(counter) would yield "_" exactly and that
       // serves as a border between city and nickname, we manually add 1 to count
       counter++;
       
       //Since the reat of the fullName is the nickName, we only care about the counter been less
       // than fullName length so that we don't get index out of bounds exception
       while (fullName.length() > counter)
       {
          this.nickName = this.nickName += fullName.charAt(counter);
          counter++;
       }
       
       // System.out.println(this.nickName); // checking this.city value
       
       // For the += trick to work proprely, city and nickName are initially set to ""
       // this is an "empty" String yet it is not completely null. If both strings wil;=l
       // only be declared, they will be null upon creation and null += String never ends well
       // So here the check is aimed to catch something like _Team or City_
       // In such scenario either first or second while loop higher will not even start
       // So either city or nickName will remain "" - that is what we aim to catch using this if
       if (city == "" || nickName == "")
       {
          throw new IllegalArgumentException("City and Nickname cannot be emptyl");
       }
       
       points = new ArrayList<Integer>();
    }

    /** Returns the current name/nickname of the city. 
     *  @return the name/nickname of the city.
     */
    public String getName() 
    {
      return this.nickName;
    }

    /** Returns the current city of the team 
     *  @return the city of the team.
     */
    public String getCity() 
    {
      return this.city;
    }
    
    /** Adds a single game including both the number of points scored and the result.
     *  @param points number of points scored in the game to be added.
     *  @param teamWon did the team win the game being added.  True=win, False = loss
     *  @throws IllegalArgumentException if an attempt to add a negative score is made.
     */
    public void addGame(int points, boolean teamWon) 
    {
      if (points < 0)
      {
         throw new IllegalArgumentException("Score cannot be negative");
      }
      
      if (teamWon == true)
      {
         totalWins++;
      }
      
      totalPoints += points;
      this.points.add(points);
    }
    
    /** Returns the average number of points scored per game.
     *  @return the average number of points scored.  If there are no games, return 0.0.
     */
    public double getAveragePoints() 
    {
      double returnValue = 0.0;
      
      for (int i = 0; i < points.size(); i++)
      {
         returnValue += points.get(i);
      }
      
      if (points.size() != 0)
      {
         return returnValue/points.size();
      }
      
      return returnValue;
    }

    /** Returns the total number of points scored in the season. 
     *  @return the total number of points scored in the current season.  If there are no games, return 0.0.
     */
    public int getTotalPoints() 
    {
      return totalPoints;
    }
    
    /** Returns the number of games played/added to the class.
     *  @return the number of games played.  (0 is acceptable).
     */
    public int getTotalGames() 
    {
      return points.size();
    }
    
    /** Returns the number of games recored as wins.
     *  @return the number of games won.  (0 is acceptable).
     */
    public int getTotalWins() 
    {
      return totalWins;
    }
    
    /** removes all game data, while keeping the name and nickname. */
    public void resetYear() 
    {
      points = new ArrayList<Integer>();
      totalWins = 0;
      totalPoints = 0;
    }
    
    /** Returns the city and name of the team in the format CITYNAME:NICKNAME
     *  @return The string representation of the team according to the format above.
     */
    @Override
    public String toString() 
    {
      return "" + this.city.toUpperCase() + ":" + this.nickName.toUpperCase();
    }

     /** Compares two Team objects based upon their name and nickname.
      * They are equal if the city name and the nickname match.
      * @param o the second Team to be compared to. 
      * @return The result of comparing the two string values.
      */
    @Override
    public boolean equals(Object o) 
    {
      // Check whether passed object even matches us
      if (this == o) return true;
      
      // Check if the passed object is Team, otherwise return false cause it does not equal it
      if (!(o instanceof Team)) return false;
      
      Team other = (Team) o;
      if (this.city.equals(other.getCity()) && this.nickName.equals(other.getName()))
      {
         return true;
      }
      
      return false;
    }
    
    /** Compares two Team objects alphabetically, by city first, and then by nickname.
      * @param b the Team to be compared.
      * @return the value 0 if this Team is equal to the argument Team; a value less than 0 if this Team is 
      * alphabetically less than the argument Team; and a value greater than 0 if this Team is alphabetically 
      * greater than the argument Integer (signed comparison).
      */
    @Override
    public int compareTo(Team other) 
    {
      // It appears that equals method is not inherently binded to return -1, 0, 1
      // In case of letter and wors, for example, java uses the unicode and substract them
      // Comparing a and b return just the negative number (not necessarily -1), but why is that?
      // because b>a, hence, a-b=-num just like 5-10=-5
      // -1 and 1 are just the most "popular" answers returned to determine whether an object is
      // preceding or not relative to the other one
      
      // If cities are equal, comparing then would return zero, but we also have a nickName
      // in this connection, we check if they are NOT equal so that their comparison is
      // "primary". In case they are not, it comes down to nickNames, caught by code below
      if (!this.city.equals(other.getCity()))
      {
         System.out.println(this.city.compareTo(other.getCity()));
         return this.city.compareTo(other.getCity());
      }
      
      // This is our hidden "else" statement. If the name are not equalm return higher will
      // properly return index using the cities. Howeverm in case cities are equal, it all comes
      // down to comparing nickNames. In case nickNames are also equal, 0 will be returned
      // similarly, proper positive or negative numbers will also be returned upon this comparison
      System.out.println(this.nickName.compareTo(other.getName()));
      return this.nickName.compareTo(other.getName());
     
    }
}