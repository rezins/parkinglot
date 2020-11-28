package positionlot.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadString {

    ClassLoader classLoader = getClass().getClassLoader();
    String commandString = "";

    String[] read(String fileName) {

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                commandString += line + "\n";
            }

            return commandString.split("\n");

        } catch (IOException e) {
            throw new NullPointerException();
        }
    }

}
