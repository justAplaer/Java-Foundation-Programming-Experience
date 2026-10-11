import java.util.*;

/**
* @author Tair Moldakhmetov
* @version 4.0
* StudentRecords class processes corresponding student's name and their grades one at a time
* The class implements Comparable, which makes it the class sortable in natural ordering
* In addition, it returns name variable, average grade and both of the mentioned value as 
* a String list by using corresponding methods
*/
public class StudentRecords implements Comparable<StudentRecords>
{
   private String name = "";
   private List<Integer> grades = new ArrayList<Integer>();
   
/**
* @param String name - takes in a provided string name of a student to assign it to private name variable
* @param List<Integer> grades - takes in an ArrayList of integer that represent correposponding student's grades
* The following method is a simple contructor that sets up StudentRecords as a class properly 
*/
   public StudentRecords(String name, List<Integer> grades)
   {
      this.name = name;
      this.grades = new ArrayList<Integer>(grades);
   }
   
/**
* @param String data - takes in a String which contains both the name and the grades of a corresponding student
* @throws IllegalArguementException("Student must have a name") in case provided String lacks the actual name
* The following method cleverly handles a signle String with information on student by using a scanner and text as "input"
* Since in the provided program all data is structured like Name->grades, program properly reads of the name in the string
* Even if order is flipped, program could still handle this unles extreme conditions like doubles inside the String are found
*/
   public StudentRecords(String data)
   {
      Scanner console = new Scanner(data);
      while (console.hasNext())
      {
         if (console.hasNextInt())
         {
            this.grades.add(console.nextInt());
         }
         
         else
         {
            name += console.next();
            
            // if statement below is pretty important so that the name has a nice format
            // For example, Tair m 5 6 7 2 will create a name "Tair M", not "Tair M " if
            // name+=" " was performed all the time
          
            if (!console.hasNextInt())
            {
               name+=" ";
            }
/* 
Note: you can use trim method, which is an in-build java method that removes the empty spaces, here is the example:
String name = "  Nott the Brave  ";
name = name.trim();

// "Nott the Brave"
So this would cut of the need for that if statement, but for history let's leave it there 
*/        
         }
      }
      
      // That is a really important check so that in case a null String is inputted 
      // so no potential bugs occur since name would also be null in case null string is inputted
      if (name.length() == 0)
      {
         throw new IllegalArgumentException("Student must have a name");
      }
   }
   
/**
* @return average - return an average grade based on the corresponding student's grades
* The following method interestingly applies Math.round() method to yield desired 1
* decimal place approximation without overcomplicating program too much
*/
   public double getAverage()
   {
      double average = 0.0;   
         
      for (int i=0; i < grades.size(); i++)
      {
         average += grades.get(i);
      }
      
      // Math.round() round a value to the nearest non-decimal place(whole number). Meaning 1.0009 is 1, 1.999 is 2 and so on so for
      // Simply doing math.round would leave dno decimal place at all so 11.5 would turn into 12 - we do not want that
      // Now suppose we first multiplied our result inside the Math.round by 10 = then it would work with 115 and notably
      // This number is already rounded to the nearest whole number - 5
      // Since we scaled our initial average by 10.0, we then divide by 10.0, but outside the parenthesis so that the operation
      // is meaningful - otherwise we would first scale it to 115, then back to 11.5 and get 12, but we need 11.5
      // Interestingly, multiplying by 1000.0 on the inside and dividing by 1000.0 on the outside leaves 4 decimal places
      // So 10^n power preserves n decimal places, when n=0, it is essnetiallt scaling and dividing by 1 which does not really
      // effect anything, so zero decimal places are preserved
      
      return Math.round(average/grades.size()*10.0)/10.0;
   }
   
/**
* @return name - return the name of the student which was initiated in constructor
*/
   public String getName()
   {
      return name;
   }
   
/**
* @return list - return a String ArrayList with a name and associated average grade
*/
public List<String> getBothValues()
   {
      List<String> list = new ArrayList<String>();
      
      // This is one of my favourites tricks to do when I need to turn something into string
      // Writing String word = ""; allow to return the word without assigning anything to it and allows to do
      //"" + int. Because formaly "" is "something", but really it does not add much, it is possible to add
      // int or double value to such string and, if performed correctly, new variable or print will "make" int a String  
      String trick = "" + this.getAverage();
      System.out.println(trick);
      
      list.add(name); list.add(trick); // Add both values in a fancy way
      return list;
   }
   
/**
* @return this.name.compareTo(other.getName()) - return the value based on ascending sorting
* the following method overrides the compareTo method, which allows StudentRecords class to
* implement Comparable interface and be able to be compared to itself, which makes it sortable 
*/
   public int compareTo(StudentRecords other)
   {
      // At first I wanted to write if else statements and compare first characters of names
      // But then I realized that it is sufficient just to return the result, which is also
      // in as java dictates, of compartison between this.name and name other
      return this.name.compareTo(other.getName());
   }
}