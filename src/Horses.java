import java.io.*;
import java.lang.*;
import java.util.Arrays;

public class Horses {
    public static void main(String[] args) throws IOException{
        int x, x1, y, y1, OY, OX;

        try(FileReader file = new FileReader("input.txt")) {
            BufferedReader buffer = new BufferedReader(file);
            String s = buffer.readLine();

            //Path path = Paths.get("input.txt");
            //List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

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
        long timerStart, timerEnd;
        timerStart = System.nanoTime();
        Field field = new Field(OX, OY, x, y, x1, y1);
        timerEnd = System.nanoTime();
        System.out.println(String.format("%,12d",timerEnd-timerStart) + " ns");

        long timeStart2 = System.nanoTime();
        Field field2 = new Field(OX, OY, x, y, x1, y1);
        long timeStop2 = System.nanoTime();
        System.out.print(String.format("%,12d",timeStop2-timeStart2) + " ns");

        FileWriter file = new FileWriter("output.txt");
        file.write(field.toString());
        file.close();
        System.out.println(field.toString());
        //field.printField();
    }
}