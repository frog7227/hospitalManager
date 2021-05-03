package models;

import models.Appointment;
import models.Date;
import models.Insurance;
import models.Medication;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * models.Patient.java:
 * This class models a patient in the controllers.PatientRegistry.
 * For every patient, they have:
 *  - Their name (String, full name is used to look up a patient from JSON file)
 *  - Gender (String)
 *  - Birthdate (date, MM/DD/YYYY)
 *  - Doctor's name (String)
 *  - Nurse's name (String)
 *  - models.Patient's models.Insurance (models.Insurance)
 *  - models.Patient's Appointments, past, present and future (ArrayList<models.Appointment>)
 *  - models.Patient's Medications (ArrayList<models.Medication>)
 *
 *  Setters and Getters for these variables are in this java file, along with a
 *  models.Patient.Print() method which prints all of the above variables.
 *
 * @author Alexander Croll
 */

public class Patient implements Serializable {
    //-----------instance variables-----------
    //These variables are used to instantiate a new patient
    private String Name;
    private String Gender;
    private Date Birthdate;
    //----------------------------------------
    private String Doctor;
    private String Nurse;
    private Insurance PatIns;
    private ArrayList<Appointment> Apps;
    private ArrayList<Medication> Meds;
    //-----------------------------------------

    /**
     * Constructor for a models.Patient instance.  Takes in a name, gender and birthdate to create
     * a new models.Patient.
     *
     * @param Name
     * @param Gender
     * @param Birthdate
     */
    public Patient(String Name, String Gender, Date Birthdate) {
        this.Name = Name;
        this.Gender = Gender;
        this.Birthdate = Birthdate;
        this.Apps = new ArrayList<Appointment>();
        this.Meds = new ArrayList<Medication>();
    }

    /**
     * getName:
     * Returns the name of a patient.
     *
     * @return models.Patient.name
     */
    public String getName() {
        return this.Name;
    }

    /**
     *setName:
     * Sets the name of a patient (if they get their name changed).
     *
     * @return void
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *getGender:
     * Returns the gender of a models.Patient.
     *
     * @return models.Patient.gender
     */
    public String getGender() {
        return this.Gender;
    }

    /**
     *setGender:
     * Sets a gender for a given patient.
     *
     * @return void
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * getDoctor:
     * Returns the doctor's name of a given patient.
     *
     * @return models.Patient.doctor
     */
    public String getDoctor() {
        return this.Doctor;
    }

    /**
     *setDoctor:
     * Sets Doctor's name of a given patient.
     *
     * @return void
     */
    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    /**
     *getNurse:
     * Returns the Nurse's name of a given patient.
     *
     * @return models.Patient.nurse
     */
    public String getNurse() {
        return this.Nurse;
    }

    /**
     *setNurse:
     * Set's the nurse's name for a given patient.
     *
     * @return void
     */
    public void setNurse(String Nurse) {
        this.Nurse = Nurse;
    }

    /**
     *setInsurance:
     * Set the insurance information of a given patient.
     *
     * @return void
     */
    public void setInsurance(Insurance Ins)
    {
        this.PatIns = Ins;
    }

    /**
     *getInsurance:
     * Returns the insurance information of a given patient.
     *
     * @return models.Patient.insurance
     */
    public Insurance getInsurance()
    {
        return this.PatIns;
    }

    /**
     *Print:
     * This function prints out ALL of a given patient's information, with
     * formatting to make it look presentable.
     *
     * @return void
     */
    //NEW USEFUL FUNCTION
    public void Print()
    {
        System.out.println("::::::::PATIENT INFORMATION::::::::");
        System.out.println("       Name: " + Name);
        System.out.println("     Gender: " + Gender);
        System.out.println("  Birthdate: "+ Birthdate.getDate());
        System.out.println("     Doctor: " + Doctor);
        System.out.println("      Nurse: " + Nurse);
        System.out.println("===================================");
        System.out.println(PatIns.toString());
        System.out.println("===================================");
        System.out.println("Medications: ");
        if(Meds.isEmpty())
        {
            System.out.println("::No Medications for this patient in system::");
        }
        else
        {
            System.out.println(Meds.toString().replace("[","").replace("]","").trim()
                    .replace(",", ""));
        }
        System.out.println("===================================");
        System.out.println("Appointments for patient: ");
        if(Apps.isEmpty())
        {
            System.out.println("::No Appointments for this patient in system::");
        }
        else
        {
            System.out.println(Apps.toString().replace("[","").replace("]","").trim()
                    .replace(",", ""));
        }
        System.out.println("===========End of Patient==========");
        System.out.println("\n");
    }

    /**
     *addAppointment:
     * Add an appointment to the ArrayList of appointments for a given patient.
     *
     * @param NewApp
     * @return void
     */
    public void addAppointment(Appointment NewApp)
    {
        Apps.add(NewApp);
    }

    //Will we need this?
//    public models.Appointment getAppoinment(models.Date AppDate)
//    {
//        //return AN appoinment attatched to AppDate
//    }

    /**
     *addMedication:
     * Add a medication to the ArrayList of patient's medications.
     *
     * @param NewMed
     * @return void
     */
    public void addMedication(Medication NewMed)
    {
        Meds.add(NewMed);
    }

    /**
     *getMedicationHistory:
     * Returns the ArrayList of patient's medications.
     *
     * @return ArrayList<models.Medication> Meds
     */
    public ArrayList<Medication> getMedicationHistory()
    {
        return Meds;
    }
}
