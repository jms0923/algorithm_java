package StringArray;

import java.lang.reflect.Array;
import java.util.*;

public class KClosestPoints {
    public static void main(String[] args){
//        Point[] points = new Point[5];
//        points[0] = new Point(4, 6);
//        points[1] = new Point(4, 7);
//        points[2] = new Point(4, 4);
//        points[3] = new Point(2, 5);
//        points[4] = new Point(1, 1);
//        Point origin = new Point(0, 0);
//        int k = 3;

        // other test case
//        Point[] points = new Point[2];
//        points[0] = new Point(0, 0);
//        points[1] = new Point(0, 9);
//        Point origin = new Point(3, 1);
//        int k = 1;

        // another test case
        Point[] points = new Point[5];
        points[0] = new Point(4, 6);
        points[1] = new Point(4, 6);
        points[2] = new Point(4, 6);
        points[3] = new Point(-4, -6);
        points[4] = new Point(-4, 6);
        Point origin = new Point(0, 0);
        int k = 3;

        Point[] sovled = kClosest(points, origin, k);
        for (Point i:sovled){
            System.out.println(i.x + " " + i.y);
        }
    }

    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public static Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int disO1 = ((origin.x - o1.x) * (origin.x - o1.x)) + ((origin.y - o1.y) * (origin.y - o1.y));
                int disO2 = ((origin.x - o2.x) * (origin.x - o2.x)) + ((origin.y - o2.y) * (origin.y - o2.y));
                if (disO1 > disO2) return 1;
                else if(disO1 < disO2) return -1;
                else{
                    if (o1.x > o2.x) return 1;
                    else if(o1.x < o2.x) return -1;
                    else{
                        if (o1.y > o2.y) return 1;
                        else return -1;
                    }
                }
            }
        });

        for (Point i:points){
            queue.offer(i);
        }

        Point[] solved = new Point[k];
        for (int i=0; i<k; i++){
            solved[i] = queue.poll();
        }

        return solved;
    }
}


//Definition for a point.
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
