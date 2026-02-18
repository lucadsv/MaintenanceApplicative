package pixel_tracer.src_java;

/**
 * Sequence globale d'identifiants incrementaux.
 */
public class SequenceId {
    private static SequenceId instance;
    private int id;
    private SequenceId(){
        id=0;
    }
    public static synchronized SequenceId instance(){
        if (instance==null){
            instance = new SequenceId();
        }
        return instance;
    }
    public synchronized int prochainId(){
        return id++;
    }
}