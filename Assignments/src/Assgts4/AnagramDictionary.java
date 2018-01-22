//Name:Zhe Jian
//USC NetID: zhejian
//CS 455 PA4
//Fall 2017
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A dictionary of all anagram sets.
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   private Map<String,ArrayList<String>> dictMap;
   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.
    * PRE: The strings in the file are unique.
    * @param fileName  the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      dictMap = new HashMap<>();
      File file = new File(fileName);
      Scanner in = new Scanner(file);
      constructMap(in);
   }

   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * @param s string to process
    * @return a list of the anagrams of s
    */

   public ArrayList<String> getAnagramsOf(String s) {
      ArrayList<String> res = dictMap.get(Rack.sortWord(s));
      if (res != null){
         return new ArrayList<String>(res);
      } else {
         return null;
      }

   }

   /**
    * construct the dictionary map from the given file and score them into the anagram dictionary
    * @param in
    */
   private void constructMap(Scanner in) {
      ArrayList<String> anagram = new ArrayList<>();
      while (in.hasNext()) {
         anagram.add(in.next());
      }
      for (int i = 0; i < anagram.size();i++) {
         String word = anagram.get(i);
         String sortedWord = Rack.sortWord(word);
         if (dictMap.containsKey(sortedWord)){
            ArrayList<String> oldValue = dictMap.get(sortedWord);
            oldValue.add(word);
            dictMap.put(sortedWord,oldValue);
         } else {
            ArrayList<String> newValue = new ArrayList<>();
            newValue.add(word);
            dictMap.put(sortedWord,newValue);
         }
      }
   }

}
