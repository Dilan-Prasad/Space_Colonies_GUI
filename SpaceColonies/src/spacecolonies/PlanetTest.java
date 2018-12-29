package spacecolonies;

import java.util.Arrays;

/**
 * Tests all methods of the Planet class
 * 
 * @author Dilan Prasad
 * @version 2018.11.17
 *
 */
public class PlanetTest extends student.TestCase {
    private Planet testerPlanet;


    /**
     * Sets up our tester Planet object
     */
    public void setUp() {
        testerPlanet = new Planet("Home", 4, 4, 4, 10);
    }


    /**
     * Test setName()
     */
    public void testSetName() {
        testerPlanet.setName("Not home");
        assertEquals("Not home", testerPlanet.getName());
    }


    /**
     * Test getSkills()
     */
    public void testGetSkills() {
        Skills comp = new Skills(4, 4, 4);
        assertTrue(comp.equals(testerPlanet.getSkills()));
    }


    /**
     * Test addPerson(Person newbie) for the different cases
     */
    public void testAddPerson() {
        testerPlanet.addPerson(new Person("Jordan", 5, 5, 5, "Planet 3"));
        assertEquals(1, testerPlanet.getPopulationSize());
        assertFalse(testerPlanet.isFull());

        Planet otherTester = new Planet("Blacksburg", 2, 2, 2, 2);
        otherTester.addPerson(new Person("iPhone", 5, 5, 5, "Blacksburg"));
        otherTester.addPerson(new Person("Hokie", 2, 2, 3, "Blacksburg"));
        assertTrue(otherTester.isFull());

        Person random = new Person("Jeremy", 5, 5, 5, "Blacksburg");
        assertFalse(otherTester.addPerson(random));

        Planet newPlanet = new Planet("AirPods", 5, 5, 5, 1);
        Person poorWorker = new Person("Array", 1, 1, 1, "Home");
        assertFalse(newPlanet.addPerson(poorWorker));
    }


    /**
     * Tests getCapacity()
     */
    public void testGetCapacity() {
        assertEquals(10, testerPlanet.getCapacity());
    }


    /**
     * Tests toString() method of Planet Objects
     */
    public void testToString() {
        Planet caturn = new Planet("Caturn", 3, 2, 1, 10);
        assertEquals(
            "Caturn, population 0 (cap: 10), Requires: A >= 3, M >= 2, T >= 1",
            caturn.toString());
    }


    /**
     * Tests equals(Object obj) method of Planet class
     */
    public void testEquals() {
        Planet caturn = new Planet("Caturn", 3, 2, 1, 10);
        Planet caturnComp = new Planet("Caturn", 3, 2, 1, 10);
        assertTrue(caturn.equals(caturnComp));

        Planet saturn = new Planet("Saturn", 4, 4, 4, 5);
        Planet saturnComp = new Planet("Jupiter", 4, 4, 4, 5);
        assertFalse(saturn.equals(saturnComp));

        Planet jupiter = new Planet("Jupiter", 5, 5, 5, 5);
        Planet jupiterComp = new Planet("Jupiter", 4, 5, 5, 5);
        assertFalse(jupiter.equals(jupiterComp));

        Planet mars = new Planet("Mars", 5, 5, 5, 10);
        Planet marsComp = new Planet("Mars", 5, 5, 5, 11);
        assertFalse(mars.equals(marsComp));

        Planet pluto = new Planet("Pluto", 3, 3, 3, 5);
        Planet plutoComp = new Planet("Pluto", 3, 3, 3, 5);
        pluto.addPerson(new Person("Steve", 5, 5, 5, "Pluto"));
        assertFalse(pluto.equals(plutoComp));
    }


    /**
     * Tests comparator for the 3 outcomes
     */
    public void testCompareTo() {
        Planet lessComparator = new Planet("Less", 5, 5, 5, 9);
        assertEquals(1, testerPlanet.compareTo(lessComparator));

        Planet comparator = new Planet("Comp", 5, 5, 5, 10);
        assertEquals(0, testerPlanet.compareTo(comparator));

        Planet greaterComparator = new Planet("Greater", 5, 5, 5, 11);
        assertEquals(-1, testerPlanet.compareTo(greaterComparator));
    }


    /**
     * Tests getPopulation() method
     */
    public void testGetPopulation() {
        Planet newTester = new Planet("Mars", 4, 4, 4, 10);

        Person billGates = new Person("Bill Gates", 4, 4, 4, "Mars");

        testerPlanet.addPerson(billGates);
        newTester.addPerson(billGates);

        Person[] testerArray = testerPlanet.getPopulation();
        Person[] newTesterArray = newTester.getPopulation();

        assertTrue(Arrays.equals(testerArray, newTesterArray));
    }

}
