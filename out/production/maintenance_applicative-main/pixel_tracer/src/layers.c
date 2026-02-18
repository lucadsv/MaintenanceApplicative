/**
 * @file layers.c
 * @brief Gestion des calques (layers) dans Pixel Tracer.
 *
 * Ce module permet de créer, supprimer et manipuler des layers,
 * ainsi que d'ajouter/supprimer des shapes dans un layer.
 */
#include "layers.h"

/**
 * @brief Crée un nouveau layer.
 *
 * @param id Identifiant du layer.
 * @param name Nom du layer.
 * @return Pointeur vers le Layer créé (NULL si erreur).
 */
Layer *create_layer(int id, char *name) {
    Layer *ptr_layer = (Layer *) malloc(sizeof(Layer));
    ptr_layer->id = id;
    strcpy(ptr_layer->name, name);
    ptr_layer->shapes = *lst_create_list();
    ptr_layer->visible = 1;
    return ptr_layer;
}

/**
 * @brief Supprime un layer et libère la mémoire associée.
 *
 * @param layer Pointeur vers le layer à supprimer.
 */
void delete_layer(Layer * layer) {
    lst_erase(&layer->shapes);
    free(layer);
}

/**
 * @brief Crée une liste de layers.
 *
 * @return Pointeur vers la liste de layers.
 */
LayersList *create_layers_list() {
    LayersList *lst_layer;
    lst_layer = lst_create_list();
    return lst_layer;
}

/**
 * @brief Supprime une liste de layers.
 *
 * @param layer_list Pointeur vers la liste à supprimer.
 */
void delete_layers_list(LayersList * layer_list) {
    lst_delete_list(layer_list);
}


/**
 * @brief Ajoute un layer à une liste de layers.
 *
 * @param layer_list Liste cible.
 * @param layer Layer à ajouter.
 */
void add_layer_to_list(LayersList * layer_list, Layer * layer) {
    lnode *l = lst_create_lnode(layer);
    lst_insert_tail(layer_list, l);
}

/**
 * @brief Retire un layer d'une liste de layers.
 *
 * @param layer_list Liste cible.
 * @param layer Layer à retirer.
 *
 * @note Fonction non implémentée dans le TP actuel (TODO).
 */
void remove_layer_from_list(LayersList * layer_list, Layer * layer) {
    /* TODO  */
}

/**
 * @brief Rend un layer visible.
 *
 * @param layer Layer à rendre visible.
 */
void set_layer_visible(Layer * layer) {
    layer->visible = LAYER_VISIBLE;
}

/**
 * @brief Rend un layer invisible.
 *
 * @param layer Layer à rendre invisible.
 */
void set_layer_unvisible(Layer * layer) {
    layer->visible = LAYER_UNVISIBLE;
}

/**
 * @brief Ajoute une shape à un layer.
 *
 * @param layer Layer cible.
 * @param shape Shape à ajouter.
 */
void add_shape_to_layer(Layer * layer, Shape * shape) {
    lnode *l = lst_create_lnode(shape);
    lst_insert_tail(&(layer->shapes), l);
}
/**
 * @brief Retire une shape d'un layer.
 *
 * @param layer Layer cible.
 * @param shape Shape à retirer.
 *
 * @note Fonction non implémentée dans le TP actuel (TODO).
 */
void remove_shape_to_from(Layer * layer, Shape * shape) {

}
