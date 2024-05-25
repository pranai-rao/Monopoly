package monopoly;

import java.awt.*;

public class Utility extends Property {
    private static int rentMultiplier;
    public Utility(int position, String name, int price, Color color) {
        super(position, name, price, color);
    }

    @Override
    public void buyProperty(Player player) {
        super.buyProperty(player);
        super.getOwner().addUtilOwned(this);
        rentMultiplier = (super.getOwner().getUtilOwned().size() == 2 ? 10 : 4);
    }

    @Override
    public void sellProperty(Player buyer, int price) {
        super.getOwner().removeUtilOwned(this);
        super.sellProperty(buyer, price);
        buyer.addUtilOwned(this);
        rentMultiplier = (super.getOwner().getUtilOwned().size() == 2 ? 10 : 4);
    }

    @Override
    public void collectRent(Player renter) {
        super.setRent(Dice.getSumLastRoll() * rentMultiplier);
        super.collectRent(renter);
    }

    public int getValue() {
        return Constants.UtilityConstants.price;
    }
}
