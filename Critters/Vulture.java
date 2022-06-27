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


//Create the vulture critter
public class Vulture extends Bird {

    private boolean hungry;


    //Construct that the vulture is hungry when born
    public Vulture () {
        hungry = true;

    }

    //roar if opponent looks like an Ant "%", otherwise pounces
    //After eating once the vulture is not hungry until they get into a fight.
    //After one or more fights the vulture is hungry again.
    public Attack fight(String opponent) {
        hungry = true;
        return super.fight(opponent);
    }

    //Remains hungry until they eat once
    public boolean eat() {
        if (hungry) {
            hungry = false;
            return true;
        }
        return false;
    }


    // Vulture is color black
    public Color getColor() {
        return Color.BLACK;
    }



}
