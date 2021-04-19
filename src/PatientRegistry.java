import java.util.Scanner;

/**
 * PatientRegistry.java:
 * <p>
 * This will be our main method/class for the final project
 */
public class PatientRegistry {
    //Testing patient fields and methods
    //NOTE: I am testing fields that DO NOT require:
    //Date.java
    //Medication.java
    //Appoinment.java

    public static void main(String[] args)
    {
        //Instantiate all variables for a patient
        FileHandler TheServer = new FileHandler();
        Date thisDate = new Date(4,20,1996);
        Patient Mike = new Patient("Mike", "Male", thisDate);
        Date AppDate = new Date(6,21,2020, 6,30);
        Date AppDateTwo = new Date(7,21,2020, 6,30);
        Appointment MikesApp = new Appointment(AppDate, "He has the AIDS");
        Appointment MikesSecondApp = new Appointment(AppDateTwo, "He trippin son");
        Date StartDate = new Date(6,21,2020);
        Date EndDate = new Date(8,21,2020);
        Date StartDateTwo = new Date(8,22,2020);
        Date EndDateTwo = new Date(11,22,2020);
        Medication MikesMeds = new Medication("Vicadin", 500, "mg", StartDate, EndDate);
        Medication MikesMedsTwo = new Medication("Fentonol/Bleach", 500, "kg",
                StartDateTwo, EndDateTwo);
        Insurance MikesIns = new Insurance("Mike Hawk", "1234566", "123456");

        //add/set everything to Mike Patient Object
        Mike.setInsurance(MikesIns);
        Mike.addMedication(MikesMeds);
        Mike.addMedication(MikesMedsTwo);
        Mike.addAppointment(MikesApp);
        Mike.addAppointment(MikesSecondApp);
        Mike.setDoctor("Jeffery Dahmer");
        Mike.setNurse("Nurse Nancy");

        //print to make sure everything is ok
        //Mike.Print();

        //save to "server"
        try {
            TheServer.savePatient(Mike);
        } catch (PatientUnableToBeSavedException putbs) {
            System.out.println(putbs.getMessage());
        }

        //pull from the file to print test
        try {
            Patient BackHere = TheServer.openPatient("Mike");
            BackHere.Print();
        } catch (PatientNotFoundException | PatientFileDamagedException filestuff) {
            System.out.println(filestuff.getMessage());
        }

        //Now testing that user can change fields of Patient
        Scanner KBScan = new Scanner(System.in);

        //change the name
        System.out.println("Change name for patient: ");
        String NewName = KBScan.nextLine();
        Mike.setName(NewName);

        //change gender
        System.out.println("Change gender for patient: ");
        String NewGender = KBScan.nextLine();
        Mike.setGender(NewGender);

        //change doctor
        System.out.println("Change doctor for patient: ");
        String NewDoc = KBScan.nextLine();
        Mike.setDoctor(NewDoc);

        //change nurse
        System.out.println("Change nurse for patient: ");
        String NewNurse = KBScan.nextLine();
        Mike.setNurse(NewNurse);

       //change insurance
        System.out.println("Change insurance info for patient: ");
        System.out.println("Change cardholder name: ");
        String newcardholder = KBScan.nextLine();
        System.out.println("Enter new id number: ");
        String newid = KBScan.next();
        System.out.println("Enter new group number: ");
        String newgroup = KBScan.next();
        Insurance hisNewIns = new Insurance(newcardholder, newid, newgroup);
        Mike.setInsurance(hisNewIns);

        //add an appointment
        System.out.println("Add another appointment for patient: ");
        System.out.println("Enter a date for appoinment: ");
        System.out.println("month: ");
        int newappmonth = KBScan.nextInt();
        System.out.println("day: ");
        int newappday = KBScan.nextInt();
        System.out.println("year: ");
        int newappyear = KBScan.nextInt();
        System.out.println("Time to visit: ");
        System.out.println("Hour: ");
        int newapphour = KBScan.nextInt();
        System.out.println("Minute: ");
        int newappmin = KBScan.nextInt();
        Date newappdate = new Date(newappmonth,newappday,newappyear, newapphour,newappmin);
        KBScan.nextLine();
        System.out.println("Enter reason for visit: ");
        String whyyouhere = KBScan.nextLine();
        Appointment newapp = new Appointment(newappdate, whyyouhere);
        Mike.addAppointment(newapp);

        //add a medication
        System.out.println("Add a medication to patient's medication history: ");
        System.out.println("New medication name: ");
        String newmedname = KBScan.nextLine();
        System.out.println("Enter dose (ex. 500): ");
        double newdose = KBScan.nextDouble();
        System.out.println("Enter unit for dose (ex. mg, g, kg, etc...): ");
        String newdoseunit = KBScan.next();

        System.out.println("Enter a start date for new medication: ");
        System.out.println("month: ");
        int newmedmonth = KBScan.nextInt();
        System.out.println("day: ");
        int newmedday = KBScan.nextInt();
        System.out.println("year: ");
        int newmedyear = KBScan.nextInt();
        Date newmeddate = new Date(newmedmonth,newmedday,newmedyear);

        System.out.println("Enter an end date for new medication: ");
        System.out.println("month: ");
        int newmedmonthend = KBScan.nextInt();
        System.out.println("day: ");
        int newmeddayend = KBScan.nextInt();
        System.out.println("year: ");
        int newmedyearend = KBScan.nextInt();
        Date newmeddateend = new Date(newmedmonthend, newmeddayend, newmedyearend);

        Medication newmedenddate = new Medication(newmedname, newdose, newdoseunit, newmeddate, newmeddateend);
        Mike.addMedication(newmedenddate);
        
        System.out.println("New patient information: ");
        Mike.Print();

        //end .patients----------------------------------------
    }
}

