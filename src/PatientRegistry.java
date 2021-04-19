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

    public static void main(String[] args) {
        Patient Mike = new Patient("Mike", "Male");
        Mike.setDoctor("Jeffery Dahmer");
        Mike.setNurse("Nurse Nancy");

        System.out.println("Patient info: ");
        Mike.Print();

        //Now testing that user can change fields of Patient
        Scanner KBScan = new Scanner(System.in);

        //change the name
        System.out.println("Enter new name for Mike: ");
        String NewName = KBScan.nextLine();
        Mike.setName(NewName);

        //change gender
        System.out.println("Enter gender for Mike: ");
        String NewGender = KBScan.nextLine();
        Mike.setGender(NewGender);

        //change doctor
        System.out.println("Change doctor for Mike: ");
        String NewDoc = KBScan.nextLine();
        Mike.setDoctor(NewDoc);

        //change nurse
        System.out.println("Change nurse for Mike: ");
        String NewNurse = KBScan.nextLine();
        Mike.setNurse(NewNurse);

        System.out.println("New patient information: ");
        Mike.Print();

        //end test----------------------------------------
    }
}

