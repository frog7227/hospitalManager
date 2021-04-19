import java.io.Serializable;

/**
 * 4/18/2021
 * This class will model our patient's insurance
 *
 * @author Cameron Hoss
 */
public class Insurance implements Serializable {
    /*
    Instance Variables
    */
    private String cardHolder;
    private String id;
    private String groupNum;

    /*
    Constructors
    */
    public Insurance(String cardHolder, String id, String groupNum) {
        this.cardHolder = cardHolder;
        this.id = id;
        this.groupNum = groupNum;
    }

    /*
    Methods
    */
    public String getCardHolder() {
        return cardHolder;
    }

    public String getID() {
        return id;
    }

    public String getGroupNum() {
        return groupNum;
    }

    /**
     * newInsurance
     * This method takes in parameters to overwrite the current instance variables
     */
    public void newInsurance(String cardHolder, String id, String groupNum) {
        this.cardHolder = cardHolder;
        this.id = id;
        this.groupNum = groupNum;
    }
    @Override
    public String toString() {
        return "Insurance Info: \n       Name: " + cardHolder + "\n  ID Number: " + id + "\n   Group ID: " + groupNum;
    }
}
