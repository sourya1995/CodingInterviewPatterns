package TopKElements;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            return (x * x) + (y * y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());

        for (int i = 0; i < k; i++)
            maxHeap.add(new Point(points[i][0], points[i][1]));

        for (int i = k; i < points.length; i++) {
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            if (dist < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(new Point(points[i][0], points[i][1]));
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        for (Point point : maxHeap) {
            result[index][0] = point.x;
            result[index][1] = point.y;
            index++;
        }
        return result;
    }
}
