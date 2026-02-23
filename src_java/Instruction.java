package pixel_tracer.src_java;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parse une ligne utilisateur puis execute l'action correspondante
 * sur l'etat de l'application.
 */
public class Instruction {
    /** Nom de la commande (ex: line, circle, list). */
    private String name;
    /** Paramètres entiers extraits de la ligne utilisateur. */
    private ArrayList<Integer> intParams;
    /** Paramètres textuels extraits de la ligne utilisateur. */
    private ArrayList<String> strParams;
    /** Nombre maximal de paramètres acceptés par type. */
    private static final int MAX_PARAM = 30;

    /**
     * Construit une instruction vide.
     */
    public Instruction() {
        this.name = "";
        this.intParams = new ArrayList<>();
        this.strParams = new ArrayList<>();
    }

    /**
     * Vide le contenu de la commande courante.
     */
    public void viderCommande() {
        this.name = "";
        this.intParams.clear();
        this.strParams.clear();
    }

    /**
     * Ajoute un paramètre entier si la limite n'est pas atteinte.
     *
     * @param p valeur entière
     */
    public void addIntParam(int p) {
        if (intParams.size() < MAX_PARAM) {
            intParams.add(p);
        }
    }

    /**
     * Ajoute un paramètre textuel si la limite n'est pas atteinte.
     *
     * @param s valeur textuelle
     */
    public void addStrParam(String s) {
        if (strParams.size() < MAX_PARAM) {
            strParams.add(s);
        }
    }

    /**
     * Lit une ligne depuis l'entrée standard et remplit les paramètres.
     *
     * <p>Les tokens numériques sont rangés dans {@code intParams},
     * les autres dans {@code strParams}. Le nom de commande est le premier
     * token textuel.</p>
     */
    public void lireDepuisStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("~> ");
        String line = scanner.nextLine().trim().toLowerCase();
        if (line.isEmpty()) return;
        String[] tokens = line.split("\\s+");
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                intParams.add(Integer.parseInt(token));
            } else {
                strParams.add(token);
            }
        }
        if (!strParams.isEmpty()) {
            name = strParams.get(0);
        }
    }

    /**
     * Affiche l'état de debug de l'instruction.
     */
    public void debug() {
        System.out.println("\n --- ");
        System.out.println("str:");
        for (String s : strParams) {
            System.out.println("<" + s + ">");
        }
        System.out.println("int:");
        for (int i : intParams) {
            System.out.println("<" + i + ">");
        }
    }

    /**
     * Retourne le nom de la commande.
     *
     * @return nom de commande
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne les paramètres textuels de la commande.
     *
     * @return paramètres textuels
     */
    public ArrayList<String> getStrParams() {
        return strParams;
    }

    /**
     * Retourne les paramètres entiers de la commande.
     *
     * @return paramètres entiers
     */
    public ArrayList<Integer> getIntParams() {
        return intParams;
    }

    /**
     * Affiche le panneau d'aide des commandes disponibles.
     */
    public void afficherAide() {
        System.out.println("\t**************************************************");
        System.out.println("\t****         VECTOR TEXT-BASED EDITOR         ****");
        System.out.println("\t**************************************************");
        System.out.println("\t==== Control ====");
        System.out.println("\tclear : clear screen ");
        System.out.println("\texit : exit the program ");
        System.out.println("\thelp : decrire this help ");
        System.out.println("\tplot : draw screen");
        System.out.println("\t==== Draw shapes ====");
        System.out.println("\tpoint px py : create point at position (px, py)");
        System.out.println("\tline x1 y1 x2 y2 : draw line from (x1, y1) to (x2, y2)");
        System.out.println("\tsquare x1 y1 l : draw square at (x1, y1) with side length l");
        System.out.println("\trectangle x1 y1 w h : draw rectangle at (x1, y1) with width w and height h");
        System.out.println("\tcircle x y r : draw circle at (x, y) with radius r");
        System.out.println("\tpolygon x1 y1 x2 y2 ... : draw polygon with vertices (x1, y1), (x2, y2), ...");
        System.out.println("\tcurve x1 y1 x2 y2 x3 y3 x4 y4 : draw Bezier curve with the given control points");
        System.out.println("\t==== Draw manager ====");
        System.out.println("\tlist {layers, areas, shapes} example :  list layers");
        System.out.println("\tselect {area, layer} {id}");
        System.out.println("\tdelete {area, layer, shape} {id}");
        System.out.println("\tnew {area, layer}");
        System.out.println("\t==== Set ====");
        System.out.println("\tset char {border, background} ascii_code");
        System.out.println("\tset layer {visible, invisible} {id}");
    }

    /**
     * Exécute la commande sur le contexte applicatif courant.
     *
     * <p>Cette méthode gère les commandes de contrôle, de dessin et de gestion
     * d'objets (list/select/delete/new/set), puis déclenche le redessin
     * si nécessaire.</p>
     *
     * @param app instance principale de l'application
     * @param area zone active
     * @param layer calque actif
     * @param shape forme active
     */
    public void executerInstruction(ApplicationConsole app, CanvasArea area, DrawingLayer layer, DrawableShape shape) {
        CoordPoint p1;
        CoordPoint p2;
        CoordPoint p3;
        CoordPoint p4;
        boolean shouldDrawCanvas = true;
        switch (getName()) {
            case "exit":
                if (this.strParams.size() == 1) {
                    MessageErreur.EXIT.afficher();
                    System.exit(0);
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    shouldDrawCanvas = false; 
                }
                break;
            case "clear":
                if (this.strParams.size() == 1) {
                    app.currentArea.reinitialiserZone();
                    System.out.flush();
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    shouldDrawCanvas = false; 
                }
                break;
            case "help":
                afficherAide();
                shouldDrawCanvas = false; 
                break;
            case "plot":
                if (this.strParams.size() == 1) { 
                    app.currentArea.reinitialiserZone(); 
                    app.currentArea.draw(); 
                    System.out.println("Canvas redrawn.");
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: plot");
                }
                shouldDrawCanvas = false;
                break;
            case "point":
                if (this.intParams.size() == 2) { 
                    p1 = new CoordPoint(this.intParams.get(0), this.intParams.get(1));
                    app.currentLayer.ajouterForme(p1);
                    area.tracerLigne(p1, p1); 
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: point {x} {y}");
                    shouldDrawCanvas = false;
                }
                break;
            case "line":
                if (this.intParams.size() == 4) { 
                    p1 = new CoordPoint(this.intParams.get(0), this.intParams.get(1));
                    p2 = new CoordPoint(this.intParams.get(2), this.intParams.get(3));
                    SegmentLine line = new SegmentLine(p1, p2);
                    app.currentLayer.ajouterForme(line);
                    area.tracerLigne(p1, p2); 
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: line {x1} {y1} {x2} {y2}");
                    shouldDrawCanvas = false;
                }
                break;
            case "square":
                if (this.intParams.size() == 3) { 
                    p1 = new CoordPoint(this.intParams.get(0), this.intParams.get(1));
                    BoxSquare square = new BoxSquare(p1, this.intParams.get(2));
                    app.currentLayer.ajouterForme(square);
                    area.tracerCarre(p1, this.intParams.get(2)); 
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: square {x} {y} {length}");
                    shouldDrawCanvas = false;
                }
                break;
            case "rectangle":
                if (this.intParams.size() == 4) { 
                    p1 = new CoordPoint(this.intParams.get(0), this.intParams.get(1));
                    BoxRectangle rectangle = new BoxRectangle(p1, this.intParams.get(2), this.intParams.get(3));
                    app.currentLayer.ajouterForme(rectangle);
                    area.tracerRectangle(p1, this.intParams.get(2), this.intParams.get(3)); 
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: rectangle {x} {y} {width} {height}");
                    shouldDrawCanvas = false;
                }
                break;
            case "circle":
                if (this.intParams.size() == 3) { 
                    p1 = new CoordPoint(this.intParams.get(0), this.intParams.get(1));
                    RoundCircle circle = new RoundCircle(p1, this.intParams.get(2));
                    app.currentLayer.ajouterForme(circle);
                    area.tracerCercle(p1, this.intParams.get(2)); 
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: circle {x} {y} {radius}");
                    shouldDrawCanvas = false;
                }
                break;
            case "curve":
                if (this.intParams.size() == 8) { 
                    p1 = new CoordPoint(this.intParams.get(0), this.intParams.get(1));
                    p2 = new CoordPoint(this.intParams.get(2), this.intParams.get(3));
                    p3 = new CoordPoint(this.intParams.get(4), this.intParams.get(5));
                    p4 = new CoordPoint(this.intParams.get(6), this.intParams.get(7));
                    BezierCurve curve = new BezierCurve(p1, p2, p3, p4);
                    app.currentLayer.ajouterForme(curve);
                    area.tracerCourbe(p1, p2, p3, p4); 
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: curve {x1} {y1} {x2} {y2} {x3} {y3} {x4} {y4}");
                    shouldDrawCanvas = false;
                }
                break;
            case "polygon":
                if (this.intParams.size() >= 4 && this.intParams.size() % 2 == 0) { 
                    ArrayList<CoordPoint> points = new ArrayList<>();
                    for (int i = 0; i < this.intParams.size(); i += 2) {
                        points.add(new CoordPoint(this.intParams.get(i), this.intParams.get(i + 1)));
                    }
                    MultiPolygon polygon = new MultiPolygon(points);
                    app.currentLayer.ajouterForme(polygon);
                    area.tracerPolygone(points); 
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: polygon {x1} {y1} {x2} {y2} ...");
                    shouldDrawCanvas = false;
                }
                break;
            case "list":
                if (this.strParams.size() == 2) {
                    String target = this.strParams.get(1);
                    switch (target) {
                        case "layers":
                            for (DrawingLayer l : app.currentArea.getCalques()) {
                                System.out.println("DrawingLayer ID: " + l.getId() + ", Name: " + l.getName());
                            }
                            break;
                        case "areas":
                            for (CanvasArea a : app.getZones()) {
                                System.out.println("CanvasArea ID: " + a.getId() + ", Name: " + a.getName());
                            }
                            break;
                        case "shapes":
                            for (DrawableShape s : app.currentLayer.getFormes()) {
                                System.out.println("DrawableShape ID: " + s.getId() + ", Type: " + s.getClass().getSimpleName());
                            }
                            break;
                        default:
                            MessageErreur.UNKNOWN_COMMAND.afficher();
                    }
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                }
                shouldDrawCanvas = false;
                break;
            case "select":
                if (this.strParams.size() == 2 && this.intParams.size() == 1) { 
                    String target = this.strParams.get(1);
                    int id = this.intParams.get(0); 
                    switch (target) {
                        case "area":
                            boolean areaFound = false;
                            for (CanvasArea a : app.getZones()) {
                                if (a.getId() == id) {
                                    app.currentArea = a;
                                    System.out.println("Selected CanvasArea ID: " + id);
                                    areaFound = true;
                                    break;
                                }
                            }
                            if (!areaFound) {
                                MessageErreur.UNKNOWN_ID.afficher();
                            }
                            break;
                        case "layer":
                            boolean layerFound = false;
                            for (DrawingLayer l : app.currentArea.getCalques()) {
                                if (l.getId() == id) {
                                    app.currentLayer = l;
                                    System.out.println("Selected DrawingLayer ID: " + id);
                                    layerFound = true;
                                    break;
                                }
                            }
                            if (!layerFound) {
                                MessageErreur.UNKNOWN_ID.afficher();
                            }
                            break;
                        default:
                            MessageErreur.UNKNOWN_COMMAND.afficher();
                    }
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: select {area, layer} {id}");
                }
                shouldDrawCanvas = false;
                break;
            case "delete":
                if (this.strParams.size() == 2 && this.intParams.size() == 1) { 
                    String target = this.strParams.get(1);
                    int id = this.intParams.get(0); 
                    switch (target) {
                        case "area":
                            app.getZones().removeIf(a -> a.getId() == id);
                            System.out.println("Deleted CanvasArea ID: " + id);
                            break;
                        case "layer":
                            app.currentArea.getCalques().removeIf(l -> l.getId() == id);
                            app.currentArea.reinitialiserZone();
                            app.currentArea.draw();
                            System.out.println("Deleted DrawingLayer ID: " + id);
                            break;
                        case "shape":
                            app.currentLayer.getFormes().removeIf(s -> s.getId() == id);
                            System.out.println("Deleted DrawableShape ID: " + id);
                            break;
                        default:
                            MessageErreur.UNKNOWN_COMMAND.afficher();
                    }
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: delete {area, layer, shape} {id}");
                }
                shouldDrawCanvas = false;
                break;
            case "new":
                if (this.strParams.size() == 2) {
                    String target = this.strParams.get(1);
                    switch (target) {
                        case "area":
                            CanvasArea newArea = new CanvasArea(40, 40, SequenceId.instance().prochainId(), "new_area");
                            app.ajouterZone(newArea);
                            System.out.println("Created new CanvasArea ID: " + newArea.getId());
                            break;
                        case "layer":
                            DrawingLayer newLayer = new DrawingLayer("new_layer", SequenceId.instance().prochainId());
                            app.currentArea.ajouterCalque(newLayer);
                            System.out.println("Created new DrawingLayer ID: " + newLayer.getId());
                            break;
                        default:
                            MessageErreur.UNKNOWN_COMMAND.afficher();
                    }
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                }
                shouldDrawCanvas = false;
                break;
            case "set":
                if (this.strParams.size() == 3 && this.intParams.size() == 1) { 
                    String target = this.strParams.get(2);
                    int asciiCode = this.intParams.get(0); 

                    
                    if (asciiCode < 32 || asciiCode > 126) {
                        MessageErreur.INVALID_PARAMETERS.afficher();
                        System.out.println("ASCII code must be between 32 and 126 for printable characters.");
                        shouldDrawCanvas = false;
                        break;
                    }
                    char newChar = (char) asciiCode; 
                    switch (target) {
                        case "background":
                            area.setEmptyChar(newChar);
                            System.out.println("Background character set to: " + newChar);
                            break;
                        case "border":
                            area.setFullChar(newChar);
                            System.out.println("Border character set to: " + newChar);
                            break;
                        default:
                            MessageErreur.UNKNOWN_COMMAND.afficher();
                    }
                } else {
                    MessageErreur.INVALID_PARAMETERS.afficher();
                    System.out.println("Expected format: set char {background, border} {ascii_code}");
                }
                shouldDrawCanvas = false;
                break;
            default:
                System.out.println("Commande inconnue"); 
                shouldDrawCanvas = false; 
                break;
        }
        if (shouldDrawCanvas) {
            app.currentArea.draw(); 
        }
    }
}
