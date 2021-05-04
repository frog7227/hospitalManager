package models;
import java.io.Serializable;
import java.util.Objects;

/**
  4/18/2021
  This class models appointments
  @author Cameron Hoss
*/
public class Appointment implements Serializable {
    /**
    Instance Variables
    */
    private Date date;
    private String ailment;
    private Date followUp;

    /**
     * Constructor for a Appointment. Takes in date and ailment to initialize
     *
     * @param date is the date for the appointment
     * @param ailment is the reason for coming in
     */
    public Appointment(Date date, String ailment)
    {
      this.date = date;
      this.ailment = ailment;
    }

    /**
     * setFollowUp
     * Sets followUp with another previous appointment's date
     *
     * @param followUp this variable is the date of the previous appointment
     */
    public void setFollowUp(Date followUp)
    {
      this.followUp = followUp;
    }

    /**
     * toString to output class info
     */
    @Override
    public String toString() {
                if(Objects.isNull(followUp)){
                    return "++Appointment on " + date.getDate() +" at "+ date.getTime()  + ":\n       Ailment: " + ailment
                            +"\r\n";
                }else return "++Appointment on " + date.getDate() +" at "+ date.getTime() + ", following up from the appointment on " + followUp.toString() + ":\n       Ailment: " + ailment
                        + "\r\n";

    }

    public Date getDate() {
        return date;
    }
}
