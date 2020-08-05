public class Tile {
    private final String name;
    private final int cost;
    private final int group; // how to replace with an enumeration?

    /*
        Design philosophy #1: get it to work first, then refactor
     */

    // Override default constructor
    public Tile() {
        this.name = "";
        this.cost = -1;
        this.group = -1;
    }
    public Tile(String name, int cost, int group) {
        this.name = name;
        this.cost = cost;
        this.group = group;
    }

    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    public int getGroup() {
        return group;
    }
    public String tileInfo() {
        return "Name: " + name + ", Cost: " + cost + ", Group: " + group;
    }
}
