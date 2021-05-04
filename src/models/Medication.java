package models;

import models.Date;

import java.io.Serializable;

/**
4/18/2021
This class will model perscribed medications
@author Cameron Hoss
*/
public class Medication implements Serializable {
    /**
    Instance Variables
    */
    private String name;
    private double dose;
    private String doseUnit;
    private Date startDate;
    private Date endDate;

    /**
     * Constructor for Medication that takes in all the necessary instance variables.
     *
     * @param name name of medication
     * @param dose dose of medication
     * @param doseUnit unit of dose
     * @param startDate date of medication start
     * @param endDate date of medication end
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
     * getName:
     * Returns the name of the medication.
     *
     * @return name of medication
     */
    public String getName()
    {
      return name;
    }

    /**
     * getDose:
     * Returns the dose of the medication.
     *
     * @return dose of medication
     */
    public double getDose()
    {
      return dose;
    }

    /**
     * getDoseUnit:
     * Returns the dose unit of the medication.
     *
     * @return dose unit of the medication
     */
    public String getDoseUnit()
    {
      return doseUnit;
    }

    /**
     * getStartDate:
     * Returns the date the medication should begin.
     *
     * @return date the medication should begin
     */
    public Date getStartDate()
    {
      return startDate;
    }

    /**
     * getEndDate:
     * Returns the date the medication should end.
     *
     * @return date the medication should end
     */
    public Date getEndDate()
    {
      return endDate;
    }

  /**
   * doseOutput
   * Saves you from calling getDose and getDoseUnit back to back
   *
   * @return "dose" and "doseUnit"
   */
    public String doseOutput()
    {
      return dose + " " + doseUnit;
    }

    @Override
    public String toString(){
        return "++"+dose + doseUnit + " of "+ name + " from " + startDate.getDate() + " to " + endDate.getDate()
                    +"\r\n";
    }
}
