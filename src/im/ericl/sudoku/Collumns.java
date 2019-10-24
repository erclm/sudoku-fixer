package im.ericl.sudoku;

import java.util.stream.IntStream;
import java.util.ArrayList;

public class Collumns extends Thread
{
    private int[][] solution = new int[9][9];
    public ArrayList<int[]> errors = new ArrayList<>();

    public Collumns(int[][] sudoku){
        solution = sudoku;
    }

    public ArrayList<int[]> getErrors(){
        return errors;
    }
    @Override
    public void run(){
        for(int i=0; i<9; i++){
            int[] column = new int[9];
            for (int j=0; j<9; j++){
                column[j] = solution[j][i];
            }

            for (int j=0; j<9; j++){//check the columns
                int n = j + 1;//1~9
                if (!IntStream.of(column).anyMatch(num -> num == n)){
                    int[] error = {i, n};//{column number, missing number}
                    errors.add(error);
                }
            }
        }
    }


}
