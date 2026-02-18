package pixel_tracer.src_java;
import pixel_tracer.src_java.SequenceId;
import pixel_tracer.src_java.DrawableType;

import java.awt.*;
import java.util.*;
/**
 * Rectangle dessine par contour a partir d'un coin de reference.
 */
public class BoxRectangle extends DrawableShape {
  private CoordPoint p1;
  private int width;
  private int height;

  public BoxRectangle(CoordPoint p1, int width, int height) {
    super(SequenceId.instance().prochainId(), DrawableType.RECTANGLE);
    this.p1 = p1;
    this.width = width;
    this.height = height;
  };

  public void draw(CanvasArea area) {
        area.tracerRectangle(p1, width, height);
    }
  public void setP1 (CoordPoint newVar) {
    p1 = newVar;
  }
  public CoordPoint getP1 () {
    return p1;
  }
  public void setWidth (int newVar) {
    width = newVar;
  }
  public int getWidth () {
    return width;
  }
  public void setHeight (int newVar) {
    height = newVar;
  }
  public int getHeight () {
    return height;
  }
  public String decrire()
  {
    return "p1 : " + p1.decrire() + "\nwidth : " + width + "\nheight : " + height;
  }
}