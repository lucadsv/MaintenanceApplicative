# Pixel Tracer

Pixel Tracer est un mini moteur de dessin vectoriel en mode texte (ASCII).
Le depot contient deux implementations :

- une version C historique (dans `src/`)
- une version Java orientee objets (dans `src_java/`)

Le principe est simple : tu saisis des commandes (`line`, `circle`, `polygon`, etc.), et le canvas est rendu dans le terminal.

## Fonctionnalites

- dessin de formes : point, ligne, carre, rectangle, cercle, courbe de Bezier, polygone
- gestion de calques (layers) et zones (areas)
- selection et suppression d'elements par ID
- personnalisation des caracteres de fond et de bordure (ASCII)
- interface interactive en ligne de commande

## Structure du depot

```text
.
├── src/                 # Implementation C
│   ├── makefile
│   └── *.c / *.h
├── src_java/            # Implementation Java
│   └── *.java
├── bin/linux/draw       # Binaire C precompile (Linux)
├── doc/                 # Documentation generee / ressources
└── README.md
```

## Lancer la version Java

Depuis la racine du projet :

```bash
mkdir -p out
javac -d out src_java/*.java
java -cp out pixel_tracer.src_java.ApplicationConsole
```

Point d'entree : `src_java/ApplicationConsole.java`.

## Lancer la version C

Depuis la racine du projet :

```bash
cd src
make
./draw
```

Le `Makefile` produit l'executable `draw` dans `src/`.
Un binaire Linux precompile est aussi present dans `bin/linux/draw`.

## Commandes disponibles (mode interactif)

### Controle

- `help`
- `plot`
- `clear`
- `exit`

### Dessin

- `point x y`
- `line x1 y1 x2 y2`
- `square x y length`
- `rectangle x y width height`
- `circle x y radius`
- `curve x1 y1 x2 y2 x3 y3 x4 y4`
- `polygon x1 y1 x2 y2 ...`

### Gestion

- `list layers`
- `list areas`
- `list shapes`
- `new area`
- `new layer`
- `select area <id>`
- `select layer <id>`
- `delete area <id>`
- `delete layer <id>`
- `delete shape <id>`

## Exemples rapides

Une session type :

```text
point 5 5
line 2 2 20 10
circle 15 8 5
polygon 5 5 10 3 15 8 8 12
plot
```