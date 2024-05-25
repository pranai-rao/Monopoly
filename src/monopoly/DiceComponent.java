package monopoly;

import javax.swing.*;
import java.awt.*;

public class DiceComponent extends BoardComponent {
    private final String[] images;
    private String die1;
    private String die2;

    public DiceComponent(int x, int y, int width, int height, String[] images) {
        super(x, y, width, height, images[0], true);
        this.images = images;
        die1 = images[0];
        die2 = images[0];
        rollDice();
    }

    // TODO: Does this need to know the player?
    public void rollDice() {
        Dice.roll();
        int[] roll = Dice.getLastRoll();
        die1 = images[roll[0] - 1];
        die2 = images[roll[1] - 1];
    }


    public void paint(Graphics g, Panel p) {
        g.drawImage(new ImageIcon(die1).getImage(), super.getX(), super.getY(), super.getWidth() / 2, super.getHeight(), p);
        g.drawImage(new ImageIcon(die2).getImage(), super.getX() + super.getWidth() / 2, super.getY(), super.getWidth() / 2, super.getHeight(), p);
    }
}
