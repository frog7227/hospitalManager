import java.io.IOException;

/**
 * This interface allows for opening a connection to the Database, in this case the file
 *
 * @author Andrew Ostrosky
 */
public interface Database {
    Patient openPatient(String name) throws PatientNotFoundException, PatientFileDamagedException;

    void savePatient(Patient patient) throws PatientUnableToBeSavedException;
}
