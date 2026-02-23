package pixel_tracer.src_java;
import java.util.ArrayList;

/**
 * Conteneur logique de formes avec un drapeau de visibilite.
 */
public class DrawingLayer {
    /** Identifiant unique du calque. */
    private int id;
    /** Nom lisible du calque. */
    private String name;
    /** Indique si le calque participe au rendu final. */
    private boolean visible;
    /** Liste des formes appartenant à ce calque. */
    private ArrayList<DrawableShape> shapes;

    /**
     * Construit un calque.
     *
     * @param name nom du calque
     * @param id identifiant du calque
     */
    public DrawingLayer(String name, int id) {
        this.name = name;
        this.id = id;
        this.shapes = new ArrayList<>();
        this.visible = true;
    }

    /**
     * Modifie la visibilité du calque.
     *
     * @param visible vrai si visible, faux sinon
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Ajoute une forme au calque.
     *
     * @param shape forme à ajouter
     */
    public void ajouterForme(DrawableShape shape) {
        shapes.add(shape);
    }

    /**
     * Supprime une forme du calque.
     *
     * @param shape forme à supprimer
     */
    public void supprimerForme(DrawableShape shape) {
        shapes.remove(shape);
    }

    /**
     * Indique si le calque est visible.
     *
     * @return vrai si visible
     */
    public boolean estVisible() {
        return visible;
    }

    /**
     * Retourne les formes du calque.
     *
     * @return liste des formes
     */
    public ArrayList<DrawableShape> getFormes() {
        return shapes;
    }

    /**
     * Retourne l'identifiant du calque.
     *
     * @return id du calque
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne le nom du calque.
     *
     * @return nom du calque
     */
    public String getName() {
        return name;
    }
}
