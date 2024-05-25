package monopoly;

import java.awt.*;

public class Street extends Property {
    private final int[] rentArray;
    private final int housePrice;
    private int houses;
    private boolean isHotel;

    public Street(int position, String name, int price, Color color, int[] rentArray, int housePrice) {
        super(position, name, price, color);
        this.rentArray = rentArray;
        super.setRent(rentArray[0]);
        this.housePrice = housePrice;
        houses = 0;
    }

    @Override
    public void mortgageProperty() {
        if (isHotel) {
            sellHotel();
        }
        else if (houses != 0) {
            sellHouse(houses);
        }
        super.mortgageProperty();
    }

    public void addHouse(int numHouses) {
        if (Bank.isHouseAvailable() && super.isOwned() && houses < 4 && !isHotel && !super.isMortgaged() && numHouses > 0) {
            Bank.buyHouse(super.getOwner(), housePrice);
            super.setRent(rentArray[++houses]);
            getOwner().modifyHousesOwned(1);
            addHouse(--numHouses);
        }
    }
    public void sellHouse(int numHouses) {
        if (super.isOwned() && houses != 0) {
            Bank.returnHouse(super.getOwner(), housePrice);
            super.setRent(rentArray[--houses]);
            getOwner().modifyHousesOwned(-1);
            sellHouse(--numHouses);
        }
    }

    public void addHotel() {
        if (Bank.isHotelAvailable() && super.isOwned() && houses == 4 && !isHotel && !super.isMortgaged()) {
            Bank.convertHouse();
            Bank.buyHotel(super.getOwner(), housePrice);
            super.setRent(rentArray[++houses]);
        }
    }
    public void sellHotel() {
        if (super.isOwned() && isHotel) {
            Bank.sellHotel(super.getOwner(), housePrice * 5);
            houses = 0;
            super.setRent(rentArray[houses]);
        }
    }

    public void demolish() {
        if (isHotel) {
            sellHotel();
        }
        else if (houses != 0) {
            sellHouse(houses);
        }
    }

    public int getHouses() {
        return houses;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public boolean isHotel() {
        return isHotel;
    }
}
