package positionlot.main;

import positionlot.util.Command;
import positionlot.util.ReadString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    String args, input;

    boolean start = true, commandValid = false;

    int index = 0, counter = 0, iterasi = 0;

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
            //else using command line
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





                }



            }

            if (!args.equals("")) {
                iterasi++;
            }
        }

    }

    //Function for parsing command with space
    private List<String> parsingCommand(String input) {
        List<String> list = new ArrayList<>();
        String[] arrayInputs = input.split(" ");
        for (String arrayInput : arrayInputs) {
            list.add(arrayInput);
        }
        return list;
    }

    private boolean checkCommand(List<String> listOfInput){

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

}
