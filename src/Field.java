import java.io.*;
import java.lang.*;
import java.util.*;

class Field {
    private int counter = 1;
    private int x1, x2, y1, y2, N, M;
    private int[][] field;
    private String matter = "1";
    private boolean flag = true;

    Field() throws IOException{
        initialization();
        //clauseChecking();
        setWeight(x1,y1);
        while(flag) cellSearch();
    }
    private void initialization() throws IOException{
        try(FileReader file = new FileReader("input.txt")) {
            BufferedReader buffer = new BufferedReader(file);
            String s = buffer.readLine();
            int[] bufferInt = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            N = bufferInt[0];
            M = bufferInt[1];
            x1 = bufferInt[2]-1;
            y1 = bufferInt[3]-1;
            x2 = bufferInt[4]-1;
            y2 = bufferInt[5]-1;
        }catch(IOException e){
            N = M = 8;
            System.out.print("Exception while trying to open file! Initial field " +
                    "size has been set at 8x8");
            System.out.print("Please, set initial position of arriving and destination cells>>");
            BufferedReader initialization = new BufferedReader(new InputStreamReader(System.in));
            x1 = Integer.parseInt(initialization.readLine())-1;
            y1 = Integer.parseInt(initialization.readLine())-1;
            x2 = Integer.parseInt(initialization.readLine())-1;
            y2 = Integer.parseInt(initialization.readLine())-1;
        }
        if ((x1 == x2) && (y1 == y2)) {
            flag = !flag;
            matter = "0";
            return;
        }
        field = new int[M][N];
        for (int[] i: field){
            for (int j: i) j=0;
        }
        field[x1][y2] = 8;
    }
    private void clauseChecking(){
        if (((N<3) && (M<3)) || (N<2) || (M<2)){ System.out.print("Input data don't satisfy the conditions!");}
        if ((N==3) && (M==3) && ((x1!=x2) || (y1!=y2)) && (x2==y2) && (x2==2)){
            System.out.print("Input data don't satisfy the conditions!");}
    }
    private void setWeight(int x, int y){
        if ((x+2)>=0 && (x+2)<N && (y+1)>=0 && (y+1)<M && field[x+2][y+1]==0){
                field[x+2][y+1] = counter;
                if ((x+2 == x2) && (y+1 == y2)) {
                    flag = !flag;
                    return;
                }
        }
        if ((x+2)>=0 && (x+2)<N && (y-1)>=0 && (y-1)<M && field[x+2][y-1]==0){
                field[x+2][y-1] = counter;
                if ((x+2 == x2) && (y-1 == y2)){
                    flag = !flag;
                    return;
                }
        }
        if ((x+1)>=0 && (x+1)<N && (y+2)>=0 && (y+2)<M && field[x+1][y+2]==0){
                field[x+1][y+2] = counter;
                if ((x+1 == x2) && (y+2 == y2)) {
                    flag = !flag;
                    return;
                }
        }
        if ((x-1)>=0 && (x-1)<N && (y+2)>0 && (y+2)<M && field[x-1][y+2]==0){
                field[x-1][y+2] = counter;
                if ((x-1 == x2) && (y+2 == y2)){
                    flag = !flag;
                    return;
                }
        }
        if ((x-2)>=0 && (x-2)<N && (y+1)>0 && (y+1)<M && field[x-2][y+1]==0){
                field[x-2][y+1] = counter;
                if ((x-2 == x2) && (y+1 == y2)){
                    flag = !flag;
                    return;
                }
        }
        if ((x-1)>=0 && (x-1)<N && (y-2)>=0 && (y-2)<M && field[x-1][y-2]==0){
                field[x-1][y-2] = counter;
                if ((x-1 == x2) && (y-2 == y2)){
                    flag = !flag;
                    return;
                }
        }
        if ((x+1)>=0 && (x+1)<N && (y-2)>=0 && (y-2)<M && field[x+1][y-2]==0){
                field[x+1][y-2] = counter;
                if ((x+1 == x2) && (y-2 == y2)){
                    flag = !flag;
                    return;
                }
        }
        if ((x-2)>=0 && (x-2)<N && (y-1)>=0 && (y-1)<M && field[x-2][y-1]==0){
                field[x-2][y-1] = counter;
                if ((x-2 == x2) && (y-1 == y2)){
                    flag = !flag;
                    return;
                }
        }
        counter++;
        matter = Integer.toString(counter);
    }
    private void cellSearch(){
        for (int i = 0; i<M; i++) {
            for (int j = 0; j<N; j++) {
                if (field[i][j]==counter-1 && (i!=x1) && (j!=y1)) setWeight(i,j);
            }
        }
        if (counter == N*M-1) {
            matter = "Could not find a solution in " + Integer.toString(counter) + " iterations";
            flag=!flag;
        }
    }
    void printField(){
        for (int[] i: field){
            for (int j: i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

@Override
    public String toString(){
        return matter;
    }
}
