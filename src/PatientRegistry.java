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

        //BELOW IS THE FIRST TEST WE RAN TO MAKE SURE EVERYTHING WORKED

//        //Instantiate all variables for a patient
//        FileHandler TheServer = new FileHandler();
//        Date thisDate = new Date(4,20,1996);
//        Patient Mike = new Patient("Mike", "Male", thisDate);
//        Date AppDate = new Date(6,21,2020, 6,30);
//        Date AppDateTwo = new Date(7,21,2020, 6,30);
//        Appointment MikesApp = new Appointment(AppDate, "He has the AIDS");
//        Appointment MikesSecondApp = new Appointment(AppDateTwo, "He trippin son");
//        Date StartDate = new Date(6,21,2020);
//        Date EndDate = new Date(8,21,2020);
//        Date StartDateTwo = new Date(8,22,2020);
//        Date EndDateTwo = new Date(11,22,2020);
//        Medication MikesMeds = new Medication("Vicadin", 500, "mg", StartDate, EndDate);
//        Medication MikesMedsTwo = new Medication("Fentonol/Bleach", 500, "kg",
//                StartDateTwo, EndDateTwo);
//        Insurance MikesIns = new Insurance("Mike Hawk", "1234566", "123456");
//
//        //add/set everything to Mike Patient Object
//        Mike.setInsurance(MikesIns);
//        Mike.addMedication(MikesMeds);
//        Mike.addMedication(MikesMedsTwo);
//        Mike.addAppointment(MikesApp);
//        Mike.addAppointment(MikesSecondApp);
//        Mike.setDoctor("Jeffery Dahmer");
//        Mike.setNurse("Nurse Nancy");
//
//        //print to make sure everything is ok
//        //Mike.Print();
//
//        //save to "server"
//        try {
//            TheServer.savePatient(Mike);
//        } catch (PatientUnableToBeSavedException putbs) {
//            System.out.println(putbs.getMessage());
//        }
//
//        //pull from the file to print test
//        try {
//            Patient BackHere = TheServer.openPatient("Mike");
//            BackHere.Print();
//        } catch (PatientNotFoundException | PatientFileDamagedException filestuff) {
//            System.out.println(filestuff.getMessage());
//        }
//
//        //Now testing that user can change fields of Patient
//        Scanner KBScan = new Scanner(System.in);
//
//        //change the name
//        System.out.println("Change name for patient: ");
//        String NewName = KBScan.nextLine();
//        Mike.setName(NewName);
//
//        //change gender
//        System.out.println("Change gender for patient: ");
//        String NewGender = KBScan.nextLine();
//        Mike.setGender(NewGender);
//
//        //change doctor
//        System.out.println("Change doctor for patient: ");
//        String NewDoc = KBScan.nextLine();
//        Mike.setDoctor(NewDoc);
//
//        //change nurse
//        System.out.println("Change nurse for patient: ");
//        String NewNurse = KBScan.nextLine();
//        Mike.setNurse(NewNurse);
//
//       //change insurance
//        System.out.println("Change insurance info for patient: ");
//        System.out.println("Change cardholder name: ");
//        String newcardholder = KBScan.nextLine();
//        System.out.println("Enter new id number: ");
//        String newid = KBScan.next();
//        System.out.println("Enter new group number: ");
//        String newgroup = KBScan.next();
//        Insurance hisNewIns = new Insurance(newcardholder, newid, newgroup);
//        Mike.setInsurance(hisNewIns);
//
//        //add an appointment
//        System.out.println("Add another appointment for patient: ");
//        System.out.println("Enter a date for appoinment: ");
//        System.out.println("month: ");
//        int newappmonth = KBScan.nextInt();
//        System.out.println("day: ");
//        int newappday = KBScan.nextInt();
//        System.out.println("year: ");
//        int newappyear = KBScan.nextInt();
//        System.out.println("Time to visit: ");
//        System.out.println("Hour: ");
//        int newapphour = KBScan.nextInt();
//        System.out.println("Minute: ");
//        int newappmin = KBScan.nextInt();
//        Date newappdate = new Date(newappmonth,newappday,newappyear, newapphour,newappmin);
//        KBScan.nextLine();
//        System.out.println("Enter reason for visit: ");
//        String whyyouhere = KBScan.nextLine();
//        Appointment newapp = new Appointment(newappdate, whyyouhere);
//        Mike.addAppointment(newapp);
//
//        //add a medication
//        System.out.println("Add a medication to patient's medication history: ");
//        System.out.println("New medication name: ");
//        String newmedname = KBScan.nextLine();
//        System.out.println("Enter dose (ex. 500): ");
//        double newdose = KBScan.nextDouble();
//        System.out.println("Enter unit for dose (ex. mg, g, kg, etc...): ");
//        String newdoseunit = KBScan.next();
//
//        System.out.println("Enter a start date for new medication: ");
//        System.out.println("month: ");
//        int newmedmonth = KBScan.nextInt();
//        System.out.println("day: ");
//        int newmedday = KBScan.nextInt();
//        System.out.println("year: ");
//        int newmedyear = KBScan.nextInt();
//        Date newmeddate = new Date(newmedmonth,newmedday,newmedyear);
//
//        System.out.println("Enter an end date for new medication: ");
//        System.out.println("month: ");
//        int newmedmonthend = KBScan.nextInt();
//        System.out.println("day: ");
//        int newmeddayend = KBScan.nextInt();
//        System.out.println("year: ");
//        int newmedyearend = KBScan.nextInt();
//        Date newmeddateend = new Date(newmedmonthend, newmeddayend, newmedyearend);
//
//        Medication newmedenddate = new Medication(newmedname, newdose, newdoseunit, newmeddate, newmeddateend);
//        Mike.addMedication(newmedenddate);
//
//        System.out.println("New patient information: ");
//        Mike.Print();

        //end initial test----------------------------------------

        //real stuff starts here
        FileHandler TheServer = new FileHandler();

        while(true)
        {
            Scanner scan = new Scanner(System.in);

            System.out.println("::Welcome to PatientRegistry!::");
            System.out.println( "::Enter function you would like to complete::");
            System.out.println("1. Add patient to system");
            System.out.println("2. Look up patient in system");
            System.out.println("3. Quit");
            System.out.println("Enter number (i.e: 1 or 2 or 3)");

            int usrChoice = scan.nextInt();

            if(usrChoice == 3)
            {
                System.out.println(":::Thank you, goodbye:::");
                break;
            }

            if(usrChoice == 1)
            {
                System.out.println("Enter full name of new patient:");
                scan.nextLine();
                String name = scan.nextLine();
                System.out.println("Enter gender of new patient:");

                String gender = scan.nextLine();
                System.out.println("Enter Birthdate of new Patient:");

                int month, day,year;

                while(true)
                {
                    System.out.println("month: ");
                    month = scan.nextInt();
                    //check month number to make sure it is a valid input
                    if(month>12 || month<1)
                    {
                        System.out.println("::Invalid month, please enter an number between 1-12::");
                        continue;
                    }

                    System.out.println("day: ");
                    day = scan.nextInt();
                    //check for even # months (30 days)
                        //or if day is < 1
                    if(month%2==0 && day>30 || day<1)
                    {
                        System.out.println("::Invalid day, check what month it is::");
                        continue;
                    }
                    if(day>31)
                    {
                        System.out.println("Invalid day, enter number from 1-31");
                        continue;
                    }

                    System.out.println("year: ");
                    year = scan.nextInt();
                    //make sure patient was not born in the future
                    if(year>2020)
                    {
                        System.out.println("::Invalid year, try again::");
                        continue;
                    }
                    //only way for loop to loop is if there is an invalid input
                    break;
                }

                //make the patient's birthdate object and make the new patient
                Date PatBday = new Date(month,day,year);
                Patient newPat = new Patient(name, gender,PatBday);

                System.out.println("Enter Doctor's name for new patient:");
                scan.nextLine();
                String newPatDoc = scan.nextLine();

                System.out.println("Enter Nurse's name for new patient:");
                String newPatNurse = scan.nextLine();

                newPat.setDoctor(newPatDoc);
                newPat.setNurse(newPatNurse);

                System.out.println("Enter Insurance information on patient:");
                System.out.println("Enter cardholder name: ");
                String cardholder = scan.nextLine();

                System.out.println("Enter id for cardholder: ");
                String id = scan.nextLine();

                System.out.println("Enter group number: ");
                String groupnumber = scan.nextLine();

                Insurance newPatIns = new Insurance(cardholder, id, groupnumber);
                newPat.setInsurance(newPatIns);

                System.out.println("Do they have any medications? answer 'yes' or 'no'");
                String medsq = scan.next();
                if(medsq.toLowerCase().compareTo("yes") == 0)
                {
                    //add a medication
                    System.out.println("Add a medication to patient's medication history: ");
                    System.out.println("New medication name: ");
                    scan.nextLine();
                    String newmedname = scan.nextLine();
                    System.out.println("Enter dose (ex. 500): ");
                    double newdose = scan.nextDouble();
                    System.out.println("Enter unit for dose (ex. mg, g, kg, etc...): ");
                    String newdoseunit = scan.next();

                    System.out.println("Enter a start date for new medication: ");
                    int MedStartMonth, MedStartDay, MedStartYear;
                    while(true)
                    {
                        System.out.println("month: ");
                        MedStartMonth = scan.nextInt();
                        //check month number to make sure it is a valid input
                        if(MedStartMonth>12 || MedStartMonth<1)
                        {
                            System.out.println("::Invalid month, please enter an number between 1-12::");
                            continue;
                        }

                        System.out.println("day: ");
                        MedStartDay = scan.nextInt();
                        //check for even # months (30 days)
                        //or if day is < 1
                        if(MedStartDay%2==0 && MedStartDay>30 || MedStartDay<1)
                        {
                            System.out.println("::Invalid day, try again::");
                            continue;
                        }
                        if(MedStartDay>31)
                        {
                            System.out.println("Invalid day, enter number from 1-31, try again");
                            continue;
                        }

                        System.out.println("year: ");
                        MedStartYear = scan.nextInt();

                        //only way for loop to loop is if there is an invalid input
                        break;
                    }
                    Date newMedStartDate = new Date(MedStartMonth,MedStartDay,MedStartYear);

                    System.out.println("Enter an end date for new medication: ");
                    int MedEndMonth, MedEndDay, MedEndYear;
                    while(true)
                    {
                        System.out.println("month: ");
                        MedEndMonth = scan.nextInt();
                        //check month number to make sure it is a valid input
                        if(MedEndMonth>12 || MedEndMonth<1)
                        {
                            System.out.println("::Invalid month, please enter an number between 1-12::");
                            continue;
                        }

                        System.out.println("day: ");
                        MedEndDay = scan.nextInt();
                        //check for even # months (30 days)
                        //or if day is < 1
                        if(MedEndDay%2==0 && MedEndDay>30 || MedEndDay<1)
                        {
                            System.out.println("::Invalid day, try again::");
                            continue;
                        }
                        if(MedEndDay>31)
                        {
                            System.out.println("Invalid day, enter number from 1-31, try again");
                            continue;
                        }

                        System.out.println("year: ");
                        MedEndYear = scan.nextInt();
                        //make sure patient was not born in the future
                        if(MedEndYear<MedStartYear)
                        {
                            System.out.println("::Invalid year, try again::");
                            continue;
                        }
                        //only way for loop to loop is if there is an invalid input
                        break;
                    }
                    Date newMedEndDate = new Date(MedEndMonth, MedEndDay, MedEndYear);

                    Medication newmedenddate = new Medication(newmedname, newdose, newdoseunit, newMedStartDate, newMedEndDate);
                    newPat.addMedication(newmedenddate);
                }
                scan.nextLine();

                //enter patient Appointment if they need to
                System.out.println("Do you want to add an appointment for this patient?");
                System.out.println("answer 'yes' or 'no':");
                String choice = scan.next();

                if(choice.toLowerCase().compareTo("yes") == 0)
                {
                    System.out.println("Enter a date for appoinment: ");
                    int AppMonth, AppDay, AppYear, AppHour, AppMin;
                    while(true)
                    {
                        System.out.println("month: ");
                        AppMonth = scan.nextInt();
                        //check month number to make sure it is a valid input
                        if(AppMonth>12 || AppMonth<1)
                        {
                            System.out.println("::Invalid month, please enter an number between 1-12::");
                            continue;
                        }

                        System.out.println("day: ");
                        AppDay = scan.nextInt();
                        //check for even # months (30 days)
                        //or if day is < 1
                        if(AppMonth%2==0 && AppDay>30 || AppDay<1)
                        {
                            System.out.println("::Invalid day, try again::");
                            continue;
                        }
                        if(AppDay>31)
                        {
                            System.out.println("Invalid day, enter number from 1-31, try again");
                            continue;
                        }

                        System.out.println("year: ");
                        AppYear = scan.nextInt();
                        //make sure appointment is not in the past
                            //anything before this year = invalid to make things simpler
                        if(AppYear<2021)
                        {
                            System.out.println("::Invalid year, try again::");
                            continue;
                        }

                        System.out.println("Hour: ");
                        AppHour = scan.nextInt();
                        if(AppHour < 1 || AppHour > 24)
                        {
                            System.out.println("Enter valid hour for appointment (1 < Hour < 24");
                            continue;
                        }

                        System.out.println("Minute: ");
                        AppMin = scan.nextInt();
                        if(AppMin < 1 || AppMin > 59)
                        {
                            System.out.println("Enter valid minute for appointment (1 < Minute < 59");
                            continue;
                        }
                        //only way for loop to loop is if there is an invalid input
                        break;
                    }
                    Date newappdate = new Date(AppMonth,AppDay,AppYear, AppHour,AppMin);
//                    scan.nextLine();

                    System.out.println("Enter reason for visit: ");
                    String whyyouhere = scan.nextLine();
                    Appointment newapp = new Appointment(newappdate, whyyouhere);

                    newPat.addAppointment(newapp);
                }


                //save patient to "server"
                try {
                        TheServer.savePatient(newPat);
                    }
                catch (PatientUnableToBeSavedException putbs) {
                        System.out.println(putbs.getMessage());
                    }

                //this was just me testing, remove and move to option 2
                System.out.println("Enter name of patient to be looked up:");
                String Lookupname = scan.nextLine();

                try {
                    Patient BackHere = TheServer.openPatient(Lookupname);
                    BackHere.Print();
                    }
                catch (PatientNotFoundException | PatientFileDamagedException filestuff)
                    {
                    System.out.println(filestuff.getMessage());
                    }
            }
            //------------END ADDING NEW PATIENT---------------------------
//            if(usrChoice == 2)
//            {
//                //enter stuff here
//            }
        }
    }
}

