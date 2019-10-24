package im.ericl.sudoku;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Subgrid extends Thread {
    private int[][] solution = new int[9][9];
    public ArrayList<int[]> errors = new ArrayList<>();

    public Subgrid(int[][] sudoku){
        solution = sudoku;
    }

    @Override
    public void run() {
        for(int i = 0; i<9;i++){
            int[] grid = new int[9]; //store the 3x3
            int index = 0; //index to compare
            for (int j = 0; j<3;j++){
                for(int k = 0; k<3; k++){
                    int row = ((i/3)*3)+j;
                    int column = ((i%3))+k;
                    grid[index++] = solution[row][column];
                }
            }

            for(int j = 0; j<9; j++){ //now checking grid[]
                int n = j+1; //check 1~9
                if(!IntStream.of(grid).anyMatch(num -> num == n)){
                    int[] error = {i + 1, n};
                    errors.add(error);
                }
            }
        }
    }

    public ArrayList<int[]> getErrors(){
        return errors;
    }
}

