package pixeltracer;
import java.util.ArrayList;
import java.util.List;

/**
 * Pixel tracer application root
 */
public class PixelTracerApp {
    private List<Area> listArea = new ArrayList<>();
    private Area currentArea;
    private Layer currentLayer;
    private Shape currentShape;

    public PixelTracerApp() {}

    public void initApp() {
        // create default area or initialize structures as needed
        listArea = new ArrayList<>();
    }

    public void destroyApp() {
        listArea.clear();
        currentArea = null;
        currentLayer = null;
        currentShape = null;
    }

    // area management
    public void addArea(Area a) {
        if (a != null) listArea.add(a);
    }

    public void removeArea(Area a) {
        listArea.remove(a);
        if (currentArea == a) currentArea = null;
    }

    // getters / setters
    public List<Area> getListArea() { return listArea; }
    public Area getCurrentArea() { return currentArea; }
    public void setCurrentArea(Area a) { currentArea = a; }
    public Layer getCurrentLayer() { return currentLayer; }
    public void setCurrentLayer(Layer l) { currentLayer = l; }
    public Shape getCurrentShape() { return currentShape; }
    public void setCurrentShape(Shape s) { currentShape = s; }
}