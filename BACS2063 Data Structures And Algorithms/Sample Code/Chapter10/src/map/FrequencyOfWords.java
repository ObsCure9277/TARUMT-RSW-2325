package map;

import entity.Word;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfWords {

  private Map<String, Word> words;

  public FrequencyOfWords() {
    words = new HashMap<>();
    System.out.print("Enter text file name: ");
    Scanner scanner = new Scanner(System.in);
    String filename = scanner.next();

    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      input.useDelimiter("\\W");
      while (input.hasNext()) {
        String nextWord = input.next();
        if (words.containsKey(nextWord)) {
          words.get(nextWord).incrementCount();
        } else {
          words.put(nextWord, new Word(nextWord, 1));
        }

      }
    } catch (FileNotFoundException ex) {
      System.out.println("\nERROR: File " + filename + " not found.");
    }
  }

  public void displayFrequency() {
    Collection<Word> collection = words.values();
    Iterator<Word> it = collection.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }

  public static void main(String[] args) {
    FrequencyOfWords f = new FrequencyOfWords();
    f.displayFrequency();
  }
}
