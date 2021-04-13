

public class PatientNotFoundException extends Exception {

    public PatientNotFoundException() {
        super("The patient could not be found in the database");
    }
}
