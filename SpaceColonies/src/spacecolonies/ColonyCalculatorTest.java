package spacecolonies;

import java.util.Arrays;

/**
 * Tests methods of the ColonyCalculator Object
 * 
 * @author Dilan Prasad 906134586
 * @version 2018.11.24
 */
public class ColonyCalculatorTest extends student.TestCase {
    private ColonyCalculator cc;

    private ArrayQueue<Person> aq;
    private Planet[] planetArray;

    private Person steveJobs;
    private Person billGates;
    private Person jeffBezos;

    private Planet planet1;
    private Planet planet3;


    /**
     * Sets up tester ColonyCalculator Object with population and applicant
     * entries
     */
    public void setUp() {
        aq = new ArrayQueue<Person>();
        steveJobs = new Person("Steve Jobs", 5, 5, 5, "Planet1");
        billGates = new Person("Bill Gates", 2, 2, 2, null);
        jeffBezos = new Person("Jeff Bezos", 1, 1, 1, null);
        aq.enqueue(steveJobs);
        aq.enqueue(billGates);
        aq.enqueue(jeffBezos);

        planet1 = new Planet("Planet1", 5, 5, 5, 10);
        Planet planet2 = new Planet("Planet2", 3, 3, 3, 8);
        planet3 = new Planet("Planet3", 2, 2, 2, 4);

        planetArray = new Planet[3];
        planetArray[0] = planet1;
        planetArray[1] = planet2;
        planetArray[2] = planet3;

        cc = new ColonyCalculator(aq, planetArray);
    }


    /**
     * Tests getPlanetIndex() method
     */
    public void testGetPlanetIndex() {
        assertEquals(0, cc.getPlanetIndex("No-Planet"));
    }


    /**
     * Tests ColonyCalculator Constructor when applicant Queue is empty
     */
    @SuppressWarnings("unused")
    public void testColonyException() {
        boolean success = false;
        ArrayQueue<Person> comp = new ArrayQueue<Person>();

        try {
            ColonyCalculator temp = new ColonyCalculator(comp, planetArray);
        }
        catch (Exception e) {
            success = true;
        }
        assertTrue(success);
    }


    /**
     * Tests getQueue() method
     */
    public void testGetQueue() {
        ArrayQueue<Person> comp = new ArrayQueue<Person>();
        comp.enqueue(steveJobs);
        comp.enqueue(billGates);
        comp.enqueue(jeffBezos);
        assertTrue(comp.equals(cc.getQueue()));
    }


    /**
     * Tests getPlanet() method
     */
    @SuppressWarnings("static-access")
    public void testGetPlanet() {
        Planet[] newPlanetArray = new Planet[3];
        newPlanetArray[0] = new Planet("Planet1", 5, 5, 5, 10);
        newPlanetArray[1] = new Planet("Planet2", 3, 3, 3, 8);
        newPlanetArray[2] = new Planet("Planet3", 2, 2, 2, 4);
        assertTrue(Arrays.equals(cc.getPlanets(), newPlanetArray));
    }


    /**
     * Tests whether applicants would be placed in the right planet
     */
    public void testGetPlanetForPerson() {
        assertSame(planet1, cc.getPlanetForPerson(steveJobs));

    }


    /**
     * Tests whether applicant would be placed in the right planet if they have
     * no preference
     */
    public void testNoPreference() {
        assertSame(planet3, cc.getPlanetForPerson(billGates));
    }


    /**
     * Test when applicant has no planet
     */
    public void testNullApplicant() {
        assertNull(cc.getPlanetForPerson(null));
        aq.clear();
        assertNull(cc.getPlanetForPerson(billGates));
    }


    /**
     * Tests accept() method
     */
    public void testAccept() {
        aq.clear();
        assertFalse(cc.accept());
    }


    /**
     * Tests reject method
     */
    public void testReject() {
        aq.clear();
        aq.enqueue(jeffBezos);
        cc.reject();
        assertTrue(aq.isEmpty());
    }


    /**
     * Tests getter for planet by number
     */
    public void testPlanetByNumber() {
        assertNull(cc.planetByNumber(0));
        assertNull(cc.planetByNumber(6));
        assertSame(planet1, cc.planetByNumber(1));

        Person nully = null;
        assertNull(cc.getPlanetForPerson(nully));
    }


    /**
     * Tests getter for String planet
     */
    public void testGetPlanetByString() {
        assertEquals(0, cc.getPlanetIndex("Planet1"));
        assertEquals(1, cc.getPlanetIndex("Planet2"));
        assertEquals(2, cc.getPlanetIndex("Planet3"));
    }


    /**
     * Tests when all planets are full
     */
    public void testAllPlanetsFull() {
        aq.clear();
        aq.enqueue(new Person("Jeremy", 5, 5, 5, "Planet3"));
        planet3.addPerson(billGates);
        planet3.addPerson(billGates);
        planet3.addPerson(billGates);
        planet3.addPerson(billGates);
        cc = new ColonyCalculator(aq, planetArray);
        cc.accept();
        assertNull(cc.getPlanetForPerson(billGates));

        Person undecided = new Person("Cant Decide", 2, 2, 2, "Planet3");
        aq.enqueue(undecided);
        assertNull(cc.getPlanetForPerson(undecided));

        Person tooLow = new Person("tl", 1, 1, 1, "Planet1");
        assertNull(cc.getPlanetForPerson(tooLow));

    }

}
