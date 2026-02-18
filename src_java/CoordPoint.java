package pixel_tracer.src_java;
import java.util.*;

/**
 * Point 2D basique utilise comme forme drawable.
 */
public class CoordPoint extends DrawableShape {
  private int x;
  private int y;

  public CoordPoint(int x, int y) {
    super(SequenceId.instance().prochainId(), DrawableType.POINT);
    this.x = x;
    this.y = y;
  }
  public void draw(CanvasArea area) {
      area.tracerPoint(this);
  }
  public void setX (int newVar) {
    x = newVar;
  }
  public int getX () {
    return x;
  }
  public void setY (int newVar) {
    y = newVar;
  }
  public int getY () {
    return y;
  }
  @Override
  public String decrire() {
    return "CoordPoint(x: " + x + ", y: " + y + ")";
  }
}