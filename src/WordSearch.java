import java.util.InputMismatchException;
import java.util.Scanner;

public class WordSearch {

    private char[][] letterArray;
    private String[] wordList;

    WordSearch(){

        int rows = getDimension("rows");
        int cols = getDimension("columns");
        letterArray = new char[rows][cols];
        wordList = new String[rows];
        setWordList();
        setRandomChar(rows, cols);

        for (int i=0; i<wordList.length; i++)
                System.out.printf("%s%s", wordList[i], (i<wordList.length-1)?", ":"\n");

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
    public void setWordList(){
        Scanner keyboard = new Scanner(System.in);

        for(int i=0; i<wordList.length; i++){
            int maxLength = letterArray[0].length;
            System.out.printf("Enter a word with less than %d characters: ", maxLength);
            wordList[i] = keyboard.next();

            while(wordList[i].length() > maxLength){
                System.out.printf("Word must be less than %d characters.", maxLength);
                wordList[i] = keyboard.next();
            }
        }
    }

    /**
     * This method populates puzzle grid with random letters.
     * @param row rows variable from constructor
     * @param col cols variable from constructor
     */
    public static void setRandomChar(int row, int col){
        char[][] grid = new char[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int num = (int) (Math.random() * 26) + 65;
                grid[row-1][col-1] = (char) num;
                System.out.print(grid[row-1][col-1]);
            }
            System.out.println();
        }
    }
}


