package monopoly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static monopoly.Constants.BoardConstants;
import static monopoly.Constants.PropertyConstants.propertyList;

public class Panel extends JPanel implements ActionListener, ItemListener, MouseListener, MouseMotionListener {
    int width, height;

    private int mouseX = 0, mouseY = 0;
    private static Queue<Player> playerQueue;
    private static final LinkedList<Player> playerList = new LinkedList<>();

    private static final HashMap<Player, BoardComponent> playersOnProperty = new HashMap<>();

    // Buttons and text fields

    public Panel(int width, int height) {
        this.width = width;
        this.height = height;
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        addMouseMotionListener(this);
        addMouseListener(this);
        shuffleDecks();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int playersPrinted = 0;
        int propertiesPrinted = 0;
        for (Player player : playerList) {
            g.setColor(Color.BLACK);
            g.setFont(BoardConstants.playerFont);
            g.drawString(player.getName() + ": $" + player.getCash(), BoardConstants.playerStatsX, propertiesPrinted * BoardConstants.propertyPadding + BoardConstants.playerStatsPadding * playersPrinted + BoardConstants.playerStatsY);
            playersPrinted++;
            for (Property property : propertyList) {
                if (player.equals(property.getOwner())) {
                    int y = propertiesPrinted * BoardConstants.propertyPadding + BoardConstants.playerStatsPadding * (playersPrinted - 1) + BoardConstants.playerStatsY;
                    g.drawRect(BoardConstants.playerStatsX + 15, y + 5, BoardConstants.propertySquareDimensions, BoardConstants.propertySquareDimensions);
                    g.setColor(property.getColor());
                    g.fillRect(BoardConstants.playerStatsX + 15, y + 5, BoardConstants.propertySquareDimensions, BoardConstants.propertySquareDimensions);
                    g.setColor(Color.BLACK);
                    g.setFont(BoardConstants.propertyFont);
                    g.drawString(property.getName(), BoardConstants.playerStatsX + 30, y + 17);
                    propertiesPrinted++;
                }
            }
        }
//        g.setFont(BoardConstants.playerFont);
//        int playersPrinted = 0;
//        int propertiesPrinted = 0;
//        for (Player player : playerList) {
//            g.setColor(Color.BLACK);
//            g.drawString(player.getName() + ": " + "$" + player.getCash(), BoardConstants.playerStatsX, BoardConstants.playerStatsY);
//            playersPrinted++;
//            for (Property p : player.getPropertiesOwned()) {
//                int propertyY = BoardConstants.playerStatsY + BoardConstants.propertyPadding + BoardConstants.playerStatsPadding * (playersPrinted - 1) + BoardConstants.propertyPadding * propertiesPrinted;
//                g.setColor(Color.BLACK);
//                g.drawRect(BoardConstants.playerStatsX, propertyY, BoardConstants.propertySquareDimensions, BoardConstants.propertySquareDimensions);
//                g.setColor(p.getColor());
//                g.fillRect(BoardConstants.playerStatsX, propertyY, BoardConstants.propertySquareDimensions, BoardConstants.propertySquareDimensions);
//                g.setFont(BoardConstants.propertyFont);
//                g.setColor(Color.BLACK);
//                g.drawString(p.getName(), BoardConstants.playerStatsX + 15, propertyY + 12);
//                propertiesPrinted++;
//            }
//        }
        for (BoardComponent bc : BoardConstants.components) bc.paint(g, this);
        BoardConstants.dice.paint(g, this);
        for (Player player : playerQueue) player.getToken().paint(g, this);
    }

    // Mouse Listener Stuff
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        for (BoardComponent bc : BoardConstants.components) {
            if (bc.isTouching(mouseX, mouseY)) {
                bc.launchOptions();
            }
        }
        if (BoardConstants.dice.isTouching(mouseX, mouseY)) {
            if (BoardConstants.sameTurnOverride) {
                BoardConstants.sameTurnOverride = false;
                System.out.println(playerQueue);
                BoardConstants.dice.rollDice();
                getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + Dice.getSumLastRoll());
            }
            else {
                //noinspection DuplicatedCode
                if (!(Arrays.equals(Dice.getLastRoll(), new int[]{1, 1}) ||
                        Arrays.equals(Dice.getLastRoll(), new int[]{2, 2}) ||
                        Arrays.equals(Dice.getLastRoll(), new int[]{3, 3}) ||
                        Arrays.equals(Dice.getLastRoll(), new int[]{4, 4}) ||
                        Arrays.equals(Dice.getLastRoll(), new int[]{5, 5}) ||
                        Arrays.equals(Dice.getLastRoll(), new int[]{6, 6}))) {
                    nextPlayer();
                } else {
                    if (getCurrentPlayer().increaseDoubleCount() == 3) {
                        getCurrentPlayer().goToJail();
                    }
                }
                System.out.println(playerQueue);
                BoardConstants.dice.rollDice();
                getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + Dice.getSumLastRoll());
            }
        }
        repaint();
    }

    // Mouse Motion Listener Stuff
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    // Action Listener Stuff
    public void actionPerformed(ActionEvent e) {
    }

    // Item Listener Stuff
    public void itemStateChanged(ItemEvent e) {
    }

    public void setPlayerList(Queue<Player> playerQueue) {
        Panel.playerQueue = playerQueue;
        for (int i = 0; i < playerQueue.size(); i++) {
            Player p = ((LinkedList<Player>) playerQueue).get(i);
            playerList.add(p);
            playersOnProperty.put(p, BoardConstants.go);
        }
        for (int i = 0; i < playerQueue.size() - 1; i++) {
            nextPlayer();
        }
    }
    public static LinkedList<Player> getPlayerList() {
        return playerList;
    }
    public static Player getCurrentPlayer() {
        return playerQueue.peek();
    }
    public static void nextPlayer() {
        //noinspection DataFlowIssue
        playerQueue.peek().resetDoubleCount();
        playerQueue.add(playerQueue.remove());
    }
    public static HashMap<Player, BoardComponent> getPlayersOnProperty() {
        return playersOnProperty;
    }
    public static void updatePlayerPosition(Player player, BoardComponent bc) {
        playersOnProperty.replace(player, bc);
    }

    public static void shuffleDecks() {
        long seed = System.nanoTime();
        Collections.shuffle(BoardConstants.chance, new Random(seed));
        Collections.shuffle(BoardConstants.communityChest, new Random(seed));
    }
}
