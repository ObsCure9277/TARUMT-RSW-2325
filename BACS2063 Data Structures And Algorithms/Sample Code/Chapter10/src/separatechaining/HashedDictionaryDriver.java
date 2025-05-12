package separatechaining;

import entity.Student;

public class HashedDictionaryDriver {

  public static void main(String[] args) {
    DictionaryInterface<Integer, Student> studentTable = new HashedDictionary<>(7);

    /*  NOTE:   Key 		Hash index
     ----		----------
     4145			1
     1234			2
     5478			4
     7888			6
     9999			3
     */
    studentTable.add(4145, new Student(4145, "Ben Tennyson", 2.5678));
    studentTable.add(1234, new Student(1234, "Dan Brown", 4.0000));
    studentTable.add(5478, new Student(5478, "Mary Lee", 3.7800));
    studentTable.add(7888, new Student(7888, "Lisa Wong", 2.9888));
    studentTable.add(9999, new Student(9999, "Jay Chou", 1.9999));
    System.out.println("\nstudentTable: \n" + studentTable);
    System.out.println("Total entries = " + studentTable.getSize());

    /*  NOTE:   Key 		Hash index
     ----		----------
     9101			1
     2332			1
     1213			2
     6787			4
     */
    System.out.println("\nAfter inserting 9101, 2332, 1213, 6787: ");
    studentTable.add(9101, new Student(9101, "Anna Lewis", 2.5678));
    studentTable.add(2332, new Student(2332, "Pete Sampras", 4.0000));
    studentTable.add(1213, new Student(1213, "Meg Ryan", 3.7800));
    studentTable.add(6787, new Student(6787, "Cat Deeley", 2.9888));
    System.out.println("\nstudentTable: \n" + studentTable);
    System.out.println("Total entries = " + studentTable.getSize());
  }
}
