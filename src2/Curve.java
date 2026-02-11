// CurveShape.java
public class CurveShape extends Shape {

    public Point p1, p2, p3, p4;

    public CurveShape(
            int x1,int y1,int x2,int y2,
            int x3,int y3,int x4,int y4) {

        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
        p3 = new Point(x3,y3);
        p4 = new Point(x4,y4);
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CURVE;
    }
}
