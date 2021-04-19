public class Patient {
    //-----------instance variables-----------
    //These variables are used to instantiate a new patient
    private String Name;
    private String Gender;
    //private Date Birthdate;
    //----------------------------------------
    private String Doctor;
    private String Nurse;
//    private Insurance PatIns;
//    private ArrayList<Appointment> Apps;
//    private ArrayList<Medication> Meds;
    //-----------------------------------------

    //methods, will put java docs here later
    public Patient(String Name, String Gender) {
        this.Name = Name;
        this.Gender = Gender;
        // this.Birthdate = Birthdate;
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
//
//    public void setInsurance(Insurance Ins)
//    {
//        this.PatIns = Ins;
//    }
//
//    public Insurance getInsurance()
//    {
//        return this.PatIns;
//    }

    //NEW USEFUL FUNCTION
    public void Print() {
        System.out.println("Name: " + this.Name);
        System.out.println("Gender: " + this.Gender);
        System.out.println("Doctor: " + this.Doctor);
        System.out.println("Nurse: " + this.Nurse);

        //for later:
//        System.out.println("Birthdate: "+ Birthdate);
//        System.out.println("Insurance information: "+ PatIns);
//        System.out.println("Appointments for patient: "+ Apps.toString());
//        System.out.println("Medications: "+ Meds.toString());
    }

//    public void addAppointment(Appointment NewApp)
//    {
//        Apps.add(NewApp);
//    }

//    public Appointment getAppoinment(Date AppDate)
//    {
//        //return AN appoinment attatched to AppDate
//    }

//    public void addMedication(Medication NewMed)
//    {
//        Meds.add(NewMed);
//    }

//    public ArrayList<Medication> getMedicationHistory()
//    {
//        return Meds;
//    }
}
