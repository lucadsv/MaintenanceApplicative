#ifndef _PIXEL_TRACER_H_
#  define _PIXEL_TRACER_H_


/**
 * @file pixel_tracer.h
 * @brief Définition de l'application Pixel Tracer.
 *
 * Ce fichier définit la structure principale de l'application
 * ainsi que les fonctions d'initialisation et de destruction.
 */
#  include "list.h"
#  include "id.h"
#  include "area.h"
#  include "layers.h"
#  include "shape.h"
#  include "pixel.h"
#  include "render.h"

/**
 * @brief Structure principale de l'application Pixel Tracer.
 *
 * Elle contient :
 *  - la liste de toutes les areas
 *  - l'area actuellement sélectionnée
 *  - le layer actuellement sélectionné
 *  - la shape actuellement sélectionnée
 *
 * Cette structure représente l'état global de l'application.
 */

struct pixel_tracer {
    AreaList *list_area;
    Area *current_area;
    Layer *current_layer;
    Shape *current_shape;
};


typedef struct pixel_tracer Pixel_tracer_app;

/**
 * @brief Initialise l'application Pixel Tracer.
 *
 * Crée une area par défaut, un layer par défaut et initialise
 * les pointeurs de sélection.
 *
 * @param app Pointeur vers l'application à initialiser.
 */

void init_app(Pixel_tracer_app * app);


/**
 * @brief Détruit l'application Pixel Tracer.
 *
 * Libère les ressources principales utilisées par l'application.
 *
 * @param app Pointeur vers l'application à détruire.
 */
void destry_app(Pixel_tracer_app * app);


#endif
