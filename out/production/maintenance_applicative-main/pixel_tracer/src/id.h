#ifndef _ID_H_
#  define _ID_H_

/**
 * @file id.h
 * @brief Interface de gestion des identifiants uniques (ID) pour Pixel Tracer.
 *
 * Ce module fournit des fonctions pour générer des IDs uniques,
 * les sauvegarder et les recharger depuis un fichier.
 */

/**
 * @brief Nom du fichier utilisé pour sauvegarder l'ID courant.
 *
 * Le fichier contient la dernière valeur utilisée afin de pouvoir
 * reprendre la numérotation après une fermeture de l'application.
 */
#  define ID_FILE "id.txt"

/**
 * @brief Retourne un nouvel ID unique.
 *
 * @return Prochain identifiant unique (unsigned long long int).
 */
unsigned long long int get_next_id();

/**
 * @brief Définit manuellement la valeur courante de l'ID global.
 *
 * @param id Valeur à attribuer au compteur global.
 */
void set_id(unsigned long long int id);

/**
 * @brief Sauvegarde l'ID courant dans le fichier ID_FILE.
 *
 * @note Fonction non implémentée dans le TP actuel (TODO).
 */
void save_id();

/**
 * @brief Charge l'ID courant depuis le fichier ID_FILE.
 *
 * @note Fonction non implémentée dans le TP actuel (TODO).
 */
void load_id();

#endif
