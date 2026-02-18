package pixel_tracer.src_java;
import java.util.*;

/**
 * Courbe de Bezier cubique definie par quatre points de controle.
 */
public class BezierCurve extends DrawableShape {
  private CoordPoint p1;
  private CoordPoint p2;
  private CoordPoint p3;
  private CoordPoint p4;

  public BezierCurve(CoordPoint p1, CoordPoint p2, CoordPoint p3, CoordPoint p4) {
    super(SequenceId.instance().prochainId(), DrawableType.CURVE);
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }
  public void draw(CanvasArea area) {
        area.tracerCourbe(p1, p2, p3, p4);
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
  public void setP3 (CoordPoint newVar) {
    p3 = newVar;
  }
  public CoordPoint getP3 () {
    return p3;
  }
  public void setP4 (CoordPoint newVar) {
    p4 = newVar;
  }
  public CoordPoint getP4 () {
    return p4;
  }
  public String decrire()
  {
    return "points :\np1 : " + p1.decrire() + "\np2 : " + p2.decrire() + "\np3 : " + p3.decrire() + "\np4 : " + p4.decrire();
  }
}