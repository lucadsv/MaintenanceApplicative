package pixel_tracer.src_java;
import java.util.*;

/**
 * Point 2D basique utilise comme forme drawable.
 */
public class CoordPoint extends DrawableShape {
  /** Abscisse du point. */
  private int x;
  /** Ordonnée du point. */
  private int y;

  /**
   * Construit un point 2D.
   *
   * @param x abscisse
   * @param y ordonnée
   */
  public CoordPoint(int x, int y) {
    super(SequenceId.instance().prochainId(), DrawableType.POINT);
    this.x = x;
    this.y = y;
  }

  /**
   * Dessine le point sur la zone cible.
   *
   * @param area zone de dessin
   */
  public void draw(CanvasArea area) {
      area.tracerPoint(this);
  }

  /**
   * Modifie l'abscisse.
   *
   * @param newVar nouvelle abscisse
   */
  public void setX (int newVar) {
    x = newVar;
  }

  /**
   * Retourne l'abscisse.
   *
   * @return abscisse
   */
  public int getX () {
    return x;
  }

  /**
   * Modifie l'ordonnée.
   *
   * @param newVar nouvelle ordonnée
   */
  public void setY (int newVar) {
    y = newVar;
  }

  /**
   * Retourne l'ordonnée.
   *
   * @return ordonnée
   */
  public int getY () {
    return y;
  }

  /**
   * Retourne une description textuelle du point.
   *
   * @return description formatée
   */
  @Override
  public String decrire() {
    return "CoordPoint(x: " + x + ", y: " + y + ")";
  }
}
