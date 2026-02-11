// PointShape.java
public class PointShape extends Shape {

    public Point p;

    public PointShape(int x, int y) {
        this.p = new Point(x, y);
    }

    @Override
    public ShapeType getType() {
        return ShapeType.POINT;
    }
}
