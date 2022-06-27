import java.awt.*;
import java.util.Random;


//The AdamSandler will dominate the critter battlefield by countering every move insuring its victory, and
//the AdamSandler is uniquely interesting and creative by the amount of crazy color and character it displays.
//The AdamSandler is does not eat until Suhūr.
public class AdamSandler extends Critter {

    private static final Color[] COLORS_ARRAY = { Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.ORANGE};
    private static final Direction[] DIRECTION_ARRAY = {Direction.EAST, Direction.SOUTH,
                                                        Direction.WEST, Direction.NORTH}; //Different order from hippo
    private static final int AMOUNT_OF_MOVEMENT = 10;
    private static final int UNTIL_EAT = 5;
    private static final String adamsandler = "ADAMSANDLER";
    private Color myColor;
    private Direction myDirection;
    private int counter;
    private int untilSuhur;
    private int amountOfTimeMoving;
    private Random r;


    public AdamSandler () {
        r = new Random();
        myColor = getRandomColor();
        myDirection = getDirectionRandomly();
    }


    //This gets a random color
    private Color getRandomColor() {
        int randomColor = r.nextInt(COLORS_ARRAY.length);
        return COLORS_ARRAY[randomColor];
    }


    //Get a random direction
    private Direction getDirectionRandomly () {
        int randomDirection = r.nextInt(DIRECTION_ARRAY.length);
        return DIRECTION_ARRAY[randomDirection];
    }


    //AdamSandler can't eat bc of ramadan until suhur
    public boolean eat() {
        untilSuhur++;
        return (untilSuhur == UNTIL_EAT);
    }


    //Counters attack base on the critter
    public Attack fight(String opponent) {
        if (opponent.equals("%") || (opponent.equals("0"))) {  //
            return Attack.ROAR;
        } else if (opponent.equals("S")){
            return Attack.POUNCE;
        }
        return Attack.SCRATCH;
    }


    //The AdamSandler will appear changing color
    public Color getColor() {
        myColor = COLORS_ARRAY[counter];
        counter = (counter + 1) % COLORS_ARRAY.length;
        return myColor;

    }


    //Move in a random direction every certain time and not touch each other AdamSandler
    //so they don't mate until certain amount of time
    public Direction getMove() {
        if (amountOfTimeMoving % AMOUNT_OF_MOVEMENT == 0) {
            myDirection = getDirectionRandomly();
        }
      while (adamsandler.contains((getNeighbor(myDirection))) && amountOfTimeMoving < AMOUNT_OF_MOVEMENT ) {
            myDirection = getDirectionRandomly();
      }
      amountOfTimeMoving++;
      return myDirection;


    }


    //The AdamSandler will appear as changing through characters within the string ADAMSANDLER
    public String toString() {
        return adamsandler.substring(counter, counter + 1);
    }

}
