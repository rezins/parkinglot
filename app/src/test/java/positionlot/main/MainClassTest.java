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

}
