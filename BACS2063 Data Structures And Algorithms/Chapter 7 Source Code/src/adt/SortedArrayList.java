package adt;

/**
 * SortedArrayList.java A class that implements the ADT Sorted List using an array.
 * Note: Some methods are not implemented yet and are left as practical exercises
 *
 * @author Frank M. Carrano
 * @version 2.0
 * @param <T>
 */
public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {

  private T[] array;
  private int numberOfEntries;
  private static final int DEFAULT_CAPACITY = 25;

  public SortedArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public SortedArrayList(int initialCapacity) {
    numberOfEntries = 0;
    array = (T[]) new Comparable[initialCapacity];
  }

  public boolean add(T newEntry) {
    int i = 0;
    while (i < numberOfEntries && newEntry.compareTo(array[i]) > 0) {
      i++;
    }
    makeRoom(i + 1);
    array[i] = newEntry;
    numberOfEntries++;
    return true;
  }

  public boolean remove(T anEntry) {
    throw new UnsupportedOperationException();
  }

  public void clear() {
    numberOfEntries = 0;
  }

  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < numberOfEntries); index++) {
      if (anEntry.equals(array[index])) {
        found = true;
      }
    }
    return found;
  }

  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  public boolean isEmpty() {
    return numberOfEntries == 0;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < numberOfEntries; ++index) {
      outputStr += array[index] + "\n";
    }

    return outputStr;
  }

  private boolean isArrayFull() {
    return numberOfEntries == array.length;
  }

  private void doubleArray() {
    T[] oldList = array;
    int oldSize = oldList.length;

    array = (T[]) new Object[2 * oldSize];

    for (int index = 0; index < oldSize; index++) {
      array[index] = oldList[index];
    }
  }

  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = numberOfEntries - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = numberOfEntries - 1;

    
    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }

}
