package pixel_tracer.src_java;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Polygone compose d'une sequence ordonnee de sommets.
 */
public class MultiPolygon extends DrawableShape {
    private int n;
    private ArrayList<CoordPoint> points;

    public MultiPolygon(ArrayList<CoordPoint> pointsList) {
        super(SequenceId.instance().prochainId(), DrawableType.POLYGON);
        points = pointsList;
    }
    public MultiPolygon(int n) {
        super(SequenceId.instance().prochainId(), DrawableType.POLYGON);
        points = new ArrayList<CoordPoint>(n);
    }
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
    public void ajouterPoint(CoordPoint p) {
        points.add(p);
    }
    public void draw(CanvasArea area) {
        area.tracerPolygone(points);
    }
    public void setN (int newVar) {
        n = newVar;
    }
    public int getN () {
        return n;
    }
    public void setPoints (ArrayList<CoordPoint> newVar) {
        points = newVar;
    }
    public ArrayList<CoordPoint> getPoints () {
        return points;
    }
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
