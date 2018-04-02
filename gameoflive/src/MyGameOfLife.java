public class MyGameOfLife {
    final static int m = 320;
    final static int n = 180;

    public static void main(String[] args) {
        Cells map = new Cells(m, n);

        StdDraw.setCanvasSize(1280, 720);
        StdDraw.setXscale(0, m);
        StdDraw.setYscale(0, n);
        StdDraw.setPenColor(StdDraw.GREEN);
        map.renewCells();
        StdDraw.enableDoubleBuffering();
        for (;;) {
            StdDraw.clear(StdDraw.BLACK);
            map.drawCells();
            map.zeroOld();
            StdDraw.show();
            map.doEpoch();
            map.flag = (map.flag == 1)? 0 : 1;
        }
    }
}
