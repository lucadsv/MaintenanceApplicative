package pixel_tracer.src_java;

/**
 * Point d'entree de test pour afficher un echantillon de formes.
 */
class Main{
    public static void main(String[] args) {
        System.out.println(" Shapes ");
        DrawableShape[] shapes = new DrawableShape[8]; 
        shapes[0] = new RoundCircle(10, 5, 4);
        shapes[1] = new CoordPoint(4, 8);
        shapes[2] = new RoundCircle(41, 65, 40);
        shapes[3] = new SegmentLine(new CoordPoint(4,8), new CoordPoint(6,10));
        shapes[4] = new BezierCurve(new CoordPoint(4,8), new CoordPoint(6,10), new CoordPoint(7,12), new CoordPoint(8,14));
        int[] coordsForPolygon = {4, 8, 6, 10, 7, 12, 8, 14};
        shapes[5] = new MultiPolygon(4, coordsForPolygon);
        shapes[6] = new BoxRectangle(new CoordPoint(4,8), 10, 20);
        shapes[7] = new BoxSquare(new CoordPoint(4,8), 10);
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("--------[" + shapes[i].getClass().getSimpleName() + "]--------");
            System.out.println(shapes[i].decrire());
        }
        System.out.println("------------------------");
    }
}