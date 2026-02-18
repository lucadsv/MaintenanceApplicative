package pixel_tracer.src_java;
import java.util.ArrayList;

/**
 * Conteneur logique de formes avec un drapeau de visibilite.
 */
public class DrawingLayer {
    private int id;
    private String name;
    private boolean visible;
    private ArrayList<DrawableShape> shapes;

    public DrawingLayer(String name, int id) {
        this.name = name;
        this.id = id;
        this.shapes = new ArrayList<>();
        this.visible = true;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void ajouterForme(DrawableShape shape) {
        shapes.add(shape);
    }
    public void supprimerForme(DrawableShape shape) {
        shapes.remove(shape);
    }
    public boolean estVisible() {
        return visible;
    }
    public ArrayList<DrawableShape> getFormes() {
        return shapes;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}