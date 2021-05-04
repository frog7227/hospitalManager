package models.exceptions;

/**
 * Thrown when a patient name is not the same as the loaded file or it is damaged
 * @author Andrew Ostrosky
 */
public class PatientFileDamagedException extends Exception {

    public PatientFileDamagedException() {

        super("The patient file was damaged or incorrect.");
    }
}
