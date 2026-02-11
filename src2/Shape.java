// Shape.java  (ABSTRACT)
public abstract class Shape {

    public long id;
    public boolean fill;
    public float thickness;
    public Color color;
    public double rotation;

    public abstract ShapeType getType();
}
