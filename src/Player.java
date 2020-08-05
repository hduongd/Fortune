public class Player {
    private int position;
    private int balance;
    private String name;

    public Player() {
        this.position = 0;
        this.balance = 1500;
        this.name = "unknown";
    }
    public Player(String name) {
        this.position = 0;
        this.balance = 1500;
        this.name = name;
    }

    public void advance(int steps) {
        position = (position + steps) % 40;
    }

    public int getPosition() {
        return position;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
