import java.lang.*;


class Field {
    private int counter = 1;
    private int x, x1, y, y1, OY, OX;
    private int[][] field;
    private String matter = "1";
    private boolean done = false;
    
    Field(int OX, int OY, int x, int y, int x1, int y1){
        this.OX = OX;
        this.OY = OY;
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;

        if(isCorrect()){
            initialization();
            if(isDestination(x,y)) {
                matter = "0";
                done = true;
            }else markRelated(x, y);
        }
        while(!done) {
            counter++;
            matter = Integer.toString(counter);
            cellSearch();
        }
    }
    private void initialization(){
        field = new int[OY][OX];

        for (int[] i: field){
            for (int j: i) j=0;
        }

        field[y][x] = -1;
    }
    private boolean isCorrect(){
        if (((OY <3) && (OX <3)) || (OY <2) || (OX <2)){
            System.out.print("Input data don't satisfy the conditions!");
            return  false;
        }
        if ((OY ==3) && (OX ==3) && ((x != x1) || (y != y1)) && (x1 == y1) && (x1 ==2)){
            System.out.print("Input data don't satisfy the conditions!");
            return false;
        }
        return true;
    }
    private boolean markRelated(int x, int y){
        if ((x+2)>=0 && (x+2)< OX && (y+1)>=0 && (y+1)< OY && field[y+1][x+2]==0){
            field[y+1][x+2] = counter;
            if (isDestination(x+2, y+1)) {
                done = true;
                return true;
            }
        }
        if ((x+2)>=0 && (x+2)< OX && (y-1)>=0 && (y-1)< OY && field[y-1][x+2]==0){
            field[y-1][x+2] = counter;
            if (isDestination(x+2,y-1)){
                done = true;
                return true;
            }
        }
        if ((x+1)>=0 && (x+1)< OX && (y+2)>=0 && (y+2)< OY && field[y+2][x+1]==0){
            field[y+2][x+1] = counter;
            if (isDestination(x+1,y+2)) {
                done = true;
                return true;
            }
        }
        if ((x-1)>=0 && (x-1)< OX && (y+2)>0 && (y+2)< OY && field[y+2][x-1]==0){
            field[y+2][x-1] = counter;
            if (isDestination(x-1,y+2)){
                done = true;
                return true;
            }
        }
        if ((x-2)>=0 && (x-2)< OX && (y+1)>0 && (y+1)< OY && field[y+1][x-2]==0){
            field[y+1][x-2] = counter;
            if (isDestination(x-2,y+1)){
                done = true;
                return true;
            }
        }
        if ((x-1)>=0 && (x-1)< OX && (y-2)>=0 && (y-2)< OY && field[y-2][x-1]==0){
            field[y-2][x-1] = counter;
            if (isDestination(x-1,y-2)){
                done = true;
                return true;
            }
        }
        if ((x+1)>=0 && (x+1)< OX && (y-2)>=0 && (y-2)< OY && field[y-2][x+1]==0){
            field[y-2][x+1] = counter;
            if (isDestination(x+1,y-2)){
                done = true;
                return true;
            }
        }
        if ((x-2)>=0 && (x-2)< OX && (y-1)>=0 && (y-1)< OY && field[y-1][x-2]==0){
            field[y-1][x-2] = counter;
            if (isDestination(x-2, y-1)){
                done = true;
                return true;
            }
        }
        return false;
    }
    private void cellSearch(){
        for (int i = 0; i< OY; i++) {
            for (int j = 0; j< OX; j++) {
                if ((field[i][j]==counter-1) && ((i!= y) || (j!= x))) {
                    if (markRelated(j,i)) return;
                }
            }
        }
        if (counter == OY * OX -1) {
            matter = "Could not find a solution in " + Integer.toString(counter) + " iterations";
            done =!done;
        }
    }
    void printField(){
        for (int i = 0; i< OY; i++){
            for (int j = 0; j< OX; j++){
                if ((field[i][j] == -1) || (field[i][j]/10 > 0) ){
                    System.out.print(" " + field[i][j]);
                }
                else {
                    System.out.print("  " + field[i][j]);
                }
            }
            System.out.println();
        }
    }
    private boolean isDestination(int x, int y){
        return (x == x1) && (y == y1);
    }

@Override
    public String toString(){
        return matter;
    }
}
