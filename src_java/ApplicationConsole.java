package pixel_tracer.src_java;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lance l'application en mode console et maintient le contexte courant
 * (zone, calque, forme) pendant la boucle interactive.
 */
public class ApplicationConsole {
    private ArrayList<CanvasArea> areas;
    public CanvasArea currentArea;
    public DrawingLayer currentLayer;
    public DrawableShape currentShape;
    private Instruction command;

    public ApplicationConsole() {
        areas = new ArrayList<>();
    }
    public void demarrer() {
        System.out.println("Pixel Tracer ApplicationConsole");
        CanvasArea area = new CanvasArea(40, 40, SequenceId.instance().prochainId(), "default");
        areas.add(area);
        currentArea = area;
        currentLayer = new DrawingLayer("default", SequenceId.instance().prochainId());
        currentArea.ajouterCalque(currentLayer);
        currentArea.draw();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            command = new Instruction();
            command.viderCommande();
            command.lireDepuisStdin();
            command.executerInstruction(this, currentArea, currentLayer, currentShape);
        }
    }
    public void ajouterZone(CanvasArea area) {
        areas.add(area);
    }
    public ArrayList<CanvasArea> getZones() {
        return areas;
    }
    public static void main(String[] args) {
        ApplicationConsole app = new ApplicationConsole();
        app.demarrer();
    }
}