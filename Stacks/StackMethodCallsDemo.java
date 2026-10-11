// idea of pausing one task while another is handled 
// this idea maps naturally to stack behavior

public class StackMethodCallsDemo 
{
   public static void main (String [] args) 
   {
      phoneCall();
   }
   
   public static void phoneCall () 
   {
        System.out.println ("Talking to your friend...");
        doorbellRings();
        System.out.println ("Back to the phone call. Conversation continues.");
   }
   
   public static void doorbellRings () 
   {
        System.out.println ("Doorbell rings. You pause the call and go to the door.");
        signPackage(); // another interruption
        System.out.println ("Done at the door. Returning to the phone");   
   }
   
   public static void signPackage () 
   {
        System.out.println ("You sign for the package");  
   }

 }