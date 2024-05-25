package monopoly;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import static monopoly.Constants.BoardConstants.nullPlayer;

public class BoardComponent {
    private final int x, y, width, height;
    private final ImageIcon img;
    private Tile tile;
    private boolean isClickable = true;

    public BoardComponent(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        img = new ImageIcon(path);
    }

    public BoardComponent(int x, int y, int width, int height, String path, Tile tile) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        img = new ImageIcon(path);
        this.tile = tile;
    }

    public BoardComponent(int x, int y, int width, int height, String path, boolean isClickable) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        img = new ImageIcon(path);
        this.isClickable = isClickable;
    }

    public void paint(Graphics g, Panel p) {
        g.drawImage(img.getImage(), x, y, width, height, p);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }

    public void launchOptions() {
        if (tile instanceof Property property && Panel.getPlayersOnProperty().get(Panel.getCurrentPlayer()).equals(this)) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Close");
            if (property.isOwned() && property.getOwner().equals(Panel.getCurrentPlayer())) {
                options.add("Sell");
                if (property.isMortgaged()) options.add("Unmortgage");
                else {
                    options.add("Mortgage");
                    if (property instanceof Street) canAddImprovements(property, options);
                }
            }
            else if (property.isOwned()) {
                options.add("Rent");
            }
            else options.add("Buy");
            executeButton(options, property);
        }
        else if (tile instanceof Property property) {
            ArrayList<String> options = new ArrayList<>();
            if (property.getOwner() != null && property.getOwner().equals(Panel.getCurrentPlayer())) {
                options.add("Close");
                options.add("Sell");
                if (property.isMortgaged()) options.add("Unmortgage");
                else {
                    options.add("Mortgage");
                    if (property instanceof Street) canAddImprovements(property, options);
                }
                executeButton(options, property);
            }
        }
        else if (tile instanceof Special special){// && Panel.getCurrentPlayer().getPosition() == tile.getPosition()) {
            String card;
            switch (special.getType()) {
                case CHANCE:
                    card = Constants.BoardConstants.chance.remove(0);
                    Constants.BoardConstants.chance.add(card);
                    JOptionPane.showMessageDialog(null, "", "Chance", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(card));
                    chance(card, Panel.getCurrentPlayer());
                    break;
                case COMMUNITY:
                    card = Constants.BoardConstants.communityChest.remove(0);
                    Constants.BoardConstants.communityChest.add(card);
                    JOptionPane.showMessageDialog(null, "", "Community Chest", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(card));
                    communityChest(card, Panel.getCurrentPlayer());
                    break;
                case INCOME:
                    if ((Panel.getCurrentPlayer().getNetWorth()) * 0.1 > 200) {
                        Panel.getCurrentPlayer().transaction(-200);
                    }
                    else Panel.getCurrentPlayer().transaction((int) (Math.round(-Panel.getCurrentPlayer().getNetWorth() * 0.1)));
                    break;
                case LUXURY:
                    Panel.getCurrentPlayer().transaction(-100);
                    break;
                case JAIL:
                    String[] options;
                    if (Constants.BoardConstants.chanceGOOJ.equals(Panel.getCurrentPlayer()) || Constants.BoardConstants.commGOOJ.equals(Panel.getCurrentPlayer())) {
                        options = new String[]{"Roll Dice", "Pay $50", "Get out of Jail Free"};
                    }
                    else options = new String[]{"Roll Dice", "Pay $50"};
                    int option = JOptionPane.showOptionDialog(null, tile.getName(), tile.getName(),
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (option == 0) {
                        Dice.roll();
                        System.out.println("Rolled " + Arrays.toString(Dice.getLastRoll()));
                        //noinspection DuplicatedCode
                        if (Arrays.equals(Dice.getLastRoll(), new int[]{1, 1}) ||
                                Arrays.equals(Dice.getLastRoll(), new int[]{2, 2}) ||
                                Arrays.equals(Dice.getLastRoll(), new int[]{3, 3}) ||
                                Arrays.equals(Dice.getLastRoll(), new int[]{4, 4}) ||
                                Arrays.equals(Dice.getLastRoll(), new int[]{5, 5}) ||
                                Arrays.equals(Dice.getLastRoll(), new int[]{6, 6})) {
                            Panel.getCurrentPlayer().setIsInJail(false);
                        }
                    }
                    else if (option == 1) {
                        System.out.println("Pay $50");
                        Panel.getCurrentPlayer().transaction(-50);
                    }
                    else if (option == 2) {
                        if (Constants.BoardConstants.chanceGOOJ.equals(Panel.getCurrentPlayer())) {
                            Constants.BoardConstants.chanceGOOJ = nullPlayer;
                            Constants.BoardConstants.chance.add("src/monopoly/img/ch_jailbreak.jpg");
                        }
                        else {
                            Constants.BoardConstants.commGOOJ = nullPlayer;
                            Constants.BoardConstants.communityChest.add("src/monopoly/img/comm_jailbreak.jpg");
                        }
                    }
                    break;
            }
        }
    }

    @SuppressWarnings("DuplicateBranchesInSwitch")
    private void communityChest(String s, Player player) {
        //noinspection SwitchStatementWithoutDefaultBranch
        switch (s) {
            case "monopoly/img/comm_bank.jpg":
                player.transaction(200);
                break;
            case "monopoly/img/comm_beauty.jpg":
                player.transaction(10);
                break;
            case "monopoly/img/comm_doctor.jpg":
                player.transaction(-50);
                break;
            case "monopoly/img/comm_go.jpg":
                player.transaction(200);
                break;
            case "monopoly/img/comm_hospital.jpg":
                player.transaction(-100);
                break;
            case "monopoly/img/comm_inherit.jpg":
                player.transaction(100);
                break;
            case "monopoly/img/comm_insurance.jpg":
                player.transaction(100);
                break;
            case "monopoly/img/comm_jail.jpg":
                player.setIsInJail(true);
                player.setPosition(10);
                break;
            case "monopoly/img/comm_jailbreak.jpg":
                Constants.BoardConstants.commGOOJ = Panel.getCurrentPlayer();
                break;
            case "monopoly/img/comm_opera.jpg":
                for (Player p : Panel.getPlayerList()) {
                    player.transaction(p, 50);
                }
                break;
            case "monopoly/img/comm_repair.jpg":
                player.transaction(-40 * player.getHousesOwned());
                player.transaction(-115 * player.getHotelsOwned());
                break;
            case "monopoly/img/comm_school.jpg":
                player.transaction(-150);
                break;
            case "monopoly/img/comm_services.jpg":
                player.transaction(-25);
                break;
            case "monopoly/img/comm_stock.jpg":
                player.transaction(45);
                break;
            case "monopoly/img/comm_tax.jpg":
                player.transaction(20);
                break;
            case "monopoly/img/comm_xmas.jpg":
                player.transaction(100);
                break;
        }
    }

    private void chance(String s, Player player) {
        int position = player.getPosition();
        switch (s) {
            case "src/monopoly/img/ch_back.jpg":
                player.setPosition(player.getPosition() - 3);
                break;
            case "src/monopoly/img/ch_boardwalk.jpg":
                player.setPosition(39);
                break;
            case "src/monopoly/img/ch_buildingLoan.jpg":
                player.transaction(150);
                break;
            case "src/monopoly/img/ch_chairman.jpg":
                for (Player p : Panel.getPlayerList()) {
                    player.transaction(p, -50);
                }
                break;
            case "src/monopoly/img/ch_charles.jpg":
                if (player.getPosition() > 11) player.transaction(200);
                player.setPosition(11);
                break;
            case "src/monopoly/img/ch_dividend.jpg":
                player.transaction(50);
                break;
            case "src/monopoly/img/ch_dup.jpg":
                if (position > 35) {
                    player.transaction(200);
                    player.setPosition(5);
                }
                else if (position > 25) player.setPosition(35);
                else if (position > 15) player.setPosition(25);
                else player.setPosition(5);
                if (Constants.BoardConstants.positionMap.get(player.getPosition()).getTile() instanceof Property property) {
                    if (property.isOwned()) property.getOwner().transaction(player, property.getRent() * 2);
                }
                break;
            case "src/monopoly/img/ch_go.jpg":
                player.setPosition(0);
                player.transaction(200);
                break;
            case "monopoly/img/ch_illinois.jpg":
                player.setPosition(24);
                break;
            case "monopoly/img/ch_jail.jpg":
                player.setIsInJail(true);
                player.setPosition(10);
                break;
            case "monopoly/img/ch_jailbreak.jpg":
                Constants.BoardConstants.chanceGOOJ = Panel.getCurrentPlayer();
                Constants.BoardConstants.chance.remove("monopoly/img/ch_jailbreak.jpg");
                break;
            case "monopoly/img/ch_nearRR.jpg":
                if (position > 35) {
                    player.transaction(200);
                    player.setPosition(5);
                }
                else if (position > 25) player.setPosition(35);
                else if (position > 15) player.setPosition(25);
                else player.setPosition(5);
                if (Constants.BoardConstants.positionMap.get(player.getPosition()).getTile() instanceof Property property) {
                    if (property.isOwned() && !player.equals(property.getOwner())) property.getOwner().transaction(player, property.getRent() * 2);
                }
                break;
            case "monopoly/img/ch_poor.jpg":
                player.transaction(-15);
                break;
            case "monopoly/img/ch_reading.jpg":
                if (player.getPosition() > 5) player.transaction(200);
                player.setPosition(5);
                break;
            case "monopoly/img/ch_repairs.jpg":
                player.transaction(-25 * player.getHousesOwned());
                player.transaction(-100 * player.getHotelsOwned());
                break;
            case "monopoly/img/ch_utility.jpg":
                if (position > 28) {
                    player.transaction(200);
                    player.setPosition(12);
                }
                else if (position > 12) {
                    player.setPosition(28);
                }
                else {
                    player.setPosition(12);
                }
                if (Constants.BoardConstants.positionMap.get(player.getPosition()).getTile() instanceof Utility utility) {
                    if (utility.isOwned() && !player.equals(utility.getOwner())) {
                        Dice.roll();
                        utility.getOwner().transaction(player, Dice.getSumLastRoll() * 10);
                    }
                }
                break;
        }
    }

    private boolean canAddImprovements(Property property) {
        int i;
        boolean setIsOwned = true;
        for (i = 0; i < Constants.PropertyConstants.propertySets.size(); i++) {
            if (Constants.PropertyConstants.propertySets.get(i).contains(property)) {
                break;
            }
        }
        for (Property p : Constants.PropertyConstants.propertySets.get(i)) {
            if (p.getOwner() != Panel.getCurrentPlayer()) {
                setIsOwned = false;
                break;
            }
        }
        return setIsOwned;
    }

    private void canAddImprovements(Property property, ArrayList<String> options) {
        if (canAddImprovements(property)) options.add("Improvements");
    }

    private void sellProperty(Property property) {
        String[] players = new String[Panel.getPlayerList().size()];
        for (int x = 0; x < Panel.getPlayerList().size(); x++) {
            players[x] = Panel.getPlayerList().get(x).getName();
        }
        String purchaser = (String) JOptionPane.showInputDialog(null, "Buyer", property.getName(), JOptionPane.PLAIN_MESSAGE, null, players, players[0]);
        int price = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Price", property.getName(), JOptionPane.PLAIN_MESSAGE, null, null, property.getPrice()));
        int i;
        for (i = 0; i < Constants.PropertyConstants.propertySets.size(); i++) {
            if (Constants.PropertyConstants.propertySets.get(i).contains(property)) {
                break;
            }
        }
        for (Property p : Constants.PropertyConstants.propertySets.get(i)) {
            if (p instanceof Street s) {
                if (s.isHotel() || s.getHouses() != 0) {
                    s.demolish();
                }
            }
            for (Player player : Panel.getPlayerList()) {
                if (player.getName().equals(purchaser)) {
                    p.sellProperty(player, price);
                }
            }
        }
    }

    private void executeButton(ArrayList<String> options, Property property) {
        String[] buttonsArray = options.toArray(new String[0]);
        int returnValue = JOptionPane.showOptionDialog(null, tile.getName(), tile.getName(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttonsArray, buttonsArray[0]);
        if (returnValue > 0) {
            switch (buttonsArray[returnValue]) {
                case "Sell":
                    sellProperty(property);
                    break;
                case "Unmortgage":
                    property.liftMortgage();
                    break;
                case "Mortgage":
                    property.mortgageProperty();
                    break;
                case "Rent":
                    property.collectRent(Panel.getCurrentPlayer());
                    break;
                case "Buy":
                    property.buyProperty(Panel.getCurrentPlayer());
                    Panel.getCurrentPlayer().addPropertyOwned(property);
                    break;
                case "Improvements":
                    ArrayList<Property> improvable = new ArrayList<>();
                    for (Property p : Panel.getCurrentPlayer().getPropertiesOwned()) {
                        if (canAddImprovements(p)) {
                            improvable.add(p);
                        }
                    }
                    JOptionPane.showOptionDialog(null, "Property", "Improvements", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, improvable.toArray(), improvable.toArray()[0]);
            }
        }
    }

    /**
     * @param x The x-position of the mouse
     * @param y The y-position of the mouse
     * @return True if touching, false if not
     */
    public boolean isTouching(int x, int y) {
        return (x >= this.x && x <= this.x + width) && (y >= this.y && y <= this.y + this.height) && isClickable;
    }

    public int getX() {
        return x;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getY() {
        return y;
    }

    public String getName() {
        return tile.getName();
    }

    public Tile getTile() {
        return tile;
    }
}
