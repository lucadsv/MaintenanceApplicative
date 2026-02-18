/**
 * @file main.c
 * @brief Point d'entrée principal de l'application Pixel Tracer.
 *
 * Ce fichier contient la fonction main qui initialise l'application,
 * lance la boucle de lecture des commandes utilisateur et gère
 * l'affichage à l'écran.
 */
#include <stdio.h>
#include <stdlib.h>
#include "pixel_tracer.h"
#include "command.h"


/**
 * @brief Fonction principale de l'application.
 *
 * Elle :
 *  - initialise l'application Pixel Tracer
 *  - affiche l'area courante
 *  - lit et exécute les commandes utilisateur
 *  - gère l'affichage selon les commandes exécutées
 *  - libère les ressources à la fin du programme
 *
 * @return Code de retour du programme (0 par convention).
 */


int main() {
    Pixel_tracer_app app;
    init_app(&app);
    clear_screen();
    draw_all_layers(app.current_area);
    draw_area(app.current_area);

    while (1) {
        int err = read_exec_command(&app);
        if (err == 0 || err == 6) {
            clear_screen();
            draw_all_layers(app.current_area);  // make pixels
            draw_area(app.current_area);        // render
        }
        if (err == 6) {
            clear_screen();
            draw_all_layers(app.current_area);  // make pixels
            draw_area(app.current_area);        // render
        }
        if (err == 4) {
            break;
        }
        if (err == 5) {
            clear_screen();
        }
        if (err == 7 || err == 8) {
            continue;
        }
    }

    destry_app(&app);
}
