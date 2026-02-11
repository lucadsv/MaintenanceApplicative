// SquarShape.java
public class SquarShape extends Shape {

    public Point p1;
    public int length;

    public SquarShape(int x, int y, int length) {
        this.p1 = new Point(x, y);
        this.length = length;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUAR;
    }
}
