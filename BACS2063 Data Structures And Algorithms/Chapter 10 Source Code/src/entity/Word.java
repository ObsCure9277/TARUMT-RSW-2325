package entity;

public class Word {

  private String word;
  private int count;

  public Word(String word) {
    this.word = word;
    count = 0;
  }

  public Word(String word, int count) {
    this.word = word;
    this.count = count;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void incrementCount() {
    count++;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    for (int i = 0; i < word.length(); ++i) {
      hash += word.charAt(i);
    }
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Word other = (Word) obj;
    if (!this.word.equals(other.word)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("%-30s %-8d", word, count);
  }

}
