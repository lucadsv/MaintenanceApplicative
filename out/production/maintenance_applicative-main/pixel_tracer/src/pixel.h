#ifndef _PIXEL_H_
#  define _PIXEL_H_
/**
 * @file pixel.h
 * @brief Gestion des pixels et rasterisation des formes.
 *
 * Ce module est responsable de la conversion des formes géométriques
 * (points, lignes, cercles, polygones, courbes, etc.)
 * en une liste de pixels exploitables par le moteur de rendu.
 */

#  include <stdlib.h>
#  include "shape.h"
#  include "list.h"

/**
 * @brief Représente un pixel.
 *
 * Un pixel est défini par :
 *  - sa position (x, y)
 *  - sa couleur
 *
 * C’est l’unité de base utilisée pour le rendu.
 */
struct pixel {
    int px;
    int py;
    int color;
};

typedef struct pixel Pixel;

/* ===================== API PUBLIQUE ===================== */

/**
 * @brief Convertit une forme en une liste de pixels.
 *
 * Selon le type de la forme (point, ligne, rectangle, cercle, etc.),
 * l’algorithme de rasterisation approprié est appliqué.
 *
 * @param shape Forme à convertir
 * @return Liste de pixels générés
 */
/* to export*/
list *create_shape_to_pixel(Shape * shape);

/**
 * @brief Supprime une liste de pixels associée à une forme.
 *
 * @param pixel_lst Liste de pixels à supprimer
 */
void remove_pixel_shape(list * pixel_lst);


/* ===================== FONCTIONS INTERNES ===================== */

/**
 * @brief Crée un pixel.
 *
 * @param px Coordonnée X
 * @param py Coordonnée Y
 * @param color Couleur du pixel
 * @return Pointeur vers le pixel créé
 */
Pixel *create_pixel(int px, int py, int color);

/**
 * @brief Supprime un pixel.
 *
 * @param pixel Pixel à supprimer
 */
void delete_pixel(Pixel * pixel);
/**
 * @brief Rasterise un point.
 *
 * @param shape Forme de type POINT
 * @param lst Liste de pixels de sortie
 */
void pixel_point(Shape * shape, list * lst);

/**
 * @brief Rasterise une ligne.
 *
 * @param shape Forme de type LINE
 * @param lst Liste de pixels de sortie
 */
void pixel_line(Shape * shape, list * lst);

/**
 * @brief Rasterise un cercle.
 *
 * @param shape Forme de type CERCLE
 * @param lst Liste de pixels de sortie
 */
void pixel_cercle(Shape * shape, list * lst);

/**
 * @brief Rasterise un rectangle.
 *
 * @param shape Forme de type RECTANGLE
 * @param lst Liste de pixels de sortie
 */
void pixel_rectangle(Shape * shape, list * lst);

/**
 * @brief Rasterise un carré.
 *
 * @param shape Forme de type SQUAR
 * @param lst Liste de pixels de sortie
 */
void pixel_square(Shape * shape, list * lst);

/**
 * @brief Rasterise un polygone.
 *
 * @param shape Forme de type POLYGON
 * @param lst Liste de pixels de sortie
 */
void pixel_polygon(Shape * shape, list * lst);


/**
 * @brief Rasterise une courbe de Bézier.
 *
 * @param shape Forme de type CURVE
 * @param lst Liste de pixels de sortie
 */
void pixel_curve(Shape * shape, list * lst);




#endif
