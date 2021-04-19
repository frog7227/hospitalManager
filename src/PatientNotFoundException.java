/**
 * @author Andrew Ostrosky
 */
public class PatientNotFoundException extends Exception {
    /**
     * @author Andrew Ostrosky
     */
    public PatientNotFoundException() {

        super("The patient could not be found in the database");
    }
}
