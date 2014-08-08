import java.util.Arrays;

public class Brute {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // re-scale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01); // make the points a bit larger
        
        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points[i] = p;
        }
        
        // brute force algorithm
        for (int p = 0; p <= N-4; p++) {
            for (int q = p+1; q <= N-3; q++) {
                for (int r = q+1; r <= N-2; r++) {
                    for (int s = r+1; s <= N-1; s++) {
                        // check if they are in the same line
                        if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r]) 
                         && points[p].slopeTo(points[q]) == points[p].slopeTo(points[s])) {
                            // find the start and the end of the line
                            Point[] tmp = new Point[4];
                            tmp[0] = points[p];
                            tmp[1] = points[q];
                            tmp[2] = points[r];
                            tmp[3] = points[s];
                            Arrays.sort(tmp);
                            // draw the segment
                            tmp[0].drawTo(tmp[3]);
                            StdOut.print(tmp[0] + "->" + tmp[1] + "->" + tmp[2] + "->" + tmp[3]);
                            StdOut.println();
                        }
                    }
                }
            }
        }
        
        // display to screen all at once
        StdDraw.show(0);
        
        // reset the pen radius
        StdDraw.setPenRadius();
    }
}