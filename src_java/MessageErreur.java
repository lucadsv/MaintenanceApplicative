package pixel_tracer.src_java;

/**
 * Messages standardises utilises par l'interface en ligne de commande.
 */
public enum MessageErreur {
    /** Commande inconnue. */
    UNKNOWN_COMMAND("Commande inconnue"),
    /** Aucune commande fournie. */
    MISSING_COMMAND("Commande manquante"),
    /** Mauvais nombre de paramètres. */
    INVALID_PARAMETERS("Erreur: mauvais nombre de paramètres"),
    /** Paramètre numérique invalide. */
    INTEGER_PARAMETER("Erreur : les coordonnees et la longueur doivent être des nombres"),
    /** Message de sortie applicative. */
    EXIT("Exiting..."),
    /** Message de nettoyage écran. */
    CLEAR("Clearing..."),
    /** Message associé à la commande plot. */
    PLOT("plot"),
    /** Message d'aide. */
    HELP("~~~ Help ~~~"),
    /** Message de succès générique. */
    DONE("done"),
    /** Identifiant introuvable. */
    UNKNOWN_ID("Id inconnu dans la list");

    /** Texte du message. */
    private final String message;

    /**
     * Construit une entrée de message.
     *
     * @param message texte associé
     */
    MessageErreur(String message) {
        this.message = message;
    }

    /**
     * Retourne le texte du message.
     *
     * @return message brut
     */
    public String getMessage() {
        return message;
    }

    /**
     * Affiche le message sur la sortie standard.
     */
    public void afficher() {
        System.out.println(message);
    }
}
