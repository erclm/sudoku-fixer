# sudoku-fixer
this application fixes sudoku grids

## stuff used
this uses Java and Java threads.

https://www.geeksforgeeks.org/intstream-anymatch-java-examples/

Uses Java8 lambda and IntStream operations.

## known shortcomings
if fed a sudoku file that is completely, just immesurrably wrong, then the program will not yield in expected results; it will not fully solve a sudoku for you. This program is a merely a fixer for minor errors.

This program does not have the most ideal runtime - after reseach, it seems that the lambda expressions supported in java8 is indeed helpful and convenient, but it's not performance friendly. 

After making this, it seems that the subgrid checker is not that useful, because after all, you're just using rows and columns to fix or show the errors. It might be more accurate if all of the checks for a grid is done at once, and fixes the grid, and moves on to the next one - this will actually solve the sudoku in linear form. 
