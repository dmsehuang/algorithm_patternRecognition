/*************************************************************************
 * Name: Huijing Huang
 * Email: dmsehuang@yahoo.com
 *
 * Compilation:  javac Point.java
 * Execution: java Point
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    
    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            double s1 = slopeTo(p1);
            double s2 = slopeTo(p2);
            if (s1 == s2) {
                return 0;
            } else if (s1 < s2) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        if (this.x == that.x) {
            if (this.y == that.y) return Double.NEGATIVE_INFINITY; // degenerate line segment
            return Double.POSITIVE_INFINITY; // vertical line segment
        }
        if (this.y == that.y) return +0.0; // horizontal line segment has positive zero slope
        
        // normal case
        double diffY = (double) (this.y - that.y);
        double diffX = (double) (this.x - that.x);
        return diffY/diffX;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (this.y == that.y) {
            return this.x - that.x;
        } else {
            return this.y - that.y;
        }
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
//        // rescale coordinates and turn on animation mode
//        StdDraw.setXscale(-10, 10);
//        StdDraw.setYscale(-10, 10);
//        StdDraw.show(0);
//        StdDraw.setPenRadius(0.01);  // make the points a bit larger
//
//        /* YOUR CODE HERE */
//        Point p0 = new Point(0, 0);
//        Point p1 = new Point(1, 1);
//        Point p2 = new Point(2, 8);
//        Point p3 = new Point(-3, -9);
//        p1.drawTo(p2);
//        p0.drawTo(p1);
//        p0.drawTo(p2);
//        p3.draw();
//        
//     // display to screen all at once
//        StdDraw.show(0);
    }
}