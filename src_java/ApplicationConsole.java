package pixel_tracer.src_java;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lance l'application en mode console et maintient le contexte courant
 * (zone, calque, forme) pendant la boucle interactive.
 */
public class ApplicationConsole {
    /** Liste de toutes les zones de dessin de la session. */
    private ArrayList<CanvasArea> areas;
    /** Zone actuellement sélectionnée. */
    public CanvasArea currentArea;
    /** Calque actuellement sélectionné. */
    public DrawingLayer currentLayer;
    /** Forme actuellement sélectionnée. */
    public DrawableShape currentShape;
    /** Dernière commande lue depuis l'entrée standard. */
    private Instruction command;

    /**
     * Construit l'application console et initialise la collection de zones.
     */
    public ApplicationConsole() {
        areas = new ArrayList<>();
    }

    /**
     * Démarre l'application interactive.
     *
     * <p>Cette méthode crée une zone et un calque par défaut, affiche le rendu
     * initial, puis entre dans une boucle infinie de lecture/exécution
     * des commandes utilisateur.</p>
     */
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

    /**
     * Ajoute une nouvelle zone de dessin à la session courante.
     *
     * @param area zone à ajouter
     */
    public void ajouterZone(CanvasArea area) {
        areas.add(area);
    }

    /**
     * Retourne toutes les zones de dessin connues.
     *
     * @return liste des zones
     */
    public ArrayList<CanvasArea> getZones() {
        return areas;
    }

    /**
     * Point d'entrée principal de l'application.
     *
     * @param args arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        ApplicationConsole app = new ApplicationConsole();
        app.demarrer();
    }
}
