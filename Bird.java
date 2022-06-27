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

//Create the bird critter
public class Bird extends Critter {

    private static final int AMOUNT_OF_MOVEMENT = 3;
    private static final Direction[] DIRECTION_ARRAY = {Direction.NORTH, Direction.SOUTH,
                                                    Direction.EAST, Direction.WEST};
    private Direction myDirection;
    private int amountOfTimeMoving;
    private int whereAmIMoving;


    //Bird starts out as flying north
    public Bird () {
        myDirection = Direction.NORTH;
    }


    //Bird does not eat
    public boolean eat() {
        return false;
    }


    //roar if opponent looks like an Ant "%", otherwise pounces
    public Attack fight(String opponent) {
        if (opponent.equals("%")) {
            return Attack.ROAR;
        }
        return Attack.POUNCE;
    }


    //The bird is blue
    public Color getColor() {
        return Color.BLUE;
    }


    // Moves 3 times depending on direction
    public Direction getMove() {
        if (amountOfTimeMoving == AMOUNT_OF_MOVEMENT) {
            amountOfTimeMoving = 0;  //reset our moving
            myDirection = DIRECTION_ARRAY[whereAmIMoving];
            whereAmIMoving = (whereAmIMoving + 1) % DIRECTION_ARRAY.length;
        }
        amountOfTimeMoving++;
        return myDirection;
    }


    //The string display changes depending on the direction
    public String toString() {
        if (myDirection == Direction.NORTH) {
            return "^";
        } else if (myDirection == Direction.EAST) {
            return ">";
        } else if (myDirection == Direction.SOUTH) {
            return "V";
        } else {  // We know that it is west
            return "<";
        }
    }

}
