public class Employee 
{
   private String name;
   private int yearsWorked;
   
   public Employee(String name, int yearsWorked)
   {
      this.name = name;
      this.yearsWorked = yearsWorked;
   }
   public double getHours() 
   {
      return 40;
   }
   
   public boolean equals(Employee other)
   {
      return this.name.equalsIgnoreCase(other.name) && this.yearsWorked == other.yearsWorked;
   }
   
   public double getSalary()
   {
      return 40000;
   }
 
   public String getJob () 
   {
      return name + " and I work here.";
   }
   
   public double getVacationDays()
   {
      return 20;
   }
   
   public double getYearsWorked()
   {
      return yearsWorked;
   }
   
   public String getName()
   {
      return name;
   }
}
   
