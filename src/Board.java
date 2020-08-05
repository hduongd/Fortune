import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Board {
    public Tile[] tiles;

    public Board() {
        this.tiles = new Tile[40];
    }

    public void init() throws IOException {
        System.out.println("Loading data...");
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("tiles.csv")));
            s.useDelimiter(",");
            s.nextLine();
            for (int i = 0; s.hasNextLine(); i++) {
                String line = s.nextLine();

                String[] tileInfo = line.split(",");

                tiles[i] = new Tile(tileInfo[0], Integer.parseInt(tileInfo[1]), tileInfo[2]);
                System.out.printf("%d ", i);
                System.out.println(tiles[i].tileInfo());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public String getTileInfo(int tileNo) {
        return tiles[tileNo].tileInfo();
    }
}
