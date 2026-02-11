public class Command {

    public static final int MAX_PARAM = 30;

    private String name;

    private int intSize;
    private int[] intParams;

    private int strSize;
    private String[] strParams;

    private int fltSize;
    private float[] fltParams;

    // === create_commande ===
    public Command() {
        this.name = "";

        this.intSize = 0;
        this.intParams = new int[MAX_PARAM];

        this.strSize = 0;
        this.strParams = new String[MAX_PARAM];

        this.fltSize = 0;
        this.fltParams = new float[MAX_PARAM];
    }

    // === add_int_param ===
    public void addIntParam(int p) {
        if (intSize < MAX_PARAM) {
            intParams[intSize++] = p;
        }
    }

    // === add_float_param ===
    public void addFloatParam(float p) {
        if (fltSize < MAX_PARAM) {
            fltParams[fltSize++] = p;
        }
    }

    // === add_str_param ===
    public void addStrParam(String p) {
        if (strSize < MAX_PARAM) {
            strParams[strSize++] = p;
        }
    }

    // === free_cmd ===
    // Pas nécessaire en Java, mais on garde un reset logique
    public void clear() {
        name = "";
        intSize = strSize = fltSize = 0;
    }

    // === getters / setters ===

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getIntParams() {
        return intParams;
    }

    public float[] getFltParams() {
        return fltParams;
    }

    public String[] getStrParams() {
        return strParams;
    }

    public int getIntSize() {
        return intSize;
    }

    public int getStrSize() {
        return strSize;
    }

    public int getFltSize() {
        return fltSize;
    }
}
