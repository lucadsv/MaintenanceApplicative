package pixeltracer;
import java.util.ArrayList;
import java.util.List;

public class Area {
    private int id; // mapped from unsigned char
    private String name;
    private int width;
    private int height;
    private char[][] area; // grid
    private List<Layer> lstLayers;
    private char emptyChar = '.';
    private char fullChar = '#';

    public Area(int width, int height, int id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name != null ? name : "";
        this.area = new char[height][width];
        this.lstLayers = new ArrayList<>();
        clearArea();
    }

    public void clearArea() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                area[y][x] = emptyChar;
            }
        }
    }

    public void addLayer(Layer layer) {
        lstLayers.add(layer);
    }

    public void removeLayer(Layer layer) {
        lstLayers.remove(layer);
    }

    public List<Layer> getLayers() {
        return lstLayers;
    }

    // getters / setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public char[][] getAreaGrid() { return area; }
    public char getEmptyChar() { return emptyChar; }
    public char getFullChar() { return fullChar; }

    // helper for setting a cell
    public void setCell(int x, int y, char c) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = c;
        }
    }

    public char getCell(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return area[y][x];
        }
        return emptyChar;
    }
}