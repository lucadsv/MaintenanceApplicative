package pixeltracer;

/* Enums */
enum ShapeType { POINT, LINE, SQUAR, RECTANGLE, CERCLE, POLYGON, CURVE }
enum ColorEnum { BLACK, WIGHT, RED, GREEN }

/* Geometry classes */
class Point {
    int posX;
    int posY;
    public Point(int x, int y) { this.posX = x; this.posY = y; }
}

class Line {
    Point p1;
    Point p2;
    public Line(Point p1, Point p2) { this.p1 = p1; this.p2 = p2; }
}

class Squar {
    Point p1;
    int length;
    public Squar(Point p1, int length) { this.p1 = p1; this.length = length; }
}

class RectangleShape {
    Point p1;
    int width;
    int height;
    public RectangleShape(Point p1, int width, int height) {
        this.p1 = p1; this.width = width; this.height = height;
    }
}

class Cercle {
    Point center;
    int radus;
    public Cercle(Point c, int r) { this.center = c; this.radus = r; }
}

class PolygonShape {
    int n;
    Point[] points;
    public PolygonShape(int n) {
        this.n = n;
        this.points = new Point[n];
    }
}

class Curve {
    Point p1, p2, p3, p4;
    public Curve(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3; this.p4 = p4;
    }
}

/* Shape wrapper */
public class Shape {
    private long id;
    private ShapeType shapeType;
    private Object ptrShape; // contains the concrete shape object
    private boolean fill;
    private float thickness;
    private ColorEnum color;
    private double rotation;

    public Shape(ShapeType t) {
        this.shapeType = t;
        this.id = IDManager.getNextId();
    }

    // Factory helper static methods similar to C exported functions
    public static Shape createPointShape(int px, int py) {
        Shape s = new Shape(ShapeType.POINT);
        s.ptrShape = new Point(px, py);
        return s;
    }

    public static Shape createLineShape(int px1, int py1, int px2, int py2) {
        Shape s = new Shape(ShapeType.LINE);
        s.ptrShape = new Line(new Point(px1, py1), new Point(px2, py2));
        return s;
    }
    public static Shape createSquareShape(int px, int py, int length) {
        Shape s = new Shape(ShapeType.SQUAR);
        s.ptrShape = new Squar(new Point(px, py), length);
        return s;
    }
    public static Shape createRectangleShape(int px, int py, int width, int height) {
        Shape s = new Shape(ShapeType.RECTANGLE);
        s.ptrShape = new RectangleShape(new Point(px, py), width, height);
        return s;
    }
    public static Shape createCercleShape(int px, int py, int radus) {
        Shape s = new Shape(ShapeType.CERCLE);
        s.ptrShape = new Cercle(new Point(px, py), radus);
        return s;
    }
    public static Shape createPolygonShape(int n, int[] coords) {
        Shape s = new Shape(ShapeType.POLYGON);
        PolygonShape p = new PolygonShape(n);
        for (int i = 0; i < n && i*2+1 < coords.length; i++) {
            p.points[i] = new Point(coords[i*2], coords[i*2+1]);
        }
        s.ptrShape = p;
        return s;
    }
    public static Shape createCurveShape(int px1, int py1, int px2, int py2, int px3, int py3, int px4, int py4) {
        Shape s = new Shape(ShapeType.CURVE);
        s.ptrShape = new Curve(new Point(px1, py1), new Point(px2, py2), new Point(px3, py3), new Point(px4, py4));
        return s;
    }

    // getters / setters
    public long getId() { return id; }
    public ShapeType getShapeType() { return shapeType; }
    public Object getPtrShape() { return ptrShape; }
    public boolean isFill() { return fill; }
    public void setFill(boolean fill) { this.fill = fill; }
    public float getThickness() { return thickness; }
    public void setThickness(float thickness) { this.thickness = thickness; }
    public ColorEnum getColor() { return color; }
    public void setColor(ColorEnum color) { this.color = color; }
    public double getRotation() { return rotation; }
    public void setRotation(double rotation) { this.rotation = rotation; }
}