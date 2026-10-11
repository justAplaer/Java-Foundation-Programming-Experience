import java.util.*;
import java.io.*;

public class Password_Data_File_Scanner_PrintStream
{ //Make a logic that would interact with the user so that any amount of usernames and Passwords can be inputted
  public static void main(String[] args)
  throws FileNotFoundException
  {
     Scanner input = new Scanner(System.in);
     PrintStream outPass =  new PrintStream("PasswordsData.txt");
     System.out.println("Please entere your username");
     String username = input.next();
     System.out.println("Please enter your Password");
     String password = input.next();
     String hiddenPass = "";
     for (int i = 0; i<=password.length()-1; i++)
     {
         hiddenPass += (password.charAt(i) + "!");
     }
      outPass.println("Username: " + username + ", Password: " + hiddenPass);
     }
}