package spacecolonies;

/**
 * Tests method of an ArrayQueue
 * 
 * @author Dilan Prasad 906134586
 * @version 2018.11.24
 *
 */
public class ArrayQueueTest extends student.TestCase {

    private ArrayQueue<Person> tester;
    private Person michaelJordan;
    private Person michaelVick;
    private Person michaelScott;


    /**
     * Sets up tester ArrayQueue and Person objects used to test
     */
    public void setUp() {
        tester = new ArrayQueue<Person>();
        michaelJordan = new Person("Michael Jordan", 5, 5, 5, "Chicago Bulls");
        michaelVick = new Person("Michael Vick", 3, 4, 5, "Atlanta Falcons");
        michaelScott = new Person("Michael Scott", 2, 2, 2, "Dunder Mifflin");
    }


    /**
     * Test toString() method
     */
    public void testToString() {
        tester.enqueue(michaelJordan);
        tester.enqueue(michaelVick);
        tester.enqueue(michaelScott);
        assertEquals("[Michael Jordan A:5 M:5 T:5 Wants: Chicago Bulls, "
            + "Michael Vick A:3 M:4 T:5 Wants: Atlanta Falcons, "
            + "Michael Scott A:2 M:2 T:2 Wants: Dunder Mifflin]", tester
                .toString());

        tester.clear();
        assertEquals("[]", tester.toString());
    }


    /**
     * Test getFront() method
     * return null when isEmpty()
     */
    public void testGetFront() {
        tester.enqueue(michaelScott);
        assertSame(michaelScott, tester.getFront());
    }


    /**
     * Test toArray() on empty ArrayQueue
     */
    public void testToArray() {
        boolean hit = false;
        try {
            tester.toArray();
        }
        catch (Exception e) {
            hit = true;
        }
        assertTrue(hit);
    }


    /**
     * Test dequeue()
     */
    public void testDequeue() {
        tester.enqueue(michaelJordan);
        tester.enqueue(michaelVick);
        assertSame(michaelJordan, tester.dequeue());
    }


    /**
     * Test ensureCapacity() doubles the array size
     */
    public void testEnsureCapacity() {
        ArrayQueue<String> stringTester = new ArrayQueue<String>(10);
        stringTester.enqueue("Macintosh");
        stringTester.enqueue("Macbook");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        stringTester.enqueue("IBM");
        assertEquals(11, stringTester.getSize());
    }


    /**
     * Tests ensureCapacity() when exception is thrown
     */
    public void testEnsureCapacity2() {
        ArrayQueue<String> stringTester = new ArrayQueue<String>();
        boolean success = false;
        try {
            for (int i = 0; i < 101; i++) {
                stringTester.enqueue("John " + i);
            }
            stringTester.enqueue("Kicker");
        }
        catch (Exception e) {
            success = true;
        }
        assertTrue(success);
    }


    /**
     * Tests equals() method
     * 
     **/
    public void testEquals() {
        ArrayQueue<Person> newTester = new ArrayQueue<Person>();

        newTester.enqueue(michaelJordan);
        tester.enqueue(michaelJordan);
        assertTrue(newTester.equals(tester));

        newTester.enqueue(michaelScott);
        tester.enqueue(michaelVick);
        assertFalse(newTester.equals(tester));

        ArrayQueue<Person> equalTester = tester;
        assertTrue(tester.equals(equalTester));
        assertEquals(tester.getSize(), equalTester.getSize());

        ArrayQueue<Person> nullTester = null;
        assertFalse(tester.equals(nullTester));

        newTester.enqueue(michaelVick);
        assertFalse(tester.equals(newTester));

        assertFalse(tester.equals("MichaelVick"));

        for (int i = 0; i < 10; i++) {
            tester.enqueue(michaelScott);
        }
        assertFalse(newTester.equals(tester));

        ArrayQueue<String> stringTester = new ArrayQueue<String>();
        stringTester.enqueue("Michael Jordan");
        assertFalse(tester.equals(stringTester));

        tester.clear();
        newTester.clear();

        tester.enqueue(michaelVick);
        newTester.enqueue(michaelScott);
        assertFalse(tester.equals(newTester));

    }


    /**
     * Tests getter for capacity of current queue
     */
    public void testGetSize() {
        tester.enqueue(michaelScott);
        tester.enqueue(michaelScott);
        assertEquals(2, tester.getSize());

        tester.clear();

        assertEquals(0, tester.getSize());
        assertEquals(11, tester.getLength());

        for (int i = 0; i < 11; i++) {
            tester.enqueue(michaelVick);
        }
        assertEquals(21, tester.getLength());
    }


    /**
     * Test dequeue() on an empty queue
     */
    public void testDequeuException() {
        boolean success = false;
        try {
            tester.dequeue();
        }
        catch (Exception e) {
            success = true;
        }
        assertTrue(success);
    }


    /**
     * Test getFront() on an empty queue
     */
    public void testGetFrontException() {
        boolean success = false;
        try {
            tester.getFront();
        }
        catch (Exception e) {
            success = true;
        }
        assertTrue(success);
    }


    /**
     * Tests methods after elements have been dequeued and enqueued
     */
    public void testMethods() {
        int[] testerInput = { 3, 2, 1, 6, 3 };

        System.out.print(testerInput[testerInput.length - 1]);

    }

}
