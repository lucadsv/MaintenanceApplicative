package pixel_tracer.src_java;
import java.util.*;

/**
 * Courbe de Bezier cubique definie par quatre points de controle.
 */
public class BezierCurve extends DrawableShape {
  /** Premier point de contrôle. */
  private CoordPoint p1;
  /** Deuxième point de contrôle. */
  private CoordPoint p2;
  /** Troisième point de contrôle. */
  private CoordPoint p3;
  /** Quatrième point de contrôle. */
  private CoordPoint p4;

  /**
   * Construit une courbe de Bézier cubique.
   *
   * @param p1 premier point de contrôle
   * @param p2 deuxième point de contrôle
   * @param p3 troisième point de contrôle
   * @param p4 quatrième point de contrôle
   */
  public BezierCurve(CoordPoint p1, CoordPoint p2, CoordPoint p3, CoordPoint p4) {
    super(SequenceId.instance().prochainId(), DrawableType.CURVE);
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }

  /**
   * Dessine la courbe sur la zone cible.
   *
   * @param area zone de dessin
   */
  public void draw(CanvasArea area) {
        area.tracerCourbe(p1, p2, p3, p4);
    }

  /**
   * Modifie le premier point de contrôle.
   *
   * @param newVar nouveau point
   */
  public void setP1 (CoordPoint newVar) {
    p1 = newVar;
  }

  /**
   * Retourne le premier point de contrôle.
   *
   * @return premier point
   */
  public CoordPoint getP1 () {
    return p1;
  }

  /**
   * Modifie le deuxième point de contrôle.
   *
   * @param newVar nouveau point
   */
  public void setP2 (CoordPoint newVar) {
    p2 = newVar;
  }

  /**
   * Retourne le deuxième point de contrôle.
   *
   * @return deuxième point
   */
  public CoordPoint getP2 () {
    return p2;
  }

  /**
   * Modifie le troisième point de contrôle.
   *
   * @param newVar nouveau point
   */
  public void setP3 (CoordPoint newVar) {
    p3 = newVar;
  }

  /**
   * Retourne le troisième point de contrôle.
   *
   * @return troisième point
   */
  public CoordPoint getP3 () {
    return p3;
  }

  /**
   * Modifie le quatrième point de contrôle.
   *
   * @param newVar nouveau point
   */
  public void setP4 (CoordPoint newVar) {
    p4 = newVar;
  }

  /**
   * Retourne le quatrième point de contrôle.
   *
   * @return quatrième point
   */
  public CoordPoint getP4 () {
    return p4;
  }

  /**
   * Retourne une description textuelle de la courbe.
   *
   * @return description formatée
   */
  public String decrire()
  {
    return "points :\np1 : " + p1.decrire() + "\np2 : " + p2.decrire() + "\np3 : " + p3.decrire() + "\np4 : " + p4.decrire();
  }
}
