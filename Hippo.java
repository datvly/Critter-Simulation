import java.awt.Color;
import java.util.Random;

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

//Create the hippo critter
public class Hippo extends Critter{

    private static final int AMOUNT_OF_MOVEMENT = 5;
    private static final Direction[] DIRECTION_ARRAY = {Direction.NORTH, Direction.SOUTH,
                                                        Direction.EAST, Direction.WEST};
    private int amountOfTimeMoving;
    private int amountOfTimeHungry;
    private Direction myDirection;


    //Construct that the hippo will be hungry and move in random direction
    public Hippo (int hunger) {
        amountOfTimeHungry = hunger;
        myDirection = getDirectionRandomly ();
    }


    //Is hippo hungry? If it is more than 0 then hippo ate
    private boolean isHungry(int hunger) {
        return (amountOfTimeHungry > 0);
    }


    //Get a random direction
    private Direction getDirectionRandomly () {
        Random r = new Random();
        int randomDirection = r.nextInt(DIRECTION_ARRAY.length);
        return DIRECTION_ARRAY[randomDirection];
    }


    //Hippo will keep eating until it reaches 0;
    public boolean eat() {
        if (isHungry(amountOfTimeHungry)) {
            amountOfTimeHungry--;
            return true;
        }
        return false;
    }


    //Hippo will scratch if hungry but pounces if not
    public Attack fight(String opponent) {
        return isHungry(amountOfTimeHungry) ? Attack.SCRATCH : Attack.POUNCE;
    }


    //Hippo will be gray if hungry but white if not
    public Color getColor() {
        return isHungry(amountOfTimeHungry) ? Color.GRAY : Color.WHITE;

    }


    //We get a new direction while the direction is equal to the previous
    public Direction getMove() {
        if (amountOfTimeMoving == AMOUNT_OF_MOVEMENT) {
            amountOfTimeMoving = 0;  //reset our moving
            Direction myNewDirection = getDirectionRandomly ();
            myDirection = myNewDirection;
        }
        amountOfTimeMoving++;
        return myDirection;
    }


    //The hippo show up as the amount hippo ate
    public String toString() {
        return (amountOfTimeHungry + " ");
    }


}
