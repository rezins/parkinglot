package positionlot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadString {

    //Deklarasi Variable

    FileInputStream fis = null;
    char[] dataText = new char[2000];
    char data;
    int temp, i = 0;
    String[] splitStr;

    public String[] Read(String file_name)
    {
        try
        {
            fis = new FileInputStream("resources/" + file_name);
        }catch(FileNotFoundException e)
        {
            System.err.println("File Not Found");
        }

        try
        {

            do{
                temp = fis.read();
                data = (char) temp;
                if(temp != -1)
                {
                    //System.out.print("" + data);
                    dataText[i] = data;
                    i++;
                }
            }while(temp != -1);

        }catch(IOException ex)
        {
            System.out.println("Problem in reading from the file");
        }

        String strLine = new String(dataText);
        splitStr = strLine.split("\n");
        return splitStr;
    }

}
