import java.security.SecureRandom;
import java.util.Arrays;
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
        setRandomChar();
        addWordsToPuzzle();
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
     */
    public void setWordList(){
        Scanner keyboard = new Scanner(System.in);

        for(int i=0; i<wordList.length; i++){
            int maxLength = letterArray[0].length;
            System.out.printf("Enter a word with less than %d characters: ", maxLength);
            wordList[i] = keyboard.next().toUpperCase();

            while(wordList[i].length() > maxLength){
                System.out.printf("Word must be less than %d characters.", maxLength);
                wordList[i] = keyboard.next().toUpperCase();
            }
        }
    }

    /**
     * This method populates puzzle grid with random letters.
     */
    public void setRandomChar(){
        for(int i=0; i<letterArray[0].length; i++){
            for(int j=0; j<letterArray[0].length; j++){
                int num = (int) (Math.random() * 26) + 65;
                letterArray[i][j] = (char) num;
            }
        }
    }

    /**
     * convert letterArray into String
     * @return puzzle as type String
     */
    public String convertToString(){
        char[][] chars = letterArray;
        StringBuilder sb = new StringBuilder();
        for (char[] ch : chars){
            sb.append(ch);
        }
        return sb.toString();
    }
    /**
     * method to get word search grid for printing
     * @return word search grid as String
     */
    public void getWordSearch(){

        for (char[] chars : letterArray) {
            for (int j = 0; j < letterArray.length; j++) {
                System.out.printf("%5s", chars[j]);
            }
            System.out.println();
        }
    }

    /**
     * method to print the word list
     */
    public void getWordList(){
        System.out.println("The words to find:");
        for(int i=0;i<wordList.length;i++){
            System.out.printf("%-5s\n", wordList[i]);
        }
    }

    /**
     * method to add the word list to the puzzle grid
     */
    public void addWordsToPuzzle(){
        SecureRandom rng = new SecureRandom();
        for(int i=0;i<letterArray.length;i++){
            int maxStart = letterArray[i].length - (wordList[i].length()-1);
            int num = rng.nextInt(maxStart);
            for(int j=0;j<wordList[i].length();j++){
                letterArray[i][j + num] = wordList[i].charAt(j);
            }
        }
    }
}


