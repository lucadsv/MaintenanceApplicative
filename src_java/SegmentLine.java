package pixel_tracer.src_java;
import java.util.*;

/**
 * Segment defini par deux coordonnees extremites.
 */
public class SegmentLine extends DrawableShape {
  private CoordPoint p1;
  private CoordPoint p2;

  public SegmentLine(CoordPoint p1, CoordPoint p2) {
    super(SequenceId.instance().prochainId(), DrawableType.LINE);
    this.p1 = p1;
    this.p2 = p2;
  }
  public void draw(CanvasArea area) {
        area.tracerLigne(p1, p2);
    }
  public void setP1 (CoordPoint newVar) {
    p1 = newVar;
  }
  public CoordPoint getP1 () {
    return p1;
  }
  public void setP2 (CoordPoint newVar) {
    p2 = newVar;
  }
  public CoordPoint getP2 () {
    return p2;
  }
  public String decrire()
  {
    return "points :\np1 : " + p1.decrire() + "\np2 : " + p2.decrire();
  }
}