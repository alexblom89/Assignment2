import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WordSearch {

    private char[][] letterArray;
    //private ArrayList<String> wordList = new ArrayList<String>();


    WordSearch(){

        int rows = getDimension("rows");
        int cols = getDimension("columns");
        letterArray = new char[cols][rows];
        String[] wordList = new String[rows];
        wordList[rows-1] = setWordList(rows, cols);

        //put a space character in every position of the gameBoard
        for (rows=0; rows<letterArray.length;rows++)
            for (cols=0;cols<letterArray[rows].length;cols++)
                letterArray[rows][cols]=' ';
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
    public static String setWordList(int row, int col){
        String word = null;
        Scanner keyboard = new Scanner(System.in);

        for(int i=row; i==row; i++){
            System.out.printf("Enter a word with less than %d characters: ", col);
            word = keyboard.next();
            while(word.length() < col){
                System.out.printf("Word must be less than %d characters.", col);
                word = keyboard.next();

                //Question for Jaret: should I have the array initialized in here and return type void, or create String variable
                //and return string type into a String array in the constructor?
            }
        }
        return word;
    }
}


