// LineShape.java
public class LineShape extends Shape {

    public Point p1;
    public Point p2;

    public LineShape(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    @Override
    public ShapeType getType() {
        return ShapeType.LINE;
    }
}
