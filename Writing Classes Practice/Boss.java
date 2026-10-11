class Boss extends Employee 
{
   public Boss(String newName, int yearsWorked)
   {
      super(newName, yearsWorked);
   }
   public String getJob () 
   {
      return name + " and I am the Boss!";
   }
   
   public double getVacationDays()
   {
      return super.getVacationDays()*2;
   }
}
