package monopoly;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final Token token;
    private int cash;
    private final ArrayList<Property> propertiesOwned = new ArrayList<>();
    private final ArrayList<Property> rrOwned = new ArrayList<>();
    private final ArrayList<Property> utilOwned = new ArrayList<>();
    private int location;
    private boolean isInJail = false;
    private int position = 0;
    private int doubleCount = 0;
    private int housesOwned = 0;
    private int hotelsOwned = 0;
    private int frozenAssets = 0;

    private static Panel p = null;

    public Player(String name, String image) {
        this.name = name;
        this.token = new Token(this, Constants.BoardConstants.tokenWidth, Constants.BoardConstants.tokenHeight, image);
        cash = 1500;
    }

    /**
     * Transacts money from player's balance
     * @param price Positive if player earns money, negative if player loses money
     */
    public void transaction(int price) {
        cash += price;
    }

    /**
     * Transacts money from player's balance
     * @param player The other player involved in the transaction
     * @param price Positive if earning money, negative if losing money
     */
    public void transaction(Player player, int price) {
        player.setCash(player.getCash() - price);
        cash += price;
    }

    public int getCash() {
        return cash;
    }
    public void setCash(int cash) {
        this.cash = cash;
    }

    public ArrayList<Property> getRROwned() {
        return rrOwned;
    }
    public ArrayList<Property> getUtilOwned() {
        return utilOwned;
    }

    public void addRROwned(Property property) {
        rrOwned.add(property);
    }
    public void removeRROwned(Property property) {
        rrOwned.remove(property);
    }

    public void addUtilOwned(Property property) {
        utilOwned.add(property);
    }
    public void removeUtilOwned(Property property) {
        utilOwned.remove(property);
    }

    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }

    public boolean getIsInJail() {
        return isInJail;
    }
    public void setIsInJail(boolean isInJail) {
        this.isInJail = isInJail;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        if (position > 39) {
            transaction(200);
            position -= 39;
        }
        else if (position < 0) {
            position += 39;
        }
        if (position == 30) goToJail();
        else this.position = position;

        token.setPosition();
        playerPaintComponent();
        BoardComponent bc = Constants.BoardConstants.positionMap.get(getPosition());
        Panel.updatePlayerPosition(this, bc);
        bc.launchOptions();
    }

    public void goToJail() {
        isInJail = true;
        position = 10; // Jail
        doubleCount = 0;
        token.setPosition();
        playerPaintComponent();
    }

    public Token getToken() {
        return token;
    }
    public String getName() {
        return name;
    }

    public void playerPaintComponent(){
        p.repaint();
    }

    public void setPanel(Panel p){
        Player.p = p;
    }

    public int increaseDoubleCount() {
        return ++doubleCount;
    }
    public void resetDoubleCount() {
        doubleCount = 0;
    }

    public String toString() {
        return this.name;
    }

    public int getHousesOwned() {
        return housesOwned;
    }
    public int getHotelsOwned() {
        return hotelsOwned;
    }
    public void modifyHousesOwned(int numHouses) {
        housesOwned += numHouses;
    }


    public void addPropertyOwned(Property p) {
        propertiesOwned.add(p);
    }
    public void removePropertyOwned(Property p) {
        propertiesOwned.remove(p);
    }
    public ArrayList<Property> getPropertiesOwned() {
        return propertiesOwned;
    }

    public int getNetWorth() {
        int netWorth = cash;
        for (Property property : propertiesOwned) {
            if (property instanceof Street street) {
                if (street.isHotel()) netWorth += street.getPrice() + street.getHousePrice() * 5;
                else netWorth += street.getPrice() + street.getHouses() * street.getHousePrice();
            }
            else netWorth += property.getPrice();
        }
        return netWorth;
    }
}
