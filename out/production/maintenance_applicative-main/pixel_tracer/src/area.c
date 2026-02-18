/**
 * @file area.c
 * @brief Implémentation des fonctions de gestion des zones de dessin (Area).
 *
 * Ce module permet de créer, supprimer et manipuler des zones de dessin.
 * Chaque Area contient une matrice de caractères représentant le dessin et
 * une liste de calques (Layers).
 */

#include "area.h"
#include <string.h>  // IMPORTANT pour strcpy

/**
 * @brief Crée une nouvelle Area.
 *
 * @param width largeur de la zone
 * @param height hauteur de la zone
 * @param id identifiant unique
 * @param name nom de la zone
 * @return pointeur vers l'Area créée (NULL si erreur)
 *
 * @note La fonction alloue dynamiquement la mémoire pour la matrice 2D.
 */
Area *create_area(unsigned int width,
                  unsigned int height, unsigned char id, char *name) {
    Area *ptr_area = (Area *) malloc(sizeof(Area));
    ptr_area->width = width;
    ptr_area->height = height;
    ptr_area->lst_layers = create_layers_list();
    ptr_area->id = id;
    ptr_area->empty_char = '.';
    ptr_area->full_char = '@';
    strcpy(ptr_area->name, name);

    ptr_area->area = (char **) malloc(height * sizeof(char *));
    for (unsigned int i = 0; i < ptr_area->height; i++) {
        ptr_area->area[i] = (char *) malloc(width * sizeof(char));
    }
    return ptr_area;
}

/**
 * @brief Supprime une Area et libère la mémoire allouée.
 *
 * @param area pointeur vers l'Area à supprimer
 *
 * @warning La suppression des calques (layers) n'est pas encore implémentée.
 */
void delete_area(Area * area) {
    // todo: delate layers
    for (unsigned int i = 0; i < area->height; i++) {
        free(area->area[i]);
    }
    free(area);
}

/**
 * @brief Crée une liste d'Area.
 *
 * @return pointeur vers la liste créée
 */
AreaList *create_area_list() {
    AreaList *lst_area;
    lst_area = lst_create_list();
    return lst_area;
}

/**
 * @brief Supprime une liste d'Area.
 *
 * @param area_list liste à supprimer
 *
 * @note La suppression des zones contenues n'est pas encore implémentée.
 */
void delete_area_list(AreaList * area_list) {
    /* TODO : delete all layers on the list */
    lst_delete_list(area_list);
}

/**
 * @brief Ajoute une Area à une liste d'Area.
 *
 * @param area_list liste cible
 * @param area Area à ajouter
 */
void add_area_to_list(AreaList * area_list, Area * area) {
    lnode *l = lst_create_lnode(area);
    lst_insert_tail(area_list, l);
}

/**
 * @brief Retire une Area d'une liste d'Area.
 *
 * @param area_list liste cible
 * @param area Area à retirer
 *
 * @note Fonction non implémentée (TODO).
 */
void remove_area_from_list(AreaList * area_list, Area * area) {
    /* TODO  */
}
