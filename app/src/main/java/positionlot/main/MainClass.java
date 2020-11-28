package positionlot.main;

import positionlot.model.Lot;
import positionlot.util.Command;
import positionlot.util.ReadString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    String args, input;

    boolean start = true, commandValid = false;

    int index = 0, counter = 0, iterasi = 0;

    private List<Lot> listParking = new ArrayList<>();

    ReadString r = new ReadString();
    Command cmd = new Command();

    String[] fileRead;

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
            fileRead = r.read(args);
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

                        //Call Proc Status Park
                        showStatusPark();

                    }else if (listOfInput.size() == 2) { // Check if command is Not Status Or Add Car to Park

                        if (listOfInput.get(0).equals(cmd.list.get(0))) { // If first word command is create_parking_lot


                        }else if (listOfInput.get(0).equals(cmd.list.get(2))) { // If first word command is leave


                        }else if (listOfInput.get(0).equals(cmd.list.get(4))) { //If first word command is registration_numbers_for_cars_with_colour


                        }else if (listOfInput.get(0).equals(cmd.list.get(5))) { //If first word command is slot_numbers_for_cars_with_colour


                        }else if (listOfInput.get(0).equals(cmd.list.get(6))) { //If first word command is slot_number_for_registration_number


                        }else { // If first command not in registered
                            System.out.println("Command Not Recognized");
                        }
                    }else if (listOfInput.size() == 3) { // Check if Command is Add Car To Park

                        //First Check if Park is created
                        if (checkParkIsCreated()) {

                            //I have variable counter for marking size of park
                            // counter will increase if a Car has been parked
                            if (counter < listParking.size()) {

                                //

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



}
