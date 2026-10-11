public class Lawyer extends SaulGoodman
{
   public Lawyer(int years)
   {
      super(years);
   }
   
   public double getSalary()
   {
      return 50000 + 2000 * getYears();
   }
   
   public double getHours()
   { 
      return 75; 
   }
   
   public String getVacationForm()
   {
      return "GREEEn";
   }
}
