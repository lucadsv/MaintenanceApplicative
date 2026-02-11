import java.util.Arrays;

public class Area {

    private int id;
    private String name;
    private int width;
    private int height;

    private char[][] area;

    private LayersList lstLayers;

    private char emptyChar;
    private char fullChar;

    // === create_area ===
    public Area(int width, int height, int id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name;

        this.lstLayers = new LayersList();

        this.emptyChar = '.';
        this.fullChar = '@';

        this.area = new char[height][width];

        // initialise comme en C (malloc + pas rempli → ici on remplit vide)
        clearArea();
    }

    // === delete_area ===
    // En Java pas de free — mais on peut nettoyer explicitement
    public void deleteArea() {
        if (lstLayers != null) {
            lstLayers.clear();
        }
        area = null;
    }

    // === clear_area ===
    public void clearArea() {
        for (int y = 0; y < height; y++) {
            Arrays.fill(area[y], emptyChar);
        }
    }

    // === helpers équivalents accès buffer ===

    public void setChar(int x, int y, char c) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = c;
        }
    }

    public char getChar(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return area[y][x];
        }
        return emptyChar;
    }

    // === getters ===

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public LayersList getLayersList() {
        return lstLayers;
    }

    public char getEmptyChar() {
        return emptyChar;
    }

    public char getFullChar() {
        return fullChar;
    }

    public char[][] getBuffer() {
        return area;
    }
}
