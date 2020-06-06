// Name: jiahui liu
// USC NetID: jliu4728
// CS 455 PA4
// Spring 2020

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   // use a hash map to store the anagram dictionary.
   // the key is string and the value is an arrayList
   private Map<String, ArrayList<String>> anagramDictionary;
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      anagramDictionary = new HashMap<>();
      File inputDictionary = new File(fileName);
      // check exception. My method is sorting the word through its characters
      // then for those anagrams, they will have the same ordered characters and I can check
      // whether they are in the ArrayList.
      try {
         Scanner scanner = new Scanner(inputDictionary);
         while (scanner.hasNext()) {
            String words = scanner.next();
            char[] characters = words.toCharArray();
            Arrays.sort(characters);
            String sortedChars = new String(characters);
            // there are two cases after word's characters sorting,
            // one has been in the ArrayList and other is not.
            // when it's not in the ArrayList, new a list and put the word in it
            // when it's in the ArrayList, add that original word in the ArrayList.
            if (!anagramDictionary.containsKey(sortedChars)) {
               ArrayList<String> newList = new ArrayList<>();
               anagramDictionary.put(sortedChars, newList);
            }
            anagramDictionary.get(sortedChars).add(words);
         }
      }catch (FileNotFoundException e) {
         throw e;
      }

   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      char[] characters = s.toCharArray();
      Arrays.sort(characters);
      String sortedChars = new String(characters);
      return new ArrayList<String>(anagramDictionary.get(sortedChars));
      //return anagramDictionary.get(sortedChars); // DUMMY CODE TO GET IT TO COMPILE
   }
   
   
}
