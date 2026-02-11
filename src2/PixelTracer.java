public class PixelTracerApp {

    private AreaList listArea;
    private Area currentArea;
    private Layer currentLayer;
    private Shape currentShape;

    // === init_app ===
    public void initApp() {
        // charge le compteur d'ID (module id.h → IdManager)
        IdManager.loadId();

        // crée la liste des areas
        listArea = new AreaList();

        // créer une area par défaut (comme demandé dans le header)
        long id = IdManager.getNextId();
        Area defaultArea = new Area(80, 40, (int) id, "default");

        listArea.addArea(defaultArea);

        currentArea = defaultArea;

        // créer un layer par défaut
        currentLayer = new Layer((int) IdManager.getNextId(), "base");
        currentArea.getLayersList().addLayer(currentLayer);

        currentShape = null;
    }

    // === destry_app === (typo C conservée mais corrigée côté Java)
    public void destroyApp() {

        if (listArea != null) {
            listArea.deleteAreaList();
        }

        IdManager.saveId();

        currentArea = null;
        currentLayer = null;
        currentShape = null;
    }

    // === getters / setters ===

    public AreaList getListArea() {
        return listArea;
    }

    public Area getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }

    public Layer getCurrentLayer() {
        return currentLayer;
    }

    public void setCurrentLayer(Layer currentLayer) {
        this.currentLayer = currentLayer;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }
}
