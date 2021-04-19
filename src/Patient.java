import java.io.Serializable;
import java.util.ArrayList;

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

    //methods, will put java docs here later
    public Patient(String Name, String Gender, Date Birthdate) {
        this.Name = Name;
        this.Gender = Gender;
        this.Birthdate = Birthdate;
        this.Apps = new ArrayList<Appointment>();
        this.Meds = new ArrayList<Medication>();
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDoctor() {
        return this.Doctor;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    public String getNurse() {
        return this.Nurse;
    }

    public void setNurse(String Nurse) {
        this.Nurse = Nurse;
    }

    public void setInsurance(Insurance Ins)
    {
        this.PatIns = Ins;
    }

    public Insurance getInsurance()
    {
        return this.PatIns;
    }

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
        System.out.println("Appointments for patient: ");
        System.out.println(Apps.toString().replace("[","").replace("]","").trim()
                .replace(",", ""));
        System.out.println("===================================");
        System.out.println("Medications: ");
        System.out.println(Meds.toString().replace("[","").replace("]","").trim()
                .replace(",", ""));
        System.out.println("===========End of Patient==========");
    }

    public void addAppointment(Appointment NewApp)
    {
        Apps.add(NewApp);
    }

//    public Appointment getAppoinment(Date AppDate)
//    {
//        //return AN appoinment attatched to AppDate
//    }

    public void addMedication(Medication NewMed)
    {
        Meds.add(NewMed);
    }

    public ArrayList<Medication> getMedicationHistory()
    {
        return Meds;
    }
}
