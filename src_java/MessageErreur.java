package pixel_tracer.src_java;

/**
 * Messages standardises utilises par l'interface en ligne de commande.
 */
public enum MessageErreur {
    UNKNOWN_COMMAND("Commande inconnue"),
    MISSING_COMMAND("Commande manquante"),
    INVALID_PARAMETERS("Erreur: mauvais nombre de paramètres"),
    INTEGER_PARAMETER("Erreur : les coordonnees et la longueur doivent être des nombres"),
    EXIT("Exiting..."),
    CLEAR("Clearing..."),
    PLOT("plot"),
    HELP("~~~ Help ~~~"),
    DONE("done"),
    UNKNOWN_ID("Id inconnu dans la list");
    private final String message;
    MessageErreur(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void afficher() {
        System.out.println(message);
    }
}