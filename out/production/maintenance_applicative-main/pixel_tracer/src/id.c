/**
 * @file id.c
 * @brief Gestion globale des identifiants uniques (ID) utilisés par Pixel Tracer.
 *
 * Ce module maintient un compteur global d'ID et fournit des fonctions
 * pour obtenir un nouvel ID, définir manuellement l'ID courant,
 * et sauvegarder / charger l'ID depuis un fichier.
 */

#include "id.h"

static unsigned long long int global_id = 0;

/**
 * @brief Retourne un nouvel ID unique.
 *
 * Chaque appel incrémente le compteur global et renvoie la nouvelle valeur.
 *
 * @return Prochain identifiant unique (unsigned long long int).
 */
unsigned long long int get_next_id() {
    global_id++;
    return global_id;
}

/**
 * @brief Définit manuellement la valeur courante de l'ID global.
 *
 * Utile lors du chargement d'une session ou pour réinitialiser l'ID.
 *
 * @param id Valeur à attribuer au compteur global.
 */
void set_id(unsigned long long int id) {
    global_id = id;
}

/**
 * @brief Sauvegarde l'ID courant dans un fichier (non implémenté).
 *
 * Objectif : permettre de reprendre la numérotation des IDs après fermeture.
 * @note TODO : implémenter la sauvegarde dans le fichier ID_FILE.
 */
void save_id() {
    // todo save id in file ID_FILE
}

/**
 * @brief Charge l'ID courant depuis un fichier (non implémenté).
 *
 * Objectif : récupérer la dernière valeur d'ID utilisée.
 * @note TODO : implémenter le chargement depuis le fichier ID_FILE.
 */
void load_id() {
    // todo load id from file ID_FILE
}
