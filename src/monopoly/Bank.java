package monopoly;

public class Bank {
    private static int housesRemaining = 32;
    private static int hotelsRemaining = 12;

    public static boolean isHouseAvailable() {
        return housesRemaining != 0;
    }
    public static boolean isHotelAvailable() {
        return hotelsRemaining != 0;
    }

    public static void buyHouse(Player player, int price) {
        player.transaction(-price);
        housesRemaining--;
    }
    public static void returnHouse(Player player, int price) {
        player.transaction(price / 2);
        housesRemaining++;
    }
    public static void convertHouse() {
        housesRemaining += 4;
    }

    public static void buyHotel(Player player, int price) {
        player.transaction(-price);
        hotelsRemaining--;
    }
    public static void sellHotel(Player player, int price) {
        player.transaction(price / 2);
        hotelsRemaining++;
    }
}
