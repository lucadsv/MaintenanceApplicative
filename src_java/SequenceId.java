package pixel_tracer.src_java;

/**
 * Sequence globale d'identifiants incrementaux.
 */
public class SequenceId {
    /** Instance singleton du générateur. */
    private static SequenceId instance;
    /** Compteur courant des identifiants. */
    private int id;

    /**
     * Constructeur privé du singleton.
     */
    private SequenceId(){
        id=0;
    }

    /**
     * Retourne l'instance singleton du générateur.
     *
     * @return instance unique de SequenceId
     */
    public static synchronized SequenceId instance(){
        if (instance==null){
            instance = new SequenceId();
        }
        return instance;
    }

    /**
     * Retourne le prochain identifiant et incrémente le compteur.
     *
     * @return identifiant suivant
     */
    public synchronized int prochainId(){
        return id++;
    }
}
