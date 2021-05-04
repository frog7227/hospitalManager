package models;

import models.Appointment;
import models.Date;
import models.Insurance;
import models.Medication;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Patient.java:
 * This class models a patient in the PatientRegistry.
 * For every patient, they have:
 *  - Their name (String, full name is used to look up a patient from the file)
 *  - Gender (String)
 *  - Birthdate (date, MM/DD/YYYY)
 *  - Doctor's name (String)
 *  - Nurse's name (String)
 *  - Patient's Insurance (Insurance)
 *  - Patient's Appointments, past, present and future (ArrayList &#60;Appointment&#62;)
 *  - Patient's Medications (ArrayList &#60; Medication&#62; )
 *
 *  Setters and Getters for these variables are in this java file, along with a
 *  Print() method which prints all of the above variables.
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
     * Constructor for a Patient instance.  Takes in a name, gender and birthdate to create a new Patient.
     *
     * @param Name is the full name of the patient.
     * @param Gender is the gender of the patient.
     * @param Birthdate is the birthdate of the patient.
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
     * @return name
     */
    public String getName() {
        return this.Name;
    }

    /**
     * Sets the name of a patient (if they get their name changed).
     * @param Name of a patient
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Returns the gender of a Patient.
     * @return the gender of the patient
     */
    public String getGender() {
        return this.Gender;
    }

    /**
     * Sets a gender for a given patient.
     * @param Gender is the gender as a string
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * Returns the doctor's name of a given patient.
     * @return the doctor's name
     */
    public String getDoctor() {
        return this.Doctor;
    }

    /**
     * Sets Doctor's name of a given patient.
     * @param Doctor the doctor's names
     */
    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    /**
     *getNurse:
     * Returns the Nurse's name of a given patient.
     *
     * @return nurse
     */
    public String getNurse() {
        return this.Nurse;
    }

    /**
     * Sets the Nurse's name of a given patient.
     * @param Nurse is the nurse of the patient
     */
    public void setNurse(String Nurse) {
        this.Nurse = Nurse;
    }

    /**
     * Set the insurance information of a given patient.
     * @param Ins is the insurance for the patient
     */
    public void setInsurance(Insurance Ins)
    {
        this.PatIns = Ins;
    }

    /**
     *getInsurance:
     * Returns the insurance information of a given patient.
     *
     * @return insurance
     */
    public Insurance getInsurance()
    {
        return this.PatIns;
    }

    /**
     *Print:
     * This function prints out ALL of a given patient's information, with
     * formatting to make it look presentable.
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
     * @param NewApp is the new appointment to be added.
     */
    public void addAppointment(Appointment NewApp)
    {
        Apps.add(NewApp);
    }

    //returns ArrayList of appointments for a given patient
   public ArrayList<Appointment> getAppointments()

   {
       return Apps;
    }

    /**
     *addMedication:
     * Add a medication to the ArrayList of patient's medications.
     *
     * @param NewMed is the new medication to be added.
     */
    public void addMedication(Medication NewMed)
    {
        Meds.add(NewMed);
    }

    /**
     *
     * @return the ArrayList of patient's medications.
     */
    public ArrayList<Medication> getMedicationHistory()
    {
        return Meds;
    }
}
