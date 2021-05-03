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
     * @param name
     * @param dose
     * @param doseUnit
     * @param startDate
     * @param endDate
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
     * @return name
     */
    public String getName()
    {
      return name;
    }

    /**
     * getDose:
     * Returns the dose of the medication.
     *
     * @return dose
     */
    public double getDose()
    {
      return dose;
    }

    /**
     * getDoseUnit:
     * Returns the dose unit of the medication.
     *
     * @return doseUnit
     */
    public String getDoseUnit()
    {
      return doseUnit;
    }

    /**
     * getStartDate:
     * Returns the date the medication should begin.
     *
     * @return startDate
     */
    public Date getStartDate()
    {
      return startDate;
    }

    /**
     * getEndDate:
     * Returns the date the medication should end.
     *
     * @return endDate
     */
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
        return "++"+dose + doseUnit + " of "+ name + " from " + startDate.getDate() + " to " + endDate.getDate()
                    +"\r\n";
    }
}
