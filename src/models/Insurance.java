package models;

import java.io.Serializable;

/**
 * 4/18/2021
 * This class will model our patient's insurance
 *
 * @author Cameron Hoss
 */
public class Insurance implements Serializable {

    private String cardHolder;
    private String id;
    private String groupNum;



    /**
     *
     * @param cardHolder is the card holder's name
     * @param id is the member id
     * @param groupNum is the group number
     */
    public Insurance(String cardHolder, String id, String groupNum) {
        this.cardHolder = cardHolder;
        this.id = id;
        this.groupNum = groupNum;
    }



    /**
     *
     * @return the card holder's name
     */
    public String getCardHolder() {
        return cardHolder;
    }
    /**
     *
     * @return the Member ID
     */
    public String getID() {
        return id;
    }
    /**
     *
     * @return the Group Number
     */
    public String getGroupNum() {
        return groupNum;
    }

    /**
     *
     * newInsurance
     * This method takes in parameters to overwrite the current instance variables
     *
     * @param cardHolder is the card holder's name
     * @param id is the member id
     * @param groupNum is the group number
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
