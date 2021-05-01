package models;

import models.exceptions.PatientFileDamagedException;
import models.exceptions.PatientNotFoundException;
import models.exceptions.PatientUnableToBeSavedException;

/**
 * This interface allows for opening a connection to the models.Database, in this case the file
 *
 * @author Andrew Ostrosky
 */
public interface Database {
    Patient openPatient(String name) throws PatientNotFoundException, PatientFileDamagedException;

    void savePatient(Patient patient) throws PatientUnableToBeSavedException;
}
