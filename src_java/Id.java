package pixel_tracer.src_java;

/**
 * Compteur historique conserve pour compatibilite interne.
 */
public class Id {
    /** Instance singleton historique. */
    private static Id instance = null;
    /** Compteur statique courant. */
    private static int id = 0;

    /**
     * Retourne le prochain identifiant global.
     *
     * @return identifiant suivant
     */
    public static int get_nextId() {
        if (instance == null) {
            instance = new Id();
        }
        return id++;
    }
}
