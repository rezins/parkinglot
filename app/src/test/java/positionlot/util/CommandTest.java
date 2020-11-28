package positionlot.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import positionlot.util.Command;

import java.util.List;

public class CommandTest {

    Command cmd = new Command();
    List<String> list = cmd.getList();

    @Test
    @DisplayName(value = "Test Command Index 0")
    void getCommandIdx0(){
        String strIdx0 = list.get(0);
        assertEquals("create_parking_lot", strIdx0, "Command pertama : create_parking_lot");
    }

    @Test
    @DisplayName(value = "Test Command Index 1")
    void getCommandIdx1(){
        String strIdx1 = list.get(1);
        assertEquals("park", strIdx1, "Command kedua : park");
    }

    @Test
    @DisplayName(value = "Test Command Index 2")
    void getCommandIdx2(){
        String strIdx2 = list.get(2);
        assertEquals("leave", strIdx2, "Command ketiga : leave");
    }

    @Test
    @DisplayName(value = "Test Command Index 3")
    void getCommandIdx3(){
        String strIdx3 = list.get(3);
        assertEquals("status", strIdx3, "Command keempat : status");
    }

    @Test
    @DisplayName(value = "Test Command Index 4")
    void getCommandIdx4(){
        String strIdx4 = list.get(4);
        assertEquals("registration_numbers_for_cars_with_colour", strIdx4, "Command keempat : registration_numbers_for_cars_with_colour");
    }

    @Test
    @DisplayName(value = "Test Command Index 5")
    void getCommandIdx5(){
        String strIdx5 = list.get(5);
        assertEquals("slot_numbers_for_cars_with_colour", strIdx5, "Command keempat : slot_numbers_for_cars_with_colour");
    }

    @Test
    @DisplayName(value = "Test Command Index 6")
    void getCommandIdx6(){
        String strIdx6 = list.get(6);
        assertEquals("slot_number_for_registration_number", strIdx6, "Command keempat : slot_number_for_registration_number");
    }

    @Test
    @DisplayName(value = "Test Command Index 7")
    void getCommandIdx7(){
        String strIdx7 = list.get(7);
        assertEquals("exit", strIdx7, "Command keempat : exit");
    }


}
