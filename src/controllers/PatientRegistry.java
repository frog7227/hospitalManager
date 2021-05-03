package controllers;

import java.util.Objects;
import java.util.Scanner;

import models.*;
import models.exceptions.PatientFileDamagedException;
import models.exceptions.PatientNotFoundException;
import models.exceptions.PatientUnableToBeSavedException;

/**
 * controllers.PatientRegistry.java:
 * <p>
 * This will be our main method/class for the final project
 *
 * @author Alexander Croll
 * @author Andrew Ostrosky
 * @author Cameron Hoss
 */
public class PatientRegistry {


    public static void main(String[] args)
    {
        //Make a new controllers.FileHandler instance for JSON file
        FileHandler TheServer = new FileHandler();

        while(true) // run until needing to stop
        {
            //user menu
            Scanner scan = new Scanner(System.in);

            System.out.println("::Welcome to PatientRegistry!::");
            System.out.println( "::Enter function you would like to complete::");
            System.out.println("1. Add patient to system");
            System.out.println("2. Look up patient in system");
            System.out.println("3. Add Appointment to existing patient");
            System.out.println("4. Quit");
            System.out.println("Enter number (i.e: 1 or 2 or 3 or 4)");

            //choice of function
            while(!scan.hasNextInt()) {
                scan.next();
                System.err.println("Please enter a number.");
            }
            int usrChoice = scan.nextInt();
            scan.nextLine();
            switch(usrChoice) {

                //ADDING A PATIENT
                case 1:
                    System.out.println("Enter full name of new patient:");
                    //scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Enter gender of new patient:");

                    String gender = scan.nextLine();
                    // System.out.println("Enter Birthdate of new Patient:");

                    int month, day, year;

                    while (true) {
                        System.out.println("Enter the month of the birthdate of this patient:");
                        while (!scan.hasNextInt()) {
                            scan.next();
                            System.err.println("Please enter a number.");
                        }
                        while (!scan.hasNextInt()) {
                            scan.next();
                            System.err.println("Please enter a number.");
                        }
                        month = scan.nextInt();
                        //check month number to make sure it is a valid input
                        if (month > 12 || month < 1) {
                            System.err.println("::Invalid month, please enter an number between 1-12::");
                            continue;
                        }

                        System.out.println("Enter the day of the birthdate of this patient:");
                        while (!scan.hasNextInt()) {
                            scan.next();
                            System.err.println("Please enter a number.");
                        }
                        day = scan.nextInt();
                        //check for even # months (30 days)
                        //or if day is < 1
                        if (month % 2 == 0 && day > 30 || day < 1) {
                            System.err.println("::Invalid day, check what month it is::");
                            continue;
                        }
                        if (day > 31) {
                            System.err.println("::Invalid day, enter number from 1-31::");
                            continue;
                        }

                        System.out.println("Enter the year of the birthdate of this patient:");
                        while (!scan.hasNextInt()) {
                            scan.next();
                            System.err.println("Please enter a number.");
                        }
                        year = scan.nextInt();
                        //make sure patient was not born in the future
                        if (year > 2020) {
                            System.err.println("::Invalid year, try again::");
                            continue;
                        }
                        //only way for loop to loop is if there is an invalid input
                        break;
                    }

                    //make the patient's birthdate object and make the new patient
                    Date PatBday = new Date(month, day, year);
                    Patient newPat = new Patient(name, gender, PatBday);

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
                    if (medsq.toLowerCase().compareTo("yes") == 0) {
                        while (medsq.equals("yes")) {
                            //add a medication
                            System.out.println("Add a medication to patient's medication history: ");
                            System.out.println("New medication name: ");
                            scan.nextLine();
                            String newmedname = scan.nextLine();
                            System.out.println("Enter dose (ex. 500): ");
                            double newdose = scan.nextDouble();
                            System.out.println("Enter unit for dose (ex. mg, g, kg, etc...): ");
                            String newdoseunit = scan.next();

                            // System.out.println("Enter a start date for new medication: ");
                            int MedStartMonth, MedStartDay, MedStartYear;
                            while (true) {
                                System.out.println("Enter a start month for new medication:");
                                while (!scan.hasNextInt()) {
                                    scan.next();
                                    System.err.println("Please enter a number.");
                                }
                                MedStartMonth = scan.nextInt();

                                //check month number to make sure it is a valid input
                                if (MedStartMonth > 12 || MedStartMonth < 1) {
                                    System.err.println("::Invalid month, please enter an number between 1-12::");
                                    continue;
                                }

                                System.out.println("Enter a start day for new medication:");
                                while (!scan.hasNextInt()) {
                                    scan.next();
                                    System.err.println("Please enter a number.");
                                }
                                MedStartDay = scan.nextInt();
                                //check for even # months (30 days)
                                //or if day is < 1
                                if (MedStartDay % 2 == 0 && MedStartDay > 30 || MedStartDay < 1) {
                                    System.err.println("::Invalid day, try again::");
                                    continue;
                                }
                                if (MedStartDay > 31) {
                                    System.err.println("Invalid day, enter number from 1-31, try again");
                                    continue;
                                }

                                System.out.println("Enter a start year for new medication:");
                                while (!scan.hasNextInt()) {
                                    scan.next();
                                    System.err.println("Please enter a number.");
                                }
                                MedStartYear = scan.nextInt();

                                //only way for loop to loop is if there is an invalid input
                                break;
                            }
                            Date newMedStartDate = new Date(MedStartMonth, MedStartDay, MedStartYear);


                            int MedEndMonth, MedEndDay, MedEndYear;
                            while (true) {
                                System.out.println("Enter the end month for the new medication: ");
                                while (!scan.hasNextInt()) {
                                    scan.next();
                                    System.err.println("Please enter a number.");
                                }
                                MedEndMonth = scan.nextInt();
                                //check month number to make sure it is a valid input
                                if (MedEndMonth > 12 || MedEndMonth < 1) {
                                    System.err.println("::Invalid month, please enter an number between 1-12::");
                                    continue;
                                }

                                System.out.println("Enter the end day for new medication: ");
                                while (!scan.hasNextInt()) {
                                    scan.next();
                                    System.err.println("Please enter a number.");
                                }
                                MedEndDay = scan.nextInt();
                                //check for even # months (30 days)
                                //or if day is < 1
                                if (MedEndDay % 2 == 0 && MedEndDay > 30 || MedEndDay < 1) {
                                    System.err.println("::Invalid day, try again::");
                                    continue;
                                }
                                if (MedEndDay > 31) {
                                    System.err.println("Invalid day, enter number from 1-31, try again");
                                    continue;
                                }

                                System.out.println("Enter the end month for new medication: ");
                                while (!scan.hasNextInt()) {
                                    scan.next();
                                    System.err.println("Please enter a number.");
                                }
                                MedEndYear = scan.nextInt();
                                //make sure patient was not born in the future
                                if (MedEndYear < MedStartYear) {
                                    System.err.println("::Invalid year, try again::");
                                    continue;
                                }
                                //only way for loop to loop is if there is an invalid input
                                break;
                            }
                            Date newMedEndDate = new Date(MedEndMonth, MedEndDay, MedEndYear);

                            Medication newmedenddate = new Medication(newmedname, newdose, newdoseunit, newMedStartDate, newMedEndDate);
                            newPat.addMedication(newmedenddate);
                            System.out.println("Do they have any additional medications? answer 'yes' or 'no'");
                            medsq = scan.next();
                        }
                    }
                    scan.nextLine();

                    //enter patient Appointment if they need to
                    System.out.println("Do you want to add an appointment for this patient?");
                    System.out.println("answer 'yes' or 'no':");
                    String choice = scan.next();

                    if (choice.toLowerCase().compareTo("yes") == 0) {
                        newPat.addAppointment(makeAppointment(scan));
                    }


                    //save patient to "server"
                    try {
                        TheServer.savePatient(newPat);
                    } catch (PatientUnableToBeSavedException putbs) {
                        System.out.println(putbs.getMessage());
                    }

                    //confirm to user that the patient has been successfully saved
                    System.out.println("\n\n::New Patient saved successfully::\n\n");

                    break;
                //------------END ADDING NEW PATIENT---------------------------

                //LOOKUP A PATIENT VIA THEIR FULL NAME
                case 2:
                    //this was just me testing, remove and move to option 2
                    System.out.println("Enter name of patient to be looked up:");
                    String Lookupname = scan.nextLine();

                    try {
                        Patient BackHere = TheServer.openPatient(Lookupname);
                        BackHere.Print();
                    } catch (PatientNotFoundException | PatientFileDamagedException filestuff) {
                        System.err.println(filestuff.getMessage());
                    }
                    break;
                //------------ADD APPOINTMENT----------------------------------------------------
                case 3:
                    System.out.println("Enter the patient name");

                    name = scan.nextLine();
                    Patient pat = null; // so we can use it no matter what
                    try {
                        pat = TheServer.openPatient(name);
                    } catch (PatientNotFoundException | PatientFileDamagedException filestuff) {
                        System.err.println(filestuff.getMessage());
                    }
                    if (!Objects.isNull(pat)) {// This is done to remove this code from the try catch itself
                        Date followUpDate = null;
                        if (!pat.getAppointments().isEmpty()) {// if there's an existing appointment
                            System.out.println("Is this appointment a follow up for a previous appointment?");
                            System.out.println("Enter yes or y for yes or anything else for no");
                            String yesOrNo = scan.nextLine();
                            if (yesOrNo.equals("yes") || yesOrNo.equals("y")) {// add patient if yes and has previous appointments
                                System.out.println("Appointments for patient: ");
                                System.out.println(pat.getAppointments().toString().replace("[", "")
                                        .replace("]", "").trim().replace(",", ""));

                            }
                            int appointmentNum = 0;
                            do {
                                System.out.println("Enter a number starting from 1 to the corresponding appointment.");
                                while (!scan.hasNextInt()) {
                                    scan.next();
                                    System.err.println("Please enter a valid number.");
                                }
                                appointmentNum = scan.nextInt();
                            } while (appointmentNum < 1 || appointmentNum > pat.getAppointments().size());// retry if it's invalid
                            followUpDate = pat.getAppointments().get(appointmentNum - 1).getDate();
                        }
                        Appointment addApt = null;// empty appointment

                        do {
                            if(!Objects.isNull(addApt) && addApt.getDate().compareTo(followUpDate) > 0){
                                System.err.println("Please enter a date after the previous appointment.");
                            }

                            addApt = makeAppointment(scan);

                        }while( !Objects.isNull(followUpDate) && addApt.getDate().compareTo(followUpDate) > 0);// is null is checked first, os if it's null it does not try to compare

                        if (!Objects.isNull(followUpDate)) {// set the follow up date if it is set already
                            addApt.setFollowUp(followUpDate);
                        }


                        pat.addAppointment(addApt);
                        try {
                            TheServer.savePatient(pat);
                        } catch (PatientUnableToBeSavedException putbs) {
                            System.out.println(putbs.getMessage());
                        }

                        //confirm to user that the patient has been successfully saved
                        System.out.println("\n\n::Appointment added successfully::\n\n");

                    }
                    break;
                //-----------------END ADD APPOINTMENT----------------------------------------------

                //-----USER QUIT PROGRAM------------------------------------------
                case 4:
                    System.out.println("Thanks. Goodbye.");
                    System.exit(0);

                    break;
                //------Invalid Input---------------------------------------------
                default:
                    System.out.println("\n\n::Invalid Input::\n\n");

                    break;
                //--------------END PATIENT LOOKUP-------------------
            }
        }
    }
    private static Appointment makeAppointment(Scanner scan){
        //System.out.println("Enter a date for appointment: ");
        int AppMonth, AppDay, AppYear, AppHour, AppMin;
        while(true)
        {
            System.out.println("Enter the month of the appointment:");
            while(!scan.hasNextInt()) {
                scan.next();
                System.err.println("Please enter a number.");
            }
            AppMonth = scan.nextInt();
            //check month number to make sure it is a valid input
            if(AppMonth>12 || AppMonth<1)
            {
                System.err.println("::Invalid month, please enter an number between 1-12::");
                continue;
            }

            System.out.println("Enter the day of the appointment:");
            AppDay = scan.nextInt();
            //check for even # months (30 days)
            //or if day is < 1
            if(AppMonth%2==0 && AppDay>30 || AppDay<1)
            {
                System.err.println("::Invalid day, try again::");
                continue;
            }
            if(AppDay>31)
            {
                System.err.println("Invalid day, enter number from 1-31, try again");
                continue;
            }

            System.out.println("Enter the Year for the appointment:");
            while(!scan.hasNextInt()) {
                scan.next();
                System.err.println("Please enter a number.");
            }
            AppYear = scan.nextInt();
            //make sure appointment is not in the past
            //anything before this year = invalid to make things simpler
            if(AppYear<2021)
            {
                System.err.println("::Invalid year, try again::");
                continue;
            }

            System.out.println("Enter the hour of the appointment (24HR time): ");
            while(!scan.hasNextInt()) {
                scan.next();
                System.err.println("Please enter a number.");
            }
            AppHour = scan.nextInt();
            if(AppHour < 1 || AppHour > 24)
            {
                System.out.println("Enter valid hour for appointment (1 < Hour < 24");
                continue;
            }

            System.out.println("Enter the minutes of the appointment:");
            while(!scan.hasNextInt()) {
                scan.next();
                System.err.println("Please enter a number.");
            }
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
        scan.nextLine();

        System.out.println("Enter reason for visit: ");
        String whyyouhere = scan.nextLine();
        return new Appointment(newappdate, whyyouhere);
    }

}

