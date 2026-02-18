#include <stdlib.h>
#include <stdio.h>
#include "layers.h"
#include "area.h"
#include "pixel.h"
/**
 * @file render.h
 * @brief Fonctions de rendu ASCII pour Pixel Tracer.
 *
 * Ce module gère :
 *  - l'effacement de l'écran
 *  - le rendu des zones (Area)
 *  - le dessin des layers et des shapes
 *
 * Il constitue la couche de rendu de l'application.
 */
#ifndef _RENDER_H_
#  define _RENDER_H_

/**
 * @enum color_cell
 * @brief Types de cellules dans la zone de rendu.
 *
 * Utilisé pour représenter l'état logique d'une cellule
 * avant affichage ASCII.
 */
typedef enum { EMPTY_CELL, BLACK_CELL, RED_CELL } color_cell;

/**
 * @brief Caractère utilisé pour représenter une cellule vide le dessin en gros.
 */
#  define EMPTY_CHAR '.'
/**
 * @brief Caractère utilisé pour représenter une cellule pleine.
 */
#  define FULL_CHAR  '#'

void render_area(Area * area);
/**
 * @brief Affiche une zone de dessin à l'écran.
 *
 * Parcourt la matrice de l'area et affiche les caractères
 * correspondants à chaque cellule.
 *
 * @param area Zone à afficher
 */
void draw_area(Area * area);

/**
 * @brief Efface l'écran du terminal.
 *
 * La commande utilisée dépend du système d'exploitation.
 */
void clear_screen();

/**
 * @brief Dessine toutes les formes d'un layer dans l'area.
 *
 * Chaque forme est convertie en pixels puis projetée
 * dans la matrice de l'area.
 *
 * @param area Zone de dessin
 * @param layer Layer à dessiner
 */
void draw_layer_shapes(Area * area, Layer * layer);

/**
 * @brief Dessine toutes les couches visibles d'une area.
 *
 * - Nettoie l'area
 * - Parcourt les layers
 * - Dessine uniquement les layers visibles
 *
 * @param area Zone de dessin
 */
void draw_all_layers(Area * area);

#endif
