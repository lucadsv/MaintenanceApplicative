package pixel_tracer.src_java;
import pixel_tracer.src_java.SequenceId;
import pixel_tracer.src_java.DrawableType;

import java.awt.*;
import java.util.*;
/**
 * Rectangle dessine par contour a partir d'un coin de reference.
 */
public class BoxRectangle extends DrawableShape {
  /** Point d'ancrage du rectangle. */
  private CoordPoint p1;
  /** Largeur du rectangle. */
  private int width;
  /** Hauteur du rectangle. */
  private int height;

  /**
   * Construit un rectangle.
   *
   * @param p1 point d'ancrage
   * @param width largeur
   * @param height hauteur
   */
  public BoxRectangle(CoordPoint p1, int width, int height) {
    super(SequenceId.instance().prochainId(), DrawableType.RECTANGLE);
    this.p1 = p1;
    this.width = width;
    this.height = height;
  };

  /**
   * Dessine le rectangle sur la zone cible.
   *
   * @param area zone de dessin
   */
  public void draw(CanvasArea area) {
        area.tracerRectangle(p1, width, height);
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
   * Modifie la largeur.
   *
   * @param newVar nouvelle largeur
   */
  public void setWidth (int newVar) {
    width = newVar;
  }

  /**
   * Retourne la largeur.
   *
   * @return largeur
   */
  public int getWidth () {
    return width;
  }

  /**
   * Modifie la hauteur.
   *
   * @param newVar nouvelle hauteur
   */
  public void setHeight (int newVar) {
    height = newVar;
  }

  /**
   * Retourne la hauteur.
   *
   * @return hauteur
   */
  public int getHeight () {
    return height;
  }

  /**
   * Retourne une description textuelle du rectangle.
   *
   * @return description formatée
   */
  public String decrire()
  {
    return "p1 : " + p1.decrire() + "\nwidth : " + width + "\nheight : " + height;
  }
}
