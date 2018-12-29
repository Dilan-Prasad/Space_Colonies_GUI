package spacecolonies;

/**
 * Skills class
 * 
 * @author Dilan Prasad
 * @version 11/14/2018
 */
public class Skills {

    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * Skills main constructor
     * 
     * @param ag
     *            agriculture trait
     * @param med
     *            medicine trait
     * @param tech
     *            technology trait
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * Returns toString representation of a skills object
     * 
     * @return String representation of skill
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("A: ");
        sb.append(this.getAgriculture());
        sb.append("\n");
        sb.append("M: ");
        sb.append(this.getMedicine());
        sb.append("\n");
        sb.append("T: ");
        sb.append(this.getTechnology());
        return sb.toString();
    }


    /**
     * Get agriculture trait value
     * 
     * @return int agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * Get medicine trait value
     * 
     * @return int medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * Get technology trait value
     * 
     * @return int technology
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * Return true if all attributes of "this" are less than
     * the parameter skill's attributes
     * 
     * @param other
     *            skills being compared to "this"
     * @return boolean
     */
    public boolean isBelow(Skills other) {
        return (this.getAgriculture() <= other.getAgriculture() && this
            .getMedicine() <= other.getMedicine() && this
                .getTechnology() <= other.getTechnology());
    }


    /**
     * Returns true if the two skills have the same value
     * for all three traits
     * 
     * @param obj
     *            being compared to for equality
     * @return boolean based off if the two are equal or not
     */
    public boolean equals(Object obj) {
        return (this.getAgriculture() == ((Skills)obj).getAgriculture() && this
            .getMedicine() == ((Skills)obj).getMedicine() && this
                .getTechnology() == ((Skills)obj).getTechnology());
    }
}
