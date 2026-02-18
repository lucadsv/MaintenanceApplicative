#include "render.h"
#include <string.h>

/**
 * @brief Réinitialise le contenu d'une zone de dessin.
 *
 * Tous les pixels de l'area sont mis à l'état vide (EMPTY_CELL).
 *
 * @param area Zone de dessin à nettoyer
 */
void clear_area(Area * area) {
    for (unsigned int i = 0; i < area->height; i++) {
        for (unsigned int j = 0; j < area->width; j++) {
            area->area[i][j] = EMPTY_CELL;
        }
    }
}

/**
 * @brief Affiche une zone de dessin à l'écran.
 *
 * Chaque cellule est rendue sous forme de caractère ASCII,
 * selon qu'elle est vide ou pleine.
 *
 * @param area Zone de dessin à afficher
 */
void draw_area(Area * area) {
    for (unsigned int i = 0; i < area->height; i++) {
        for (unsigned int j = 0; j < area->width; j++) {
            switch (area->area[i][j]) {
            case EMPTY_CELL:
                printf("%c", area->empty_char);
                break;
            case FULL_CHAR:
                printf("%c", area->full_char);
                break;
            }
        }
        printf("\n");
    }
}

/**
 * @brief Efface l'écran du terminal.
 *
 * La commande utilisée dépend du système d'exploitation.
 */
void clear_screen() {

#ifdef __linux__
    printf("\033[H\033[J");
#elif _WIN32
    system("cls");
#else
    printf("\033[H\033[J");
#endif

}

/**
 * @brief Dessine toutes les couches visibles d'une area.
 *
 * - Réinitialise l'area
 * - Parcourt les layers
 * - Dessine uniquement celles visibles
 *
 * @param area Zone de dessin
 */
void draw_all_layers(Area * area) {
    clear_area(area);
    list *layer_list = area->lst_layers;
    lnode *layer_node = get_first_node(layer_list);
    while (layer_node != NULL) {
        Layer *layer = (Layer *) layer_node->data;
        if (layer->visible == LAYER_VISIBLE) {
            draw_layer_shapes(area, layer);
        }
        layer_node = get_next_node(layer_list, layer_node);
    }

}


/**
 * @brief Dessine toutes les formes d'un layer dans l'area.
 *
 * Chaque forme est convertie en pixels, puis chaque pixel est
 * projeté dans la matrice de l'area.
 *
 * @param area Zone de dessin
 * @param layer Layer à dessiner
 */
void draw_layer_shapes(Area * area, Layer * layer) {
    list shape_list = layer->shapes;

    lnode *shape_node = get_first_node(&shape_list);
    while (shape_node != NULL) {
        Shape *shp = (Shape *) shape_node->data;

        list *list_pixel = create_shape_to_pixel(shp);

        lnode *pixel_node = get_first_node(list_pixel);
        while (pixel_node != NULL) {
            Pixel *pxl = pixel_node->data;
            if (pxl->px < area->height && pxl->py < area->width)
                area->area[pxl->px][pxl->py] = FULL_CHAR;
            pixel_node = get_next_node(list_pixel, pixel_node);
        }
        void remove_pixel_shape(list * list_pixel);
        shape_node = get_next_node(&shape_list, shape_node);
    }

    return;
}
