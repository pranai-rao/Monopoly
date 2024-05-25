package monopoly;

public class Special extends Tile {
    private final Type type;
    public Special(String name, int position, Type type) {
        super(name, position);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        CHANCE, COMMUNITY, INCOME, LUXURY, JAIL
    }
}
