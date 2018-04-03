import java.util.Random;

public class Cells {
    final static double CELL_RAD = 0.5;

    int w;
    int h;
    boolean[][] cells;
    int flag;

    Cells(int width, int height) {
        w = width;
        h = height;
        cells = new boolean[2][width * height];
        flag = 1;
    }

    public void renewCells() {
        Random random = new Random();
        for (int i = 0; i < h * w; i++) {
                cells[0][i] = random.nextBoolean();
                cells[1][i] = cells[0][i];
            }
    }

    private boolean dotProduct(int x, int y) {
        int alive;
        alive = 0;
        int deltaX;
        int deltaY;
        for (int y1 = y - 1; y1 < y + 2; y1++) {
            for (int x1 = x - 1; x1 < x + 2; x1++) {
                deltaX = (x1 == -1)? w - 1 : (x1 == w)? 0 : x1;
                deltaY = (y1 == -1)? h - 1 : (y1 == h)? 0 : y1;
                if ((x1 == x) && (y1 == y)) continue;
                if (cells[flag][deltaY * w + deltaX]) {
                    alive++;
                }
            }
        }
        if (!cells[flag][y * w + x] && (alive == 3))
            return true;
        else if (cells[flag][y * w + x] && ((alive == 2) || (alive == 3)))
            return true;
        else
            return false;
    }

    public void doEpoch() {
        int opp;
        opp = (flag == 1)? 0 : 1;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                cells[opp][y * w + x] = dotProduct(x, y);
            }
        }
    }

   public void drawCells() {
        int opp;
        opp = (flag == 1)? 0 : 1;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (cells[opp][y * w + x]) {
                    StdDraw.filledCircle(x, y, CELL_RAD);
                }
            }
        }
    }
}
