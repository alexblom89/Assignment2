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
        do {
            try {
                System.out.println("Enter the number of rows (2-15): ");
                rows = keyboard.nextInt();
                if (rows<2||rows>15) {
                    System.out.println("Rows must be between 2 and 15 units long");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only integers allowed.");
                keyboard.next();
            }
        } while (rows < 2 || rows > 15);

        do {
            try {
                System.out.println("Enter the number of cols (2-15): ");
                cols = keyboard.nextInt();
                if (cols<2||cols>15) {
                    System.out.println("Rows must be between 2 and 15 units long");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only integers allowed.");
                keyboard.next();
            }
        } while (cols < 2 || cols > 15);


        return new int[] {rows, cols};
    }
}


