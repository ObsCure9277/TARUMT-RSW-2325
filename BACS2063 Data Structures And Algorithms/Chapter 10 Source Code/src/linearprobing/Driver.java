package linearprobing;

/**
 * A driver that demonstrates the class HashedDictionary. Note: The class Name
 * overrides hashCode in a way that causes collisions for this test.
 *
 * @author Frank M. Carrano
 * @version 2.0
 */
import entity.Name;
import java.io.*;
import java.util.*;

public class Driver {

  public static void main(String[] args) {
    testDictionary();
    testHashTable();
    System.out.println("\n\nDone.");
  }  // end main

  public static void testDictionary() {
    Name dirk = new Name("Dirk", "Dexter");
    Name abel = new Name("Abel", "Baker");
    Name miguel = new Name("Miguel", "Lopez");
    Name tabbie = new Name("Tabatha", "Jones");
    Name tom = new Name("Tom", "");
    Name sam = new Name("Sam", "");
    Name reiss = new Name("Reiss", "");
    Name bette = new Name("Bette", "");
    Name carole = new Name("Carole", "");
    Name derek = new Name("Derek", "");
    Name nancy = new Name("Nancy", "");
    Name bogus = new Name("Bo", "Gus");

// create a dictionary of initial size 11
    DictionaryInterface<Name, String> nameList = new HashedDictionary<>();

    System.out.println("Create a dictionary:\n");
    System.out.println("Initial dictionary should be empty; isEmpty() returns "
            + nameList.isEmpty());

// test add		
    System.out.println("\n\nTesting add():\n");
    nameList.add(dirk, "555-1234");
    nameList.add(abel, "555-5678");
    nameList.add(miguel, "555-9012");
    nameList.add(tabbie, "555-3456");
    nameList.add(tom, "555-5555");
    nameList.add(sam, "555-7890");
    nameList.add(reiss, "555-2345");
    nameList.add(bette, "555-7891");
    nameList.add(carole, "555-7892");
    nameList.add(derek, "555-7893");
    nameList.add(nancy, "555-7894");

    System.out.println("Dictionary should not be full; isFull() returns "
            + nameList.isFull());

    System.out.println(nameList.getSize() + " (should be 11) items in dictionary, as follows:\n");
    System.out.println(nameList);

// test getValue
    System.out.println("\n\nTesting getValue():\n");
    System.out.println("\nAbel:   " + nameList.getValue(abel) + " should be 555-5678");
    System.out.println("\nSam:    " + nameList.getValue(sam) + " should be 555-7890");
    System.out.println("\nTom:    " + nameList.getValue(tom) + " should be 555-5555");
    System.out.println("\nReiss:  " + nameList.getValue(reiss) + " should be 555-2345");
    System.out.println("\nMiguel: " + nameList.getValue(miguel) + " should be 555-9012");

// test contains
    System.out.println("\n\n\nTesting contains():\n");

    if (nameList.contains(sam)) {
      System.out.println("\nSam is in dictionary - OK");
    } else {
      System.out.println("Error in contains()");
    }

    if (nameList.contains(abel)) {
      System.out.println("\nAbel is in dictionary - OK");
    } else {
      System.out.println("Error in contains()");
    }

    if (nameList.contains(miguel)) {
      System.out.println("\nMiguel is in dictionary - OK");
    } else {
      System.out.println("Error in contains()");
    }

    if (nameList.contains(tom)) {
      System.out.println("\nTom is in dictionary - OK");
    } else {
      System.out.println("Error in contains()");
    }

    if (!nameList.contains(bogus)) {
      System.out.println("\nBo Gus is not in dictionary - OK");
    } else {
      System.out.println("Error in contains()");
    }

// remove first item
    System.out.println("\n\n\nRemoving first item Dirk - Dirk's number is "
            + nameList.remove(dirk) + " should be 555-1234");

// test replacing value
    System.out.println("Replacing phone number of Reiss and Miguel:\n");
    String oldNumber = nameList.add(reiss, "555-5432");
    System.out.println("Reiss's old number " + oldNumber + " is replaced by 555-5432");
    oldNumber = nameList.add(miguel, "555-2109");
    System.out.println("Miguel's old number " + oldNumber + " is replaced by 555-2109");

    System.out.println("\n" + nameList.getSize()
            + " (should be 10) items in dictionary, as follows:\n");
    System.out.println(nameList);

// remove interior and last items
    System.out.println("\n\nRemoving interior item Reiss and last item Nancy:\n");
    nameList.remove(reiss);
    nameList.remove(nancy);

// remove Bo Gus (not in dictionary)				
    System.out.println("\nRemoving Bo Gus (not in dictionary):\n");
    String result = nameList.remove(bogus);
    if (result == null) {
      System.out.println("Bo Gus was not found in the dictionary.");
    } else {
      System.out.println("Error in remove().");
    }

    System.out.println("\n\n" + nameList.getSize()
            + " (should be 8) items in dictionary, as follows:\n");
    System.out.println(nameList);

// test clear
    System.out.println("\n\nTesting clear():\n");
    nameList.clear();

    System.out.println("Dictionary should be empty; isEmpty() returns "
            + nameList.isEmpty());
  } // testDictionary

  /**
   * Tests the hash table when no locations contain null
   */
  public static void testHashTable() {
    // declaring nameList as HashedDictionary instead of DictionaryInterface enables display method in HashedDictionary
    HashedDictionary<Name, String> nameList = new HashedDictionary<Name, String>(11);

    System.out.println("\n\n-----------------------------------------------------------------------\n");
    System.out.println("testHashTable():");

    System.out.println("Create a dictionary whose initial hash table has 11 locations:\n");
    System.out.println("Initial dictionary should be empty; isEmpty() returns " + nameList.isEmpty());

// add 5 names - rehashing will not occur, since the load factor will be < 0.5	
    System.out.println("\n\nTesting add() - add 5 names:\n");
    nameList.add(new Name("Tabatha"), "555-1234");
    nameList.add(new Name("Toni"), "555-1235");
    nameList.add(new Name("Tobbie"), "555-1236");
    nameList.add(new Name("Tabbie"), "555-1237");
    nameList.add(new Name("Tim"), "555-1238");

    System.out.println("Dictionary should not be full; isFull() returns " + nameList.isFull() + "\n");
    System.out.println("Dictionary contains " + nameList.getSize() + " (should be 5) items, as follows:\n");
    System.out.println(nameList);

    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList); // display hash table [METHOD ADDED TO CLASS FOR TESTING PURPOSES]

//    We now remove a name and add a name, so the table size remains the same. Our goal is to
//    remove null from all table locations. Then we will test the method contains() in this situation.
    System.out.println("\nRemove Tabatha, add Nancy:\n");
    nameList.remove(new Name("Tabatha"));
    nameList.add(new Name("Nancy"), "555-1239");
    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList);

    System.out.println("\nRemove Toni, add Derek:\n");
    nameList.remove(new Name("Toni"));
    nameList.add(new Name("Derek"), "555-1240");
    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList);

    System.out.println("\nRemove Tabbie, add Carole:\n");
    nameList.remove(new Name("Tabbie"));
    nameList.add(new Name("Carole"), "555-1241");
    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList);

    System.out.println("\nRemove Tobbie, add Bette:\n");
    nameList.remove(new Name("Tobbie"));
    nameList.add(new Name("Bette"), "555-1242");
    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList);

    System.out.println("\nRemove Tim, add Reiss:\n");
    nameList.remove(new Name("Tim"));
    nameList.add(new Name("Reiss"), "555-1243");
    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList);

    System.out.println("\nRemove Tim, add Miguel:\n");
    nameList.remove(new Name("Tim"));
    nameList.add(new Name("Miguel"), "555-1244");
    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList);

    System.out.println("\nRemove Bette, add Tom:\n");
    nameList.remove(new Name("Bette"));
    nameList.add(new Name("Tom"), "555-1245");
    System.out.println("\nThe hash table is:\n");
    System.out.println(nameList);

    System.out.println("\nLocate Reis, Carole, Nancy, and Zeke: ");
    if (nameList.contains(new Name("Reiss"))) {
      System.out.println("Reis is in the dictionary ");
    } else {
      System.out.println("Reis is NOT in the dictionary: ERROR ");
    }

    if (nameList.contains(new Name("Carole"))) {
      System.out.println("Carole is in the dictionary ");
    } else {
      System.out.println("Carole is NOT in the dictionary: ERROR ");
    }

    if (nameList.contains(new Name("Nancy"))) {
      System.out.println("Nancy is in the dictionary ");
    } else {
      System.out.println("Nancy is NOT in the dictionary: ERROR ");
    }

    if (nameList.contains(new Name("Zeke"))) {
      System.out.println("Zeke is in the dictionary: ERROR ");
    } else {
      System.out.println("Zeke is NOT in the dictionary ");
    }
  } // end testHashTable
}  // end Driver

