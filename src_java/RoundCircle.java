package pixel_tracer.src_java;
import java.util.*;

/**
 * Cercle caracterise par un centre et un rayon.
 */
public class RoundCircle extends DrawableShape {
    /** Centre du cercle. */
    private CoordPoint center;
    /** Rayon du cercle. */
    private int radius;

    /**
     * Construit un cercle à partir d'un centre et d'un rayon.
     *
     * @param center centre du cercle
     * @param radius rayon
     */
    public RoundCircle(CoordPoint center, int radius) {
        super(SequenceId.instance().prochainId(), DrawableType.CIRCLE);
        this.center = center;
        this.radius = radius;
    }

    /**
     * Construit un cercle à partir de coordonnées.
     *
     * @param px abscisse du centre
     * @param py ordonnée du centre
     * @param radius rayon
     */
    public RoundCircle(int px, int py, int radius) {
        super(SequenceId.instance().prochainId(), DrawableType.CIRCLE);
        this.center = new CoordPoint(px, py);
        this.radius = radius;
    }

    /**
     * Retourne une description textuelle du cercle.
     *
     * @return description formatée
     */
    @Override
    public String decrire() {
        return "RoundCircle(center: " + center.decrire() + ", radius: " + radius + ")";
    }

    /**
     * Modifie le centre du cercle.
     *
     * @param newVar nouveau centre
     */
    public void setCenter(CoordPoint newVar) {
        center = newVar;
    }

    /**
     * Retourne le centre du cercle.
     *
     * @return centre
     */
    public CoordPoint getCenter() {
        return center;
    }

    /**
     * Modifie le rayon.
     *
     * @param newVar nouveau rayon
     */
    public void setRadius(int newVar) {
        radius = newVar;
    }

    /**
     * Retourne le rayon.
     *
     * @return rayon
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Dessine le cercle sur la zone cible.
     *
     * @param area zone de dessin
     */
    public void draw(CanvasArea area) {
        area.tracerCercle(center, radius);
    }
}
