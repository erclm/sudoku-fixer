package im.ericl.sudoku;

import java.util.stream.IntStream;
import java.util.ArrayList;

public class Rows extends Thread
{
    private int[][] solution = new int[9][9];
    private ArrayList<int[]> errors = new ArrayList<>();

    public Rows(int[][] sudoku){
        solution = sudoku;
    }

    public ArrayList<int[]> getErrors(){
        return errors;
    }

    @Override
    public void run(){
        for(int i=0; i<9; i++){
            int[] row = solution[i]; //check the row
            for (int j=0; j<9; j++){
                int n = j + 1; //iterate through 1~9 to find missing number
                if (!IntStream.of(row).anyMatch(num -> num == n)){
                    int[] error = {i, n}; // {row number, missing number}
                    errors.add(error);
                }
            }
        }
    }


}