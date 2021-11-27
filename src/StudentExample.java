

import java.util.Arrays;
import java.util.Comparator;

/**
 *  The {@code Student} class is an immutable data type to encapsulate a
 *  student name and section number. It is used to illustrate various
 *  comparators.
 *  <p>
 *  For additional documentation, 
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class StudentExample {
   
    public static final Comparator<StudentExample> NAME_ORDER    = new NameOrder();

    /**
     *  A comparator for comparing students in ascending order by section number.
     */
    public static final Comparator<StudentExample> SECTION_ORDER = new SectionOrder();

    private final String name;
    private final int section;


    /**
     * Initializes a new student from the given arguments.
     *
     * @param  name the name of this student
     * @param  section the section number of this student
     */
    public StudentExample(String name, int section) {
        this.name = name;
        this.section = section;
    }

    /**
     * Returns a comparator for comparing students in lexicographic order by name.
     *
     * @return a {@link Comparator} for comparing students in lexicographic order by name
     */
    private static Comparator<StudentExample> byNameOrder() {
        return new NameOrder();
    }

    /**
     * Returns a comparator for comparing students in numerical order by section.
     *
     * @return a {@link Comparator} for comparing students in numerical order by section
     */
    private static Comparator<StudentExample> bySectionOrder() {
        return new SectionOrder();
    }

    // compare students by names, starting at this student's name
    // and wrapping around alphabetically
    private Comparator<StudentExample> byRelativeNameOrder() {
        return new RelativeNameOrder();
    }

    // comparator to sort by name
    private static class NameOrder implements Comparator<StudentExample> {
        public int compare(StudentExample a, StudentExample b) {
            return a.name.compareTo(b.name);
        }
    }

    // comparator to sort by section
    private static class SectionOrder implements Comparator<StudentExample> {
        public int compare(StudentExample a, StudentExample b) {
            return a.section - b.section;
        }
    }

    // comparator to sort by name with this name first
    // illustrates the use of a non-static comparator
    private class RelativeNameOrder implements Comparator<StudentExample> {
        public int compare(StudentExample a, StudentExample b) {
            if (a.name.compareTo(b.name) == 0) return 0;
            if (a.name.compareTo(name) == 0) return -1;
            if (b.name.compareTo(name) == 0) return +1;
            if ((a.name.compareTo(name) < 0) && (b.name.compareTo(name) > 0))
                return +1;
            if ((a.name.compareTo(name) > 0) && (b.name.compareTo(name) < 0))
                return -1;
            return a.name.compareTo(b.name);
        }
    }

    /**       
     * Compares this student to the specified student.
     *       
     * @param  other the other student
     * @return {@code true} if this student equals {@code other};
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        StudentExample that = (StudentExample) other;
        return (this.section == that.section) && (this.name.equals(that.name));
    }

    @Override
    public int hashCode() {
        return 31*section + name.hashCode();
    }

    @Override
    public String toString() {
        return section + " " + name;
    }


    /**
     * Unit tests the {@code Student} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // create an array of students
        StudentExample alice  = new StudentExample("Alice",  2);
        StudentExample bob    = new StudentExample("Bob",    1);
        StudentExample carol  = new StudentExample("Carol",  2);
        StudentExample dave   = new StudentExample("Dave",   1);
        StudentExample eve    = new StudentExample("Eve",    2);
        StudentExample frank  = new StudentExample("Frank",  3);
        StudentExample grant  = new StudentExample("Grant",  1);
        StudentExample helia  = new StudentExample("Helia",  3);
        StudentExample isaac  = new StudentExample("Isaac",  3);
        StudentExample jen    = new StudentExample("Jen",    1);
        StudentExample kevin  = new StudentExample("Kevin",  1);
        StudentExample larry  = new StudentExample("Larry",  2);
        StudentExample[] students = {
            larry, kevin, jen, isaac, grant, helia,
            frank, eve, dave, carol, bob, alice
        };

        // sort by name and print results
        StdOut.println("By name");
        StdOut.println("----------");
        Arrays.sort(students, StudentExample.byNameOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();


        // now, sort by section and print results
        StdOut.println("By section");
        StdOut.println("----------");
        Arrays.sort(students, StudentExample.bySectionOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();

        // now, sort by name relative to Kevin
        StdOut.println("By Kevin");
        StdOut.println("----------");
        Arrays.sort(students, kevin.byRelativeNameOrder());
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();

        StudentExample ali = new StudentExample("Alice", 3);
        String fred = "Fred";

        StdOut.println("alice == ali:        " + (alice == ali));
        StdOut.println("alice.equals(ali):   " + (alice.equals(ali)));
        StdOut.println("alice.equals(bob):   " + (alice.equals(bob)));
        StdOut.println("alice.equals(fred):  " + (alice.equals(fred)));

    }

}
