// CercleShape.java
public class CercleShape extends Shape {

    public Point center;
    public int radius;

    public CercleShape(int x, int y, int r) {
        this.center = new Point(x, y);
        this.radius = r;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CERCLE;
    }
}
