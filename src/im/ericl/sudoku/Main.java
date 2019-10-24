package im.ericl.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int data[][];
        data = new int[9][9];

        /*
        * Input sudoku from file
         */
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            String line;
            String[] numbers;
            if(!scanner.hasNextLine()){
                System.out.println("Illegal file");
                return;
            }else{
                for(int i = 0;i<9;i++){
                    line = scanner.nextLine();
                    numbers = line.split(",");
                    for(int j = 0; j<9;j++){
                        data[i][j] = Integer.parseInt(numbers[j]);
                    }
                }
            }
            scanner.close();
            System.out.println("Sudoku loaded");
            for(int i = 0;i<9;i++){
                for(int j = 0; j<9;j++){
                    System.out.print(data[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        } catch (FileNotFoundException e) {
            System.out.println("Sudoku file not found");
            return;
        }

        Subgrid s = new Subgrid(data);
        Collumns c = new Collumns(data);
        Rows r = new Rows(data);

        ArrayList<int[]> subgridErrors = new ArrayList<>();
        ArrayList<int[]> columnErrors = new ArrayList<>();
        ArrayList<int[]> rowErrors = new ArrayList<>();

        try{
            s.start();
            c.start();
            r.start();

            s.join();
            c.join();
            r.join();

            subgridErrors = s.getErrors();
            columnErrors = c.getErrors();
            rowErrors = r.getErrors();

        }catch (Exception e){
            e.printStackTrace();
        }

        if(subgridErrors.size() == 0){//means no error found
            System.out.println("No errors found!");
            return;
        }else{
            for(int i = 0; i<columnErrors.size(); i++){
                int cind = columnErrors.get(i)[0];
                int rind = rowErrors.get(i)[0];
                data[rind][cind] = rowErrors.get(i)[1];
                cind++;//add 1 because array index start at 0 and 0 is not really a column, same with row
                rind++;
                System.out.println("Incorrect at row " + rind + " column " + cind);
                System.out.println("Correct at row " + rind + " column " + cind + " is " + rowErrors.get(i)[1] + "\n");
            }
        }

        System.out.println("Fixed Sudoku:");
        for(int i = 0;i<9;i++){
            for(int j = 0; j<9;j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.print("\n");
        }



	// write your code here
    }
}
