public class Die {
    private String name;    // Die name
    private int numOfSides; // Number of sides of the die
    private int upSide;     // Current up side of the die

    // Default constructor to create a "d6" die of 6 sides with a random up side
    public Die() {
        this.name = "d6";
        this.numOfSides = 6;
        roll();
    }

    // Constructor to create a die of a given number of sides named "d{numOfSides}" with a random
    // up side
    public Die(int numOfSides) {
        this.name = "d" + numOfSides;
        this.numOfSides = numOfSides;
        roll();
    }

    // Constructor to create a die with a given name and a number of sides with a random up side
    public Die(String name, int numOfSides) {
        this.name = name;
        this.numOfSides = numOfSides;
        roll();
    }

    // Die name getter
    public String getName() {
        return name;
    }
    // Die name setter
    public void setName(String name) {
        this.name = name;
    }

    // Die number of sides getter
    public int getNumOfSides() {
        return numOfSides;
    }
    // Die number of sides setter
    public void setNumOfSides(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    // Die up side getter
    public int getUpSide() {
        return upSide;
    }
    // Die up side setter
    public void setUpSide(int upSide) {
        this.upSide = upSide;
    }

    // Roll the die and save the current up side result
    public void roll() {
        // Generate random integer from 1 to {numOfSides}
        this.upSide = (int)(Math.random() * this.numOfSides + 1);
    }
}
