/**
4/18/2021
This class will model perscribed medications
@author Cameron Hoss
*/
public class Medication {
    /**
    Instance Variables
    */
    private String name;
    private double dose;
    private String doseUnit;
    private Date startDate;
    private Date endDate;
  
    /**
    Constructors
    */
    public Medication(String name, double dose, String doseUnit, Date startDate, Date endDate)
    {
      this.name = name;
      this.dose = dose;
      this.doseUnit = doseUnit;
      this.startDate = startDate;
      this.endDate = endDate;
    }
  
    /**
    Methods
    */
    public String getName()
    {
      return name;
    }
    public double getDose()
    {
      return dose;
    }
    public String getDoseUnit()
    {
      return doseUnit;
    }
    public Date getStartDate()
    {
      return startDate;
    }
    public Date getEndDate()
    {
      return endDate;
    }

  /**
   * doseOutput
   * Saves you from calling getDose and getDoseUnit back to back
   */
    public String doseOutput()
    {
      return dose + " " + doseUnit;
    }

    @Override
    public String toString(){
        return dose + doseUnit + " of "+ name + " from " + startDate.toString() + " to " + endDate.toString();
    }
}
