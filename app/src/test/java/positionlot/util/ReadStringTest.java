package positionlot.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ReadStringTest {

    ReadString readString = new ReadString();

    @Test
    @DisplayName(value = "File Not Found")
    void fileNotFound(){
        assertThrows(NullPointerException.class, () -> {
            readString.read("file_input_example.txt");
        });

    }

    @Test
    @DisplayName(value = "Result Array")
    void resultArray() throws IOException {
        String[] tmp = readString.read("file_input.txt");
        assertTrue(tmp.length > 0, "Input is not empty");

    }


}
