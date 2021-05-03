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
    private String aliment;
    private Date followUp;
  
    /**
    Constructors
    */
    public Appointment(Date date, String aliment)
    {
      this.date = date;
      this.aliment = aliment;
    }
  
    /**
    Methods
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
                    return "++Appointment on " + date.getDate() +" at "+ date.getTime()  + ":\n       Ailment: " + aliment
                            +"\r\n";
                }else return "++Appointment on " + date.getDate() +" at "+ date.getTime() + ", following up from the appointment on " + followUp.toString() + ":\n       Ailment: " + aliment
                        + "\r\n";

    }

    public Date getDate() {
        return date;
    }
}
