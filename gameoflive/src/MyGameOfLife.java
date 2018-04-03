public class MyGameOfLife {
    final static int M = 320;
    final static int N = 180;

    public static void main(String[] args) {
        Cells map = new Cells(M, N);

        StdDraw.setCanvasSize(1280, 720);
        StdDraw.setXscale(0, M);
        StdDraw.setYscale(0, N);
        StdDraw.setPenColor(StdDraw.GREEN);
        map.renewCells();
        StdDraw.enableDoubleBuffering();
        for (;;) {
            StdDraw.clear(StdDraw.BLACK);
            map.drawCells();
            StdDraw.show();
            map.doEpoch();
            map.flag = (map.flag == 1)? 0 : 1;
        }
    }
}
