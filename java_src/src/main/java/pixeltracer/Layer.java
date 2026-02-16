package pixeltracer;
import java.util.LinkedList;
import java.util.List;

public class Layer {
    private int id;
    private String name;
    private boolean visible = true;
    private List<Shape> shapes = new LinkedList<>();

    public static final boolean LAYER_VISIBLE = true;
    public static final boolean LAYER_UNVISIBLE = false;

    public Layer(int id, String name) {
        this.id = id;
        this.name = name != null ? name : "";
    }

    public void addShape(Shape s) {
        if (s != null) shapes.add(s);
    }

    public void removeShape(Shape s) {
        shapes.remove(s);
    }

    public void setVisible() { visible = true; }
    public void setUnvisible() { visible = false; }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isVisible() { return visible; }
    public List<Shape> getShapes() { return shapes; }
}