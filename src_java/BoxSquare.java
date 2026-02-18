package pixel_tracer.src_java;
import pixel_tracer.src_java.SequenceId;
import pixel_tracer.src_java.DrawableType;

import java.awt.*;
import java.util.*;


/**
 * Carre dessine par contour a partir d'un point d'ancrage.
 */
public class BoxSquare extends DrawableShape {
  private CoordPoint p1;
  private int length;

  public BoxSquare(CoordPoint p1, int length) {
    super(SequenceId.instance().prochainId(), DrawableType.SQUARE);
    this.p1 = p1;
    this.length = length;
  }
  public void draw(CanvasArea area) {
      area.tracerCarre(p1, length);
  }
  public void setP1 (CoordPoint newVar) {
    p1 = newVar;
  }
  public CoordPoint getP1 () {
    return p1;
  }
  public void setLength (int newVar) {
    length = newVar;
  }
  public int getLength () {
    return length;
  }
  public String decrire()
  {
    return "p1 : " + p1.decrire() + "\nlength : " + length;
  }
}