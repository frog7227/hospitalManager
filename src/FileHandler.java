import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;// used for the object saver

public class FileHandler implements Database  {
    private final String Extension = ".patient";// the file extension used to save the patient
    /**
     * default constructor
     */
    public FileHandler(){

    }
/*
        the file name is in this format
        Name.patient
        it exists in the patients folder
        e.g. Name is "Michael Jackson" the file name is MICHAELJACKSON.patient
         */

    /**
     * Opens a patient file from the local storage
     * @param name the name of the patient like "first last"; spacing and capitalization doesn't matter
     * @return the patient object
     * @throws PatientNotFoundException if the patient could not be found on the disk
     */
    @Override
    public Patient openPatient(String name) throws PatientNotFoundException,PatientFileDamagedException {
        Patient patient;
        try {
            FileInputStream fileReader = new FileInputStream(("../patients/" + name.replaceAll(" ", "").toUpperCase() + Extension)); // open the file to read the patient
            ObjectInputStream patientReader = new ObjectInputStream(fileReader);// open the object reader
            patient = (Patient)  patientReader.readObject();// read the object and interpret it as a patient
            if(!patient.getName().equals(name)) throw new PatientFileDamagedException();
        }catch (IOException | ClassNotFoundException exception){//catch the IO errors

            throw new PatientNotFoundException();// throw the exception to the caller informing them that the patient doesn't exist
        }

        return patient;// return the patient object, it must be casted as the readObject method can return any object
    }

    /**
     * saves a patient file to the local storage
     * @param patient is the patient to be saved to the disk
     * @throws IOException when the the file cannot be saved
     */
    @Override
    public void savePatient(Patient patient) throws IOException {

            FileOutputStream fileWriter = new FileOutputStream(("../patients/" + patient.getName().replaceAll(" ","").toUpperCase() + Extension)); // open the file to save the patient
            ObjectOutputStream patientWriter = new ObjectOutputStream(fileWriter); // make the object writer
            patientWriter.writeObject(patient);// write the object to the file

            patientWriter.close();// close the streams
            fileWriter.close();

    }
}