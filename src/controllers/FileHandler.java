package controllers;// imports

import models.*;

import java.io.*;

/**
 * @author Andrew Ostrosky
 */
public class FileHandler implements Database {
    private final String Extension = ".patient";// the file extension used to save the patient

    /**
     * default constructor
     */
    public FileHandler() {// no actual constructor is needed

    }
/*
        the file name is in this format
        Name.patient
        it exists in the patients folder
        e.g. Name is "Michael Jackson" the file name is MICHAELJACKSON.patient
         */

    /**
     * Opens a patient file from the local storage
     *
     * @param name the name of the patient like "first last"; spacing and capitalization doesn't matter
     * @return the patient object
     * @throws PatientNotFoundException if the patient could not be found on the disk
     * @throws PatientFileDamagedException if the patient name does not match the one loaded from the disk indicating tampering or corruption of the data.
     */
    @Override
    public Patient openPatient(String name) throws PatientNotFoundException, PatientFileDamagedException {
        Patient patient;
        try {
            FileInputStream fileReader = new FileInputStream(("./patients/" + name.replaceAll(" ", "").toUpperCase() + Extension)); // open the file to read the patient
            ObjectInputStream patientReader = new ObjectInputStream(fileReader);// open the object reader
            patient = (Patient) patientReader.readObject();// read the object and interpret it as a patient
            if (!patient.getName().equals(name))
                throw new PatientFileDamagedException(); // if the name in the opened file doesn't match the original name request, throw the damaged file exception
        } catch (IOException | ClassNotFoundException exception) {//catch the IO errors
            throw new PatientNotFoundException();// throw the exception to the caller informing them that the patient doesn't exist
        }

        return patient;// return the patient object, it must be casted as the readObject method can return any object
    }

    /**
     * saves a patient file to the local storage
     *
     * @param patient is the patient to be saved to the disk
     * @throws PatientUnableToBeSavedException when the the patient file cannot be saved for whatever Reason
     */
    @Override
    public void savePatient(Patient patient) throws PatientUnableToBeSavedException {
        try {
            FileOutputStream fileWriter = new FileOutputStream(("./patients/" + patient.getName().replaceAll(" ", "").toUpperCase() + Extension)); // open the file to save the patient
            ObjectOutputStream patientWriter = new ObjectOutputStream(fileWriter); // make the object writer
            patientWriter.writeObject(patient);// write the object to the file

            patientWriter.close();// close the streams
            fileWriter.close();
        } catch (IOException e) {
            throw new PatientUnableToBeSavedException();// if an IOException occurs throw the unable to save exception
        }

    }
}