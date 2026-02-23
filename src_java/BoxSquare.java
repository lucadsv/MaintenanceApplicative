package pixel_tracer.src_java;
import pixel_tracer.src_java.SequenceId;
import pixel_tracer.src_java.DrawableType;

import java.awt.*;
import java.util.*;


/**
 * Carre dessine par contour a partir d'un point d'ancrage.
 */
public class BoxSquare extends DrawableShape {
  /** Point d'ancrage du carré. */
  private CoordPoint p1;
  /** Longueur du côté du carré. */
  private int length;

  /**
   * Construit un carré.
   *
   * @param p1 point d'ancrage
   * @param length longueur du côté
   */
  public BoxSquare(CoordPoint p1, int length) {
    super(SequenceId.instance().prochainId(), DrawableType.SQUARE);
    this.p1 = p1;
    this.length = length;
  }

  /**
   * Dessine le carré sur la zone cible.
   *
   * @param area zone de dessin
   */
  public void draw(CanvasArea area) {
      area.tracerCarre(p1, length);
  }

  /**
   * Modifie le point d'ancrage.
   *
   * @param newVar nouveau point
   */
  public void setP1 (CoordPoint newVar) {
    p1 = newVar;
  }

  /**
   * Retourne le point d'ancrage.
   *
   * @return point d'ancrage
   */
  public CoordPoint getP1 () {
    return p1;
  }

  /**
   * Modifie la longueur du côté.
   *
   * @param newVar nouvelle longueur
   */
  public void setLength (int newVar) {
    length = newVar;
  }

  /**
   * Retourne la longueur du côté.
   *
   * @return longueur
   */
  public int getLength () {
    return length;
  }

  /**
   * Retourne une description textuelle du carré.
   *
   * @return description formatée
   */
  public String decrire()
  {
    return "p1 : " + p1.decrire() + "\nlength : " + length;
  }
}
