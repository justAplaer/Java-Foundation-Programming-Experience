public class StanfordLawyer extends Lawyer
{
    public StanfordLawyer(int years)
    {
         super(years);
    }
    public double getSalary()
    {
        return (super.getSalary())*1.2;
    }

    public String getVacationForm()
    {
        return super.getVacationForm() + super.getVacationForm() + super.getVacationForm() + super.getVacationForm();
    }

    public double getVacationDays()
    {
        return super.getVacationDays() + 3.0;
    }
}




