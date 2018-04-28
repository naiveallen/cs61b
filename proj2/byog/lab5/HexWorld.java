package byog.lab5;
import javafx.geometry.Pos;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;

    private static final long SEED = 6666;
    private static final Random RANDOM = new Random(SEED);

    private static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position() {
            this(0, 0);
        }
    }

    public static void fillWorld(TETile[][] world) {
        int width = world[0].length;
        int height = world.length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }

    public static void addHexagon(TETile[][] world, int s, Position p, TETile t) {
        int height = s * 2;
        int[] width = new int[s];

        for (int i = 0; i < width.length; i++, s += 2) {
            width[i] = s;
        }

        int i = 0;
        int j = width.length - 1;

        for (int y = p.y; y < p.y + height; y++) {

            if(i < width.length) {
                for (int x = p.x; x < p.x + width[i]; x++) {
                    world[x][y] = t;
                }
                i++;
                p.x--;
            } else {
                p.x++;
                for (int x = p.x; x < p.x + width[j]; x++) {
                    world[x][y] = t;
                }
                j--;
            }
        }
    }

    public static Position topRightHex(Position p, int s) {
        Position topRightp = new Position();
        topRightp.x = p.x + 2 * s - 1;
        topRightp.y = p.y + s;
        return topRightp;
    }

    public static Position bottomRightHex(Position p, int s) {
        Position bottomRightp = new Position();
        bottomRightp.x = p.x + 2 * s - 1;
        bottomRightp.y = p.y - s;
        return bottomRightp;
    }

    public static Position bottomHex(Position p, int s) {
        Position bottomp = new Position();
        bottomp.x = p.x;
        bottomp.y = p.y - s * 2;
        return bottomp;
    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.TREE;
            case 3: return Tileset.GRASS;
            case 4: return Tileset.MOUNTAIN;
            case 5: return Tileset.WATER;
            default: return Tileset.WALL;
        }
    }

    public static void drawRandomVerticalHexes(TETile[][] world, int s, Position p, int N) {
        for (int i = 0; i < N; i++) {
            addHexagon(world, s, p, randomTile());
            p = topRightHex(p, s);
        }
    }


    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        fillWorld(world);
        Position p = new Position(5,25);

        //addHexagon(world, 4, p, Tileset.TREE);
        drawRandomVerticalHexes(world, 3, p, 3);
        p = bottomHex(p, 3);
        drawRandomVerticalHexes(world, 3, p, 4);
        p = bottomHex(p, 3);
        drawRandomVerticalHexes(world, 3, p, 5);
        p = bottomRightHex(p, 3);
        drawRandomVerticalHexes(world, 3, p, 4);
        p = bottomRightHex(p, 3);
        drawRandomVerticalHexes(world, 3, p, 3);

        ter.renderFrame(world);
    }
}
