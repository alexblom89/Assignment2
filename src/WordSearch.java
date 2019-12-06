import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Formatter;
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
            wordList[i] = keyboard.next().toUpperCase().trim();

            while(wordList[i].length() > maxLength || wordList[i].length() < 2){
                System.out.printf("Word must be between 2 and %d characters.\n", maxLength);
                System.out.printf("Enter a word with less than %d characters: ", maxLength);
                wordList[i] = keyboard.next().toUpperCase().trim();
            }

            //Doesn't quite work properly...
//            while(wordList[i].contains(" ")){
//                System.out.println("Word must not contain spaces.\n");
//                System.out.printf("Enter a word with less than %d characters: ", maxLength);
//                wordList[i] = keyboard.next().toUpperCase().trim();
//            }

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
     * @param puzzle
     * @return puzzle as type String
     */
    public String convertSearchToString(char[][] puzzle) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                s.append(puzzle[i][j]);
                s.append("     ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * convert wordList into String
     * @param words
     * @return wordList as type String
     */
    public String convertWordListToString(String[] words){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            s.append(words[i]);
            s.append("\n");
        }
        return s.toString();
    }
    /**
     * method to get word search grid for printing
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

    /**
     * method to write word search grid and word list to .txt file
     */
    public void writeToFile() {
            try {
            Formatter outputFile = new Formatter("puzzle.txt");
            outputFile.format(convertSearchToString(letterArray));
            outputFile.format("\nThe words to find:\n");
            outputFile.format(convertWordListToString(wordList));
            outputFile.close();
        }
            catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


