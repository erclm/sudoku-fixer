package im.ericl.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
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

        } catch (FileNotFoundException e) {
            System.out.println("Sudoku file not found");
            return;
        }


        
        for(int i = 0;i<9;i++){
            for(int j = 0; j<9;j++){
                System.out.print(data[i][j]);
            }
            System.out.print("\n");
        }


	// write your code here
    }
}
