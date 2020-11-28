package positionlot.main;

import positionlot.model.Lot;
import positionlot.util.Command;
import positionlot.util.ReadString;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class MainClass {

    private String args, input;

    private boolean start = true, commandValid = false;

    private int index = 0, counter = 0, iterasi = 0;

    private List<Lot> listParking = new ArrayList<>();

    private ReadString r = new ReadString();
    private Command cmd = new Command();

    private String[] fileRead;

    //Here's main code
    public void launch(String args){
        this.args = args;

        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("============                                ===============");
        System.out.println("============      WELCOME TO PARKING LOT    ===============");
        System.out.println("============                                ===============");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("\n");
        System.out.println("Please type command below ! ");
        System.out.println("-----------------------------------------------------------");

        //Cek if using argument or not
        if (!args.equals("")) {
            try {
                fileRead = r.read(args);
            }catch (NullPointerException e){
                System.out.println("File Not Found");
                fileRead = new String[0];
            }
        }else{
            fileRead = new String[1];
        }

        while (start && iterasi < fileRead.length) {

            //If using args then input by file_input.txt perline
            //else using command line by scanner
            if (!args.equals("")) {
                input = fileRead[iterasi].trim();
            } else {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
            }

            //check if input equals null or empty string then do not executed
            if (!input.equals("")) {

                //do parsing command and put into list
                List<String> listOfInput = parsingCommand(input);

                //check if command is valid
                commandValid = checkCommand(listOfInput);

                // If command is invalid then print Command Not Found
                // Else Do Execution command
                if (!commandValid) {
                    System.out.println("Command Not Found");
                }else{

                    //Check If Command is Show Status
                    if (listOfInput.size() == 1 && listOfInput.get(0).equals(cmd.list.get(3))) {

                        //First Check if Park is created
                        if (checkParkIsCreated()) {

                            //Call Proc Status Park
                            showStatusPark();

                        }else { // park is not created

                            System.out.println("Park has not been created.");
                        }

                    }else if (listOfInput.size() == 2) { // Check if command is Not Status Or Add Car to Park

                        if (listOfInput.get(0).equals(cmd.list.get(0))) { // If first word command is create_parking_lot

                            //Check if second word is number or not
                            if(checkIsNumber(listOfInput.get(1))){

                                //Check if parking lot is already created
                                if(listParking.size()==0){

                                    //The Idea is creating all list with empty attribute
                                    for (int i = 0; i < Integer.parseInt(listOfInput.get(1)); i++) {
                                        listParking.add(new Lot(i, 0, null, null));
                                    }
                                    System.out.println("Created a parking lot with " + listOfInput.get(1) + " slots");

                                }else{

                                    System.out.println("Parking lot is already created");

                                }

                            }else{
                                System.out.println("you must input number");
                            }



                        }else if (listOfInput.get(0).equals(cmd.list.get(2))) { // If first word command is leave

                            //First Check if Park is created
                            if (checkParkIsCreated()) {

                                //Check if second word is number
                                if(checkIsNumber(listOfInput.get(1))){

                                    int slotRemove = Integer.parseInt(listOfInput.get(1));

                                    //check if input between 1 and size of parking lot
                                    if(slotRemove > 0 && slotRemove <= listParking.size()){

                                        leave(slotRemove);

                                    }else{

                                        System.out.println("choose slot between 1 and " + listParking.size());

                                    }

                                }else{

                                    System.out.println("you must input number");
                                }

                            }else { // park is not created

                                System.out.println("Park has not been created.");
                            }

                        }else if (listOfInput.get(0).equals(cmd.list.get(4))) { //If first word command is registration_numbers_for_cars_with_colour

                            //First Check if Park is created
                            if (checkParkIsCreated()) {

                                //print out query
                                System.out.println(registration_numbers_for_cars_with_colour(listOfInput.get(1)));

                            }else { // park is not created

                                System.out.println("Park has not been created.");
                            }

                        }else if (listOfInput.get(0).equals(cmd.list.get(5))) { //If first word command is slot_numbers_for_cars_with_colour

                            //First Check if Park is created
                            if (checkParkIsCreated()) {

                                //print out query
                                System.out.println(slot_numbers_for_cars_with_colour(listOfInput.get(1)));

                            }else { // park is not created

                                System.out.println("Park has not been created.");
                            }

                        }else if (listOfInput.get(0).equals(cmd.list.get(6))) { //If first word command is slot_number_for_registration_number

                            //First Check if Park is created
                            if (checkParkIsCreated()) {

                                //print out query
                                System.out.println(slot_number_for_registration_number(listOfInput.get(1)));

                            }else { // park is not created

                                System.out.println("Park has not been created.");
                            }

                        }else { // If first command not in registered
                            System.out.println("Command Not Recognized");
                        }
                    }else if (listOfInput.size() == 3) { // Check if Command is Add Car To Park

                        //First Check if Park is created
                        if (checkParkIsCreated()) {

                            //I have variable counter for marking size of park
                            // counter will increase if a Car has been parked
                            if (counter < listParking.size()) {

                                //call prod add car to park
                                addParking(listOfInput);

                            } else { // if counter more than park alocated then ..

                                System.out.println("Sorry, parking lot is full");

                            }
                        } else { // park is not created

                            System.out.println("Park has not been created.");
                        }


                    }else if (listOfInput.size() == 1 && listOfInput.get(0).equals(cmd.list.get(7))) { //Check if command is Exit

                        //Just set variable start to false if want to exit in loop
                        start = false;

                    }else { // Else for Not Recognized Commnad
                        System.out.println("Command Not Recognized");
                    }

                }



            }

            if (!args.equals("")) {
                iterasi++;
            }
        }

    }

    //Function for parsing command with space
     List<String> parsingCommand(String input) {
        List<String> list = new ArrayList<>();
        String[] arrayInputs = input.split(" ");
        for (String arrayInput : arrayInputs) {
            list.add(arrayInput);
        }
        return list;
    }

    //Function for check validation command registered
    boolean checkCommand(List<String> listOfInput){

        boolean validation = false;

        for (int i = 0; i < cmd.list.size(); i++) {

            if (listOfInput.get(0).equals(cmd.list.get(i))) {
                validation = true;
                break;
            } else {
                validation = false;
            }
        }

        return validation;
    }

    //Function check if Input is Number or Not
    boolean checkIsNumber(String input){
        int tmp = 0;

        try {
            tmp = Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }

    //Function check If Park is created, return boolean
    private boolean checkParkIsCreated() {
        return listParking.size() > 0 ? true : false;
    }

    //Proc Showing Status Car In Park
    private void showStatusPark() {
        System.out.println("Slot No. \t Registration No \t Colour");
        for (Lot lot : listParking) {
            if (lot.getSlot() != 0) {
                System.out.println(lot.getSlot() + "  \t\t" + lot.getRegister_number() + "  \t\t" + lot.getColor());
            }
        }
    }


    //===================================================== MAIN LOGIC ===================================================


    // Add Parking Method, is to set List with Input Car by Command Line
    void addParking(List<String> listOfInput) {

        ListIterator<Lot> iterator = listParking.listIterator();
        while (iterator.hasNext()) {
            Lot next = iterator.next();
            if (next.getSlot() == 0) {
                Lot lot = listParking.get(next.getIndex());
                listParking.set(next.getIndex(), new Lot(lot.getIndex(), next.getIndex() + 1, listOfInput.get(1), listOfInput.get(2)));
                counter++;
                System.out.println("Allocated slot number " + (next.getIndex() + 1));
                break;
            }
        }

    }

    //Leave car in parking lot
    void leave(int slot) {

        Lot lot = listParking.get(slot - 1);
        listParking.set(slot - 1, new Lot(lot.getIndex(), 0, null, null));
        counter--;
        System.out.println("Slot number " + slot + " is free");
    }

    //method search regis number with color
    String registration_numbers_for_cars_with_colour(String color) {
        String str = "";

        for (Lot lot : listParking) {
            if (lot.getSlot() != 0) {
                if (lot.getColor().equals(color)) {
                    str += lot.getRegister_number() + ", ";
                }
            }
        }

        if (!str.equals("")) {
            str = str.substring(0, str.length() - 2);
        } else {
            str = "Not found";
        }

        return str;
    }

    //method slot number with color
    String slot_numbers_for_cars_with_colour(String color) {
        String str = "";

        for (Lot lot : listParking) {
            if (lot.getSlot() != 0) {
                if (lot.getColor().equals(color)) {
                    str += lot.getSlot() + ", ";
                }
            }

        }

        if (!str.equals("")) {
            str = str.substring(0, str.length() - 2);
        } else {
            str = "Not found";
        }

        return str;
    }

    //method slot number
    String slot_number_for_registration_number(String regis) {
        String str = "";

        for (Lot lot : listParking) {
            if (lot.getSlot() != 0) {
                if (lot.getRegister_number().trim().equals(regis.trim())) {
                    str += lot.getSlot() + ", ";
                }
            }

        }

        if (!str.equals("")) {
            str = str.substring(0, str.length() - 2);
        } else {
            str = "Not found";
        }

        return str;
    }

}
