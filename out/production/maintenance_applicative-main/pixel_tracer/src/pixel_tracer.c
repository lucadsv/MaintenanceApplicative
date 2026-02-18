/**
 * @file pixel_tracer.c
 * @brief Initialisation et destruction de l'application Pixel Tracer.
 *
 * Ce module gère la création de l'état initial de l'application
 * (areas, layers, sélections courantes) ainsi que la libération
 * des ressources à la fin du programme.
 */

#include "pixel_tracer.h"

/**
 * @brief Initialise l'application Pixel Tracer.
 *
 * Cette fonction :
 *  - crée la liste des areas
 *  - crée une area par défaut
 *  - crée un premier layer dans cette area
 *  - initialise les pointeurs courants (area, layer, shape)
 *
 * @param app Pointeur vers la structure Pixel_tracer_app à initialiser.
 */
void init_app(Pixel_tracer_app * app) {
    app->list_area = create_area_list();
    Area *area = create_area(80, 40, get_next_id(), "Area1");
    add_area_to_list(app->list_area, area);
    app->current_area = area;

    LayersList *layerlst = create_layers_list();
    area->lst_layers = layerlst;
    Layer *layer = create_layer(get_next_id(), "Layer 1");
    add_layer_to_list(layerlst, layer);
    app->current_layer = layer;
    app->current_shape = NULL;
}

/**
 * @brief Détruit l'application Pixel Tracer.
 *
 * Cette fonction libère les ressources principales utilisées
 * par l'application et remet les pointeurs à NULL.
 *
 * @param app Pointeur vers la structure Pixel_tracer_app à détruire.
 */
void destry_app(Pixel_tracer_app * app) {
    delete_area_list(app->list_area);
    app->current_area = NULL;
    app->current_layer = NULL;
    app->current_shape = NULL;
}
