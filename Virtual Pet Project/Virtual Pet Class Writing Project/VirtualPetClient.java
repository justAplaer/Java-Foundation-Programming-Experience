// Tair Moldakhmetov, Student, CS122, Spring 2026
// Virtual Pet Project, 04/16/26
// This program uses blueprint to create and interesting set of interations with a vitrual pet


import java.util.*;

public class VirtualPetClient
{
   public static void main(String[] args)
   {
      // Since I added new interactions in the VirtualPet, the output of these commands became a bit different for the good
      VirtualPet pet = new VirtualPet("Lina"); // Lina was my dog when I was a kid. Unfortinately she died long ago, but not in my memories
      pet.feed();                              // As well as Lina still lives in my memory, childsih me also found a plave in my brain
      pet.play(); 
      pet.play();
      pet.play();
      pet.nap();
      System.out.println(pet.isHappy());
      System.out.println(pet.getHistory());
      
      // When I undesrstood this project's purpose, I imidiately came up with an idea to make a while loop and let user decide what to do with the pet
      // In my opinion, it is pretty fun to look at the interaction with pet
      String userChoice = "";
      System.out.println("Welcome to Pet Play! In this game, you can interact with your own pet!");
      System.out.println("But first, let's give a name to your pet: how do you want it to be called?");
      Scanner console = new Scanner(System.in);
      userChoice = console.next();
      System.out.println(userChoice + ", huh... Great! Now we can get started!");
      VirtualPet userPet = new VirtualPet(userChoice);
      System.out.println("To this game, there are several gimmicks");
      System.out.println("Enter 'Feed' to feed your pet\nEnter 'Play' to play with your pet\nEnter 'Nap' to give your pet some sleep\nEnter 'Bath' to bath your pet");
      System.out.println("Enter 'Stats' to check your pet's current status\nEnter 'Happy Check' to check if your pet is happy\nEnter 'Get History' to see history of your interaction with pet");
      System.out.println("Enter 'Menu' to access game's commands\nEnter 'STOP' to quit the game");
      while (!userChoice.equals("STOP"))
      {
         System.out.println("What do you wanna do now?");
         userChoice = console.next();
         if (userChoice.equals("Feed"))
         {
            userPet.feed();
         }
         else if (userChoice.equals("Play"))
         {
            userPet.play();
         }
         else if (userChoice.equals("Nap"))
         {
            userPet.nap();
         }
         else if (userChoice.equals("Bath"))
         {
            userPet.bath();
         }
         else if (userChoice.equals("Stats"))
         {
            System.out.println(userPet.toString());
         }
         else if (userChoice.equals("HappyCheck"))
         {
            userPet.isHappy();
         }
         else if (userChoice.equals("GetHistory"))
         {
            System.out.println(userPet.getHistory());
         }
         else if (userChoice.equals("Menu"))
         {
            System.out.println("Enter 'Feed' to feed your pet\nEnter 'Play' to play with your pet\nEnter 'Nap' to give your pet some sleep\nEnter 'Bath' to bath your pet");
            System.out.println("Enter 'Stats' to check your pet's current status\nEnter 'HappyCheck' to check if your pet is happy\nEnter 'GetHistory' to see history of your interaction with pet");
            System.out.println("Enter 'Menu' to access game's commands\nEnter 'STOP' to quit the game");
         }
         else if (userChoice.equals("STOP"))
         {
            System.out.println(userPet.getName() + " is sad to see you go :(\nMake sure to come back later and thank you for playing!");
         }
         else
         {
            System.out.println("ERROR. No such command. Please try again");
         }
      }
   }
}