package pixel_tracer.src_java;
import java.util.ArrayList;

/**
 * Represente la grille ASCII de rendu.
 * Cette classe centralise les primitives de trace des formes.
 */
public class CanvasArea {
    private int width;
    private int height;
    private int id;
    private String name;
    private char[][] area;
    private ArrayList<DrawingLayer> layers;
    private char emptyChar;
    private char fullChar;

    public CanvasArea(int width, int height, int id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name;
        this.layers = new ArrayList<>();
        this.emptyChar = '.';
        this.fullChar = '@';
        this.area = new char[height][width];
        reinitialiserZone();
    }

    public void reinitialiserZone() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = emptyChar; 
            }
        }
    }
    public void ajouterCalque(DrawingLayer layer) {
        layers.add(layer);
    }

    public void draw() {
        reinitialiserZone();
        for (DrawingLayer layer : layers) {
            if (!layer.estVisible()) continue;

            for (DrawableShape shape : layer.getFormes()) {
                shape.draw(this);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

    public void tracerLigne(CoordPoint p1, CoordPoint p2) {
        int x1 = p1.getX(), y1 = p1.getY();
        int x2 = p2.getX(), y2 = p2.getY();
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        while (true) {
            if (x1 >= 0 && x1 < width && y1 >= 0 && y1 < height) {
                area[y1][x1] = fullChar;
            }
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    public void tracerCarre(CoordPoint p1, int length) {
        int x = p1.getX(), y = p1.getY();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int px = x + i, py = y + j;
                if ((i == 0 || i == length - 1 || j == 0 || j == length - 1) &&
                        px >= 0 && px < width && py >= 0 && py < height) {
                    area[py][px] = fullChar;
                }
            }
        }
    }

    public void tracerRectangle(CoordPoint p1, int width, int height) {
        int x = p1.getX(), y = p1.getY();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int px = x + j, py = y + i;
                if ((i == 0 || i == height - 1 || j == 0 || j == width - 1) &&
                        px >= 0 && px < this.width && py >= 0 && py < this.height) {
                    area[py][px] = fullChar;
                }
            }
        }
    }

    public void tracerCercle(CoordPoint center, int radius) {
        int cx = center.getX(), cy = center.getY();
        int x = 0, y = radius;
        int d = 3 - 2 * radius;
        while (y >= x) {
            tracerPixelCercle(cx + x, cy + y);
            tracerPixelCercle(cx - x, cy + y);
            tracerPixelCercle(cx + x, cy - y);
            tracerPixelCercle(cx - x, cy - y);
            tracerPixelCercle(cx + y, cy + x);
            tracerPixelCercle(cx - y, cy + x);
            tracerPixelCercle(cx + y, cy - x);
            tracerPixelCercle(cx - y, cy - x);
            if (d <= 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    private void tracerPixelCercle(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

    public void tracerCourbe(CoordPoint p1, CoordPoint p2, CoordPoint p3, CoordPoint p4) {
        int steps = 100; 
        for (int i = 0; i <= steps; i++) {
            float t = i / (float) steps;
            int x = (int) (Math.pow(1 - t, 3) * p1.getX() +
                    3 * Math.pow(1 - t, 2) * t * p2.getX() +
                    3 * (1 - t) * Math.pow(t, 2) * p3.getX() +
                    Math.pow(t, 3) * p4.getX());
            int y = (int) (Math.pow(1 - t, 3) * p1.getY() +
                    3 * Math.pow(1 - t, 2) * t * p2.getY() +
                    3 * (1 - t) * Math.pow(t, 2) * p3.getY() +
                    Math.pow(t, 3) * p4.getY());
            tracerPixelCercle(x, y); 
        }
    }

    public void tracerPoint(CoordPoint p) {
        int x = p.getX();
        int y = p.getY();
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

    public void tracerPolygone(ArrayList<CoordPoint> points) {
        if (points.size() < 2) return;
        for (int i = 0; i < points.size(); i++) {
            CoordPoint p1 = points.get(i);
            CoordPoint p2 = points.get((i + 1) % points.size()); 
            tracerLigne(p1, p2); 
        }
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char[][] getArea() {
        return area;
    }
    public void setArea(char[][] area) {
        this.area = area;
    }
    public ArrayList<DrawingLayer> getCalques() {
        return layers;
    }
    public char getEmptyChar() {
        return emptyChar;
    }
    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
    }
    public char getFullChar() {
        return fullChar;
    }
    public void setFullChar(char fullChar) {
        this.fullChar = fullChar;
    }
}