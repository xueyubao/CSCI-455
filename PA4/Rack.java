// Name: jiahui liu
// USC NetID: jliu4728
// CS 455 PA4
// Spring 2020

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
   A Rack of Scrabble tiles
 */

public class Rack {
   private String rack;

   public Rack(String rack) {
      this.rack = rack;
   }


   /**
    * this is a method to rack a word. Use a HashMap to store the
    * character and its corresponding times after racking
    * and finally return the HashMap
    * @return A Map, its key is Character and its value is an Integer
    */


   public Map<Character, Integer> getLetterAndNum() {
      Map<Character, Integer> letterAndNum = new HashMap<>();
      char[] currChars = rack.toCharArray();
      for (char currChar : currChars) {
         if (Character.isLetter(currChar)) {
            Integer num = letterAndNum.get(currChar);
            if (num == null) {
               letterAndNum.put(currChar, 1);
            }else {
               letterAndNum.put(currChar, letterAndNum.get(currChar) +1);
            }
         }
      }
      return letterAndNum;
   }

   /**
    * This a method to return all subSets of the rack.
    * Use a recursive method to get all subsets.
    * @return an ArrayList of all subSets
    */
   public ArrayList<String> subSets() {
      // the initial state of variable in that recursive method
      String unique = "";
      int startLoc = 0;
      int multiIndex = 0;
      // the multi array store the times of its corresponding character
      int[] multi = new int[getLetterAndNum().size()];
      // use Iterator traverse original Map, and it will be easier to use entrySet()
      Iterator<Map.Entry<Character, Integer>> iter = getLetterAndNum().entrySet().iterator();
      while (iter.hasNext()){
         Map.Entry<Character, Integer> entry = iter.next();
         unique = unique + entry.getKey();
         multi[multiIndex] = entry.getValue();
         multiIndex++;
      }
      return allSubsets(unique, multi, startLoc);
   }



   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      return allCombos;
   }

}
