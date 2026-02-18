package pixel_tracer.src_java;
import java.util.*;

/**
 * Cercle caracterise par un centre et un rayon.
 */
public class RoundCircle extends DrawableShape {
    private CoordPoint center;
    private int radius;

    public RoundCircle(CoordPoint center, int radius) {
        super(SequenceId.instance().prochainId(), DrawableType.CIRCLE);
        this.center = center;
        this.radius = radius;
    }

    public RoundCircle(int px, int py, int radius) {
        super(SequenceId.instance().prochainId(), DrawableType.CIRCLE);
        this.center = new CoordPoint(px, py);
        this.radius = radius;
    }

    @Override
    public String decrire() {
        return "RoundCircle(center: " + center.decrire() + ", radius: " + radius + ")";
    }

    public void setCenter(CoordPoint newVar) {
        center = newVar;
    }
    public CoordPoint getCenter() {
        return center;
    }
    public void setRadius(int newVar) {
        radius = newVar;
    }
    public int getRadius() {
        return radius;
    }
    public void draw(CanvasArea area) {
        area.tracerCercle(center, radius);
    }
}