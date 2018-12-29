package spacecolonies;

/**
 * Planet Class for Planet objects
 * 
 * @author Dilan Prasad 906134586
 * @version 2018.11.24
 *
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;


    /**
     * Main Planet constructor
     * 
     * @param planetName
     *            name of planet
     * @param planetAgri
     *            minimum agriculture skill
     * @param planetMedi
     *            minimum medical skill
     * @param planetTech
     *            minimum technical skill
     * @param planetCap
     *            planets capacity
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        population = new Person[capacity];
    }


    /**
     * Resets value of name
     * 
     * @param newName
     *            String of desired new name
     */
    public void setName(String newName) {
        this.name = newName;
    }


    /**
     * Gets name of Planet
     * 
     * @return String of planet's name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Returns skills required of the planet
     * 
     * @return Skills object of planet's minimum accepted skills
     */
    public Skills getSkills() {
        return minSkills;
    }


    /**
     * Returns population as array of Persons
     * 
     * @return Person array
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * Gets size of the population
     * 
     * @return size of population
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * Gets capacity of planet
     * 
     * @return size of capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Returns number of available spaces left
     * 
     * @return availability
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * Boolean to decide if Planet's population is full
     * 
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return (populationSize == capacity);
    }


    /**
     * Adds the parameterized Person to the Planet's Population[]
     * 
     * @param newbie
     *            attempting to be added into the designated Planet
     * @return boolean if person was accepted
     */
    public boolean addPerson(Person newbie) {
        if (getAvailability() > 0 && minSkills.isBelow(newbie.getSkills())) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * Returns the Planet as a string representation
     * 
     * @return String representation of Planet
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());
        sb.append(", population ");
        sb.append(populationSize);
        sb.append(" (cap: ");
        sb.append(capacity);
        sb.append("), Requires: A >= ");
        sb.append(minSkills.getAgriculture());
        sb.append(", M >= ");
        sb.append(minSkills.getMedicine());
        sb.append(", T >= ");
        sb.append(minSkills.getTechnology());
        return sb.toString();
    }


    /**
     * Checks if two planets are equal
     * They are only equal if all 5 parameters are equal
     * 
     * @param other
     *            Object being compared
     * @return boolean if the two are equal
     */
    public boolean equals(Object other) {

        if (other == null || ((Planet)other).getName() == null) {
            return false;
        }
        return this.getName() == ((Planet)other).getName() && this.getSkills()
            .equals(((Planet)other).getSkills()) && this
                .getCapacity() == ((Planet)other).getCapacity() && this
                    .getPopulationSize() == (((Planet)other)
                        .getPopulationSize());
    }


    /**
     * Comparator to rank the Planets based of availability
     * 
     * @param other
     *            Planet whose availability is being compared with
     * @return -1 if this < other, 0 if equal, 1 if this > other
     */
    public int compareTo(Planet other) {
        return Integer.compare(this.getAvailability(), other.getAvailability());
    }

}
