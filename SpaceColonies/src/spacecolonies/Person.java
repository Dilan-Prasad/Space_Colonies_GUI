package spacecolonies;

/**
 * Person class
 * 
 * @author Dilan Prasad
 * @version 11/14/2018
 */
public class Person {

    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * Main Person constructor with 5 parameters
     * 
     * @param name
     *            of person
     * @param agri
     *            agriculture trait value
     * @param medi
     *            medicine trait value
     * @param tech
     *            technology trait value
     * @param planet
     *            preferred planet
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skills(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * Gets name of Person object
     * 
     * @return name of Person
     */
    public String getName() {
        return name;
    }


    /**
     * Gets Skills object of Person
     * 
     * @return skills object
     */
    public Skills getSkills() {
        return skills;
    }


    /**
     * Gets name of preferred planet
     * 
     * @return planetPreference of Person
     */
    public String getPlanetName() {
        if (planetPreference == null) {
            return null;
        }
        else {
            return planetPreference;
        }
    }


    /**
     * Returns String representation of Person in the form
     * "Name A:* M:* T:* Wants: preferred planet"
     * or "No-Planet Name A:* M:* T:*"
     * 
     * @return String representation of the Person
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (planetPreference == null) {
            sb.append("No-Planet ");
        }
        sb.append(name + " ");
        sb.append("A:" + skills.getAgriculture());
        sb.append(" M:" + skills.getMedicine());
        sb.append(" T:" + skills.getTechnology());
        if (planetPreference != null) {
            sb.append(" Wants: " + this.getPlanetName());
        }

        return sb.toString();
    }
}
