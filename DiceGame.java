/**
 Full Name: Minh Tri Le
 Student ID: A00249054

 Program Description:
 Write a class (Die.java) that closely replicates dice:
 - Data fields to describe the die
   + Type - or name(eg d20)
   + Number of sides (eg 20)
   + Current side up
 - A 0 argument constructor
   + Default type/name: "d6"; default number of sides: 6; random side up generated from the roll method
 - A 1 argument constructor
   + Number of sides is the parameter. Default type/name: "d{number of sides}" random side up generated from the roll method
 - A 2 argument constructor
   + Both the number of sides and the type are parameters; random side up generated from the roll method
 - Appropriate accessors and mutators
   + Things to consider:
     * Should you let the user change the number of sides?
     * If you can change the number of sides, should you also change the type?
   + A roll method to generate a random value
     * Your roll method can make use of built-in random functions like Math.random() or the Random class.
     * roll is a special set method that doesn't take any arguments and shouldn't return a value

 Write a class (DiceGame.java) to test your Die class:
 - Create different sized dice using each constructor
 - Roll the dice and display their results (before and after)
 - Choose one Die object and set it to show it's highest value
 - BONUS (optional): create 5 six-sided dice. Roll each Die in a loop until you get 5 of a kind. Count and display the number of rolls.

 ====================
 To use this program: Just run it to see the results.
 **/

public class DiceGame {

    public static void main(String[] args) {
        System.out.println("Creating a default d6...");
        Die d6 = new Die();

        System.out.println("Creating a d20...");
        Die d20 = new Die(20);

        System.out.println("Creating percentile die (a special d10)...");
        Die percentile = new Die("Percentile", 10);

        // Print all current up sides
        System.out.println("The current side up for " + d6.getName() + " is " + d6.getUpSide());
        System.out.println("The current side up for " + d20.getName() + " is " + d20.getUpSide());
        System.out.println("The current side up for " + percentile.getName() + " is " + percentile.getUpSide());

        System.out.println("\nTesting the roll method\n");

        // Roll d6
        System.out.println("Rolling the " + d6.getName() + "...");
        d6.roll();
        System.out.println("The new value is " + d6.getUpSide());
        // Roll d20
        System.out.println("Rolling the " + d20.getName() + "...");
        d20.roll();
        if (d20.getUpSide() < 20) {
            System.out.println("The current side up for " + d20.getName() + " is " + d20.getUpSide());
        } else {
            System.out.println("YAY! It's a " + d20.getUpSide());
        }
        // Roll Percentile
        System.out.println("Rolling the " + percentile.getName() + "...");
        percentile.roll();
        System.out.println("The new value is " + percentile.getUpSide());

        System.out.println();

        // Choose d20 Die object and set it to show it's highest value (the 20)
        System.out.println("Setting the d20 to show 20...");
        d20.setUpSide(20);
        System.out.println("The side up is now " + d20.getUpSide() + ". Finally.");

        System.out.println();

        // Create 5 six-sided dice. Roll each Die in a loop until you get 5 of a kind.
        // Count and display the number of rolls.
        System.out.println("-----");
        System.out.println("BONUS");
        System.out.println("-----");

        System.out.println("Creating 5 d6...");
        int numOfDice = 5;
        Die[] dice = new Die[numOfDice];
        for (int i = 0; i < numOfDice; ++i) {
            dice[i] = new Die();
        }

        int numOfRolls = 0;
        Boolean areAllEqual = false;    // Check if all up sides of all dice are equal
        while (!areAllEqual) {  // Keep rolling all dice until all up sides are equal
            // Roll all the dice in a row
            for (int i = 0; i < numOfDice; ++i) {
                dice[i].roll();
            }
            ++numOfRolls;   // Increase 1 roll after rolling all the dice in a row
            // Check if all up sides of all dice are equal
            for (int i = 1; i < numOfDice; ++i) {
                if (dice[i].getUpSide() != dice[i-1].getUpSide()) {
                    break;
                }
                // Reach the last die and found no difference of all up sides of all dice
                if (i == numOfDice - 1) {
                    areAllEqual = true; // Exit while loop
                }
            }
        }
        System.out.println("YAHTZEE! It took " + numOfRolls + " rolls");
    }
}
