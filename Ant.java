import java.awt.Color;

/**
 * CS312 Assignment 11.
 *
 * On MY honor, Dat Ly, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Dat Ly
 * UTEID: dl36287
 * email address: dat.ly@utexas.edu
 * Grader name: Pavan
 * Number of slip days used on this assignment: 2
 *
 */

//Create the Ant critter
public class Ant extends Critter{

    private Direction myDirection;
    private boolean east;


    //The ant will walk south if it's pass as true
    public Ant (boolean walkSouth) {
        myDirection = walkSouth ? Direction.SOUTH : Direction.NORTH;
        east = false;
    }


    //The ant will always eat
    public boolean eat() {
        return true;
    }


    //Watch out, the ant will scratch you!
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    //Ant is color red
    public Color getColor() {
        return Color.RED;
    }


    // The ant is moving alternate between south & east and north & east.
    public Direction getMove() {
        Direction result = myDirection;
        if (east) {
            result = Direction.EAST;
            east = false;
        } else {
            east = true;
        }
        return result;
    }


    // The ant is now just a simple %
    public String toString() {
        return "%";
    }




}
