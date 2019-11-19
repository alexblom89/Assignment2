import java.util.InputMismatchException;
import java.util.Scanner;

public class WordSearch {

    private char[][] letterArray;
    private String[] wordList;

    WordSearch(){

        letterArray = new char[15][15];

        //put a space character in every position of the gameBoard
        for (int row=0; row<letterArray.length;row++)
            for (int col=0;col<letterArray[row].length;col++)
                letterArray[row][col]=' ';
    }

    public int[] getRowCol() {
        Scanner keyboard = new Scanner(System.in);
        int rows = 0;
        int cols = 0;
        for(int i=0; i<2; i++) {
            if(i==0) {
                System.out.println("Enter the number of rows (2-15): ");
                try {
                    rows = keyboard.nextInt();
                    while (rows < 2 || rows > 15) {
                        System.out.println("Rows must be between 2 and 15 units long");
                        rows = keyboard.nextInt();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Only integers allowed.");
                } continue;
            }
            if(i==1) {
                System.out.println("Enter the number of columns (2-15): ");
                try {
                    cols = keyboard.nextInt();
                    while (cols < 2 || cols > 15) {
                        System.out.println("Columns must be between 2 and 15 units long");
                        cols = keyboard.nextInt();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Only integers allowed.");
                }
            }
        }
        return new int[] {rows, cols};
    }
}



        /*for (int x = 2; x <= columns; x++) {
            for (int y = 2; y <= rows; y++) {
                System.out.printf("%5d", x * y); //5 is used to create 5 spaces (formatting).
            }
            System.out.println();
        } */

