import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WordSearch {

    private char[][] letterArray;
    private ArrayList<String> wordList = new ArrayList<String>();

    WordSearch(){

        int rows = getDimension("rows");
        int cols = getDimension("columns");
        letterArray = new char[cols][rows];

        //put a space character in every position of the gameBoard
        for (int row=0; row<letterArray.length;row++)
            for (int col=0;col<letterArray[row].length;col++)
                letterArray[row][col]=' ';
    }

    /**
     * Method to set # of rows and columns from user input.
     * @return 2D array with row and column #.
     */
    public static int getDimension(String dimension) {
        Scanner keyboard = new Scanner(System.in);
        int num = 0;

        do {
            try {
                System.out.printf("Enter the number of %s (2-15): ", dimension);
                num = keyboard.nextInt();
                if (num<2||num>15) {
                    System.out.printf("%s must be between 2 and 15 units long", dimension);
                }
            } catch (InputMismatchException e) {
                System.out.println("Only integers allowed.");
                keyboard.next();
            }
        } while (num < 2 || num > 15);

        return num;
    }

    /**
     * method to set word list array.
     * @return String word.
     */
    public static void setWordList(){
        int rows = getDimension(rows);
        String word;

        Scanner keyboard = new Scanner(System.in);

        for(int i=rows; i<rows; i++){
            System.out.printf("Enter a word with less than %d characters: ", cols);
            word = keyboard.next();
            while(word.length() > cols){
                System.out.printf("Word must be less than %d characters.", cols);
                word = keyboard.next();
            }
        }
    }
}


