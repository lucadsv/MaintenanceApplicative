package pixel_tracer.src_java;
import pixel_tracer.src_java.DrawableType;

import java.util.*;
/**
 * Type de base abstrait pour les formes manipulees par le moteur de dessin.
 */
abstract public class DrawableShape  {
    /** Identifiant unique de la forme. */
    private int id;
    /** Catégorie de forme. */
    private DrawableType type;
    /** Couleur logique associée à la forme. */
    private String color;
    /** Épaisseur logique du trait. */
    private float thickness;
    /** Rotation logique de la forme. */
    private float rotation;
    /** Indique si la forme est remplie. */
    private boolean fill;

    /**
     * Construit une forme de base.
     *
     * @param id identifiant unique
     * @param type type de la forme
     */
    public DrawableShape(int id, DrawableType type) {
        this.id = id;
        this.type = type;
        this.color = "BLACK";
        this.thickness = 1.0f;
        this.rotation = 0.0f;
        this.fill = false;
    }

    /**
     * Dessine la forme sur la zone passée en paramètre.
     *
     * @param area zone de rendu
     */
    public abstract void draw(CanvasArea area);

    /**
     * Retourne une description textuelle de la forme.
     *
     * @return description de la forme
     */
    public abstract String decrire();

    /**
     * Définit l'identifiant de la forme.
     *
     * @param newVar nouvel identifiant
     */
    public void setId(int newVar) {
        id = newVar;
    }

    /**
     * Retourne l'identifiant de la forme.
     *
     * @return identifiant
     */
    public int getId() {
        return id;
    }

    /**
     * Active ou désactive le remplissage logique.
     *
     * @param newVar état du remplissage
     */
    public void setFill(boolean newVar) {
        fill = newVar;
    }

    /**
     * Retourne l'état de remplissage logique.
     *
     * @return vrai si rempli
     */
    public boolean getFill() {
        return fill;
    }

    /**
     * Définit la couleur logique.
     *
     * @param newVar nouvelle couleur
     */
    public void setColor(String newVar) {
        color = newVar;
    }

    /**
     * Retourne la couleur logique de la forme.
     *
     * @return couleur
     */
    public String getColor() {
        return color;
    }

    /**
     * Retourne une représentation textuelle par défaut.
     *
     * @return chaîne par défaut
     */
    public String toString(){
        return "Unknown shape";
    }
}
