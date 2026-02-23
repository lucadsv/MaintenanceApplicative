package pixel_tracer.src_java;
import java.util.*;

/**
 * Segment defini par deux coordonnees extremites.
 */
public class SegmentLine extends DrawableShape {
  /** Premier point du segment. */
  private CoordPoint p1;
  /** Second point du segment. */
  private CoordPoint p2;

  /**
   * Construit un segment à partir de deux points.
   *
   * @param p1 point de départ
   * @param p2 point d'arrivée
   */
  public SegmentLine(CoordPoint p1, CoordPoint p2) {
    super(SequenceId.instance().prochainId(), DrawableType.LINE);
    this.p1 = p1;
    this.p2 = p2;
  }

  /**
   * Dessine le segment sur la zone cible.
   *
   * @param area zone de dessin
   */
  public void draw(CanvasArea area) {
        area.tracerLigne(p1, p2);
    }

  /**
   * Modifie le premier point.
   *
   * @param newVar nouveau premier point
   */
  public void setP1 (CoordPoint newVar) {
    p1 = newVar;
  }

  /**
   * Retourne le premier point.
   *
   * @return premier point
   */
  public CoordPoint getP1 () {
    return p1;
  }

  /**
   * Modifie le second point.
   *
   * @param newVar nouveau second point
   */
  public void setP2 (CoordPoint newVar) {
    p2 = newVar;
  }

  /**
   * Retourne le second point.
   *
   * @return second point
   */
  public CoordPoint getP2 () {
    return p2;
  }

  /**
   * Retourne une description textuelle du segment.
   *
   * @return description formatée
   */
  public String decrire()
  {
    return "points :\np1 : " + p1.decrire() + "\np2 : " + p2.decrire();
  }
}
