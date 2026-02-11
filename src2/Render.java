public class Render {

    public static final char EMPTY_CHAR = '.';
    public static final char FULL_CHAR  = '#';

    // === clear_screen ===
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // === render_area ===
    public static void renderArea(Area area) {
        area.clearArea();
        drawAllLayers(area);
    }

    // === draw_area ===
    public static void drawArea(Area area) {
        char[][] buf = area.getBuffer();

        for (int y = 0; y < area.getHeight(); y++) {
            for (int x = 0; x < area.getWidth(); x++) {
                System.out.print(buf[y][x]);
            }
            System.out.println();
        }
    }

    // === draw_layer_shapes ===
    public static void drawLayerShapes(Area area, Layer layer) {

        if (!layer.isVisible()) return;

        for (Shape shape : layer.getShapes()) {

            LinkedListCustom pixels = PixelRasterizer.createShapeToPixel(shape);

            LNode node = pixels.getFirstNode();

            while (node != null) {
                Pixel p = (Pixel) node.getData();

                area.setChar(
                        p.getPx(),
                        p.getPy(),
                        FULL_CHAR
                );

                node = node.getNext();
            }
        }
    }

    // === draw_all_layers ===
    public static void drawAllLayers(Area area) {

        LayersList layers = area.getLayersList();

        for (Layer layer : layers.getAll()) {
            drawLayerShapes(area, layer);
        }
    }
}
