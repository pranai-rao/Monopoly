package monopoly;

import java.util.Random;

public class Dice {
    private static boolean isDouble;
    private static final Die die1 = new Die();
    private static final Die die2 = new Die();

    private static int roll1;
    private static int roll2;

    public static void roll() {
        roll1 = die1.roll();
        roll2 = die2.roll();
        isDouble = roll1 == roll2;
    }

    public static int[] getLastRoll() {
        return new int[]{roll1, roll2};
    }
    public static int getSumLastRoll() {
        return roll1 + roll2;
    }

    private static class Die {
        Random random = new Random();
        private int lastRoll;
        public int roll() {
            lastRoll = random.nextInt(1, 7);
            return lastRoll;
        }
        public int getLastRoll() {
            return lastRoll;
        }
    }
}
