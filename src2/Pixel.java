public class Pixel {

    private int px;
    private int py;
    private int color;

    // === create_pixel ===
    public Pixel(int px, int py, int color) {
        this.px = px;
        this.py = py;
        this.color = color;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public int getColor() {
        return color;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
