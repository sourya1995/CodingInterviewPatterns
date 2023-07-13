import java.util.List;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Rectangle {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean contains(Point point) {
        return (point.getX() >= x && point.getX() <= x + width && point.getY() >= y && point.getY() <= y + height);
    }

    public boolean intersects(Rectangle other) {
        return !(x + width < other.x || other.x + other.width < x || y + height < other.y
                || other.y + other.height < y);
    }
}

class QuadTree {
    private int capacity;
    private Rectangle boundary;
    private Point[] points;
    private boolean divided;
    private QuadTree[] children;

    public QuadTree(Rectangle boundary, int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        this.points = new Point[capacity];
        this.divided = false;
        this.children = new QuadTree[4];
    }

    public void insert(Point point) {
        if (!boundary.contains(point)) {
            return;
        }

        if (points.length < capacity) {
            points[points.length] = point;
        } else {
            if (!divided) {
                subdivide();
            }

            for (int i = 0; i < 4; i++) {
                children[i].insert(point);
            }
        }
    }

    public void subdivide() {
        double x = boundary.getX();
        double y = boundary.getY();
        double width = boundary.getWidth() / 2;
        double height = boundary.getHeight() / 2;

        children[0] = new QuadTree(new Rectangle(x, y, width, height), capacity);
        children[1] = new QuadTree(new Rectangle(x + width, y, width, height), capacity);
        children[2] = new QuadTree(new Rectangle(x, y + height, width, height), capacity);
        children[3] = new QuadTree(new Rectangle(x + width, y + height, width, height), capacity);

        divided = true;
    }

    public void query(Rectangle range, List<Point> result) {
        if (!boundary.intersects(range)) {
            return;
        }

        for (Point point : points) {
            if (range.contains(point)) {
                result.add(point);
            }
        }

        if (divided) {
            for (QuadTree child : children) {
                child.query(range, result);
            }
        }
    }
}