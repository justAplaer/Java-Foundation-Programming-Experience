public class InheritanceClient
{
   public static void main(String[] agrs)
   {
      Employee fred = new Employee("Fred", 5);
      
      Boss nick = new Boss("Nick", 10);
      //Custodian dan = new Custodian();    
      SaulGoodman saul = new SaulGoodman(10);
      Lawyer marty = new Lawyer(2);
      StanfordLawyer daniel = new StanfordLawyer(5);
      
      System.out.println(saul.getYears());
      System.out.println(marty.getYears());
      System.out.println(daniel.getVacationForm());
      
    
      
   }
}