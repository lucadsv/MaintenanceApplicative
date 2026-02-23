package pixel_tracer.src_java;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Polygone compose d'une sequence ordonnee de sommets.
 */
public class MultiPolygon extends DrawableShape {
    /** Nombre logique de sommets. */
    private int n;
    /** Sommets ordonnés du polygone. */
    private ArrayList<CoordPoint> points;

    /**
     * Construit un polygone à partir d'une liste de points.
     *
     * @param pointsList liste des sommets
     */
    public MultiPolygon(ArrayList<CoordPoint> pointsList) {
        super(SequenceId.instance().prochainId(), DrawableType.POLYGON);
        points = pointsList;
    }

    /**
     * Construit un polygone vide avec capacité initiale.
     *
     * @param n capacité initiale de sommets
     */
    public MultiPolygon(int n) {
        super(SequenceId.instance().prochainId(), DrawableType.POLYGON);
        points = new ArrayList<CoordPoint>(n);
    }

    /**
     * Construit un polygone à partir d'un tableau [x1, y1, x2, y2, ...].
     *
     * @param n nombre de sommets
     * @param xandy coordonnées à plat
     */
    public MultiPolygon(int n, int[] xandy) {
        super(SequenceId.instance().prochainId(), DrawableType.POLYGON);
        points = new ArrayList<CoordPoint>(n);
        try {
            for (int i = 0; i < n * 2; i += 2) { 
                System.out.println();
                points.add(new CoordPoint(xandy[i], xandy[i + 1]));
            }
            this.n = n;
        } catch (Exception e) {
            System.out.println("Taille du tableau et cordonnees des points incoherentes : " + e);
        }
    }

    /**
     * Ajoute un sommet au polygone.
     *
     * @param p sommet à ajouter
     */
    public void ajouterPoint(CoordPoint p) {
        points.add(p);
    }

    /**
     * Dessine le polygone sur la zone cible.
     *
     * @param area zone de dessin
     */
    public void draw(CanvasArea area) {
        area.tracerPolygone(points);
    }

    /**
     * Modifie le nombre logique de sommets.
     *
     * @param newVar nouveau nombre
     */
    public void setN (int newVar) {
        n = newVar;
    }

    /**
     * Retourne le nombre logique de sommets.
     *
     * @return nombre de sommets
     */
    public int getN () {
        return n;
    }

    /**
     * Remplace la liste des sommets.
     *
     * @param newVar nouvelle liste
     */
    public void setPoints (ArrayList<CoordPoint> newVar) {
        points = newVar;
    }

    /**
     * Retourne les sommets du polygone.
     *
     * @return liste des sommets
     */
    public ArrayList<CoordPoint> getPoints () {
        return points;
    }

    /**
     * Retourne une description textuelle du polygone.
     *
     * @return description formatée
     */
    public String decrire()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("points :\n");
        for (CoordPoint point : points) {
            sb.append(point.decrire()).append("\n");
        }
        sb.append("n : ").append(n);
        return sb.toString();
    }
}
