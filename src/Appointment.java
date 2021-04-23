import java.io.Serializable;

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
    private String empty;
  
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
        return "++Appointment on " + date.getDate() +" at "+ date.getTime()  + ":\n       Ailment: " + aliment
                    +"\r\n";
    }
}
