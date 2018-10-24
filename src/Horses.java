import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.math.*;

public class Horses {
    public static void main(String[] args) throws IOException{
        int x, x1, y, y1, OY, OX;

        try(FileReader file = new FileReader("input.txt")) {
            BufferedReader buffer = new BufferedReader(file);
            String s = buffer.readLine();

            int[] bufferInt = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            OX = bufferInt[0];
            OY = bufferInt[1];
            x = bufferInt[2];
            y = bufferInt[3];
            x1 = bufferInt[4];
            y1 = bufferInt[5];
        }catch(IOException e){
            OY = OX = 8;
            System.out.print("Exception while trying to open file! Initial field " +
                    "size has been set at 8x8");
            System.out.print("Please, set initial position of arriving and destination cells>>");
            BufferedReader initialization = new BufferedReader(new InputStreamReader(System.in));
            x = Integer.parseInt(initialization.readLine());
            y = Integer.parseInt(initialization.readLine());
            x1 = Integer.parseInt(initialization.readLine());
            y1 = Integer.parseInt(initialization.readLine());
        }
        BigDecimal timeStart = new BigDecimal(System.nanoTime());
        Field field = new Field(OX, OY, x, y, x1, y1);
        BigDecimal nanos = new BigDecimal(System.nanoTime()).subtract(timeStart);
        BigDecimal seconds = nanos.divide(new BigDecimal(1e+9));

        FileWriter file = new FileWriter("output.txt");

        file.write(field.toString());
        file.close();

        System.out.println(field.toString());
        System.out.println(seconds + " seconds passed");
        //field.printField();
    }
}