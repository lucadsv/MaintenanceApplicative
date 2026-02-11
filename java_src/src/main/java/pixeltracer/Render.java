package main.java.pixeltracer;
import java.util.List;

public class Render {
    public enum ColorCell { EMPTY_CELL, BLACK_CELL, RED_CELL }

    public static final char EMPTY_CHAR = '.';
    public static final char FULL_CHAR = '#';

    public static void renderArea(Area area) {
        drawArea(area);
    }

    public static void drawArea(Area area) {
        if (area == null) return;
        int h = area.getHeight();
        int w = area.getWidth();
        char[][] grid = area.getAreaGrid();

        // clear console (best-effort)
        clearScreen();

        for (int y = 0; y < h; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < w; x++) {
                sb.append(grid[y][x]);
            }
            System.out.println(sb.toString());
        }
    }

    public static void clearScreen() {
        // Best-effort console clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void drawLayerShapes(Area area, Layer layer) {
        if (area == null || layer == null || !layer.isVisible()) return;
        for (Shape s : layer.getShapes()) {
            // call shape -> pixel conversion and draw on area
            List<Pixel> pixels = ShapeRasterizer.createShapeToPixel(s);
            for (Pixel p : pixels) {
                area.setCell(p.getX(), p.getY(), area.getFullChar());
            }
        }
    }

    public static void drawAllLayers(Area area) {
        for (Layer layer : area.getLayers()) {
            drawLayerShapes(area, layer);
        }
    }
}