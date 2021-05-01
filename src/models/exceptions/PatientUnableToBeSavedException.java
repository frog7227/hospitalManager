package models.exceptions;

/**
 * @author Andrew Ostrosky
 */
public class PatientUnableToBeSavedException extends Exception {
    public PatientUnableToBeSavedException() {
        super("The models.Patient couldn't be saved to the models.Database.");
    }
}
