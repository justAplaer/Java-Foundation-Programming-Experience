public class VirtualPet
{
   // Creating private variables
   private String name;
   private int cleanliness; //This is my "unique contribute", which makes the game more fun since now it is possible to actually loose happiness
   private int energy;
   private int hunger;
   private int count = 1;   //I have decided to create variable "count" so that the action history is more readible for user
   private int happiness;
   private String actionHistory = "History of your pet:\n";
   
   // Constructor of a pet
   public VirtualPet(String userName)
   {
      this.name = userName;
      this.energy = 50;
      this.hunger = 50; 
      this.happiness = 50;
      this.cleanliness = 50;
      this.actionHistory += (count + "." + name + " was born!\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n");
      count++;
   }
   
   // I have decided that it would be more fun to add unique commentaries for each situation a pet can be at, so I did that
   // In addition, I print what just happened to the pet, that way the output is more straightforward
   public void feed()
   {
      if (cleanliness <= 20)
      {
         System.out.println(name + " is too dirty to eat! You wanna bath it for sure.\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to feed " + name + ", but it was too dirty.\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else
      {
         this.hunger = Math.max(0, this.hunger - 20);
         this.energy = Math.min(100, this.energy + 10);
         this.cleanliness = Math.max(0, this.cleanliness - 10);
         this.actionHistory += (count + "." + name + " got fed!\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n");
         System.out.println(name + " got fed!\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         count++;
      }
   }
   
   public void play()
   {
      if (this.hunger >= 80 && this.energy <= 20)
      {
         System.out.println("My gosh! Poor animal! Let it sleep!\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to play with " + name + ", but it was too hungry and exhausted!\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else if (this.hunger >= 80)
      {
         System.out.println(name + " is too hungry to play! You wanna either feed it or let it sleep.\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to play with " + name + ", but it was too hungry to play.\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else if (this.energy <= 20)
      {
         System.out.println(name + " is too exhausted to play! You wanna feed it or let it sleep.\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to play with " + name + ", but it was too exhauted to play.\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else if (cleanliness <= 20)
      {
         System.out.println(name + " is already too dirty to play! You wanna bath it for sure.\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to play with " + name + ", but it was too dirty.\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else
      {
         this.happiness = Math.min(100, this.happiness + 20);
         this.energy = Math.max(0, this.energy - 15);
         this.hunger = Math.min(100, this.hunger + 10);
         this.cleanliness = Math.max(0, this.cleanliness - 20);
         this.actionHistory += (count + "." + name + " received a play setion!\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         System.out.println(name + " received a play setion!\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         count++;
      }
   }
   
   public void nap()
   {
      this.energy = Math.min(100, this.energy + 30);
      this.hunger = Math.max(0, this.hunger - 10);
      if (this.cleanliness <= 20)
      {
         this.actionHistory += (count + "." + name + " took a messy nap with you cleaning the bed after it!\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n");
         System.out.println(name + " took a nap... and made the bed really dirty\nYou better start cleaning until the dirt hardens!\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
      }
      else
      {
         this.actionHistory += (count + "." + name + " took a nap!\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n");
         System.out.println(name + " took nap!\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");      
      }
      count++;
   }
   
   // This one is a unique mutator. As I mentioned, it deduce the happiness parameter
   // In addition, property "clenliness" overall makes interactions with other mutatore more fun
   // Overall, it intercts with other variables as well, which make the programm more unique and interesting in interaction
   public void bath()
   {
      if (this.hunger >= 80 && this.energy <= 20)
      {
         System.out.println("My gosh! Poor animal! Let it sleep!\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to bath " + name + ", but it was too hungry and exhausted!\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++; //Addint value to the count so that he history outputs properly
      }
      else if (this.hunger >= 80)
      {
         System.out.println(name + " is too hungry to be bathed! You wanna either feed it or let it sleep.\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to bath " + name + ", but it was too hungry.\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else if (this.energy <= 20)
      {
         System.out.println(name + " is too exhausted to be bathed! You wanna feed it or let it sleep.\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to bath " + name + ", but it was too exhauted.\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else if (this.happiness <= 20)
      {
         System.out.println(name + " is too sad to be bathed! You wanna play with it.\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
         this.actionHistory += (count + ". You tried to bath " + name + ", but it was too sad.\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
         count++;
      }
      else
      {
        // Interaction with variables
        this.cleanliness = 100;
        this.energy = Math.max(0, this.energy - 20);
        this.happiness = Math.max(0, this.happiness - 40);
        this.hunger = Math.min(100, this.hunger + 25);
        // Outputting the print and updating the history
        System.out.println("You bathed " + name + "... I don't think it liked that...\nHunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n");
        this.actionHistory += (count + ". You bathed " + name + "... I don't think it was happy about it...\n  Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + ", Cleanliness: " + cleanliness + "\n\n" );
        count++; 
      }
      
   }
   
   public boolean isHappy()
   {  
      if (happiness >= 70)
      {
         System.out.println(name + " is happy!");
         return true;
      }
      else
      {
         System.out.println(name + " is sad :(\nYou better play with it more!");
         return false;
      }  
   }
   
   public String toString()
   {
      return "Hunger: " + hunger + ", Energy: " + energy + ", Happiness: " + happiness + "\n";
   }
   
   // I needed this particular accessor to return name in one of my if statements in a while loop
   public String getName()
   {
      return this.name;
   } 
   
   public String getHistory()
   {
      return actionHistory;
   }
}