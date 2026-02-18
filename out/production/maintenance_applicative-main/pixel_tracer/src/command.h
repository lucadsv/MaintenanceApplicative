/**
 * @file command.h
 * @brief Gestion des commandes utilisateur (CLI) pour Pixel Tracer.
 *
 * Ce module permet de lire les commandes depuis stdin, de parser les
 * paramètres (int, float, string) et d'exécuter les actions correspondantes
 * (dessin, gestion des layers, etc.).
 */

#ifndef _COMMAND_H_
#  define _COMMAND_H_

#  define MAX_PARAM 30

#  include <stdlib.h>
#  include <string.h>
#  include <stdio.h>

#  include <readline/readline.h>
#  include <readline/history.h>
#  include "pixel_tracer.h"

/**
 * @brief Représente une commande saisie par l'utilisateur.
 *
 * Une commande contient :
 *  - un nom (ex: "line", "circle", "list"...)
 *  - une liste de paramètres int, float et string
 */
struct command {
    char name[50];
    int int_size;
    int int_params[MAX_PARAM];
    int str_size;
    char *str_params[MAX_PARAM];
    int flt_size;
    float flt_params[MAX_PARAM];
};

typedef struct command Command;

/**
 * @brief Crée une commande vide.
 *
 * @return pointeur vers une Command initialisée
 */
Command *create_commande();

/**
 * @brief Ajoute un paramètre entier à une commande.
 *
 * @param cmd commande cible
 * @param p paramètre entier
 */
void add_int_param(Command * cmd, int p);

/**
 * @brief Ajoute un paramètre float à une commande.
 *
 * @param cmd commande cible
 * @param p paramètre float
 */
void add_float_param(Command * cmd, float p);

/**
 * @brief Ajoute un paramètre string à une commande.
 *
 * @param cmd commande cible
 * @param p paramètre string (copie allouée)
 */
void add_str_param(Command * cmd, char *p);

/**
 * @brief Libère la mémoire allouée par une commande.
 *
 * @param cmd commande à libérer
 */
void free_cmd(Command * cmd);

/**
 * @brief Lit une commande depuis stdin et l'exécute.
 *
 * @param app instance de l'application Pixel Tracer
 * @return code d'erreur (0 si OK)
 */
int read_exec_command(Pixel_tracer_app * app);

/**
 * @brief Lit une ligne depuis stdin et remplit la structure Command.
 *
 * @param cmd commande à remplir
 */
void read_from_stdin(Command * cmd);

#endif
