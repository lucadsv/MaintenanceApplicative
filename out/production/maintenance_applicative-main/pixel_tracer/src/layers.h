#include "list.h"
#include "shape.h"
#include <stdlib.h>
#include <string.h>

#ifndef _LAYERS_H_
#  define _LAYERS_H_

#  define LAYER_VISIBLE 1
#  define LAYER_UNVISIBLE 0

/**
 * @file layers.h
 * @brief Gestion des calques (layers).
 */

/**
 * @brief Représente un calque de dessin.
 */
struct layer {
    unsigned int id;
    char name[255];
    unsigned char visible;
    list shapes;
};

typedef struct layer Layer;

/**
 * @brief Crée un calque.
 *
 * @param id identifiant du calque
 * @param name nom du calque
 * @return pointeur vers le calque créé
 */
Layer *create_layer(int id, char *name);

/**
 * @brief Supprime un calque (et ses shapes).
 *
 * @param layer calque à supprimer
 */
void delete_layer(Layer * layer);

/**
 * @brief Crée une liste de calques.
 */
LayersList *create_layers_list();

/**
 * @brief Supprime une liste de calques.
 */
void delete_layers_list(LayersList * layer_list);

/**
 * @brief Ajoute un calque à une liste.
 */
void add_layer_to_list(LayersList * layer_list, Layer * layer);

/**
 * @brief Retire un calque d'une liste.
 */
void remove_layer_from_list(LayersList * layer_list, Layer * layer);

/**
 * @brief Rends un calque visible.
 */
void set_layer_visible(Layer * layer);

/**
 * @brief Rends un calque invisible.
 */
void set_layer_unvisible(Layer * layer);

/**
 * @brief Ajoute une shape à un calque.
 */
void add_shape_to_layer(Layer * layer, Shape * shape);

/**
 * @brief Retire une shape d'un calque.
 */
void remove_shape_to_from(Layer * layer, Shape * shape);

#endif
