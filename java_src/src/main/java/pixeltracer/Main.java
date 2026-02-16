package pixeltracer;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PixelTracer Java ===");

        // Initialisation
        PixelTracerApp app = new PixelTracerApp();
        app.initApp();

        // Crée une zone 20x10 avec un ID fictif et un nom
        Area area = new Area(20, 10, 1, "DemoArea");
        app.addArea(area);
        app.setCurrentArea(area);

        // Crée une couche et ajoute-la à la zone
        Layer layer = new Layer(1, "Layer1");
        area.addLayer(layer);

        // Ajoute une forme (un rectangle)
        Shape rect = Shape.createRectangleShape(2, 2, 10, 5);
        layer.addShape(rect);

        // Dessine la couche
        Render.drawAllLayers(area);

        // Affiche le résultat dans la console
        Render.renderArea(area);

        System.out.println("=== Fin du rendu ===");
    }
}