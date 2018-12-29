package spacecolonies;

/**
 * Test methods in the Skills class
 * 
 * @author Dilan Prasad 906134586
 * @version 2018.11.24
 */
public class SkillsTest extends student.TestCase {

    private Skills skillTester;


    /**
     * Sets up our Skills object used for testing
     */
    public void setUp() {
        skillTester = new Skills(3, 4, 5);
    }


    /**
     * Tests getAgriculture() method
     */
    public void testGetAgriculture() {
        assertEquals(3, skillTester.getAgriculture());
    }


    /**
     * Tests getMedicine() method
     */
    public void testGetMedicine() {
        assertEquals(4, skillTester.getMedicine());
    }


    /**
     * Tests getTechnology() method
     */
    public void testGetTechnology() {
        assertEquals(5, skillTester.getTechnology());
    }


    /**
     * Tests isBelow when returned TRUE
     */
    public void testIsBelow() {
        Skills higherSkill = new Skills(5, 5, 5);
        assertTrue(skillTester.isBelow(higherSkill));
    }


    /**
     * Tests isBelow when returned FALSE
     */
    public void testIsBelow2() {
        Skills lowerSkill1 = new Skills(5, 5, 1);
        Skills lowerSkill2 = new Skills(5, 1, 5);
        Skills lowerSkill3 = new Skills(1, 5, 5);

        assertFalse(skillTester.isBelow(lowerSkill1));
        assertFalse(skillTester.isBelow(lowerSkill2));
        assertFalse(skillTester.isBelow(lowerSkill3));

    }


    /**
     * Test equals when returned TRUE
     */
    public void testEquals() {
        Skills equals = new Skills(3, 4, 5);

        assertTrue(skillTester.equals(equals));
    }


    /**
     * Tests equals when returned FALSE
     */
    public void testEquals2() {
        Skills comp1 = new Skills(3, 5, 5);
        Skills comp2 = new Skills(5, 5, 5);
        Skills comp3 = new Skills(3, 4, 4);

        assertFalse(skillTester.equals(comp1));
        assertFalse(skillTester.equals(comp2));
        assertFalse(skillTester.equals(comp3));
    }


    /**
     * Tests toString() method
     */
    public void testToString() {
        assertEquals("A: 3\n" + "M: 4\n" + "T: 5", skillTester.toString());
    }
}
