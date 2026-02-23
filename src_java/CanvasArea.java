package pixel_tracer.src_java;
import java.util.ArrayList;

/**
 * Represente la grille ASCII de rendu.
 * Cette classe centralise les primitives de trace des formes.
 */
public class CanvasArea {
    /** Largeur de la zone de dessin. */
    private int width;
    /** Hauteur de la zone de dessin. */
    private int height;
    /** Identifiant unique de la zone. */
    private int id;
    /** Nom lisible de la zone. */
    private String name;
    /** Matrice de caractères représentant le canvas. */
    private char[][] area;
    /** Ensemble des calques associés à la zone. */
    private ArrayList<DrawingLayer> layers;
    /** Caractère utilisé pour les cellules vides. */
    private char emptyChar;
    /** Caractère utilisé pour les cellules tracées. */
    private char fullChar;

    /**
     * Construit une zone de dessin.
     *
     * @param width largeur de la zone
     * @param height hauteur de la zone
     * @param id identifiant de la zone
     * @param name nom de la zone
     */
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

    /**
     * Réinitialise la matrice en remplissant chaque case avec le caractère vide.
     */
    public void reinitialiserZone() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = emptyChar; 
            }
        }
    }

    /**
     * Ajoute un calque à la zone de dessin.
     *
     * @param layer calque à ajouter
     */
    public void ajouterCalque(DrawingLayer layer) {
        layers.add(layer);
    }

    /**
     * Dessine la zone complète dans la sortie standard.
     *
     * <p>La méthode réinitialise la zone, dessine les calques visibles puis
     * imprime la grille ASCII.</p>
     */
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

    /**
     * Trace une ligne entre deux points.
     *
     * @param p1 premier point
     * @param p2 second point
     */
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

    /**
     * Trace le contour d'un carré.
     *
     * @param p1 coin supérieur gauche
     * @param length longueur du côté
     */
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

    /**
     * Trace le contour d'un rectangle.
     *
     * @param p1 coin supérieur gauche
     * @param width largeur
     * @param height hauteur
     */
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

    /**
     * Trace le contour d'un cercle.
     *
     * @param center centre du cercle
     * @param radius rayon
     */
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

    /**
     * Trace un pixel si ses coordonnées sont dans les bornes de la zone.
     *
     * @param x coordonnée x
     * @param y coordonnée y
     */
    private void tracerPixelCercle(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

    /**
     * Trace une courbe de Bézier cubique.
     *
     * @param p1 premier point de contrôle
     * @param p2 second point de contrôle
     * @param p3 troisième point de contrôle
     * @param p4 quatrième point de contrôle
     */
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

    /**
     * Trace un point sur la zone.
     *
     * @param p point à tracer
     */
    public void tracerPoint(CoordPoint p) {
        int x = p.getX();
        int y = p.getY();
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

    /**
     * Trace un polygone en reliant chaque sommet au suivant, puis le dernier au premier.
     *
     * @param points sommets du polygone
     */
    public void tracerPolygone(ArrayList<CoordPoint> points) {
        if (points.size() < 2) return;
        for (int i = 0; i < points.size(); i++) {
            CoordPoint p1 = points.get(i);
            CoordPoint p2 = points.get((i + 1) % points.size()); 
            tracerLigne(p1, p2); 
        }
    }

    /**
     * Retourne la largeur de la zone.
     *
     * @return largeur
     */
    public int getWidth() {
        return width;
    }

    /**
     * Modifie la largeur de la zone.
     *
     * @param width nouvelle largeur
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Retourne la hauteur de la zone.
     *
     * @return hauteur
     */
    public int getHeight() {
        return height;
    }

    /**
     * Modifie la hauteur de la zone.
     *
     * @param height nouvelle hauteur
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Retourne l'identifiant de la zone.
     *
     * @return identifiant
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant de la zone.
     *
     * @param id nouvel identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne le nom de la zone.
     *
     * @return nom
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom de la zone.
     *
     * @param name nouveau nom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retourne la matrice de caractères de la zone.
     *
     * @return matrice du canvas
     */
    public char[][] getArea() {
        return area;
    }

    /**
     * Remplace la matrice de caractères de la zone.
     *
     * @param area nouvelle matrice
     */
    public void setArea(char[][] area) {
        this.area = area;
    }

    /**
     * Retourne les calques de la zone.
     *
     * @return liste des calques
     */
    public ArrayList<DrawingLayer> getCalques() {
        return layers;
    }

    /**
     * Retourne le caractère de fond.
     *
     * @return caractère des cellules vides
     */
    public char getEmptyChar() {
        return emptyChar;
    }

    /**
     * Modifie le caractère de fond.
     *
     * @param emptyChar nouveau caractère de fond
     */
    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
    }

    /**
     * Retourne le caractère de tracé.
     *
     * @return caractère des cellules pleines
     */
    public char getFullChar() {
        return fullChar;
    }

    /**
     * Modifie le caractère de tracé.
     *
     * @param fullChar nouveau caractère de tracé
     */
    public void setFullChar(char fullChar) {
        this.fullChar = fullChar;
    }
}
