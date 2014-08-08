import java.util.Arrays;

public class Fast {

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
        Point[] ref = new Point[N]; // reference to original array
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points[i] = p;
            ref[i] = p;
        }
        
        // fast algorithm
        for (int i = 0; i < N; i++) {
            // sort the array for the natural order and slope order
            Arrays.sort(points); 
            Arrays.sort(points, ref[i].SLOPE_ORDER);
            int start = 1;
            // search for the continuous points, from start to end
            while (start <= N-3) {
                int end = start + 1;
                // search for the same slope
                while (end < N && (points[0].slopeTo(points[start]) == points[0].slopeTo(points[end]))) {
                        end++;
                }
                if (end - start + 1 >= 4) {
                    boolean asc = true;
                    // make sure all the points in the ascending order
                    for (int j = start; j < end; j++) {
                        if (points[0].compareTo(points[j]) >= 0) {
                            asc = false;
                            break;
                        }
                    }
                    if (asc) {
                        // draw the line
                        points[0].drawTo(points[end-1]);
                        StdOut.print(points[0] + "->");
                        for (int j = start; j < end - 1; j++) {
                            StdOut.print(points[j] + "->");
                        }
                        StdOut.print(points[end-1] + "\n");
                    }
                }
                start = end;
            }
        }

        // display to screen all at once
        StdDraw.show(0);       
        // reset the pen radius
        StdDraw.setPenRadius();
    }
}
