package main.java.pixeltracer;
import java.util.ArrayList;
import java.util.List;

/**
 * Corresponds to the C struct command
 */
public class Command {
    public static final int MAX_PARAM = 30;

    private String name;
    private final List<Integer> intParams = new ArrayList<>();
    private final List<String> strParams = new ArrayList<>();
    private final List<Float> fltParams = new ArrayList<>();

    public Command() {
        this.name = "";
    }

    public Command(String name) {
        this.name = name;
    }

    public void addIntParam(int p) {
        if (intParams.size() < MAX_PARAM) intParams.add(p);
    }

    public void addFloatParam(float p) {
        if (fltParams.size() < MAX_PARAM) fltParams.add(p);
    }

    public void addStrParam(String p) {
        if (strParams.size() < MAX_PARAM) strParams.add(p);
    }

    public void clear() {
        intParams.clear();
        fltParams.clear();
        strParams.clear();
        name = "";
    }

    // getters
    public String getName() { return name; }
    public List<Integer> getIntParams() { return intParams; }
    public List<String> getStrParams() { return strParams; }
    public List<Float> getFltParams() { return fltParams; }
}