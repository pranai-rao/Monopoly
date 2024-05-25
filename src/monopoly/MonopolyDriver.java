package monopoly;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MonopolyDriver implements ActionListener {
    public static void main(String[] args) {
        // Constructing a panel
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        DisplayWindow d = new DisplayWindow();
        Panel p = new Panel(size.width, size.height - 50);

        // Adding players via CLI using game logic
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList("Car", "Dog", "Ship", "Wheelbarrow"));
        LinkedList<Player> playerList = new LinkedList<Player>();
        int numPlayers = Integer.parseInt(input("How many players?: "));
        for (int i = 0; i < numPlayers; i++) {
            String name = input("What is your name?: ");
            for (int j = 1; j <= tokens.size(); j++) {
                System.out.println(j + ") " + tokens.get(j - 1));
            }
            int token = Integer.parseInt(input("Select a token by its number: "));
            switch (tokens.remove(token - 1)) {
                case "Car":
                    playerList.add(new Player(name, "src/monopoly/img/car.png"));
                    break;
                case "Dog":
                    playerList.add(new Player(name, "src/monopoly/img/dog.png"));
                    break;
                case "Ship":
                    playerList.add(new Player(name, "src/monopoly/img/ship.png"));
                    break;
                case "Wheelbarrow":
                    playerList.add(new Player(name, "src/monopoly/img/barrow.png"));
                    break;
            }
        }

        // Player who rolls highest goes first, then clockwise (i.e., highest roll, then by index)
        int highestRoll = 0;
        int highestRolledIndex = 0;
        for (int x = 0; x < playerList.size(); x++) {
            Dice.roll();
            if (Dice.getSumLastRoll() > highestRoll) {
                highestRoll = Dice.getSumLastRoll();
                highestRolledIndex = x;
            }
        }

        // Adding players to the queue appropriately
        Queue<Player> queue = new LinkedList<>();
        System.out.println(playerList);
        for (int y = 0; y < playerList.size(); y++) {
            int index = highestRolledIndex + y;
            if (index >= playerList.size()) index -= playerList.size();
            queue.add(playerList.get(index));
        }

        p.setPlayerList(queue);

        //noinspection DataFlowIssue
        queue.peek().setPanel(p);

        d.addPanel(p);
        d.showFrame();
    }

    // Action Listener Stuff
    public void actionPerformed(ActionEvent e) {

    }

    private static String input(String m) {
        System.out.print(m);
        return new Scanner(System.in).nextLine();
    }
}
