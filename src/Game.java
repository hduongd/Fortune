import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        try {
            board.initBoard();
        } catch (IOException e) {
            System.err.println(e);
        }

        Player p = new Player();
        while (true) {  // ignore the loop-can-only-end-by-exception warning
            System.out.println("Starting position: 0 (GO)");
            System.out.print("Press ENTER to roll: ");

            try {
                System.in.read(); // wait for ENTER key press
            } catch (IOException e) {
                System.err.println(e);
            }
            p.advance(1);

            System.out.println("New position: " + p.getPosition());
            System.out.println("Tile info: " + board.getTileInfo(p.getPosition()));
        }
    }
}
