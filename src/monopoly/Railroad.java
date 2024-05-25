package monopoly;

import java.awt.*;

public class Railroad extends Property{
    private final int[] rentArray;
    public Railroad(int position, String name, int price, Color color, int[] rentArray) {
        super(position, name, price, color);
        this.rentArray = rentArray;
        super.setRent(rentArray[0]);
    }

    @Override
    public void buyProperty(Player player) {
        super.buyProperty(player);
        super.getOwner().addRROwned(this);
        adjustRent(super.getOwner());
    }

    @Override
    public void sellProperty(Player buyer, int price) {
        super.getOwner().removeRROwned(this);
        super.sellProperty(buyer, price);
        adjustRent(super.getOwner());
        buyer.addRROwned(this);
        adjustRent(buyer);
    }

    private void adjustRent(Player player) {
        for (Property rr : super.getOwner().getRROwned()) {
            rr.setRent(rentArray[super.getOwner().getRROwned().size() - 1]);
        }
    }
}
