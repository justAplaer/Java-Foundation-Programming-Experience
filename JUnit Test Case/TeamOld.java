import java.util.*;

/** This class will keep track of the current status of sports teams, and all the
 *  games this team has won during the current season.
 *  @version 0.0
 */
public class TeamOld implements Comparable<TeamOld>
{
    /** Constructor to set the team name and identifier.
     *  The intial list of points is set to a empty list.
     *  @param city A string version of the name of the city.
     *  @param nickName A string version of the nickname of the team.
     *  @throws IllegalArgumentException if the city or nickName is null.
     */
    public Team(String city, String nickName) {}

    /** Constructor to set the team name and identifier.  The full name should be a combination
     *  of the city plus nickName with an underscore <b> "_" </b> between them
     *  for example <em>Denver_Mountaineers</em>.
     *  The intial list of points is set to a empty list.
     *  @param fullName A string version of the name of the city plus the nickname.
     *  @throws IllegalArgumentException if the fullName is null.
     *  @throws IllegalArgumentException if the full name does not have an underscore '_' in it.
     */
    public Team(String fullName) {}

    /** Returns the current name/nickname of the city. 
     *  @return the name/nickname of the city.
     */
    public String getName() {return null;}

    /** Returns the current city of the team 
     *  @return the city of the team.
     */
    public String getCity() {return null;}
    
    /** Adds a single game including both the number of points scored and the result.
     *  @param points number of points scored in the game to be added.
     *  @param teamWon did the team win the game being added.  True=win, False = loss
     *  @throws IllegalArgumentException if an attempt to add a negative score is made.
     */
    public void addGame(int points, boolean teamWon) {}
    
    /** Returns the average number of points scored per game.
     *  @return the average number of points scored.  If there are no games, return 0.0.
     */
    public double getAveragePoints() {return -1.0;}

    /** Returns the total number of points scored in the season. 
     *  @return the total number of points scored in the current season.  If there are no games, return 0.0.
     */
    public int getTotalPoints() {return -1;}
    
    /** Returns the number of games played/added to the class.
     *  @return the number of games played.  (0 is acceptable).
     */
    public int getTotalGames() {return -1;}
    
    /** Returns the number of games recored as wins.
     *  @return the number of games won.  (0 is acceptable).
     */
    public int getTotalWins() {return -1;}
    
    /** removes all game data, while keeping the name and nickname. */
    public void resetYear() {}
    
    /** Returns the city and name of the team in the format CITYNAME:NICKNAME
     *  @return The string representation of the team according to the format above.
     */
    @Override
    public String toString() {return "";}

     /** Compares two Team objects based upon their name and nickname.
      * They are equal if the city name and the nickname match.
      * @param o the second Team to be compared to. 
      * @return The result of comparing the two string values.
      */
    @Override
    public boolean equals(Object o) {return false;}
    
    /** Compares two Team objects alphabetically, by city first, and then by nickname.
      * @param b the Team to be compared.
      * @return the value 0 if this Team is equal to the argument Team; a value less than 0 if this Team is 
      * alphabetically less than the argument Team; and a value greater than 0 if this Team is alphabetically 
      * greater than the argument Integer (signed comparison).
      */
    @Override
    public int compareTo(Team b) {return 0;}
}