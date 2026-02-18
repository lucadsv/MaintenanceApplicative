package pixel_tracer.src_java;
import pixel_tracer.src_java.DrawableType;

import java.util.*;
/**
 * Type de base abstrait pour les formes manipulees par le moteur de dessin.
 */
abstract public class DrawableShape  {
    private int id;
    private DrawableType type;
    private String color;
    private float thickness;
    private float rotation;
    private boolean fill;

    public DrawableShape(int id, DrawableType type) {
        this.id = id;
        this.type = type;
        this.color = "BLACK";
        this.thickness = 1.0f;
        this.rotation = 0.0f;
        this.fill = false;
    }
    public abstract void draw(CanvasArea area);
    public abstract String decrire();
    public void setId(int newVar) {
        id = newVar;
    }
    public int getId() {
        return id;
    }
    public void setFill(boolean newVar) {
        fill = newVar;
    }
    public boolean getFill() {
        return fill;
    }
    public void setColor(String newVar) {
        color = newVar;
    }
    public String getColor() {
        return color;
    }
    public String toString(){
        return "Unknown shape";
    }
}