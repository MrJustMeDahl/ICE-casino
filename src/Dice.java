import java.util.Random;

public class Dice {

    int diceSides = 6;
    public static Dice dice = new Dice();


    public int rollDice(int numberOfRolls){

        int roll = 0;
            Random rnd = new Random();
            for (int i = 0; i < numberOfRolls; i++) {
                roll += rnd.nextInt(6) + 1;

            }
            return roll;


        }


}
