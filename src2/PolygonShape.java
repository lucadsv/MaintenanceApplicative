// PolygonShape.java
public class PolygonShape extends Shape {

    public int n;
    public Point[] points;

    public PolygonShape(int[] tab) {
        this.n = tab.length / 2;
        this.points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(tab[i*2], tab[i*2+1]);
        }
    }

    @Override
    public ShapeType getType() {
        return ShapeType.POLYGON;
    }
}
