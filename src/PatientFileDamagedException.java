/**
 * @author Andrew Ostrosky
 */
public class PatientFileDamagedException extends Exception{

    public PatientFileDamagedException() {

        super("The patient file was damaged or incorrect.");
    }
}
