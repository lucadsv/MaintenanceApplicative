import java.util.LinkedList;
import java.util.List;

public class Layer {

    public static final int LAYER_VISIBLE = 1;
    public static final int LAYER_UNVISIBLE = 0;

    private int id;
    private String name;
    private boolean visible;
    private List<Shape> shapes;

    // === create_layer ===
    public Layer(int id, String name) {
        this.id = id;
        this.name = name;
        this.visible = true; // visible par défaut
        this.shapes = new LinkedList<>();
    }

    // === delete_layer ===
    public void deleteLayer() {
        shapes.clear();
    }

    // === set_layer_visible ===
    public void setVisible() {
        this.visible = true;
    }

    // === set_layer_unvisible ===
    public void setUnvisible() {
        this.visible = false;
    }

    // === add_shape_to_layer ===
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    // === remove_shape_to_from ===
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    // === getters ===

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isVisible() {
        return visible;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
