#include <stdlib.h>
#include <stdio.h>
#include "layers.h"

#ifndef _AREA_H_
#  define _AREA_H_


/**
 * @file area.h
 * @brief Gestion des "areas" (zones de dessin).
 *
 * Une Area représente une grille 2D (width x height) contenant un tableau
 * de caractères et une liste de calques (layers).
 */

/**
 * @brief Représente une zone de dessin (Area).
 *
 * @details
 * Une Area contient :
 *  - un id unique
 *  - un nom
 *  - une matrice de caractères (area)
 *  - une liste de calques (LayersList)
 *  - les caractères utilisés pour le fond et le remplissage
 */
struct area {
    unsigned char id;
    char name[255];
    unsigned int width;
    unsigned int height;
    char **area;
    LayersList *lst_layers;
    char empty_char;
    char full_char;
};

typedef struct area Area;

/**
 * @brief Crée une nouvelle Area.
 *
 * @param width largeur de la zone
 * @param height hauteur de la zone
 * @param id identifiant unique
 * @param name nom de la zone
 * @return pointeur vers l'Area créée (NULL si erreur)
 */
Area *create_area(unsigned int width, unsigned int height,
                  unsigned char id, char *name);

/**
 * @brief Supprime une Area et libère la mémoire.
 *
 * @param area pointeur vers l'Area à supprimer
 */
void delete_area(Area * area);

/**
 * @brief Vide une Area (remet tous les pixels à empty_char).
 *
 * @param area pointeur vers l'Area à nettoyer
 */
void clear_area(Area * area);

/**
 * @brief Crée une liste d'Area.
 *
 * @return pointeur vers la liste
 */
AreaList *create_area_list();

/**
 * @brief Supprime une liste d'Area.
 *
 * @param area_list liste à supprimer
 */
void delete_area_list(AreaList * area_list);

/**
 * @brief Ajoute une Area à une liste.
 *
 * @param area_list liste cible
 * @param area Area à ajouter
 */
void add_area_to_list(AreaList * area_list, Area * area);

/**
 * @brief Retire une Area d'une liste.
 *
 * @param area_list liste cible
 * @param area Area à retirer
 */
void remove_area_from_list(AreaList * area_list, Area * area);


#endif
