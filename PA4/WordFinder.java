// Name: jiahui liu
// USC NetID: jliu4728
// CS 455 PA4
// Spring 2020

import java.io.FileNotFoundException;
import java.util.*;

public class WordFinder {

    private static boolean STATUS = true;
    private static String DEFAULT_DICTIONARY = "sowpods.txt";
    private static String clientInput;
    private static String clientDictionary;

    /**
     * This is the main method, first we are going to check file input to see whether
     * there is an exception by calling startFile method
     * then call the startGame method
     * @param args
     */


    public static void main(String[] args) {
        clientDictionary = startFile(args);
        try{
            AnagramDictionary inputDictionary = new AnagramDictionary(clientDictionary);
            startGame(inputDictionary);
        }catch (FileNotFoundException e){
            System.out.println("Dictionary you create " + clientDictionary + " does not exist.");
            System.exit(0);
        }
    }

    /**
     * This is the method check the client's input for the dictionary
     * @param args
     * @return
     */

    private static String startFile(String[] args) {
        if (args.length != 0) {
            return args[0];
        }else {
            return DEFAULT_DICTIONARY;
        }
    }

    /**
     * The parameter is the AnagramDictionary type.
     * and if the input is not '.', we are going to process the Input
     * by calling the processingInput
     * if the input is '.', make the variable STATUS false ant it will not
     * go to that while loop.
     * and finally close the IO.
     * @param inputDictionary it is AnagramDictionary object
     */


    private static void startGame(AnagramDictionary inputDictionary){
        Scanner input = new Scanner(System.in);
        System.out.println("Type . to quit.");
        while (STATUS) {
            System.out.print("Rack? ");
            clientInput = input.nextLine();
            if (clientInput.equals(".")) {
                STATUS = false;
            }else {
                processingInput(clientInput, inputDictionary);
            }
        }
        input.close();
    }

    /**
     * This is the method to make clientInput valid, there is a possible that
     * player will input some special character such is ! @ # $ like this.
     * @param clientInput
     * @return valid format of the clientInput
     */


    private static String getValidLetters(String clientInput){
        String validLetters = "";
        for (int i = 0; i < clientInput.length(); i++) {
            if (Character.isLetter(clientInput.charAt(i))) {
                validLetters = validLetters + clientInput.charAt(i);
            }
        }
        return validLetters;
    }

    /**
     * this is a method to deal with clientInput and InputDictionary. Use the getValidLetters
     * to transfer clientInput into validInput.
     * Use a TreeMap to store the grade for each word, the key is word, its type is String
     * and the value is an integer.
     * wordList aims to store the subset for the rack object.
     * In order to get grade, call the calculateGrade method;
     * @param clientInput the word of that client input
     * @param inputDictionary the dictionary for checking the word
     */
    private static void processingInput(String clientInput, AnagramDictionary inputDictionary) {
        String validInput = getValidLetters(clientInput);
        ArrayList<String> wordsList = new ArrayList<>();
        TreeMap<String, Integer> wordGrade = new TreeMap<String, Integer>();
        Rack validRack = new Rack(validInput);
        ArrayList<String> rackCombos = validRack.subSets();
        for (int i = 0; i < rackCombos.size(); i++) {
            wordsList = inputDictionary.getAnagramsOf(rackCombos.get(i));
            if (wordsList != null) {
                for (int index = 0; index < wordsList.size(); index++) {
                    String word = wordsList.get(index);
                    Integer grade = calculateGrade(word);
                    wordGrade.put(word, grade);
                }
            }
        }
        show(wordGrade);
    }

    /**
     * this is the calculateGrade method in order to get every word's corresponding grade
     * its return is an Integer
     * @param word
     * @return Integer object and this is the grade
     */
    private static Integer calculateGrade(String word) {
        ScoreTable a = new ScoreTable(word);
        Integer score = a.getTotalGrade();
        return score;
    }

    /**
     * This is the method to show wordGrade. The wordGrade is stored in a TreeMap as mentioned before;
     * wordGrade implements Comparator interface. its firstly compare by the Grade corresponding to word
     * with a decreasing order
     * If the grade is same, it will compare by the key with alphabet order
     * @param wordGrade this is the grade for each word
     */
    private static void show(TreeMap<String, Integer> wordGrade) {
        ArrayList<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(wordGrade.entrySet());
        Collections.sort(sortedList, new ScoreSort());
        System.out.println("We can make " + wordGrade.size() + " words from \"" + clientInput + "\"");
        if (sortedList.size() != 0) {
            System.out.println("All of the words with their scores (sorted by score):");
            for (int i = 0; i < sortedList.size(); i++) {
                System.out.println(sortedList.get(i).getValue() + ": " + sortedList.get(i).getKey());
            }

        }
    }

    // this is the wordGrade sorting rule
    static class ScoreSort implements Comparator<Map.Entry<String, Integer>>{
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
            int num =  b.getValue() - a.getValue();
            if (num == 0) {
                return a.getKey().compareTo(b.getKey());
            }else {
                return num;
            }
        }
    }
}
