// Name: jiahui liu
// USC NetID: jliu4728
// CS 455 PA4
// Spring 2020


public class ScoreTable {
    /**
     * word is the number we are going to calculate and totalScore is the score
     * corresponding to that word.
     * use an array of size with 26 to store the corresponding score for the character
     * with the alphabet order.
     *
     */

    private String word;
    private Integer totalScore;
    private static final int[] SCORE_OF_LETTER = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    public ScoreTable(String word){
        totalScore = 0;
        // transfer the format of the word into a lower case for characters.
        this.word = word.toLowerCase();
    }

    /**
     * This method is going to get a total number of a word
     * split a word into characters and call the scoreOfletter method
     * according to the character and finally return the totalScore.
     * @return grade of that word
     */

    public Integer getTotalGrade(){
        char[] letters = word.toCharArray();
        for (char i : letters) {
            totalScore += gradeOfLetter(i);
        }
        return totalScore;
    }

    /**
     * This method is going to get each letter's point corresponding to
     * the array.
     * @param letter the every character of the word
     * @return the score of that letter
     */
    private static Integer gradeOfLetter(char letter) {
        int letterIndex = letter - 'a';
        return SCORE_OF_LETTER[letterIndex];
    }

}
