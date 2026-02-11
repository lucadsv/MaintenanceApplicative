package main.java.pixeltracer;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility to convert Shape -> list of Pixel (simple rasterizations).
 * Implémentations très basiques: point, line (Bresenham simplified), rectangle outline.
 * You can améliorer selon besoin.
 */
public class ShapeRasterizer {

    public static List<Pixel> createShapeToPixel(Shape shape) {
        List<Pixel> res = new ArrayList<>();
        if (shape == null) return res;

        switch (shape.getShapeType()) {
            case POINT:
                Point p = (Point) shape.getPtrShape();
                res.add(new Pixel(p.posX, p.posY, 1));
                break;
            case LINE:
                Line l = (Line) shape.getPtrShape();
                res.addAll(bresenhamLine(l.p1.posX, l.p1.posY, l.p2.posX, l.p2.posY));
                break;
            case RECTANGLE:
                RectangleShape r = (RectangleShape) shape.getPtrShape();
                res.addAll(rectangleOutline(r.p1.posX, r.p1.posY, r.width, r.height));
                break;
            case SQUAR:
                Squar s = (Squar) shape.getPtrShape();
                res.addAll(rectangleOutline(s.p1.posX, s.p1.posY, s.length, s.length));
                break;
            // add other cases as needed
            default:
                break;
        }
        return res;
    }

    private static List<Pixel> rectangleOutline(int x, int y, int w, int h) {
        List<Pixel> out = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            out.add(new Pixel(x + i, y, 1));
            out.add(new Pixel(x + i, y + h - 1, 1));
        }
        for (int j = 0; j < h; j++) {
            out.add(new Pixel(x, y + j, 1));
            out.add(new Pixel(x + w - 1, y + j, 1));
        }
        return out;
    }

    private static List<Pixel> bresenhamLine(int x0, int y0, int x1, int y1) {
        List<Pixel> pts = new ArrayList<>();
        int dx = Math.abs(x1 - x0), sx = x0 < x1 ? 1 : -1;
        int dy = -Math.abs(y1 - y0), sy = y0 < y1 ? 1 : -1;
        int err = dx + dy;
        int x = x0, y = y0;
        while (true) {
            pts.add(new Pixel(x, y, 1));
            if (x == x1 && y == y1) break;
            int e2 = 2 * err;
            if (e2 >= dy) { err += dy; x += sx; }
            if (e2 <= dx) { err += dx; y += sy; }
        }
        return pts;
    }
}