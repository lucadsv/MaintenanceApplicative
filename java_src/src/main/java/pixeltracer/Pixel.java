package main.java.pixeltracer;
public class Pixel {
    private int px;
    private int py;
    private int color; // store as int (could be enum / ARGB)

    public Pixel(int px, int py, int color) {
        this.px = px;
        this.py = py;
        this.color = color;
    }

    public int getX() { return px; }
    public int getY() { return py; }
    public int getColor() { return color; }

    public void setColor(int c) { this.color = c; }
}