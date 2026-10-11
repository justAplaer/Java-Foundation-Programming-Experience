import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class TeamTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
    @Before public void setUp() {
   }
   
   @Test public void FirstContructorTest1() {
      
      try {
         Team team = new Team(null, "Quatar");
         fail();
      }
      
      catch (IllegalArgumentException e) {
      }
      
   }
   
   @Test public void FirstContructorTest2() {
      
      try {
         Team team = new Team("Almaty", null);
         fail();
      }
      
      catch (IllegalArgumentException e) {
      } 
   }
   
   @Test public void FirstContructorTest3() {
      
      try {
         Team team = new Team(null, null);
         fail();
      }
      
      catch (IllegalArgumentException e) {
      }
   }
   
   @Test public void SecondContructorTest1() {
      
      try {
         Team team = new Team(null);
         fail();
      }
      
      catch (IllegalArgumentException e) {
      }
   }
   
   @Test public void SecondContructorTest2() {
      
      try {
         Team team = new Team("Apple_");
         fail();
      }
      
      catch (IllegalArgumentException e) {
      }
   }
   
   @Test public void SecondContructorTest3() {
      
      try {
         Team team = new Team("_Banana");
         fail();
      }
      
      catch (IllegalArgumentException e) {
      }
   }
   
   @Test(expected = IllegalArgumentException.class) public void SecondContructorTest4() 
   {
     Team team = new Team("Apple");
   }
   
   @Test public void getName1()
   {
      Team team = new Team("Almaty", "Quatar");
      assertEquals("The following test tests the getName() function through first constructor", "Quatar", team.getName());
   }
   
   @Test public void getName2()
   {
      Team team = new Team("Almaty_Quatar");
      assertEquals("The following test tests the getName() function through second constructor", "Quatar", team.getName());
   }
   
   @Test public void getCity1()
   {
      Team team = new Team("Almaty", "Quatar");
      assertEquals("The following test tests the getCity() function through first constructor", "Almaty", team.getCity());
   }
   
   @Test public void getCity2()
   {
      Team team = new Team("Almaty_Quatar");
      assertEquals("The following test tests the getCity() function through second constructor", "Almaty", team.getCity());
   }
   
   @Test(expected = IllegalArgumentException.class) public void addGameTest1()
   {
      Team team = new Team("Almaty_Quatar");
      team.addGame(-1, false);
   }
  
   // How to test something Illegal like incomparable types?
   /*
   @Test(expected = IllegalArgumentException.class) public void addGameTest2()
   {
      try {
      Team team = new Team("Almaty_Quatar");
      team.addGame(-1, "false");
      fail(); 
      }
      
      catch (IllegalArgumentException e) {
      }
   }
   */
   @Test public void getAverageTest1()
   {
      Team team = new Team("Moscow_Russia");
      assertEquals("The following test tests the getAveragePoints() method if no games are added", 0.0, team.getAveragePoints(), 0.0);
   }
   
   @Test public void getAverageTest2()
   {
      Team team = new Team("Moscow_Russia");
      team.addGame(2, true);
      assertEquals("The following test tests the getAveragePoints() method if one games are added", 2.0, team.getAveragePoints(), 0.0);
   }
   
   @Test public void getAverageTest3()
   {
      Team team = new Team("Moscow_Russia");
      team.addGame(3, false);
      team.addGame(4, true);
      assertEquals("The following test tests the getAveragePoints() method if two games with points 4 and 3, hence, average of 3.5, are added", 3.5, team.getAveragePoints(), 0.0);
   }
   
   @Test public void getTotalPointsTest1()
   {
      Team team = new Team("London", "UK");
      assertEquals("The following test tests the getTotalPoints() method when no games are added", 0.0, team.getTotalPoints(), 0.0);
   }
   
   @Test public void getTotalPointsTest2()
   {
      Team team = new Team("London", "UK");
      team.addGame(3, true);
      assertEquals("The following test tests the getTotalPoints() method when one game with points 3 is added", 3.0, team.getTotalPoints(), 0.0);
   }
   
   @Test public void getTotalPointsTest3()
   {
      Team team = new Team("London", "UK");
      team.addGame(3, true);
      team.addGame(5, true);
      assertEquals("The following test tests the getTotalPoints() method when two game with points 3 and 5 are added", 8.0, team.getTotalPoints(), 0.0);
   }
   
   @Test public void getTotalGamesTest1()
   {
      Team team = new Team("London", "UK");
      assertEquals("The following method checks the getTotalGames() method when no games are added", 0, team.getTotalGames());
   }
   
   @Test public void getTotalGamesTest2()
   {
      Team team = new Team("London", "UK");
      team.addGame(4, true);
      assertEquals("The following method checks the getTotalGames() method when one games is added", 1, team.getTotalGames());
   }
   
   @Test public void getTotalGamesTest3()
   {
      Random random = new Random();
      Team team = new Team("London", "UK");
      int boundary = random.nextInt(3, 6); // Random amount of games added from 3 to 5 
      
      for (int i=0; i < boundary; i++)
      {
         team.addGame(random.nextInt(0, 9), random.nextBoolean());
      }
      
      assertEquals("The following method checks the getTotalGames() method when few games are added", boundary, team.getTotalGames());
   }
   
   @Test public void getTotalWinsTest1()
   {
      Team team = new Team("Spain_Madrid");
      assertEquals("The following test checks the getTotalWins() method when no games are added", 0, team.getTotalWins());
   }
   
   @Test public void getTotalWinsTest2()
   {
      Team team = new Team("Spain_Madrid");
      team.addGame(4, true);
      assertEquals("The following test checks the getTotalWins() method when one won game is added", 1, team.getTotalWins());
  
   }
   
   @Test public void getTotalWinsTest3()
   {
      Team team = new Team("Spain_Madrid");
      team.addGame(4, false);
      assertEquals("The following test checks the getTotalWins() method when one lost game is added", 0, team.getTotalWins());
   }
   
   @Test public void getTotalWinsTest4()
   {
      Team team = new Team("Spain_Madrid");
      team.addGame(4, true);
      team.addGame(2, false);
      assertEquals("The following test checks the getTotalWins() method when one won and one lost games are added", 1, team.getTotalWins());
   }
   
   @Test public void resetYearTest1()
   {
      Team team = new Team("Spain_Madrid");
      team.addGame(4, true);
      team.addGame(2, false);
      team.resetYear();
      assertEquals("The following method tests resetYear() method after two games were added with average of 3 points", 0.0, team.getAveragePoints(), 0.0);
   }
   
   @Test public void resetYearTest2()
   {
      Team team = new Team("Spain_Madrid");
      team.addGame(4, true);
      team.addGame(2, false);
      team.resetYear();
      assertEquals("The following method tests resetYear() method after two games were added", 0, team.getTotalGames());
   } 
   
   @Test public void resetYearTest3()
   {
      Team team = new Team("Spain_Madrid");
      team.addGame(4, true);
      team.addGame(2, false);
      team.resetYear();
      assertEquals("The following method tests resetYear() method after two games were added with total points of 6", 0, team.getTotalPoints());
   }
   
   @Test public void resetYearTest4()
   {
      Team team = new Team("Spain_Madrid");
      team.addGame(4, true);
      team.addGame(2, false);
      team.resetYear();
      assertEquals("The following method tests resetYear() method after two games were added with only one won", 0, team.getTotalWins());
   }
      
   @Test public void toStringTest()
   {
      Team team = new Team("Spain_Madrid");
      assertEquals("The following test tests toString() method", "SPAIN:MADRID", team.toString());
   }
   
   @Test public void equalsTest1()
   {
      Team team1 = new Team("Spain_Madrid");
      Team team2 = new Team("Spain", "Madrid");
      assertEquals("The following test tests equals() method when two identical teams are added", true, team1.equals(team2));
   }
   
   @Test public void equalsTest2()
   {
      Team team1 = new Team("Spain_Madrid");
      Team team2 = new Team("London", "UK");
      assertEquals("The following test tests equals() method when two different teams are added", false, team1.equals(team2));
   }
   
   @Test public void equalsTest3()
   {
      Team team1 = new Team("Spain_Madrid");
      Team team2 = new Team("Spain", "UK");
      assertEquals("The following test tests equals() method when two teams with same cities but different nicknames are added", false, team1.equals(team2));
   }
   
   @Test public void equalsTest4()
   {
      Team team1 = new Team("Spain_UK");
      Team team2 = new Team("London", "UK");
      assertEquals("The following test tests equals() method when two teams with different cities but same nicknames are created", false, team1.equals(team2));
   }
   
   @Test public void compareToTest1()
   {
      Team team1 = new Team("Spain_Madrid");
      Team team2 = new Team("Spain", "Madrid");
      assertEquals("The following test tests compareTo() method when two identical teams are compared", 0, team1.compareTo(team2));
   }
   
   @Test public void compareToTest2()
   {
      Team team1 = new Team("Almaty_Madrid");
      Team team2 = new Team("Bangladesh", "Madrid");
      assertEquals("The following test tests compareTo() method when two games with this.team City starting on preceding letter and other team with letter after this", -1, team1.compareTo(team2));
   }
   
   @Test public void compareToTest3()
   {
      Team team1 = new Team("Bangladesh_Madrid");
      Team team2 = new Team("Almaty", "Madrid");
      assertEquals("The following test tests compareTo() method when two games with this.team City starting on the letter after the letter of city of other team", 1, team1.compareTo(team2));
   }
   
   @Test public void compareToTest4()
   {
      Team team1 = new Team("Almaty_Badrid");
      Team team2 = new Team("Almaty", "Madrid");
      assertTrue("The following test tests compareTo() method when two games with same cities and this first letter in nickname comming before other", team1.compareTo(team2) < 0);
   }
   
   @Test public void compareToTest5()
   {
      Team team1 = new Team("Almaty_Madrid");
      Team team2 = new Team("Almaty", "Badrid");
      assertTrue("The following test tests compareTo() method when two games with same cities and this first letter in nickname coming after other", team1.compareTo(team2) > 0);
   }
}
