import java.io.*;
import java.lang.*;

public class Horses {
    public static void main(String[] args) throws IOException{
        Field field = new Field();
        FileWriter file = new FileWriter("output.txt");
        file.write(field.toString());
        file.close();
        field.printField();
    }
}
