/**
 * @author Andrew Ostrosky
 */
public class PatientUnableToBeSavedException extends Exception {
    public PatientUnableToBeSavedException() {
        super("The Patient couldn't be saved to the Database.");
    }
}
