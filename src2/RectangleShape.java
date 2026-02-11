// RectangleShape.java
public class RectangleShape extends Shape {

    public Point p1;
    public int width;
    public int height;

    public RectangleShape(int x, int y, int w, int h) {
        this.p1 = new Point(x, y);
        this.width = w;
        this.height = h;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.RECTANGLE;
    }
}
