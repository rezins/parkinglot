package positionlot.main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import positionlot.main.MainClass;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainClassTest {

    MainClass mainClass = new MainClass();

    @Test
    @DisplayName("Test Parsing Command")
    void testParsingCommand(){

        List<String> tmp = mainClass.parsingCommand("create_parking_lot 6");
        assertTrue(tmp.size() > 0 , "parsing accepted");

    }

    @Test
    @DisplayName("Test Parsing Command if Empty")
    void testParsingCommandIfEmpty(){

        List<String> tmp = mainClass.parsingCommand("");
        assertTrue(tmp.size()==1 , "parsing empty string accepted");

    }


    @Test
    @DisplayName(value = "Test Command Is Registered ")
    void testCommandRegistered(){
        List<String> tmp = mainClass.parsingCommand("create_parking_lot 6");
        boolean tmpBool = mainClass.checkCommand(tmp);
        assertTrue(tmpBool, "commad is registered");
    }

    @Test
    @DisplayName(value = "Test Command Is Not Registered ")
    void testCommandNotRegistered(){
        List<String> tmp = mainClass.parsingCommand("Hai Test Command");
        boolean tmpBool = mainClass.checkCommand(tmp);
        assertTrue(!tmpBool, "commad is not registered");
    }

    @Test
    @DisplayName(value = "Test For Checking Input is Number")
    void checkParkIsCreated(){

        boolean tmp = mainClass.checkIsNumber("1");
        assertTrue(tmp, "input is number");
    }

    @Test
    @DisplayName(value = "Test Slot Number For Registration Number")
    void slot_number_for_registration_number(){
        mainClass.launch("file_input.txt");
        String slotNumber = mainClass.slot_number_for_registration_number("KA-01-HH-3141");
        assertTrue(!slotNumber.equals("Not found"), "Slot number exists");
    }

    @Test
    @DisplayName(value = "Test Slot Number For Registration Number Not Found")
    void slot_number_for_registration_number_not_found(){
        mainClass.launch("file_input.txt");
        String slotNumber = mainClass.slot_number_for_registration_number("MH-04-AY-1111");
        assertTrue(slotNumber.equals("Not found"), "Slot number not found");
    }

    @Test
    @DisplayName(value = "Test Slot Number For Cars with Colour")
    void slot_numbers_for_cars_with_colour(){
        mainClass.launch("file_input.txt");
        String slotNumber = mainClass.slot_numbers_for_cars_with_colour("White");
        assertTrue(!slotNumber.equals("Not found"), "Slot number exists");
    }

    @Test
    @DisplayName(value = "Test Slot Number For Cars with Colour Not Found")
    void slot_numbers_for_cars_with_colour_not_found(){
        mainClass.launch("file_input.txt");
        String slotNumber = mainClass.slot_numbers_for_cars_with_colour("Green");
        assertTrue(slotNumber.equals("Not found"), "Slot number not found");
    }

    @Test
    @DisplayName(value = "Test Regis Number With color")
    void testRegisNumberWithColor(){
        mainClass.launch("file_input.txt");
        String slotNumber = mainClass.registration_numbers_for_cars_with_colour("White");
        assertTrue(!slotNumber.equals("Not found"), "Regis number exists");
    }

    @Test
    @DisplayName(value = "Test Regis Number With color Not Found")
    void testRegisNumberWithColorNotFound(){
        mainClass.launch("file_input.txt");
        String slotNumber = mainClass.registration_numbers_for_cars_with_colour("Green");
        assertTrue(slotNumber.equals("Not found"), "Regis number not found");
    }



}
