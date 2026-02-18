package pixel_tracer.src_java;

/**
 * Compteur historique conserve pour compatibilite interne.
 */
public class Id {
    private static Id instance = null;
    private static int id = 0;

    public static int get_nextId() {
        if (instance == null) {
            instance = new Id();
        }
        return id++;
    }
}
