import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Board {
    public Tile[] tiles;

    public Board() {
        this.tiles = new Tile[40];
    }

    public void initBoard() throws IOException {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("tiles.csv")));
            s.useDelimiter(",");
            s.nextLine();
            for (int i = 0; s.hasNextLine(); i++) {
                String line = s.nextLine();

                String[] tileInfo = line.split(",");
                int group;
                group = switch (tileInfo[2]) {
                    case "purple" -> 0;
                    case "blue" -> 1;
                    case "pink" -> 2;
                    case "orange" -> 3;
                    case "red" -> 4;
                    case "yellow" -> 5;
                    case "green" -> 6;
                    case "navy" -> 7;
                    case "tax" -> 8;
                    default -> -1;
                };

                tiles[i] = new Tile(tileInfo[0], Integer.parseInt(tileInfo[1]), group);
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
