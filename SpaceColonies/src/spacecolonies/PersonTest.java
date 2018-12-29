package spacecolonies;

/**
 * Tests methods of Person class
 * 
 * @author Dilan Prasad
 * @version 2018.11.24
 *
 */
public class PersonTest extends student.TestCase {

    private Person testerPerson;


    /**
     * Initializes tester Person object
     */
    public void setUp() {
        testerPerson = new Person("Elon Musk", 5, 5, 5, "planet1");
    }


    /**
     * Tests getName()
     */
    public void testGetName() {
        assertEquals("Elon Musk", testerPerson.getName());
    }


    /**
     * Tests getSkills()
     */
    public void testGetSkills() {
        Skills testSkills = new Skills(5, 5, 5);
        assertTrue(testSkills.equals(testerPerson.getSkills()));
    }


    /**
     * Tests getPlanetName()
     */
    public void testGetPlanetName() {
        assertEquals("planet1", testerPerson.getPlanetName());
        Person nullPerson = new Person("Nully", 1, 1, 1, null);
        assertNull(nullPerson.getPlanetName());
    }


    /**
     * Tests toString() method on a Person object
     */
    public void testToString() {
        assertEquals("Elon Musk A:5 M:5 T:5 Wants: planet1", testerPerson
            .toString());
    }


    /**
     * Tests toString() method when planetPreference is empty
     */
    public void testToString2() {
        Person noPreference = new Person("Tim Cook", 5, 5, 5, null);
        assertEquals("No-Planet Tim Cook A:5 M:5 T:5", noPreference.toString());
    }
}
