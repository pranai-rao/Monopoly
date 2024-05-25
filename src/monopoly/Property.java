package monopoly;

import java.awt.*;

public class Property extends Tile implements Comparable<Property> {
    private int rent;
    private final int price;

    private Player owner;
    private boolean isOwned;
    private boolean isMortgaged;

    private final Color color;

    public Property(int position, String name, int price, Color color) {
        super(name, position);
        this.price = price;
        this.color = color;
    }

    public void buyProperty(Player player) {
        if (!isOwned) {
            player.transaction(-price);
            owner = player;
            isOwned = true;
        }
    }
    public void sellProperty(Player buyer, int price) {
        if (isOwned) {
            owner.transaction(buyer, price);
            owner = buyer;
        }
    }
    public void mortgageProperty() {
        isMortgaged = true;
        owner.transaction(price);
    }
    public void liftMortgage() {
        owner.transaction((int) -(1.1 * price));
        isMortgaged = false;
    }

    public void collectRent(Player renter) {
        owner.transaction(renter, rent);
    }

    public int getPrice() {
        return price;
    }
    public int getRent() {
        return rent;
    }
    public void setRent(int rent) {
        this.rent = rent;
    }
    public Player getOwner() {
        return owner;
    }
    public boolean isOwned() {
        return isOwned;
    }
    public boolean isMortgaged() {
        return isMortgaged;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int compareTo(Property p) {
        return Integer.compare(Constants.ColorConstants.colorOrder.indexOf(color), Constants.ColorConstants.colorOrder.indexOf(p.color));
    }
}
