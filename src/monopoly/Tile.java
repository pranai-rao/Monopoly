package monopoly;

public class Tile {
    private final String name;
    private final int position;
    public Tile(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
